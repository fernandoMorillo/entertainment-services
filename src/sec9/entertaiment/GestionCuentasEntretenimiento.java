package sec9.entertaiment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.Date;

public class GestionCuentasEntretenimiento {
    private List<Cliente> clientes;
    private List<CuentaEntretenimiento> cuentasDisponibles;
    private List<CuentaEntretenimiento> cuentasAsignadas;

    public GestionCuentasEntretenimiento() {
        clientes = new ArrayList<>();
        cuentasDisponibles = new ArrayList<CuentaEntretenimiento>();
        cuentasAsignadas = new ArrayList<CuentaEntretenimiento>();
    }

    // Método para registrar un nuevo cliente
    public void registrarCliente(Scanner scanner) {
        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Correo del cliente: ");
        String correo = scanner.nextLine();

        Cliente nuevoCliente = new Cliente(nombre, correo);
        clientes.add(nuevoCliente);
        System.out.println("Cliente registrado con éxito.");
    }

    public void ingresarCuentas(Scanner scanner) {
        System.out.println("Ingresar una nueva cuenta disponible para la venta:");

        System.out.print("Nombre de la cuenta: ");
        String nombreCuenta = scanner.nextLine();

        System.out.print("Tipo de cuenta: ");
        String tipo = scanner.nextLine();

        System.out.println("Fecha de vencimiento: ");
        String fecha_vencimiento = scanner.nextLine();

        CuentaEntretenimiento nuevaCuenta = new CuentaEntretenimiento(nombreCuenta, tipo, null);
        cuentasDisponibles.add(nuevaCuenta);

        System.out.println("Cuenta ingresada con éxito a la lista de cuentas disponibles para la venta.");
    }

    // Método para vender una cuenta
    public void venderCuenta(Scanner scanner) {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados. Registre un cliente primero.");
            return;
        }

        if (cuentasDisponibles.isEmpty()) {
            System.out.println("No hay cuentas disponibles para la venta.");
            return;
        }

        // Mostrar la lista de clientes disponibles
        System.out.println("Clientes registrados:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNombre());
        }

        System.out.print("Seleccione un cliente (número): ");
        int clienteSeleccionado = obtenerEnteroValido(scanner, 1, clientes.size()) - 1;

