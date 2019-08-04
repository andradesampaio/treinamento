package boas.praticas

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GeredorSenhaNumericasTest {

//    @InjectMocks
//    private lateinit var  geradorSenhaNumericas: GeradorSenhaNumericas
//    @Mock
//    private lateinit var geradorNumeroAleatorio: GeradorNumeroAleatorio

    @Test
    fun `ao gerar senha deve retornar uma senha de 4 digitos`() {

        val geradorSenhaNumericas = GeradorSenhaNumericas(GeradorNumeroAleatorio())
        val senhaGerada = geradorSenhaNumericas.gerar(4)
        Assert.assertEquals(4, senhaGerada.length)

    }

    @Test
    fun `ao gerar senha deve retornar uma senha numerica`() {

        val geradorSenhaNumericas = GeradorSenhaNumericas(GeradorNumeroAleatorio())
        val senhaGerada = geradorSenhaNumericas.gerar(4)

        Assert.assertTrue(senhaGerada[0].isDigit())
        Assert.assertTrue(senhaGerada[1].isDigit())
        Assert.assertTrue(senhaGerada[2].isDigit())
        Assert.assertTrue(senhaGerada[3].isDigit())
    }


    @Test(expected = RuntimeException::class)
    fun `ao gerar a senha informando quantidade de digitos zeradas deve lancar uma excecao`() {
        val geradorSenhaNumericas = GeradorSenhaNumericas(GeradorNumeroAleatorio())
        geradorSenhaNumericas.gerar(0)
    }

    @Test
    fun `ao gerar a senha deve retornar uma senha gerada aleatoriamente`() {
        val geradorNumeroAleatorioMock = Mockito.mock(GeradorNumeroAleatorio::class.java)
        val geradorSenhaNumericas = GeradorSenhaNumericas(geradorNumeroAleatorioMock)
        Mockito.`when`(geradorNumeroAleatorioMock.gerar()).thenReturn("4")

        val senhaGerada = geradorSenhaNumericas.gerar(4)

        Assert.assertEquals("4444", senhaGerada)
    }


}