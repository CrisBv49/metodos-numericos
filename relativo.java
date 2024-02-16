
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class relativo {
public static void main(String[] args) { 
    Scanner teclado = new Scanner(System.in);

    
    double valorReal = 0; // Valor real de la cantidad medida
    double valorMedido = 0; // Valor medido de la cantidad
    valorReal = Double.parseDouble( JOptionPane.showInputDialog( "ingrese el valor real"));
    valorMedido = Double.parseDouble(JOptionPane.showInputDialog("ingrese el valor medido"));    
    // Cálculo del error absoluto
    double errorAbsoluto = Math.abs(valorReal - valorMedido);
    

    // Cálculo del error relativo (en porcentaje)
    double errorRelativo = (errorAbsoluto / valorReal) ;
    double errorRelativopor = (errorAbsoluto / valorReal) * 100;

    // JOptionPane.("valor real "+ valorReal);
    // + "valor medido"+valorMedido 
    // + "error absoluto "+ errorAbsoluto
    // + "error relativo "+ errorRelativo);

    JOptionPane.showMessageDialog(null, x(errorAbsoluto,errorRelativo,errorRelativopor, errorRelativopor, errorRelativopor), "Valores", JOptionPane.INFORMATION_MESSAGE);
    
}

    static String x (double errorAbsoluto,double errorRelativo,double errorRelativopor, double errorRelativopor2, double errorRelativopor3){
    DecimalFormat a = new DecimalFormat("0.00000");
    DecimalFormat b = new DecimalFormat("0.00000");

        return ""
        +"\nerror absoluto: "+ b.format(errorAbsoluto)
        + "\nerror relativo: "+ a.format(errorRelativo)
        +"\nvalor relativo porcentual verdadero: "+a.format(errorRelativopor)+"%";

    }

}