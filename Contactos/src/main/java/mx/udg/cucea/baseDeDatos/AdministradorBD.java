package mx.udg.cucea.baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mx.udg.cucea.datos.Contacto;

public class AdministradorBD {

    private Connection conexion; 
    private Statement statement;
    private ResultSet resultSet;
    
    //Constructor: Conexion a la base de datos
    public AdministradorBD() {
        try {
            //Por medio de connection 
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/dbContactosPOO?serverTimeZone=UTC" , "root", "chavaDBM");
            statement = conexion.createStatement(); //Para mandar llamar queries
        } catch (SQLException ex) {
            System.out.println("No me pude conectar a la base de datos: " + ex.getMessage());
        }
    }
    
    public ArrayList<Contacto> leerContactos (){
        ArrayList<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT * FROM contactos";
        try {
            resultSet = statement.executeQuery(sql); //Devuelve un resultSet
            while(resultSet.next()){
                long telefonoMovil = resultSet.getLong("telefonoMovil"); //Se pasa el nombre de la columna en mysql como paramtro
                long telefonoCasa = resultSet.getLong("telefonoCasa");
                long telefonoOficina = resultSet.getLong("telefonoOficina");
                String nombre = resultSet.getString("nombre");
                String apellidoPaterno = resultSet.getString("apellidoPaterno");
                String apellidoMaterno = resultSet.getString("apellidoMaterno");
                String correoElectronico = resultSet.getString("correoElectronico");
                
                Contacto c = new Contacto(nombre, telefonoMovil);
                c.setApellidoMaterno(apellidoMaterno);
                c.setApellidoPaterno(apellidoPaterno);
                c.setCorreoElectronico(correoElectronico);
                c.setTelefonoDeCasa(telefonoCasa);
                c.setTelefonoDeOficina(telefonoOficina);
                
                contactos.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("No pude ejecutar el query:" + ex.getMessage());
        }
        return contactos;
    }
    
    public void insertarContacto(Contacto c){
        String query = "INSERT INTO contactos SET "
                   + "telefonoMovil="      + c.getTelefonoMovil()     + ", "
                   + "telefonoCasa="       + c.getTelefonoDeCasa()    + ", "
                   + "telefonoOficina="    + c.getTelefonoDeOficina() + ", "
                   + "nombre='"            + c.getNombres()           + "',"
                   + "apellidoPaterno='"   + c.getApellidoPaterno()   + "',"
                   + "apellidoMaterno='"   + c.getApellidoMaterno()   + "',"
                   + "correoElectronico='" + c.getCorreoElectronico() + "';";
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("No pude insertar el contacto: " + ex.getMessage());
        }
    }
    
    public void actualizarContacto(Contacto cOriginal, Contacto cNuevo){
        String query = "UPDATE contactos SET "
                     + "telefonoMovil="      + cNuevo.getTelefonoMovil()     + ", "
                     + "telefonoCasa="       + cNuevo.getTelefonoDeCasa()    + ", "
                     + "telefonoOficina="    + cNuevo.getTelefonoDeOficina() + ", "
                     + "nombre='"            + cNuevo.getNombres()           + "',"
                     + "apellidoPaterno='"   + cNuevo.getApellidoPaterno()   + "',"
                     + "apellidoMaterno='"   + cNuevo.getApellidoMaterno()   + "',"
                     + "correoElectronico='" + cNuevo.getCorreoElectronico() + "'"
                     + "WHERE contactos.telefonoMovil=" + cOriginal.getTelefonoMovil() + ";";
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("No pude actualizar el contacto: " + ex.getMessage());
        }
    }
        
    public void borrarContacto(Contacto c){
        String query = "DELETE from contactos "
                     + "WHERE contactos.telefonoMovil=" + c.getTelefonoMovil() + ";";
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("No pude borrar el contacto: " + ex.getMessage());
        }
    }
    
    
    //TEST: Validación de la conexión
    public static void main(String[] args){
        AdministradorBD db = new AdministradorBD();
        
        //System.out.println(db.leerContactos());
        
        Contacto c = new Contacto("Diana", 123455);
        c.setApellidoMaterno("Yamile");
        c.setApellidoPaterno("Garcia");
        c.setCorreoElectronico("yamileD@hotmail.com");
        c.setTelefonoDeCasa(543211);
        c.setTelefonoDeOficina(987654);
        
        Contacto c2 = new Contacto("Maria", 123455);
        c2.setApellidoMaterno("Yamile");
        c2.setApellidoPaterno("Garcia");
        c2.setCorreoElectronico("maria@hotmail.com");
        c2.setTelefonoDeCasa(543211);
        c2.setTelefonoDeOficina(987654);
        
        db.borrarContacto(c2);
        
    }
    
}
