package br.org.demotdd.calculadora;



public class Calculadora {


    public int somar(int a, int b) {
        return a + b;
    }

    public int subtrair(int a, int b) {
        return a - b;
    }

    public int dividir(int a, int b) throws NaoPoderDividirPorZero {

        if (b == 0) {
            throw new NaoPoderDividirPorZero("Numero nao pode se Zero");
        }

        return a/b;
    }
}
