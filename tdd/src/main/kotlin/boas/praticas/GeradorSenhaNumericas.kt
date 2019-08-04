package boas.praticas

import java.lang.RuntimeException
import java.util.*

open class GeradorSenhaNumericas(val geradorNumeroAleatorio: GeradorNumeroAleatorio) {

   open fun gerar(quantidadeDigitos: Int) : String {

        if (quantidadeDigitos < 4){
            throw RuntimeException()
        }
        var senha = ""
        for (i in 0..3) {
            senha += geradorNumeroAleatorio.gerar()
        }
         return senha
    }

}


