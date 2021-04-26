package domain

import (
	"context"
)

type Repository interface {
	ListProducts(ctx context.Context) ([]Product, error)
	GetProduct(ctx context.Context, id string) (Product, error)
	GetUser(ctx context.Context, id string) (User, error)
	ListDateRules(ctx context.Context) ([]DateDiscountRule, error)
}
