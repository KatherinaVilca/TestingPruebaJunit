import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CalculadoraMultiuso {

    public int sumar(int x, int y){
        return x+y;
    }

    public int restar(int x, int y){
        return x-y;
    }

    public int multiplicar(int x, int y){
        return x*y;
    }

    public int dividir(int x, int y){
        if (y == 0) {
            throw new ArithmeticException("División por cero no permitida.");
        }
        return x/y;
    }

    public double calcularIMC(double pesoKg, double alturaM) {
        if (pesoKg <= 0 || alturaM <= 0) {
            throw new IllegalArgumentException("El peso y la altura deben ser mayores que cero.");
        }
        double imc = pesoKg / (alturaM * alturaM);
        return Math.round(imc * 100.0) / 100.0;
    }

    public String clasificarIMC(double imc) {
        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc < 24.9) {
            return "Peso normal";
        } else if (imc < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
    public String calcularSignoZodiacal(String fechaNacimiento) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(fechaNacimiento, formatter);
            int dia = fecha.getDayOfMonth();
            int mes = fecha.getMonthValue();

            switch (mes) {
                case 1:
                    return (dia <= 20) ? "Capricornio" : "Acuario";
                case 2:
                    return (dia <= 18) ? "Acuario" : "Piscis";
                case 3:
                    return (dia <= 20) ? "Piscis" : "Aries";
                case 4:
                    return (dia <= 20) ? "Aries" : "Tauro";
                case 5:
                    return (dia <= 21) ? "Tauro" : "Géminis";
                case 6:
                    return (dia <= 21) ? "Géminis" : "Cáncer";
                case 7:
                    return (dia <= 22) ? "Cáncer" : "Leo";
                case 8:
                    return (dia <= 23) ? "Leo" : "Virgo";
                case 9:
                    return (dia <= 23) ? "Virgo" : "Libra";
                case 10:
                    return (dia <= 23) ? "Libra" : "Escorpio";
                case 11:
                    return (dia <= 22) ? "Escorpio" : "Sagitario";
                case 12:
                    return (dia <= 21) ? "Sagitario" : "Capricornio";
                default:
                    throw new IllegalArgumentException("Fecha inválida");
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido. Debe ser dd/MM/yyyy");
        }
    }

    public double[] calcularRaices(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("El coeficiente 'a' no puede ser cero.");
        }

        double discriminante = b * b - 4 * a * c;
        if (discriminante < 0) {
            throw new IllegalArgumentException("La ecuación no tiene raíces reales.");
        }

        double raizDiscriminante = Math.sqrt(discriminante);
        double x1 = (-b + raizDiscriminante) / (2 * a);
        double x2 = (-b - raizDiscriminante) / (2 * a);

        return new double[]{x1, x2};
    }
}
