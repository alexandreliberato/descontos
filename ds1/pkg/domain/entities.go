package domain

import "time"

type User struct {
	Id          string
	FirstName   string
	LastName    string
	DateOfBirth time.Time
}

type Product struct {
	Id           string
	Title        string
	Description  string
	PriceInCents int
	Discount     Discount
}

type Discount struct {
	Percentage   float64
	ValueInCents int
}

type DateDiscountRule struct {
	Id         string
	Title      string
	Percentage float64
	Date       time.Time
	Limit      float64
}

type Param struct {
	IdUsuario string
	IdProduto string
}
