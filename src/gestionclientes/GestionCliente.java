package gestionclientes;

import java.io.*;
import java.util.Scanner;

/**
 * PROPIEDADES
 * <p>
 * ninguna
 * <p>
 * <p>
 * METODOS:
 * <p>
 * altaCliente: procedimiento que registra un cliente en el final de un fichero de texto
 * consultarElementoPorApellidos: procedimiento que muestra el registro al que le corresponda los apellidos pasados por parametro
 * consultarElementoPorCif: procedimiento que muestra el registro al que le corresponda el cif pasado por parametro
 * buscarElementoPorApellidos: funcion que devuelve el registro al que le corresponda los apellidos pasado por parametro
 * buscarElementoPorCif: funcion que devuelve el registro al que le corresponda el cif pasado por parametro
 * insertarModificacionCliente: procedimiento que inserta en el fichero de modificaciones un cliente para ser modificado en un futuro sobre le original de clientes
 * insertarBajaCliente: procedimiento que inserta en el fichero d ebajas un cliente para ser dado de baja en en un futuro sobre el fichero original de clientes
 * realizarAltas: procedimiento que recoge en el fichero clientes todas las altas registradas en el fichero de altas
 * realizarBajas: procedimiento que recoge en el fichero clientes todas las altas registradas en el fichero de bajas
 * relizarModificaciones: procedimiento que recoge en el fichero clientes todas las modificaciones registradas en el fichero de modificaciones
 * transformarAObjeto: funcion que transforma un registro cliente en forma de cadena a un objeto cliente
 * ordenarFichero: metodo que ordena un fichero ascendentemente segun el compareTo implementado por el registro
 * <p>
 * altaClienteOrdenado: procedimiento que registra un cliente en el lugar que le corresponde en un fichero de texto segun cif
 * modificarElemento:procedimiento que modifica un elemento del fichero directamente con ayuda de un fichero auxiliar
 * bajaElemento: procedimiento que borra del fichero un elemento directamente con ayuda de un fichero auxiliar
 * <p>
 * <p>
 * INTERFACES
 * void altaCliente(File fichero,Cliente cliente)
 * Cliente transformarAObjeto(String registro)
 * void consultarElementoPorApellidos(File fichero, String apellidos)
 * void consultarElementoPorCif(File fichero, String cif)
 * Cliente buscarElementoPorApellidos (File fichero, String apellidos)
 * Cliente buscarElementoPorCif (File fichero, String apellidos)
 * void insertarModifacionCliente(File fichero, Cliente cli)
 * void insertarBajaCliente(File fichero, Cliente cli)
 * void realizarAltas(File clientes, File altas)
 * void realizarModificaciones(File clientes, File modificaciones)
 * void realizarBajas(File clientes, File bajas)
 * * <p>
 * * <p>
 * * <p>
 * * <p>
 * void altaClienteOrdenado(File fichero, Cliente cliente)
 * void modificarElemento(File fichero, String registroViejo, Cliente registroNuevo)
 * void bajaElemento(File fichero, String registro)
 */

/**
 * procedimiento que escribe en un fichero de texto un cliente al final del fichero
 * entrada un objeto file y un objeto cliente a escribir
 * precondiciones el cliente debe ser válido. el fichero no tiene por que existir
 * salida nada
 * postcondiciones el cliente queda registrado a final de fichero en forma de cadena
 */
public class GestionCliente {