        // Mostrar la lista de cuentas disponibles
        System.out.println("Cuentas disponibles para la venta:");
        for (int i = 0; i < cuentasDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + cuentasDisponibles.get(i).getNombreCuenta());
        }

        System.out.print("Seleccione una cuenta (número): ");
        int cuentaSeleccionada = obtenerEnteroValido(scanner, 1, cuentasDisponibles.size()) - 1;

        // Vender la cuenta al cliente seleccionado
        Cliente cliente = clientes.get(clienteSeleccionado);
        CuentaEntretenimiento cuenta = cuentasDisponibles.get(cuentaSeleccionada);
        cuenta.setPropietario(cliente);
        cuentasDisponibles.remove(cuenta);
        cliente.agregarCuenta(cuenta);

        System.out.println("Cuenta vendida con éxito a " + cliente.getNombre());
    }

    //Metodo para ver Stock cuenta
    public void verStockCuentas() {
        if (cuentasDisponibles.isEmpty()) {
            System.out.println("No hay cuentas disponibles en el stock.");
        } else {
            System.out.println("Stock de cuentas disponibles:");
            for (int i = 0; i < cuentasDisponibles.size(); i++) {
                CuentaEntretenimiento cuenta = cuentasDisponibles.get(i);
                System.out.println((i + 1) + ". Nombre: " + cuenta.getNombreCuenta());
                System.out.println("   Tipo: " + cuenta.getTipo());
            }
        }
    }

    //Metodo para ver cuentas activas
    public void verCuentasActivas() {
        if (cuentasDisponibles.isEmpty()) {
            System.out.println("No hay cuentas disponibles para mostrar.");
            return;
        }

        System.out.println("Cuentas activas:");
        for (CuentaEntretenimiento cuenta : cuentasDisponibles) {
            if (cuenta.estaActiva()) {
                System.out.println("Nombre: " + cuenta.getNombreCuenta());
                System.out.println("Tipo: " + cuenta.getTipo());
            }
        }
    }

    //Metodo para ver cuenta proxima a vencer
    public void verCuentasProximasAVencer() {
        if (cuentasDisponibles.isEmpty()) {
            System.out.println("No hay cuentas disponibles en el stock.");
        } else {
            Date fechaActual = new Date(); // Obtiene la fecha actual

            System.out.println("Cuentas próximas a vencer:");
            for (CuentaEntretenimiento cuenta : cuentasDisponibles) {
                if (cuenta.getFechaVencimiento() != null && cuenta.getFechaVencimiento().after(fechaActual)) {
                    // Suponemos que getFechaVencimiento() devuelve la fecha de vencimiento de la cuenta
                    System.out.println("Nombre: " + cuenta.getNombreCuenta());
                    System.out.println("Tipo: " + cuenta.getTipo());

                }
            }
        }
    }

    //Metodo para ver Stock cuenta
    public void asignarCuenta(Scanner scanner) {
        if (clientes.isEmpty() || cuentasDisponibles.isEmpty()) {
            System.out.println("No hay clientes registrados o cuentas disponibles para asignar.");
            return;
        }

        System.out.println("Clientes registrados:");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            System.out.println((i + 1) + ". Nombre: " + cliente.getNombre());
            System.out.println("   Correo: " + cliente.getCorreo());
        }

        System.out.print("Seleccione un cliente (número): ");
        int clienteSeleccionado = obtenerEnteroValido(scanner, 1, clientes.size()) - 1;

        System.out.println("Cuentas disponibles para asignar:");
        for (int i = 0; i < cuentasDisponibles.size(); i++) {
            CuentaEntretenimiento cuenta = cuentasDisponibles.get(i);
            System.out.println((i + 1) + ". Nombre: " + cuenta.getNombreCuenta());
            System.out.println("   Tipo: " + cuenta.getTipo());
        }

        System.out.print("Seleccione una cuenta para asignar (número): ");
        int cuentaSeleccionada = obtenerEnteroValido(scanner, 1, cuentasDisponibles.size()) - 1;

        Cliente cliente = clientes.get(clienteSeleccionado);
        CuentaEntretenimiento cuenta = cuentasDisponibles.get(cuentaSeleccionada);

        // Asigna la cuenta al cliente
        cuenta.setPropietario(cliente);
        cuentasDisponibles.remove(cuenta);
        cliente.agregarCuenta(cuenta);

        System.out.println("Cuenta asignada con éxito a " + cliente.getNombre());
    }

    //Metodo para eliminar cuenta
    public void eliminarCuenta(Scanner scanner) {
        if (cuentasDisponibles.isEmpty()) {
            System.out.println("No hay cuentas disponibles para eliminar.");
            return;
        }

        System.out.println("Cuentas disponibles para eliminar:");
        for (int i = 0; i < cuentasDisponibles.size(); i++) {
            CuentaEntretenimiento cuenta = cuentasDisponibles.get(i);
            System.out.println((i + 1) + ". Nombre: " + cuenta.getNombreCuenta());
            System.out.println("   Tipo: " + cuenta.getTipo());
        }

        System.out.print("Seleccione una cuenta para eliminar (número): ");
        int cuentaSeleccionada = obtenerEnteroValido(scanner, 1, cuentasDisponibles.size()) - 1;

        CuentaEntretenimiento cuentaEliminada = cuentasDisponibles.remove(cuentaSeleccionada);
        System.out.println("Cuenta '" + cuentaEliminada.getNombreCuenta() + "' eliminada con éxito.");
    }

    //Metodo para ver actualizar cliente
    public void actualizarCliente(Scanner scanner) {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados para actualizar.");
            return;
        }

        System.out.println("Clientes registrados para actualizar:");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            System.out.println((i + 1) + ". Nombre: " + cliente.getNombre());
            System.out.println("   Correo: " + cliente.getCorreo());
        }

        System.out.print("Seleccione un cliente para actualizar (número): ");
        int clienteSeleccionado = obtenerEnteroValido(scanner, 1, clientes.size()) - 1;

        Cliente cliente = clientes.get(clienteSeleccionado);

        System.out.print("Nuevo nombre del cliente: ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Nuevo correo del cliente: ");
        String nuevoCorreo = scanner.nextLine();

        // Actualiza la información del cliente
        cliente.setNombre(nuevoNombre);
        cliente.setCorreo(nuevoCorreo);

        System.out.println("Información del cliente actualizada con éxito.");
    }

    //Metodo para actualizar cuenta
    public void actualizarCuenta(Scanner scanner) {
        if (cuentasDisponibles.isEmpty()) {
            System.out.println("No hay cuentas disponibles para actualizar.");
            return;
        }

        System.out.println("Cuentas disponibles para actualizar:");
        for (int i = 0; i < cuentasDisponibles.size(); i++) {
            CuentaEntretenimiento cuenta = cuentasDisponibles.get(i);
            System.out.println((i + 1) + ". Nombre: " + cuenta.getNombreCuenta());
            System.out.println("   Tipo: " + cuenta.getTipo());
        }

        System.out.print("Seleccione una cuenta para actualizar (número): ");
        int cuentaSeleccionada = obtenerEnteroValido(scanner, 1, cuentasDisponibles.size()) - 1;

        CuentaEntretenimiento cuenta = cuentasDisponibles.get(cuentaSeleccionada);

        System.out.print("Nuevo nombre de la cuenta: ");
        String nuevoNombreCuenta = scanner.nextLine();

        System.out.print("Nuevo tipo de la cuenta: ");
        String nuevoTipo = scanner.nextLine();

        // Actualiza la información de la cuenta
        cuenta.setNombreCuenta(nuevoNombreCuenta);
        cuenta.setTipo(nuevoTipo);

        System.out.println("Información de la cuenta actualizada con éxito.");
    }


    // Método para obtener un valor entero válido dentro de un rango
    private int obtenerEnteroValido(Scanner scanner, int min, int max) {
        int valor;

        while (true) {
            try {
                valor = Integer.parseInt(scanner.nextLine());
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Valor fuera de rango. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
            }
        }
    }
}
