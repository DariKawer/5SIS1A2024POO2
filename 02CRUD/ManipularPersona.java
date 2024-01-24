import java.util.Scanner;

public class ManipularPersona {

    public void menu() {
        Scanner entrada = new Scanner(System.in);
        int opcion, edad;
        String nombre;

        AccionesPersona p1 = new AccionesPersona();

        Persona persona1 = new Persona(01, "Jose", 50);
        p1.agregarPersona(persona1);
        Persona persona2 = new Persona(02, "Maria", 25);
        p1.agregarPersona(persona2);
        Persona persona3 = new Persona(03, "Javier", 34);
        p1.agregarPersona(persona3);
        Persona persona4 = new Persona(04, "Pedro", 18);
        p1.agregarPersona(persona4);
        Persona persona5 = new Persona(05, "Juan", 31);
        p1.agregarPersona(persona5);


        do {
            System.out.println("Bienvenido a este programa");
            System.out.println("Elija una opcion valida");
            System.out.println("1.- Mostrar todos los registros de personas");
            System.out.println("2.- Registrar un nuevo objeto");
            System.out.println("3.- Buscar objeto");
            System.out.println("4.- Editar ese objeto");
            System.out.println("5.- Borrar el objeto");
            System.out.println("6.- Salir");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    p1.mostrarRegistro();
                    break;
                case 2:
                    entrada.nextLine();
                    System.out.println("Ingresa nombre");
                    nombre = entrada.nextLine();
                    System.out.println("Ingresa edad");
                    edad = entrada.nextInt();
                
                    p1.agregarPersona(new Persona(06, nombre, edad));
                    break;
                case 3:
                    System.out.println("Ingresa el ID de la persona a buscar");
                    int busqueda = entrada.nextInt();
                    p1.buscarPersona(busqueda);
                    break;
                case 4:
                    System.out.println("Ingresa el ID de la persona a editar");
                    int editado = entrada.nextInt();
                    Persona editarPersona = p1.buscarPersona(editado);
                    if(editarPersona != null) {
                        System.out.println("Ingresa nombre a editar");
                        entrada.nextLine();
                        nombre = entrada.nextLine();
                        System.out.println("Ingresa edad a editar");
                        edad = entrada.nextInt();

                        editarPersona.setNombre(nombre);
                        editarPersona.setEdad(edad);
                        p1.editarPersona(editarPersona);
                        System.out.println("Editado correctamente");
                    }
                    break;
                case 5:
                    System.out.println("Ingresa el ID de la persona a eliminar");
                    int eliminado = entrada.nextInt();
                    Persona eliminarPersona = p1.buscarPersona(eliminado);
                    if(eliminarPersona != null) {
                    p1.eliminarPersona(eliminarPersona);
                    System.out.println("Elimnado correctamente");
                    }
                    break;
                case 6:
                    System.out.println("chao viejo");
                    break;
                default:
                    System.out.println("Opcion no valida intenta de nuevo");
            }
        } while (opcion != 6);
    }

    public static void main(String[] args) {
        ManipularPersona wey = new ManipularPersona();
        wey.menu();
    }
}
