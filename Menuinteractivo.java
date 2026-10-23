package edu.unl.cc;

import edu.unl.cc.domain.EcuacionCuadratica;
import java.util.Scanner;

/**
 * Interfaz de consola interactiva con menú, validación de entradas
 * y formateo de salidas con printf.
 *
 * @author Alexander Guaman
 */
public class MainEcuacionInteractivo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EcuacionCuadratica ecuacion = null;
        int opcion = 0;

        do {
            System.out.println("\n========================================");
            System.out.println("     SISTEMA DE ECUACIONES CUADRÁTICAS   ");
            System.out.println("========================================");
            System.out.println("1. Ingresar coeficientes (a, b, c)");
            System.out.println("2. Mostrar ecuación actual y discriminante");
            System.out.println("3. Calcular y mostrar raíces");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción [1-4]: ");

            // Validación de entrada para la opción del menú
            while (!sc.hasNextInt()) {
                System.out.printf("%n[ERROR] '%s' no es una opción válida. Ingrese un entero: ", sc.next());
            }
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    try {
                        System.out.println("\n--- INGRESO DE COEFICIENTES ---");

                        double a = leerDouble(sc, "Ingrese el coeficiente 'a' (a != 0): ");
                        double b = leerDouble(sc, "Ingrese el coeficiente 'b': ");
                        double c = leerDouble(sc, "Ingrese el coeficiente 'c': ");

                        // Instanciación del dominio
                        ecuacion = new EcuacionCuadratica(a, b, c);
                        System.out.printf("%n[ÉXITO] Ecuación creada correctamente: %s%n", ecuacion);

                    } catch (IllegalArgumentException e) {
                        System.out.printf("%n[EXCEPCIÓN CAPTURADA] %s%n", e.getMessage());
                        ecuacion = null;
                    }
                    break;

                case 2:
                    if (ecuacion == null) {
                        System.out.println("\n[ADVERTENCIA] Primero debe ingresar coeficientes válidos (Opción 1).");
                    } else {
                        System.out.println("\n--- INFORMACIÓN DE LA ECUACIÓN ---");
                        System.out.printf("Expresión:     %s%n", ecuacion);
                        System.out.printf("Coeficiente a: %.2f%n", ecuacion.getA());
                        System.out.printf("Coeficiente b: %.2f%n", ecuacion.getB());
                        System.out.printf("Coeficiente c: %.2f%n", ecuacion.getC());
                        System.out.printf("Discriminante (Δ): %.4f%n", ecuacion.calcularDiscriminante());
                        System.out.printf("¿Tiene raíces reales?: %s%n", ecuacion.tieneRaicesReales() ? "Sí" : "No");
                    }
                    break;

                case 3:
                    if (ecuacion == null) {
                        System.out.println("\n[ADVERTENCIA] Primero debe ingresar coeficientes válidos (Opción 1).");
                    } else {
                        System.out.println("\n--- RESULTADO DE RAÍCES ---");
                        System.out.printf("Ecuación: %s%n", ecuacion);
                        System.out.printf("Solución: %s%n", ecuacion.obtenerRaices());
                    }
                    break;

                case 4:
                    System.out.println("\nGracias por usar el sistema. Programa finalizado.");
                    break;

                default:
                    System.out.printf("%n[ERROR] Opción %d fuera de rango. Seleccione entre 1 y 4.%n", opcion);
            }

        } while (opcion != 4);

        sc.close();
    }

    /**
     * Método auxiliar para validar que el usuario ingrese un número double válido.
     */
    private static double leerDouble(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            System.out.printf("[ERROR] Entrada inválida. %s", mensaje);
            sc.next();
        }
        return sc.nextDouble();
    }
}
