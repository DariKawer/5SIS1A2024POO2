import java.util.*;

public class AccionesPersona {

    public ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

    // Listar personas
    public ArrayList<Persona> mostrarPersonas() {
        return listaPersonas;
    }

    // Registrar persona
    public void agregarPersona(Persona p) {
        listaPersonas.add(p);
    }

    // Buscar persona
    public Persona buscarPersona(int id) {
        Persona encontrada = null;
        for (Persona p : listaPersonas) {
            if (id == p.getId()) {
                encontrada = p;
                System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre() + ", Edad: " + p.getEdad());
                break;
            }
        }
        if (encontrada == null) {
            System.out.println("Persona no encontrada");
        }
        return encontrada;
    }

    // Actualizar persona
    public void actualizarPersona(Persona actualizada) {
        Persona encontrada = buscarPersona(actualizada.getId());
        if (encontrada != null) {
            listaPersonas.remove(encontrada);
            listaPersonas.add(actualizada);
        } else {
            System.out.println("Persona no encontrada");
        }
    }

    // Eliminar persona
    public void eliminarPersona(Persona eliminar) {
        listaPersonas.remove(eliminar);
        acomodarID();
    }

    // Acomodar bien los ids
    public void acomodarID() {
        for (int i = 0; i < listaPersonas.size(); i++) {
            listaPersonas.get(i).setId(i + 1);
        }
    }

    // Editar datos de persona
    public void editarPersona(Persona editar) {
        Persona encontrada = buscarPersona(editar.getId());
        if (encontrada != null) {
            encontrada.setNombre(editar.getNombre());
            encontrada.setEdad(editar.getEdad());
        } else {
            System.out.println("Persona no encontrada");
        }
    }

    // Mostrar tabla
    public void mostrarRegistro() {
        ArrayList<Persona> personas = mostrarPersonas();
        System.out.println("Registro:");
        System.out.println("===================================");
        for (Persona p : personas) {
            System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre() + ", Edad: " + p.getEdad());
        }
    }
}
