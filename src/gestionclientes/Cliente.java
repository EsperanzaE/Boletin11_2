package gestionclientes;

/**
 * información sobre un cliente:
 * Nombre (hasta 50 caracteres).
 * Apellidos (Hasta 50 caracteres)
 * C.I.F. (hasta 10 caracteres).
 * Categoría (entero sin signo).
 * Dirección (hasta 50 caracteres).
 * salto de línea.
 */

/**PROPIEDADES
 * nombre: cadena consultable y modificable. maximo 50 caracteres
 * apellidos: cadena consultabley modificable. maximo 50 caracteres
 * cif: cadena consultable y modificable maximo 10 caracteres
 * categoria: entero consultable y modificable
 * direccion: cadena consultable y modificable maximo 50 caracteres
 *
 * METODOS:
 * compareTo: metodo que compara dos clientes en funcion de su cif
 *
 * INTERFAZ
 * String getNombre()
 * void setNombre(String nombre)
 * String getApellidos()
 * void setApellidos(String apellidos)
 * String getCif()
 * void setCif(String cif)
 * int getCategoria()
 * void setCategoria(int categoria)
 * String getDireccion()
 * void setDireccion(String direccion)
 *
 */
public class Cliente implements Comparable {

    static final int MAXIMO50 = 50;
    static final int MAXCIF = 10;
    //atributos
    private String nombre;
    private String apellidos;
    private String cif;
    private int categoria;
    private String direccion;

    public Cliente(String nombre, String apellidos, String cif, int categoria, String direccion) {
        setNombre(nombre);
        setApellidos(apellidos);
        setCif(cif);
        this.categoria = categoria;
        setDireccion(direccion);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() > MAXIMO50)
            this.nombre = nombre.substring(0,MAXIMO50);
        else
            this.nombre=nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        if (apellidos.length() > MAXIMO50)
            this.apellidos = apellidos.substring(0,MAXIMO50);
        else
            this.apellidos=apellidos;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        if (cif.length() > MAXCIF)
            this.cif = cif.substring(0,MAXCIF);
        else
            this.cif=cif;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion.length() > MAXIMO50)
            this.direccion = direccion.substring(0,MAXIMO50);
        else
        this.direccion = direccion;
    }

    @Override
    public int compareTo(Object object) {
        int rtdo=0;
        if (object instanceof Cliente){
        rtdo= this.cif.compareTo(( (Cliente) object ).getCif());
        }
        return rtdo;
    }

    /**funcion que muestra al cliente en el formato exacto en el que se va a guardar en un fichero
     * se usa para ello el método toString de la clase
     * entrada nada
     * salida una cadena
     * precondiciones nada
     * postcondiciones la cadena devuelta representa el formato en el que se va a registrar el objeto cliente en un fichero de texto
     */
    @Override
    public String toString()
    {
        return this.getNombre()+","+this.getApellidos()+","+this.getCif()+","+
                this.getCategoria()+","+this.getDireccion();
    }
}
