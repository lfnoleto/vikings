import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by lucas on 02/02/17.
 */
public class CreateDabase {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/";

// Database credentials
    static final String USER = "postgres";
    static final String PASS = "root";

    public static void main(String[] args) {

        Connection conn = null;
        
        Statement stmt = null;


        try{

            //STEP 2: Register JDBC driver
            Class.forName("org.postgresql.Driver");


            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating database...");
            stmt = conn.createStatement();

            try{
                String sql = "CREATE DATABASE  DB_CONTINENTAL";
                stmt.executeUpdate(sql);
                System.out.println("Database created successfully...");
            }catch (SQLException te){

                System.out.print("Deu erro na criar o banco"+te);

              /*  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERRO NO DB CONTINENTAL");
                alert.setHeaderText(null);
                alert.setContentText("ERRO AO CRIAR DATABASES BANCO JÁ EXISTE");
                alert.show();*/

            }

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            System.out.println("erro ao cria o banco de dados ");
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end JDBCExample




