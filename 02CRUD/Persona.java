/*
 * Vamos a crear una aplicacion
 * para poder tener una plantilla
 * de registro
 * 
 * 
*/
public class Persona {

    private static int contId = 1;
    private int id, edad;
    private String nombre;

    // constructor
    public Persona() {
    }

    public Persona(String nombre, int edad) {
        this.id = contId++;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}