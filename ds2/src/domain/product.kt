package model

data class Product(val id: String, val title: String, val description: String, val priceInCents: Int, var discount: model.Discount?)
