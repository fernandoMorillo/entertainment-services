import sec9.entertaiment.GestionCuentasEntretenimiento;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        GestionCuentasEntretenimiento gestionCuentasEntretenimiento = new GestionCuentasEntretenimiento();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int opcion = obtenerOpcionValida(scanner);

            switch (opcion) {
                case 1:
                    gestionCuentasEntretenimiento.registrarCliente(scanner);
                    break;
                case 2:
                    gestionCuentasEntretenimiento.venderCuenta(scanner);
                    break;
                case 3:
                    gestionCuentasEntretenimiento.verStockCuentas();
                    break;
                case 4:
                    gestionCuentasEntretenimiento.verCuentasActivas();
                    break;
                case 5:
                    gestionCuentasEntretenimiento.verCuentasProximasAVencer();
                    break;
                case 6:
                    gestionCuentasEntretenimiento.asignarCuenta(scanner);
                    break;
                case 7:
                    gestionCuentasEntretenimiento.eliminarCuenta(scanner);
                    break;
                case 8:
                    gestionCuentasEntretenimiento.actualizarCliente(scanner);
                    break;
                case 9:
                    gestionCuentasEntretenimiento.actualizarCuenta(scanner);
                    break;
                case 10:
                    gestionCuentasEntretenimiento.ingresarCuentas(scanner);
                    break;
                case 11:
                    System.out.println("Gracias por utilizar el sistema de gestión de cuentas de entretenimiento.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }


    }

    private static void mostrarMenu() {
        System.out.println("*************************************************************************");
        System.out.println("******** Bienvenido a su gestor Ventas de entretenimiento *********");
        System.out.println("*************************************************************************");
        System.out.println("Menú de opciones:");
        System.out.println("1. Registrar un cliente");
        System.out.println("2. Vender una cuenta");
        System.out.println("3. Ver stock de cuentas");
        System.out.println("4. Ver cuentas activas");
        System.out.println("5. Ver cuentas próximas a vencer");
        System.out.println("6. Asignar una cuenta");
        System.out.println("7. Eliminar cuenta");
        System.out.println("8. Actualizar cliente");
        System.out.println("9. Actualizar cuenta");
        System.out.println("10. Ingresar cuenta");
        System.out.println("11. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int obtenerOpcionValida(Scanner scanner) {
        int opcion = 0;
        boolean opcionValida = false;

        do {
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                opcionValida = opcion >= 1 && opcion <= 11;
                if (!opcionValida) {
                    System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (!opcionValida);

        return opcion;
    }
}