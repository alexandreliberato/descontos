package infra

import (
	"alexandreliberato.dev/descontos/pkg/domain"
	"context"
	"log"
	"time"

	"github.com/jackc/pgx/v4/pgxpool"
)

var _ domain.Repository = &DiscountRepository{}

type DiscountRepository struct {
	pool *pgxpool.Pool
}

func (r *DiscountRepository) ListProducts(ctx context.Context) ([]domain.Product, error) {
	var products = []domain.Product{}

	query := "SELECT * FROM products"

	rows, errQuery := r.pool.Query(
	  context.Background(),
	  query,
	)

	if errQuery != nil {
		log.Printf("> err query: %v\n", errQuery)
		return nil, errQuery
	}
	defer rows.Close()

	for rows.Next() {
		var id string
		var title string
		var description string
		var priceInCents int

		log.Println("> scan results!")

		err := rows.Scan(
			&id,
			&title,
			&description,
			&priceInCents,
			nil,
			nil,
		)

		if err != nil {
			 log.Printf("> error on Scan: %v", err)
			 return nil, err
		}

		product := domain.Product{
			Id:  id,
			Title: title,
			PriceInCents: priceInCents,
			Description: description,
		}

		log.Printf("> product: %v", product)
		products = append(products, product)
	}

	return products, nil
}

func (r *DiscountRepository) GetProduct(ctx context.Context, id string) (domain.Product, error) {
	var product = domain.Product{}
	var title string
	var description string
	var priceInCents int

	query := "select * from products where id = $1"

	rows := r.pool.QueryRow(
		context.Background(),
		query,
		id,
	)

	err := rows.Scan(
		&id,
		&title,
		&description,
		&priceInCents,
		nil,
		nil,
	)

	if err != nil {
		log.Printf("> error on Scan: %v", err)
		return domain.Product{}, err
	}

	product = domain.Product{
		Id:  id,
		Title: title,
		PriceInCents: priceInCents,
		Description: description,
	}

	log.Printf("> product: %v", product)

	return product, nil
}

func (r *DiscountRepository) GetUser(ctx context.Context, id string) (domain.User, error) {
	var user = domain.User{}
	var firstName string
	var lastName string
	var dateOfBirth time.Time

	query := "select * from users where id = $1"

	rows := r.pool.QueryRow(
		context.Background(),
		query,
		id,
	)

	err := rows.Scan(
		&id,
		&firstName,
		&lastName,
		&dateOfBirth,
		nil,
		nil,
	)

	if err != nil {
		log.Printf("> error on Scan: %v", err)
		return domain.User{}, err
	}

	user = domain.User{
		Id:  id,
		FirstName: firstName,
		LastName: lastName,
		DateOfBirth: dateOfBirth,
	}

	log.Printf("> user: %v", user)
	return user, nil
}

func (r *DiscountRepository) ListDateRules(ctx context.Context) ([]domain.DateDiscountRule, error) {
	var dateRules = []domain.DateDiscountRule{}

	query := "SELECT * FROM date_discount_rules"

	rows, errQuery := r.pool.Query(
		context.Background(),
		query,
	)

	if errQuery != nil {
		log.Printf("> err query: %v\n", errQuery)
		return nil, errQuery
	}
	defer rows.Close()

	for rows.Next() {
		var id string
		var title      string
		var percentage float64
		var limit      float64
		var date       time.Time

		log.Println("> scan results!")

		err := rows.Scan(
			&id,
			&title,
			&percentage,
			&limit,
			&date,
			nil,
			nil,
		)

		if err != nil {
			log.Printf("> error on Scan: %v", err)
			return nil, err
		}

		product := domain.DateDiscountRule{
			Id:  id,
			Title: title,
			Percentage: percentage,
			Date: date,
			Limit: limit,
		}

		log.Printf("> dateRule: %v", product)
		dateRules = append(dateRules, product)
	}

	return dateRules, nil
}

func NewDiscountRepository(pool *pgxpool.Pool) *DiscountRepository {
	return &DiscountRepository{
		pool: pool,
	}
}

func ConnectPool(url string) (*pgxpool.Pool, error) {
	config, err := pgxpool.ParseConfig(url)
	if err != nil {
		return nil, err
	}

	return pgxpool.ConnectConfig(context.Background(), config)
}
