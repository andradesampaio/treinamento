package model

data class RawEvent(
       val id: Int,
       val amount: Double,
       val installmentAmount: Double,
       val localAmount: Double,
       val currencyLiteral: String,
       val category: String
)

data class TransactionEvent(
        val id: String,
        val externalId:Int,
        val realAmount: Double,
        val dollarAmount: Double,
        val type: TransactionType,
        val playerCategory: PlayerCategory
)

enum class TransactionType{
    NATIONAL,
    INTERNATIONAL
}

enum class PlayerCategory{
    FOOD,
    TRANSPORT,
    OTHERS
}


/*
Restaurantes = FOOD
Lanche = FOOD
Combustivel = Transporte
Pedagio = Transporte
Entretenimento = Others
Geral = Others
 */