    public static void altaCliente(File ficheroClientes, Cliente cliente) {
        FileWriter fileWriter = null;
        BufferedWriter output = null;
        try {

            fileWriter = new FileWriter(ficheroClientes, true);
            output = new BufferedWriter(fileWriter);
            output.write(cliente.toString()); //así se guarda un registro como string
            output.newLine();//salto de línea

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("no se encuentra el fichero de clientes");
        } catch (IOException ioException) {
            System.out.println("error al escribir el fichero de clientes");

        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (Exception exception) {
                    System.out.println("erro al cerrar el fichero de clientes");
                }
            }
        }
    }

    /**
     * procedimiento que realiza una consulta a un fichero de texto y muestra el registro correspondiente en pantalla
     * entrada un fichero de texto y una cadena que corresponde a los apellidos del registro a consultar
     * precondiciones ambas entradas son válidas
     * salida nada
     * postcondicion en caso de existir un registro con dichos apellidos se mostrara en pantalla con todos sus datos
     *
     * @param ficheroClientes
     * @param apellido
     */
    public static void consultarElementoPorApellidos(File ficheroClientes, String apellido) {

        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        Scanner scanner = null;
        String registro = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(ficheroClientes));
            registro = bufferedReader.readLine();
            while (registro != null) {
                scanner = new Scanner(registro);
                String[] datos = registro.split(",");

                if (datos[1].equals(apellido)) {

                    System.out.print("registro encontrado: ");
                    System.out.println(registro);
                }
                registro = bufferedReader.readLine();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("no se encuentra el fichero de clientes en consultarElementoPorApellidos");
        } catch (IOException ioException) {
            System.out.println("error al escribir el fichero de clientes en ");

        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception exception) {
                    System.out.println("error al cerrar el fichero en el método consultarElementoPorApellidos");
                }
            }
        }


    }

    /**
     * funcion que busca en un fichero de texto un registro tipo cliente mediante los apellidos
     * entrada un fichero y una cadena que corresponde al cif del elemento a buscar
     * precondiciones ambos deben ser validos
     * salida una cadena
     * postcondiciones la cadena es el registro del fichero correspondiente a los apellidos introducidos
     *
     * @param ficheroClientes
     * @param apellido
     * @return
     */
    public static String buscarElementoPorApellidos(File ficheroClientes, String apellido) {


        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        Scanner scanner = null;
        String registro = "", cadena = "";
        boolean encontrado = false;
        try {
            bufferedReader = new BufferedReader(new FileReader(ficheroClientes));
            registro = bufferedReader.readLine();
            while (registro != null && !encontrado) {
                scanner = new Scanner(registro);
                String[] datos = registro.split(",");

                if (datos[1].equals(apellido)) {
                    encontrado = true;
                    System.out.print("registro encontrado: ");
                    System.out.println(registro);
                    cadena = registro;

                }
                registro = bufferedReader.readLine();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("error fichero no encontrado en metodo buscarElementoPorApellidos");
            ;
        } catch (IOException ioException) {
            System.out.println("error IO en método buscarElementoPorApellidos");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception exception) {
                    System.out.println("error al cerrar el fichero en el método buscarElementoPorApellidos");
                }
            }
            return cadena;
        }

    }

    /**
     * procedimiento que inserta en el fichero de modificaciones pasado por parametro el cliente pasado por parametro
     * entrada un fichero de modificaciones para clientes y el cliente a modificar
     * salida nada
     * precondiciones ambos son validos
     * postcondiciones el cliente queda registrado en el fichero de modificación
     *
     * @param ficheroModificaciones
     * @param cliente
     */
    public static void insertarModificacionCliente(File ficheroModificaciones, Cliente cliente) {

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {

            fileWriter = new FileWriter(ficheroModificaciones, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(cliente.toString());
            bufferedWriter.newLine();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("error de fichero no encontrado en método insertarModificacionCliente");
            ;
        } catch (IOException e) {
            System.out.println("error IO en método insertarModificacionCliente");
            ;
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (Exception e) {
                    System.out.println("error al cerrar el archivo buffer en metodo insertarModificacionCliente");
                }
            }
        }
    }

    /**
     * procedimiento que realiza todas las modificaciones registradas en el fichero de modificaciones
     * entrada dos ficheros, el original de clientes y el de modificaciones
     * salida nada
     * precondiciones ambos son validos
     * postcondiciones el fichero clientes recogerá todas las modificaciones registradas en el fichero de modificaciones
     *
     * @param ficheroClientes
     * @param ficheroModificaciones
     */
    public static void realizarModificaciones(File ficheroClientes, File ficheroModificaciones) {
        Cliente clienteleido = null;
        Cliente clienteConModificacion = null;

        String lineaLeida = "";
        String lineaAModificar = "";

        File ficheroFinal = null;//fichero definitivo que se renombrará con el nombre del fichero original
        FileWriter fileWriter = null;
        BufferedWriter output = null;

        FileReader fileReader = null;//fichero de modificaciones
        BufferedReader inputModificaciones = null;

        FileReader fileReader1 = null;//fichero original de clientes
        BufferedReader inputOriginal = null;

        ficheroFinal = new File("ficheroFinal.txt");
        try {
            //abrimos el fichero que tendrá el fichero original con las modificaciones
            fileWriter = new FileWriter(ficheroFinal);
            output = new BufferedWriter(fileWriter);
            //abrimos el fichero que contiene el fichero original
            fileReader = new FileReader(ficheroClientes);
            inputOriginal = new BufferedReader(fileReader);
            //abrimos el fichero que contiene el fichero con las modificaciones
            fileReader1 = new FileReader(ficheroModificaciones);
            inputModificaciones = new BufferedReader(fileReader1);
            //leemos un registro de cada uno de los ficheros de entrada
            lineaLeida = inputOriginal.readLine();
            lineaAModificar = inputModificaciones.readLine();
            //mientras no lleguemos al final en ninguno de los ficheros
            while (lineaAModificar != null && lineaLeida != null) {
                //transformamos el string que hay en los ficheros en un objeto usando split
                clienteleido = transformarAObjeto(lineaLeida);
                clienteConModificacion = transformarAObjeto(lineaAModificar);
                //si ambos registros son iguales, tienen el mismo CIF
                if (clienteleido.compareTo(clienteConModificacion) == 0) {
                    //se escribe  en el fichero de salida el registro del fichero de las modificaciones
                    output.write(clienteConModificacion.toString());
                    output.newLine();
                    //se lee de nuevo cada uno de los ficheros de entrada
                    lineaAModificar = inputModificaciones.readLine();
                    lineaLeida = inputOriginal.readLine();
                } else {
                    //si no son iguales, se escribe en el fichero de salida, el registro del fichero
                    //original de clientes y se hace una nueva lectura de éste
                    output.write(clienteleido.toString());
                    output.newLine();
                    lineaLeida = inputOriginal.readLine();
                }
            }//si no se ha llegado al final del fichero con lso clientes origianles, se vuelca éste
            // directamente en el fichero de salida
            while (lineaLeida != null) {
                output.write(lineaLeida);
                output.newLine();
                lineaLeida = inputOriginal.readLine();
            }
        } catch (IOException ioException) {
            System.out.println("error de entrada salida en método realizarModificaciones");;
        } finally {
            try {
                output.close();
                inputModificaciones.close();
                inputOriginal.close();
                ficheroClientes.delete();
                //modificaciones.delete();
                ficheroFinal.renameTo(new File("clientes.txt"));
            } catch (Exception e) {
                System.out.println("error en el cierre de algún fichero del método realizarModificaciones");;
            }
        }
    }
    /**
     * funcion que transforma un registro de un fichero de texto en un objeto cliente
     * entrada una cadena
     * precondiciones la cadena debe valida. Corresponde a un registro tipo cliente de un fichero de texto
     * el método toString de la clase Cliente NO contiene los literales de los atributos
     * salida un cliente
     * postcondiciones la cadena enviada por parametro sale devuelta en un objeto cliente
     *
     * @param registro
     * @return
     * @throws IOException
     */
    private static Cliente transformarAObjeto(String registro) {
        String[] campos = registro.split(",");
        int categoria = Integer.parseInt(campos[3]);
        return new Cliente(campos[0], campos[1], campos[2], categoria, campos[4]);
    }
    /**
     * procedimiento que ordena un fichero de forma ascendente segun el compareTo implementado por
     * el registro del fichero
     * entrada un fichero a ordenar
     * precondiciones el fichero debe existir y estar lleno
     * salida nada
     * postcondiciones el fichero queda ordenado ascendentemente
     */

    public static void ordenarFichero(File ficheroClientes) {
        boolean ordenado = false;
        String AUX1 = "aux1.txt", AUX2 = "aux2.txt";


            ordenado = dividirSplit(ficheroClientes, AUX1, AUX2);
            while (!ordenado) {

                fusionarMerge(ficheroClientes, AUX1, AUX2);
                ordenado = dividirSplit(ficheroClientes, AUX1, AUX2);
            }

    }
    /**
     * este proceso leerá del fichero aux1 y del aux2 e irá colocando en el fichero de salida
     * el menor que se encuentre, aunque esto no quiere decir que se ordenen en la primera
     * pasada ya que los ficheros aux1 y aux2 no tienen por qué estar ordenados
     * @param ENTRADA fichero de entrada que ahora será fichero de salida se devolverá
     *                con los ficheros aux1 y aux2 fusionados con el orden que estos tengan
     * @param AUX1
     * @param AUX2
     */
    private static void fusionarMerge(File ENTRADA, String AUX1, String AUX2) {
        BufferedWriter output = null;
        BufferedReader input1 = null, input2 = null;
        String linea1="", linea2="";
        Cliente cliente1=null, cliente2=null;

        try{
            output= new BufferedWriter(new FileWriter(ENTRADA));
            input1=new BufferedReader(new FileReader(AUX1));
            input2=new BufferedReader(new FileReader(AUX2));
            linea1=input1.readLine();
            cliente1=transformarAObjeto(linea1);
            linea2=input2.readLine();
            cliente2=transformarAObjeto(linea2);

            while (linea1!=null && linea2!=null){
                if (cliente1.compareTo(cliente2)<0){
                    output.write(linea1);
                    output.newLine();
                    linea1=input1.readLine();
                    cliente1=transformarAObjeto(linea1);
                }else{
                    output.write(linea2);
                    output.newLine();
                    linea2=input2.readLine();
                    cliente2=transformarAObjeto(linea2);
                }
            }
            while (linea1!=null ){
                output.write(linea1);
                output.newLine();
                linea1=input1.readLine();
            }
            while (linea2!=null ){
                output.write(linea2);
                output.newLine();
                linea2=input2.readLine();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                output.close();
                input1.close();
                input2.close();
            }catch (Exception exception){
                System.out.println("algo ha pasado al cerrar algún archivo");

        }

    }}

    /**
     * Este procedimiento divide en dos un fichero mientras esté desordenado, Lee cada registro y si es
     * mayor que el anterior lo mete en un fichero, cuando se encuetra un registro leido menor que el anterior
     * lo escribe en el otro fichero y así sucesivamente alternando el fichero de salida cada vez que se
     * encuentre un dato menor que el anteriormente leido
     *
     * @param ENTRADA fichero secuencial de entrada
     * @param AUX1    con una parte del archivo de entrada
     * @param AUX2    con la otra parte del archivo de entrada
     * @return devuelve true si el fichero de entrada está ordenado y no hay que seguir
     * @throws IOException
     */
    private static boolean dividirSplit(File ENTRADA, String AUX1, String AUX2) {
        BufferedReader input = null;
        BufferedWriter out = null, outAuxiliar = null;
        String linea = "", lineaPrevia = "";
        Cliente cliente=null, clientePrevio=null;
        boolean ordenado = true;
        try {
            input = new BufferedReader(new FileReader(ENTRADA));
            out = new BufferedWriter(new FileWriter(AUX1));
            outAuxiliar = new BufferedWriter(new FileWriter(AUX2));

            linea = input.readLine();

            while (linea != null) {
                cliente=transformarAObjeto(linea);
                if (cliente.compareTo(clientePrevio) < 0) {//acabo de leer un valor menor que el anterior por lo que
                    //tengo que cambiar de archivo y seguir ordenando
                    ordenado = false;
                    BufferedWriter temp = outAuxiliar;
                    outAuxiliar = out;
                    out = temp;
                }
                //escribo el registro leido en el fichero de salida y leo un nuevo registro
                out.write(linea);
                out.newLine();
                lineaPrevia = linea;
                clientePrevio=transformarAObjeto(lineaPrevia);
                linea = input.readLine();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                input.close();
                out.close();
                outAuxiliar.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
            return ordenado;
    }

}

