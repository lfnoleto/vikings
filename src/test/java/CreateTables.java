import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by lucas on 04/02/17.
 */
public class CreateTables {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:/students";

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
                System.out.println("Connecting to a selected database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Connected database successfully...");

                //STEP 4: Execute a query
                System.out.println("Creating table in given database...");
                stmt = conn.createStatement();

                String sql = "CREATE TABLE usuario(id int not null,nome varchar(100),senha varchar(100),primary key (id))";


                stmt.executeUpdate(sql);
                System.out.println("Created table in given database...");
            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)
                        conn.close();
                }catch(SQLException se){
                }// do nothing
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }//end try
            System.out.println("Goodbye!");
        }//end main








}
