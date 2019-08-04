class Calculadora() {

    fun somar(n1: Int, n2: Int): Int {
        if (n1 < 0)  {
            return throw ParametroNegativoExcepion()
        }
        return n1 + n2
    }
}