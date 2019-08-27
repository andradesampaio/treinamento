package br.org.demotdd.calculadora;

import br.org.demotdd.calculadora.Calculadora;
import br.org.demotdd.calculadora.NaoPoderDividirPorZero;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculadoraTest {

    private Calculadora calc;

    @Before
    public void setup(){
        calc = new Calculadora();
    }

    @Test
    public void deveSomarDoisNumeros(){
        int a = 20;
        int b = 15;
        int result = calc.somar(a, b);
        assertEquals(35,result);
      }

    @Test
    public void deveSubrairDoisNumeros(){
        int a = 15;
        int b = 15;
        int result = calc.subtrair(a, b);
        assertEquals(0,result);
    }

    @Test
    public void deveDividirDoisNumeros() throws NaoPoderDividirPorZero {
        int a = 15;
        int b = 15;
        int result = calc.dividir(a, b);
        assertEquals(1,result);
    }
    @Test(expected = NaoPoderDividirPorZero.class)
     public void deveLancharExcepion() throws NaoPoderDividirPorZero {
        int a = 15;
        int b = 0;
        int result = calc.dividir(a, b);
    }
}
