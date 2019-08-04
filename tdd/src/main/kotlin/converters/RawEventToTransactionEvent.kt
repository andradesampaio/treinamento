package converters

import model.PlayerCategory
import model.RawEvent
import model.TransactionEvent
import model.TransactionType
import java.util.*

class RawEventToTransactionEvent {

    public open fun convert(rawEvent: RawEvent): TransactionEvent? {


        val externalId = rawEvent.id
        val realAmount = rawEvent.amount
        val dollarAmount = gerarDollarAmount(rawEvent)
        val type = gerarTransactionType(rawEvent)
        val playerCategory = PlayerCategory.FOOD

        return TransactionEvent(UUID.randomUUID().toString(), externalId, realAmount, dollarAmount, type, playerCategory)
    }


    private fun gerarDollarAmount(rawEvent: RawEvent) : Double{
        if (rawEvent.currencyLiteral == "BRL") {
            return rawEvent.localAmount
        }
            return rawEvent.installmentAmount
    }

    private fun gerarTransactionType(rawEvent: RawEvent): TransactionType{
        if (rawEvent.currencyLiteral == "BRL")
            return TransactionType.NATIONAL

        return TransactionType.INTERNATIONAL
    }

}
