import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraMultiusoTest {
    CalculadoraMultiuso calculadora = new CalculadoraMultiuso();
    @Test
    public void sumaPositivos() {
        int resultSuma = calculadora.sumar(2, 3);
        assertEquals(5,resultSuma);
    }
    @Test
    public void sumaNegativos() {
        int resultSuma = calculadora.sumar(2, -3);
        assertEquals(-1,resultSuma );
        assertEquals(0, calculadora.sumar(0, 0));
    }
    @Test
    public void sumaCeros() {
        int resultSuma = calculadora.sumar(0, 0);
        assertEquals(0,resultSuma );
    }
    @Test
    public void restaPositivos() {
        int resultResta= calculadora.restar(2, 3);
        assertEquals(-1, resultResta);

    }
    @Test
    public void restaPositivoYNegativo() {
        int resultResta = calculadora.restar(2, -3);
        assertEquals(5, resultResta);
    }
    @Test
    public void restaCeros() {
        int resultResta = calculadora.restar(0, 0);
        assertEquals(0,resultResta);
    }
    @Test
    public void multiplicarPositivos() {
        int resultMultiplicacion = calculadora.multiplicar(2, 3);
        assertEquals(6, resultMultiplicacion);
    }

    @Test
    public void multiplicarPositivoYNegativo() {
        int resultMultiplicacion = calculadora.multiplicar(2, -3);
        assertEquals(-6, resultMultiplicacion);
    }

    @Test
    public void multiplicarPositivoYCero() {
        int resultMultiplicacion = calculadora.multiplicar(0, 3);
        assertEquals(0,resultMultiplicacion);
    }

    @Test
    public void dividirPorCERO() {
        assertThrows(ArithmeticException.class, () -> {
            calculadora.dividir(6, 0);
        });
    }
    @Test
    public void dividirPositivos() {
        int resultDivision = calculadora.dividir(6, 3);
        assertEquals(2, resultDivision);
    }

    @Test
    public void dividirPositivoYNegativo() {
        int resultDivision = calculadora.dividir(6, -3);
        assertEquals(-2, resultDivision);
    }

    @Test
    public void signoPisis() {
        String resultadoSigno = calculadora.calcularSignoZodiacal("15/03/1996");
        assertEquals("Piscis",resultadoSigno );
    }
    @Test
    public void signoAries(){
        String resultadoSigno = calculadora.calcularSignoZodiacal("15/04/1990");
        assertEquals("Aries",resultadoSigno);
    }

    @Test
    public void signoTauro(){
        String resultadoSigno = calculadora.calcularSignoZodiacal("21/05/1995");
        assertEquals("Tauro",resultadoSigno);
    }

    @Test
    public void signoGeminis(){
        String resultadoSigno = calculadora.calcularSignoZodiacal("10/06/1988");
        assertEquals("Géminis", resultadoSigno);
    }

    @Test
    public void signoCancer(){
        String resultadoSigno = calculadora.calcularSignoZodiacal("21/07/1996");
        assertEquals("Cáncer", resultadoSigno);
    }
    @Test
    public void signoLeo(){
        String resultadoSigno = calculadora.calcularSignoZodiacal("05/08/2000");
        assertEquals("Leo", resultadoSigno);
    }
    @Test
    public void signoVirgo(){
        String resultadoSigno = calculadora.calcularSignoZodiacal("21/09/2000");
        assertEquals("Virgo", resultadoSigno);
    }
    @Test
    public void signoLibra(){
        String resultadoSigno = calculadora.calcularSignoZodiacal("04/10/1996");
        assertEquals("Libra", resultadoSigno);
    }

    @Test
    public void signoEscorpio(){
        String resultadoSigno = calculadora.calcularSignoZodiacal("10/11/1999");
        assertEquals("Escorpio", resultadoSigno);
    }

    @Test
    public void signoSagitario(){
        String resultadoSigno = calculadora.calcularSignoZodiacal("25/11/2001");
        assertEquals("Sagitario", resultadoSigno);
    }

    @Test
    public void signoCapricornio(){
        String resultadoSigno = calculadora.calcularSignoZodiacal("25/12/1997");
        assertEquals("Capricornio", resultadoSigno);
    }

    @Test
    public void signoCapricornioDeEnero(){
        String resultadoSigno = calculadora.calcularSignoZodiacal("05/01/1997");
        assertEquals("Capricornio", resultadoSigno);
    }

    @Test
    public void signoAcuario(){
        String resultadoSigno = calculadora.calcularSignoZodiacal("10/02/1994");
        assertEquals("Acuario", resultadoSigno);
    }

    @Test
    public void fechaInvalidaParaSigno() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularSignoZodiacal("hola");
        });
    }

    @Test
    public void fechaInexistenteParaSigno() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularSignoZodiacal("50/01/2000");
        });
    }
    /////////////////////

    @Test
    public void testCalcularIMC() {
        double resultadoIMC = calculadora.calcularIMC(85, 1.75);
        assertEquals(27.68, resultadoIMC , 0.1);
    }

    @Test
    public void clasificacionObesidad() {
        String resultadoIMC = calculadora.clasificarIMC(32);
        assertEquals("Obesidad", resultadoIMC);
    }
    @Test
    public void clasificacionPesoBajo(){
        String resultadoIMC = calculadora.clasificarIMC(17);
        assertEquals("Bajo peso",  resultadoIMC);
    }

    @Test
    public void clasificacionPesoNormal() {
        String resultadoIMC = calculadora.clasificarIMC(22);
        assertEquals("Peso normal", resultadoIMC);
    }
    @Test
    public void clasificacionPesoSobrepeso(){
        String resultadoIMC =calculadora.clasificarIMC(27);
        assertEquals("Sobrepeso",resultadoIMC );
    }

    @Test
    public void pesoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularIMC(-70, 1.75);
        });
    }

    @Test
    public void alturaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularIMC(70, 0);
        });
    }

    @Test
    public void dosRaicesReales() {
        double[] resultado = calculadora.calcularRaices(1, -3, 2);
        assertEquals(2.0, resultado[0], 0.01);
        assertEquals(1.0, resultado[1], 0.01);
    }

    @Test
    public void unaSolaRaizReal() {
        double[] resultado = calculadora.calcularRaices(1, -2, 1);
        assertEquals(1.0, resultado[0], 0.01);
        assertEquals(1.0, resultado[1], 0.01);
    }

    @Test
    public void noExistenRaicesReales() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularRaices(1, 2, 5);
        });
    }

    @Test
    public void coeficienteACero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularRaices(0, 2, 3);
        });
    }
}
