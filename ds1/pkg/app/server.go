package main

import (
	"alexandreliberato.dev/descontos/pkg"
	"alexandreliberato.dev/descontos/pkg/domain/services"
	"google.golang.org/grpc"
	"log"
	"net"
	"sync"

	"golang.org/x/net/context"
)

type discountCalculatorServer struct {
	descontos.UnimplementedDiscountCalculatorServer

	savedParam *descontos.Param

	mu sync.Mutex
	routeDiscounts map[string][] *descontos.Discount
}

func (s *discountCalculatorServer) GetDiscount(ctx context.Context, in *descontos.Param) (*descontos.Discount, error) {
	log.Printf("Receive message body from client: %s", in)
	services.Setup()
	discount, err := services.Processa(ctx, in.IdUser, in.IdProduct)
	if err != nil {
		return &descontos.Discount{}, err
	}

	return &descontos.Discount{
		Percentage: float32(discount.Percentage),
		ValueInCents: int32(discount.ValueInCents),
	}, nil
}

func main() {
	lis, err := net.Listen("tcp", ":9000")
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}

	s := discountCalculatorServer{}

	grpcServer := grpc.NewServer()
	descontos.RegisterDiscountCalculatorServer(grpcServer, &s)

	if err := grpcServer.Serve(lis); err != nil {
		log.Fatalf("failed to serve: %s", err)
	}
}