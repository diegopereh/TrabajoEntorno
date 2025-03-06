/**
* Clase que representa un contacto con nombre, dirección y teléfono.
*/
public class Contacto {
    private String nombre;
       private String telefono;
       private Direccion direccion; 
      /**
        * Constructor de la clase Contacto

        * Constructor de la clase Contacto.

        * @param direccion Dirección del contacto.
        * @param nombre Nombre del contacto
        * @param telefono Teléfono del contacto.
        */
       public Contacto(Direccion direccion, String nombre, String telefono) {
           this.direccion = direccion; 
           this.nombre = nombre;
           this.telefono = telefono;
       }
       /**
        * Obtiene el nombre del contacto.
        * @return Nombre del contacto. 
        */
       public String getNombre() {
           return nombre;
       }
       /**
        * Establece el teléfono del contacto.
        * @param telefono Nuevo teléfono del contacto.
        */
       public String getTelefono() {
           return telefono;
       }
       /**
        * Obtiene la dirección del contacto.
        * @return Dirección del contacto.
        */
       public Direccion getDireccion() {
           return direccion;
       }
      
       public void setNombre(String nombre) {
           if (nombre != null && nombre.matches("^[a-zA-Z]{3,50}$")) {
               this.nombre = nombre;
           } else {
               throw new IllegalArgumentException("Nombre no válido");
           }
       }
      
       public void setTelefono(String telefono) {
           if (telefono != null && telefono.matches("^\\d{9}$")) {
               this.telefono = telefono;
           } else {
               throw new IllegalArgumentException("Teléfono no válido");
           }
       }
       public void setDireccion(Direccion direccion) {
           this.direccion = direccion;
       }
       @Override
       public String toString() {
           return "Contacto{" +
                   "nombre='" + nombre + '\'' +
                   ", telefono='" + telefono + '\'' +
                   ", direccion=" + direccion +
                   '}';
       }
}
