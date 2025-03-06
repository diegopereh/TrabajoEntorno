import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
* Clase GestorContactos que gestiona una lista de contactos.
*/  
public class GestorContactos {
    private List<Contacto> contactos;
    /**
        * Constructor que inicializa la lista de contactos.
        */
       public GestorContactos() {
           contactos = new ArrayList<>();
       } 
       /** 
        * Agrega un nuevo contacto a la lista.
        * 
        * @param contacto El contacto a agregar.
        */
       public void agregarContacto(Contacto contacto) {
           contactos.add(contacto);
       }
       /**
        * Edita un contacto existente buscando por su número de teléfono.
        *
        * @param telefono Número de teléfono del contacto a editar.
        */
     
       public void editarContacto(String telefono) {
            Scanner scanner = new Scanner(System.in);
            Contacto contacto = buscarContactoPorTelefono(telefono);
           
          
  if (contacto != null) {
                System.out.println("Contacto encontrado: " +   contacto.getNombre());
               
                actualizarNombre(contacto, scanner);
                actualizarTelefono(contacto, scanner);
                actualizarDireccion(contacto, scanner);
               
            }else {
                System.out.println("Usuario no encontrado");
            }
       }
     
       private void actualizarNombre(Contacto contacto, Scanner scanner) {
           System.out.println("Nuevo nombre: ");
           String nuevoNombre = scanner.nextLine().trim();   
           if(!nuevoNombre.isEmpty()) {
               contacto.setNombre(nuevoNombre);
           }
       }
     
       private void actualizarTelefono(Contacto contacto, Scanner scanner) {
           System.out.println("Nuevo telefono: ");
           String nuevoTelefono = scanner.nextLine().trim();     
           if(!nuevoTelefono.isEmpty()) {
               contacto.setNombre(nuevoTelefono);
           }
       }
     
       private void actualizarDireccion(Contacto contacto, Scanner scanner) {
           System.out.println("Nueva ciudad: ");
           String nuevaCiudad = scanner.nextLine().trim();   
         
           System.out.println("Nueva calle: ");
           String nuevaCalle = scanner.nextLine().trim();     
         
           System.out.println("Nuevo número: ");
           String nuevoNumeroStr = scanner.nextLine();
         
         
           if(!nuevaCiudad.isEmpty() || !nuevaCalle.isEmpty() || !nuevoNumeroStr.isEmpty()) {
               Direccion direccion = contacto.getDireccion();
               if(!nuevaCiudad.isEmpty()) {
                   direccion.setCiudad(nuevaCiudad);
               }
               if(!nuevaCalle.isEmpty()) {
                   direccion.setCalle(nuevaCalle);
               }
               if(!nuevoNumeroStr.isEmpty()) {
                   direccion.setNumero(Integer.parseInt(nuevoNumeroStr));
               }
           }
       }
     
   
       /**
        * Busca un contacto en la lista por su número de teléfono.
        *
        * @param telefono Número de teléfono del contacto a buscar.
        * @return El contacto encontrado o null si no existe.
        */
       public Contacto buscarContactoPorTelefono(String telefono) {
           for (Contacto contacto : contactos) {
               if (contacto.getTelefono().equals(telefono)) {
                   return contacto;
               }
           }
           return null;
       }
       /**
        * Muestra en la consola la lista de contactos registrados.
        */
       public void listarContactos() {
           if (contactos.isEmpty()) {
               System.out.println("No hay contactos registrados.");
           } else {
               System.out.println("Lista de contactos:");
               for (Contacto contacto : contactos) {
                   System.out.println(contacto);
               }
           }
       }
} 

