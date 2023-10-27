package sec9.entertaiment;

import java.util.Date;  // Para trabajar con fechas

class CuentaEntretenimiento {
    private String nombreCuenta;
    private String tipo;
    private boolean activa;
    private Cliente propietario;
    private Date fechaVencimiento;

    public CuentaEntretenimiento(String nombreCuenta, String tipo, Date fechaVencimiento) {
        this.nombreCuenta = nombreCuenta;
        this.tipo = tipo;
        this.activa = true;
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setPropietario(Cliente cliente) {
        propietario = cliente;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean estaActiva() {
        return activa;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void asignar() {
        activa = true;
    }

    public void desactivar() {
        activa = false;
    }


}

