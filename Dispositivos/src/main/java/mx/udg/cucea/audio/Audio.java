package mx.udg.cucea.audio;

/**
 *
 * @author murillo
 */
public class Audio {
    private int year;
    private int capacidad;
    private String modelo;
    private String marca;
    private String color;
    private String material;
    private boolean isHighRes;
    

    public Audio(int year, int capacidad, String modelo, String marca, String color) {
        this.year = year;
        this.capacidad = capacidad;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
    }
    
    public void mostrarDetallesAudio(){
        System.out.println("Marca: " + marca +
                         "\nModelo: " + modelo +
                         "\nMaterial: " + material + 
                         "\nColor: " + color +
                         "\nCapacidad: " + capacidad + " gb" + 
                         "\nAño Lanzamiento: " + year);
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isIsHighRes() {
        return isHighRes;
    }

    public void setIsHighRes(boolean isHighRes) {
        this.isHighRes = isHighRes;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
}
