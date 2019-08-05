import org.junit.Assert.assertEquals
import org.junit.Test


class CalculadoraTest {

    @Test
    fun meuPrimeiroTeste() {
        val soma = 10 + 4
        assertEquals(14, soma)
    }

    @Test
    fun meuSegundoTeste() {
        //Arrange
        val calculadora = Calculadora()
        //ACT
        val soma = calculadora.somar(2, 3)
        //ASSERT
        assertEquals(5, soma)
    }

    @Test(expected = ParametroNegativoExcepion::class)
    fun sePrimeiroParametroForNegativoDeveLancarExcecao() {
        val calculadora = Calculadora()
        val soma = calculadora.somar(-2, 3)

    }


}