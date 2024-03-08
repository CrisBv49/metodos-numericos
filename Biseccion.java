import java.text.DecimalFormat;

public class Biseccion {

    static int iteracciones = 0;
    static DecimalFormat df = new DecimalFormat(".00000000");

    static void calcularValores(double rangoA, double rangoB, double ErrorAproximar, String ecua) {
        iteracciones++;
        double media = ValorMedio(rangoA, rangoB);
        double error = porcentajeError(rangoA, rangoB);

        double Fa = evaluar1(rangoA, ecua);
        double Fb = evaluar1(rangoB, ecua);
        double Fm = evaluar1(media, ecua);


        if (media == 0 || (Fa * Fb) > 0) {
            System.out.println("\nDATOS FINALES :");
            resultados(iteracciones, rangoA, rangoB, media, error, Fa, Fb, Fm);

            System.out.println("Finaliza por signos");
        }

        else {

            if (error <= ErrorAproximar) {
                System.out.println("\nDATOS FINALES :"); 
                resultados(iteracciones, rangoA, rangoB, media, error, Fa, Fb, Fm);
                System.out.println("Fin se encontro un margen de error igual o parecido");
            }

            else { /* Raiz de la recursividad */

                if (signoPositivo(Fm)) {

                    if (!signoPositivo(Fa)) /* cuando: - Fa y + Fm */ {

                        resultados(iteracciones, rangoA, rangoB, media, error, Fa, Fb, Fm);
                        calcularValores(rangoA, media, ErrorAproximar, ecua);

                    } else /* cuando: + Fm y - FB */ {

                        resultados(iteracciones, rangoA, rangoB, media, error, Fa, Fb, Fm);
                        calcularValores(media, rangoB, ErrorAproximar, ecua);
                    }

                } else {
                    if (signoPositivo(Fa))/* cuando: + Fa y -Fm */ {

                        resultados(iteracciones, rangoA, rangoB, media, error, Fa, Fb, Fm);
                        calcularValores(rangoA, media, ErrorAproximar, ecua);

                    } else /* cuando: - Fm y + Fb */ {

                        resultados(iteracciones, rangoA, rangoB, media, error, Fa, Fb, Fm);
                        calcularValores(media, rangoB, ErrorAproximar, ecua);

                    }
                }
            }
        }
    }

    static Double ValorMedio(double a, double b) {
        return Double.parseDouble(df.format((a + b) / 2));
    }

    static Double porcentajeError(double a, double b) {
        return Math.abs(Double.parseDouble(df.format(((b - a) / 2) * 100)));
    }

    static double evaluar1(double x, String ecuacion) {
        // AQUI VA LA FORMULA
        // /* Ejemplo: x^2 --> */ return Math.pow(x, 2) ;

        double formula = eva.eva(ecuacion, x); // por el momento se usa la clase Evaluar para evaluar las
                                                       // formulas
        return Double.parseDouble(df.format(formula));
    }

    static boolean signoPositivo(double valor) {
        return (valor > 0);
    }

    static void imprimirValores(int i, double Ra, double Rb, double m, double error) {
        System.out.println(
                "\n . Iteracion: " + i +
                        "\n . Rangos: [" + Ra + " - " + Rb +
                        "]\n . Media: " + m +
                        "\n . Error: " + error + " %");
    }

    static void imprimirResultFuncion(double Fa, double Fb, double Fm) {
        System.out.println(
                "\n * F(a): " + Fa +
                        "\n * F(b): " + Fb +
                        "\n * F(m): " + Fm + "\n");

    }

    static void resultados(int i, double Ra, double Rb, double m, double error, double Fa, double Fb, double Fm) {
        imprimirValores(i, Ra, Rb, m, error);
        imprimirResultFuncion(Fa, Fb, Fm);
    }

}
