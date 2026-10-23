package edu.unl.cc;

import edu.unl.cc.domain.EcuacionCuadratica;
/**
 * Clase de prueba rápida para verificar el comportamiento de EcuacionCuadratica
 * cubriendo raíces reales distintas, raíz doble, complejas y manejo de errores.
 *
 * @author Alexander Guaman
 */
public class MainEcuacionInteractivo {

    public static void main(String[] args) {
        System.out.println("=== EJECUCIÓN DE PRUEBAS AUTOMÁTICAS ===\n");

        // Caso 1: Raíces Reales Distintas (x^2 - 5x + 6 = 0 -> x1=3, x2=2)
        probarEcuacion("Caso 1 (Raíces distintas)", 1, -5, 6);

        // Caso 2: Raíz Real Doble (x^2 - 4x + 4 = 0 -> x=2)
        probarEcuacion("Caso 2 (Raíz doble)", 1, -4, 4);

        // Caso 3: Raíces Complejas Conjugadas (x^2 + 2x + 5 = 0)
        probarEcuacion("Caso 3 (Raíces complejas)", 1, 2, 5);

        // Caso 4: Excepción al enviar 'a = 0'
        probarEcuacionInvalida("Caso 4 (Coeficiente 'a' igual a 0)", 0, 4, 2);
    }

    private static void probarEcuacion(String titulo, double a, double b, double c) {
        System.out.println("--- " + titulo + " ---");
        EcuacionCuadratica eq = new EcuacionCuadratica(a, b, c);
        System.out.println("Ecuación: " + eq);
        System.out.println("Discriminante (Δ): " + eq.calcularDiscriminante());
        System.out.println("Resultado: " + eq.obtenerRaices());
        System.out.println();
    }

    private static void probarEcuacionInvalida(String titulo, double a, double b, double c) {
        System.out.println("--- " + titulo + " ---");
        try {
            EcuacionCuadratica eq = new EcuacionCuadratica(a, b, c);
            System.out.println("Ecuación: " + eq);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada con éxito -> " + e.getMessage());
        }
        System.out.println();
    }
}
