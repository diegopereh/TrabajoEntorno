import java.util.Scanner; 
/**
* Clase principal que ejecuta el programa del Gestor de Contactos. 
* Proporciona un menú interactivo para agregar, editar, buscar y listar contactos.
*/
public class main {
  
   /**
    * Método principal que ejecuta el gestor de contactos.
    * Muestra un menú de opciones y permite al usuario interactuar con el gestor.
    *
    * @param args Argumentos de la línea de comandos, no utilizados en este caso.
    */
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       GestorContactos gestor = new GestorContactos(); // Gestor que maneja los contactos
       while (true) {
           // Menú de opciones para el usuario 
           System.out.println("╔═════════════════════════╗");
           System.out.println("║   Gestor de Contactos   ║");
           System.out.println("╚═════════════════════════╝");
           System.out.println("║ 1. Agregar Contacto     ║");
           System.out.println("║ 2. Editar Contacto      ║");
           System.out.println("║ 3. Buscar Contacto      ║");
           System.out.println("║ 4. Listar Contactos     ║");
           System.out.println("║ 5. Salir                ║");
           System.out.println("╚═════════════════════════╝");
           System.out.print("Seleccione una opción: ");
           int opcion = sc.nextInt();
           sc.nextLine(); // Limpia el buffer de la entrada
           switch (opcion) {
               case 1:
                   // Agregar un nuevo contacto
                   System.out.print("Ingrese el nombre: ");
                   String nombre = sc.nextLine();
                   System.out.print("Ingrese el teléfono: ");
                   String telefono = sc.nextLine();
                   System.out.print("Ingrese la ciudad: ");
                   String ciudad = sc.nextLine();
                   System.out.print("Ingrese la calle: ");
                   String calle = sc.nextLine();
                   System.out.print("Ingrese el número: ");
                   int numero = sc.nextInt();
                   sc.nextLine(); // Limpia el buffer
                   // Crea un objeto Direccion y un Contacto con la información proporcionada
                   Direccion direccion = new Direccion(calle, ciudad, numero);
                   Contacto nuevoContacto = new Contacto(direccion, nombre, telefono);
                   gestor.agregarContacto(nuevoContacto); // Agrega el nuevo contacto al gestor
                   System.out.println("Contacto agregado correctamente.");
                   break;
               case 2:
                   // Editar un contacto existente por teléfono
                   System.out.print("Ingrese el teléfono del contacto a editar: ");
                   String telefonoEditar = sc.nextLine();
                   gestor.editarContacto(telefonoEditar); // Llama al método de editar contacto
                   break;
               case 3:
                   // Buscar un contacto por teléfono
                   System.out.print("Ingrese el teléfono del contacto a buscar: ");
                   String telefonoBuscar = sc.nextLine();
                   Contacto contactoEncontrado = gestor.buscarContactoPorTelefono(telefonoBuscar);
                   if (contactoEncontrado != null) {
                       System.out.println("Contacto encontrado: " + contactoEncontrado); // Muestra el contacto encontrado
                   } else {
                       System.out.println("Contacto no encontrado."); // Muestra mensaje si no se encuentra
                   }
                   break;
               case 4:
                   // Listar todos los contactos
                   gestor.listarContactos();
                   break;
               case 5:
                   // Salir del programa
                   System.out.println("Saliendo del gestor de contactos...");
                   sc.close(); // Cierra el scanner
                   return; // Termina el programa
               default:
                   // Opción no válida
                   System.out.println("Opción no válida. Intente de nuevo.");
           }
       }
   }
}
