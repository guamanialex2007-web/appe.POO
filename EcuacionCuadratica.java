package edu.unl.cc.domain;

/**
 *Representa el modelo del dominio para resolver una Ecuación Cuadrática (ax² + bx + c = 0).
 *Proporciona métodos para el cálculo del discriminante y determinación de raíces.
 *@author Alexander Guaman
 */
public class EcuacionCuadratica extends Ecuacion {

    private final double a;
    private final double b;
    private final double c;

    private Double discriminanteCache;

    public EcuacionCuadratica(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("Error: 'a' no puede ser cero.");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double calcularDiscriminante() {
        if (discriminanteCache == null) {
            discriminanteCache = (b * b) - (4 * a * c);
        }
        return discriminanteCache;
    }

    public boolean tieneRaicesReales() {
        return calcularDiscriminante() >= 0;
    }

    public  String obtenerRaices(){
        final double disc = calcularDiscriminante();
        final  double dosA = 2 * a;

        if (disc == 0){
            return "Raiz reales doble; x = " + (-b / dosA);
        }
        final double parteReal = -b / dosA;
        final double parteImaginaria = Math.sqrt(-disc) / dosA;
        return "raices complejas: x1 =" + parteReal + " + " + parteImaginaria + "i, "+
                "x2 =" + parteReal + " - " + parteImaginaria + "i";
    }
    @Override
    public String toString() {
        return a + "x^2 + " + b + "x + " + c + " = 0";
    }
}


