class eva {

    /*
     * Metodo que convierte y resuelve la cad de texto de la ecuacion a un
     * resu entero
     */

    // [(coseno([3*x])]*3

    static double eva(String cad, double x) {
        double resu = 0;
        try {
            String[] tokens;

            if (cad.contains("x")) {

                cad = cad.replace("x", String.valueOf(x));
            }

            if (Es_numero(cad)) {
                resu = Double.parseDouble(cad);

            } else {

                if (cad.contains("[") || cad.contains("]")) {

                    int parentIni = cad.indexOf("[");
                    int parentFin = cad.lastIndexOf("]");

                    if (parentIni != -1 && parentFin != -1) {
                        String valor = cad.substring(parentIni + 1, parentFin);

                        resu = eva(valor, x);
                        cad = cad.substring(0, parentIni) + resu + cad.substring(parentFin + 1);
                    }
                }

                if (cad.contains("Sen(") || cad.contains("sen(")) {

                    

                        int parentIni = cad.indexOf("(");
                        int parentFin = cad.lastIndexOf(")");

                        if (parentIni != -1 && parentFin != -1) {
                            String valor = cad.substring(parentIni + 1, parentFin);

                            resu = Math.sin(eva(valor, x));
                            cad = cad.substring(0, parentIni) + resu + cad.substring(parentFin + 1);
                        }
                    
                }

                if (cad.contains("Cos(") || cad.contains("cos(")) {

                    

                        int parentIni = cad.indexOf("(");
                        int parentFin = cad.lastIndexOf(")");

                        if (parentIni != -1 && parentFin != -1) {
                            String valor = cad.substring(parentIni + 1, parentFin);

                            resu = Math.cos(eva(valor, x));
                            cad = cad.substring(0, parentIni) + resu + cad.substring(parentFin + 1);
                        }
                    
                }

                if (cad.contains("Tan(") || cad.contains("tan(")) {

                    

                        int parentIni = cad.indexOf("(");
                        int parentFin = cad.lastIndexOf(")");

                        if (parentIni != -1 && parentFin != -1) {
                            String valor = cad.substring(parentIni + 1, parentFin);

                            resu = Math.tan(eva(valor, x));
                            cad = cad.substring(0, parentIni) + resu + cad.substring(parentFin + 1);
                        }
                    
                }

                if (cad.contains("^")) {
                    tokens = cad.split("\\^");
                    resu = Math.pow(eva(tokens[0], x), eva(tokens[1], x));

                } else if (cad.contains("*")) {
                    tokens = cad.split("\\*");
                    resu = eva(tokens[0], x) * eva(tokens[1], x);

                } else if (cad.contains("/")) {
                    tokens = cad.split("\\/");
                    resu = eva(tokens[0], x) / eva(tokens[1], x);

                } else if (cad.contains("+")) {
                    tokens = cad.split("\\+");
                    resu = eva(tokens[0], x) + eva(tokens[1], x);

                } else if (cad.contains("-")) {
                    tokens = cad.split("-");
                    resu = eva(tokens[0], x) - eva(tokens[1], x);
                }

            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return resu;
    }

    static boolean Es_numero(String n)/* verifica si una cad String puede pasar a un Double */ {
        try {
            Double.parseDouble(n);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}