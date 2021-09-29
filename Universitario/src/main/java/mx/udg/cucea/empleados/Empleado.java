package mx.udg.cucea.empleados;

import java.util.Date;
import mx.udg.cucea.universitarios.Universitario;

public class Empleado extends Universitario {
    private float sueldo;
    private String puesto;
    private String departamento;
    private Date fechaIngreso;
    
    private Empleado(long codigo, String nombres, String apellidoPaterno, char genero, String domicilio, long telefono) {
        super(codigo, nombres, apellidoPaterno, genero, domicilio, telefono);
    }
    
    public Empleado(long codigo, String nombres, String apellidoPaterno, char genero, String domicilio, long telefono, String puesto, String departamento) {
        this(codigo, nombres, apellidoPaterno, genero, domicilio, telefono);
        this.puesto = puesto;
        this.departamento = departamento;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
}
