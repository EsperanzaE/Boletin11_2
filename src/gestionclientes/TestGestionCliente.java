package gestionclientes;

import java.io.File;


public class TestGestionCliente {
    public static void main(String[] args) {
   //Creamos un pequeño fichero para ir probando los métodos
   //Los datos se encuentran ordenados ascendentemente por CIF. Cada uno de los campos del registro
   //se encuentra separado por comas(,).

   File ficheroClientes = new File("clientes.txt");
   File ficheroModificaciones = new File("modificaciones.txt");
   File ficheroBajas = new File("bajas.txt");
   File ficheroAltas = new File("altas.txt");

   Cliente cli1 = new Cliente("Pepe", "Rodriguez Rodriguez Rodriguez Pérez Pérez Enciso Borbon", "A1", 1, "felipe I");
   Cliente cli2 = new Cliente("Juan", "Gutiérrez", "B2", 2, "felipe II");
   Cliente cli3 = new Cliente("Manolo", "Ramírez", "C3", 3, "felipe III");
   Cliente cli4 = new Cliente("Diego", "González", "D4", 4, "felipe IV");
   Cliente cli5 = new Cliente("Jesús", "Ridruejo", "E5", 5, "felipe V");

   //probamos el método que da de alta a un cliente al final del fichero
   GestionCliente.altaCliente(ficheroClientes, cli1);
   GestionCliente.altaCliente(ficheroClientes, cli2);
   GestionCliente.altaCliente(ficheroClientes, cli3);
   GestionCliente.altaCliente(ficheroClientes, cli4);
   GestionCliente.altaCliente(ficheroClientes, cli5);

   //probamos el método  ConsultarElementoPorApellidos:
   // procedimiento que muestra el registro al que le corresponda los apellidos pasados por parámetro.
   // Interfaz: void consultarElementoPorApellidos(File fichero, String apellidos)
   GestionCliente.consultarElementoPorApellidos(ficheroClientes, "Ramírez");

   // probamos el método buscarElementoPorApellidos: funcion que devuelve el registro al que le
   // corresponda los apellidos pasados por parámetro.
   // Interfaz: String buscarElementoPorApellidos (File fichero, String apellidos)
   System.out.println(GestionCliente.buscarElementoPorApellidos(ficheroClientes, "Ramírez"));

   // Probamos el método consultarElementoPorCif: procedimiento que muestra el registro al que le
   // corresponda el cif pasado por parámetro.
   // Interfaz: “void consultarElementoPorCif(File fichero, String cif)”
   //   GestionCliente.consultarElementoPorCif(ficheroClientes, "1");
   // NO lo voy a desarrollar porque sería igual que el método consultarElementoPorApellidos

   //Probamos el método insertarModificacionCliente: procedimiento que inserta en el fichero de
   // modificaciones un cliente para ser modificado en un futuro sobre el original de clientes.
   // No se valida que el cliente exista en el fichero maestro.
   // Interfaz: void insertarModifacionCliente(File fichero, Cliente cliente)

   Cliente cli6 = new Cliente("Pepa", "Blanco", "C3", 1, "La borbolla");
   Cliente cli7 = new Cliente("Juana", "Rubio", "D4", 3, "Asunción");

   GestionCliente.insertarModificacionCliente( ficheroModificaciones,  cli6);
   GestionCliente.insertarModificacionCliente( ficheroModificaciones,  cli7);

   // Probamos el método realizarModificaciones: procedimiento que recoge en el fichero clientes todas
   // las modificaciones registradas en el fichero de modificaciones.
   // Interfaz: void realizarModificaciones(File clientes, File modificaciones)

   GestionCliente.realizarModificaciones(ficheroClientes, ficheroModificaciones);

// Probamos el método ordenarFichero: método que ordena un fichero ascendentemente según el compareTo
//implementado para la clase Cliente. Usaremos el método iterativo de spplit/Merge

       //Previamente vamos a insertar más clientes
       Cliente cli8 = new Cliente("Mariquilla", "Blanco", "111A", 1, "La borbolla");
       Cliente cli9 = new Cliente("Juan", "Belmonte", "0000AF", 3, "Asunción");

       GestionCliente.altaCliente(ficheroClientes, cli8);
       GestionCliente.altaCliente(ficheroClientes, cli9);

       GestionCliente.ordenarFichero(ficheroClientes);
    }
}
