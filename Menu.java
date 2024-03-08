import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        imp(
                "\n Antes de comenzar: \n\n" +
                        " valores trigonométricas son validos: Sen(x), Cos(x), Tan(x)\n" +
                        " para varias ecuaciones use corchetes: '[]'\n" +
                        " +, -, *, /,^, (). Son validos\n" +
                        " Para las incognitas utilice solo 'x', ejemplo: 3*x. No 3x\n\n");

        imp(" Ingrese su ecuacion: ");
        String ecuacion = scn.next();
        imp(" Ingrese rangos 'a, b' : ");
        String rango = scn.next();
        imp(" porcentaje de error: ");
        double err = scn.nextDouble();

        String[] rangos = rango.split(","); // Divide la cadena de texto de rango en 2 partes, separadas por las comas

        imp("\n RESULTADOS: ");

        Biseccion.calcularValores(
                Double.parseDouble(rangos[0]),
                Double.parseDouble(rangos[1]),
                err,
                ecuacion);

        scn.close();
    }

    static void imp(String text) {
        System.out.print(text);
    }

}
