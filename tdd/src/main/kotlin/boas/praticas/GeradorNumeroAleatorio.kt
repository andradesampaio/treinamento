package boas.praticas

import java.util.*

open class GeradorNumeroAleatorio{

    open fun gerar() : String {

        return Random().nextInt(10).toString()
    }

}