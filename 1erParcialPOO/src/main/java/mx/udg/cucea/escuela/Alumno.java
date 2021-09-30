package mx.udg.cucea.escuela;

/**
 *
 * @author murillo
 */
public class Alumno {
    private String nombre;
    private float calificacion1;
    private float calificacion2;
    private float calificacion3;

    public Alumno(String nombre, float calificacion1, float calificacion2, float calificacion3) {
        this.nombre = nombre;
        this.calificacion1 = calificacion1;
        this.calificacion2 = calificacion2;
        this.calificacion3 = calificacion3;
    }

    public float getCalificacion3() {
        return calificacion3;
    }

    public void setCalificacion3(float calificacion3) {
        this.calificacion3 = calificacion3;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCalificacion1() {
        return calificacion1;
    }

    public void setCalificacion1(float calificacion1) {
        this.calificacion1 = calificacion1;
    }

    public float getCalificacion2() {
        return calificacion2;
    }

    public void setCalificacion2(float calificacion2) {
        this.calificacion2 = calificacion2;
    }
    
    public float promedio(){
        return (calificacion1+calificacion2+calificacion3)/3;
    }
}
