package infra.grpc

import io.grpc.ManagedChannelBuilder
import java.lang.Exception

class DiscountClient {
    fun getDiscount(idUser: String?, idProduct: String): model.Discount {
        println("> grpc client: getDiscount()")
        var idUserStr = ""
        if (idUser != null) {
            idUserStr = idUser
        }

        var channel = ManagedChannelBuilder.forAddress("servico-01", 9000).usePlaintext().build()
        var stub = DiscountCalculatorGrpc.newBlockingStub(channel)
        var param = Param.newBuilder().setIdUser(idUserStr).setIdProduct(idProduct).build()


        var emptyDiscount: model.Discount = model.Discount(0f,0)
        var discount: infra.grpc.Discount

        try {
            discount = stub.getDiscount(param)
            println("> discount: " + discount.percentage)
        } catch (e: Exception) {
            e.printStackTrace()
            return emptyDiscount
        }

        return model.Discount(
            percentage = discount.percentage,
            valueInCents = discount.valueInCents
        )
    }
}