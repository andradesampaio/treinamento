package converters

import model.PlayerCategory
import model.RawEvent
import model.TransactionType
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class RawEventToTransactionEventTest {

    @InjectMocks
    private lateinit var rawEventToTransactionEvent: RawEventToTransactionEvent


    @Test
    fun `deve converter um rawEven para um TransactionEvent do tipo nacional da categoria RESTAURANTE para FOOD`(){

        val rawEvent = RawEvent(1, 10.0, 20.00,30.00,"BRL", "RESTAURANTE")
        var transactionEventConvertido = rawEventToTransactionEvent.convert(rawEvent)


            Assert.assertEquals(1, transactionEventConvertido!!.externalId)
            Assert.assertEquals(30.00, transactionEventConvertido.dollarAmount, 1.0)
            Assert.assertEquals(10.00, transactionEventConvertido.realAmount, 1.0)
            Assert.assertEquals(TransactionType.NATIONAL, transactionEventConvertido.type)
            Assert.assertEquals(PlayerCategory.FOOD, transactionEventConvertido.playerCategory)

    }

    @Test
    fun `deve converter um rawEven para um TransactionEvent do tipo Internacional da categoria RESTAURANTE para FOOD`(){

        val rawEvent = RawEvent(1, 10.0, 20.00,30.00,"USD", "RESTAURANTE")
        var transactionEventConvertido = rawEventToTransactionEvent.convert(rawEvent)


        Assert.assertEquals(1, transactionEventConvertido!!.externalId)
        Assert.assertEquals(20.00, transactionEventConvertido.dollarAmount, 1.0)
        Assert.assertEquals(10.00, transactionEventConvertido.realAmount, 1.0)
        Assert.assertEquals(TransactionType.INTERNATIONAL, transactionEventConvertido.type)
        Assert.assertEquals(PlayerCategory.FOOD, transactionEventConvertido.playerCategory)

    }
}