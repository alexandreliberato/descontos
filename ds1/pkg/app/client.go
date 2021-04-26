package main

import (
	descontos "alexandreliberato.dev/descontos/pkg"
	"context"
	"google.golang.org/grpc"
	"log"
	"time"
)

func main() {
	conn, err := grpc.Dial("localhost:9000", grpc.WithInsecure())
	if err != nil {
		log.Printf("x error: %v", err)
	}
	defer conn.Close()

	client := descontos.NewDiscountCalculatorClient(conn)

	params := descontos.Param{
		IdUser: "235a6935-3852-4914-998e-dad7e52ed3ae",
		IdProduct: "a97317a0-6b47-4168-96c6-554a3adaca49",
	}

	getDiscount(client, &params)
}

func getDiscount(client descontos.DiscountCalculatorClient, params *descontos.Param) {
	ctx, cancel := context.WithTimeout(context.Background(), 3*time.Second)
	defer cancel()
	discount, err := client.GetDiscount(ctx, params)
	if err != nil {
		log.Fatalf("%v.GetFeatures(_) = _, %v: ", client, err)
	}
	log.Printf("> discount: %v", discount)
}