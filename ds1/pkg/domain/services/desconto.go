package services

import (
	"alexandreliberato.dev/descontos/pkg/domain"
	"alexandreliberato.dev/descontos/pkg/infra"
	"context"
	"fmt"
	"log"
	"os"
	"time"
)

type Repository struct {
	db *infra.DiscountRepository
}

var r *infra.DiscountRepository

func Setup() {
	log.SetOutput(os.Stdout)

	// pool, err := infra.ConnectPool("postgres://postgres:postgres@localhost:5438/postgres")
	pool, err := infra.ConnectPool("postgres://postgres:postgres@postgres:5432/postgres?sslmode=disable")
	if err != nil {
		log.Println(err)
		panic(err)
	}

	r = infra.NewDiscountRepository(pool)
}

//end API

//var ctx = context.Background()
var limite float64 = 0.10                //TODO buscar da base: Rules.limit, para facilitar alteração de regras
var descontoDeAniversario float64 = 0.05 //TODO buscar da base: Rules.birthdayDiscountPercentage

func Processa(ctx context.Context, idUsuario, idProduto string) (domain.Discount, error) {
	log.Printf("> processando desconto para produto %v\n", idProduto)

	usuario, err := r.GetUser(ctx, idUsuario)
	produto, err := r.GetProduct(ctx, idProduto)

	if usuario.Id == "" {
		return domain.Discount{}, fmt.Errorf("processa: usuario não é válido %v", usuario.Id)
	}

	desconto, err := calcula(ctx, usuario, produto)
	if err != nil {
		log.Printf("> erro ao calcular desconto %v\n", err)
		return domain.Discount{}, err
	}

	return limita(desconto, limite, produto), nil
}

func calcula(ctx context.Context, usuario domain.User, produto domain.Product) (domain.Discount, error) {
	log.Println(">> calculando desconto...")

	desconto := domain.Discount{}

	hoje := time.Now()
	log.Printf(">> hoje: %v\n", hoje)
	log.Printf(">> aniversario: %v\n", usuario.DateOfBirth)

	regrasPorData, err := r.ListDateRules(ctx)
	if err != nil {
		log.Printf("> erro: %s", err)
		return domain.Discount{}, err
	}

	for _, r := range regrasPorData {
		log.Printf(">> regra por data: %v\n", r)
		if isMesmoMesEDia(r.Date, hoje) {
			desconto.Percentage += r.Percentage
		}
	}

	if isMesmoMesEDia(usuario.DateOfBirth, hoje) {
		desconto.Percentage += descontoDeAniversario
	}

	desconto.ValueInCents = calculaValorEmCentavos(desconto.Percentage, produto.PriceInCents)

	log.Printf(">> desconto gerado: %v\n", desconto)
	return desconto, nil
}

func calculaValorEmCentavos(percentual float64, valorEmCentavos int) int {
	return int(float64(valorEmCentavos) * percentual)
}

func isMesmoMesEDia(dataAniversario time.Time, data time.Time) bool {
	return dataAniversario.Month() == data.Month() && dataAniversario.Day() == data.Day()
}

func limita(d domain.Discount, l float64, p domain.Product) domain.Discount {
	log.Println("> limitando desconto")

	if d.Percentage > l {
		log.Printf("> limite de desconto atingido: %v\n", d.Percentage)
		d.Percentage = l
		d.ValueInCents = calculaValorEmCentavos(d.Percentage, p.PriceInCents)
	}

	return d
}


