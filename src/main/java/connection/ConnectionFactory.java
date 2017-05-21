package connection;

import javafx.scene.control.Alert;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by lucas on 23/01/17.
 */
public class ConnectionFactory
{

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL  = "jdbc:postgresql://localhost:5432/db_continental";
    private static final String USER ="postgres";
    private static final String PASS ="root";


    public static Connection getConnection() {

        try {

            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {

            throw new RuntimeException("Erro na connexão", ex);


        }



    }


    public static void closeConnetion(Connection con) {

        if(con!=null){

            try {
                con.close();
            } catch (SQLException ex) {

                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null, ex);


            }


        }


    }

    public static void closeConnetion(Connection con, PreparedStatement stmt) {

        closeConnetion(con);

        if(stmt!=null){

            try {
                stmt.close();

            } catch (SQLException ex) {

                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null, ex);


            }


        }


    }

    public static void closeConnetion(Connection con, PreparedStatement stmt,ResultSet rs) {

        closeConnetion(con,stmt);

        if(rs!=null){

            try {
                rs.close();

            } catch (SQLException ex) {

                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null, ex);


            }


        }


    }


}
