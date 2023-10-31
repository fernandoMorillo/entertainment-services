package sec9.entertaiment;

import java.util.ArrayList;
import java.util.List;

class Cliente {
    String nombre;
    String correo;

    private List<CuentaEntretenimiento> cuentas = new ArrayList<>();

    public Cliente(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }
    public void agregarCuenta(CuentaEntretenimiento cuenta) {
        cuentas.add(cuenta);
    }
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }

    public void setNombre (String nuevoNombre) {
        nombre = nuevoNombre;
    }

    public void setCorreo (String nuevoCorreo) {
        correo = nuevoCorreo;
    }
}