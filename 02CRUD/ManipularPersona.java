import java.util.Scanner;

public class ManipularPersona {

    public void menu() {
        Scanner entrada = new Scanner(System.in);
        int opcion, edad;
        String nombre, op1;

        AccionesPersona gestionar = new AccionesPersona();

        gestionar.agregarPersona(new Persona("Jose", 50));
        gestionar.agregarPersona(new Persona("Maria", 25));
        gestionar.agregarPersona(new Persona("Javier", 34));
        gestionar.agregarPersona(new Persona("Pedro", 18));
        gestionar.agregarPersona(new Persona("Juan", 31));

        do {
            System.out.println("===================================");
            System.out.println("Elija una opcion:");
            System.out.println("1.- Mostrar registro de personas");
            System.out.println("2.- Registrar una nueva persona");
            System.out.println("3.- Buscar persona");
            System.out.println("4.- Editar datos de la persona");
            System.out.println("5.- Borrar una persona");
            System.out.println("6.- Salir");
            opcion = entrada.nextInt();
            System.out.println("===================================");

            switch (opcion) {
                case 1:
                    gestionar.mostrarRegistro();
                    break;

                case 2:
                    entrada.nextLine();
                    System.out.println("Ingrese el nombre:");
                    nombre = entrada.nextLine();
                    System.out.println("Ingrese la edad:");
                    edad = entrada.nextInt();

                    gestionar.agregarPersona(new Persona(nombre, edad));
                    System.out.println("===================================");
                    System.out.println("Registrado correctamente!");
                    break;

                case 3:
                    System.out.println("Ingresa el ID de la persona a buscar:");
                    int busquedaID = entrada.nextInt();
                    System.out.println("===================================");

                    System.out.println("Resultado de busqueda:");
                    gestionar.buscarPersona(busquedaID);
                    break;

                case 4:
                    System.out.println("Ingresa el ID de la persona a editar:");
                    int editadoID = entrada.nextInt();

                    System.out.println("===================================");
                    System.out.println("Editando a:");
                    Persona editarPersona = gestionar.buscarPersona(editadoID);
                    System.out.println("===================================");

                    if(editarPersona != null) {
                        System.out.println("Ingresa nuevo nombre:");
                        entrada.nextLine();
                        nombre = entrada.nextLine();
                        System.out.println("Ingresa nueva edad:");
                        edad = entrada.nextInt();

                        editarPersona.setNombre(nombre);
                        editarPersona.setEdad(edad);

                        System.out.println("===================================");
                        System.out.println("Resultado de la editación:");
                        gestionar.editarPersona(editarPersona);
                        System.out.println("===================================");
                        System.out.println("Editado correctamente");
                    }
                    break;

                case 5:
                    System.out.println("Ingresa el ID de la persona a eliminar:");
                    int eliminadoID = entrada.nextInt();

                    System.out.println("===================================");
                    System.out.println("Eliminando a:");
                    Persona eliminarPers = gestionar.buscarPersona(eliminadoID);
                    System.out.println("===================================");

                    if (eliminarPers != null) {
                        gestionar.eliminarPersona(eliminarPers);
                        System.out.println("Elimnado correctamente");
                    }
                    break;

                case 6:
                    System.out.println("Programado finalizado! chao viejo");
                    break;

                default:
                    System.out.println("Opcion no valida intenta de nuevo");
                    break;
            }

            entrada.nextLine();
            System.out.println("===================================");
            System.out.println("Queres continuar? (Y/N)");
            op1 = entrada.nextLine();
        } while (opcion != 6 && !(op1.equals("N") || op1.equals("n")));

        entrada.close();
    }
}
