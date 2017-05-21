import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by lucas on 02/02/17.
 */
public class  CreateTable {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/db_continental";

    // Database credentials
    static final String USER = "postgres";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        StringBuilder sb = new StringBuilder();
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.postgresql.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");





            try {
                stmt = conn.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS CLIENTE(ID_CLIENTE  SERIAL NOT NULL ,NOME VARCHAR (10),FANTASIA VARCHAR (50), CEP VARCHAR (2),MUNICIPIO VARCHAR (10),LAGRADOURO VARCHAR (45),COMPLEMENTO VARCHAR (45),CPF_CNPJ VARCHAR (45),IE_RG VARCHAR (45),TELEFONE VARCHAR (45),E_MAIL VARCHAR (45),PRIMARY KEY (ID_CLIENTE));"+
                             "CREATE TABLE IF NOT EXISTS ORDEM_DE_SERVICO(OS SERIAL NOT NULL ,DATE_OS TIMESTAMP DEFAULT CURRENT_TIMESTAMP,EQUIPAMENTO VARCHAR(150) NOT NULL,DEFEITO VARCHAR(150)NOT NULL,TECNICO VARCHAR(30),VALOR DECIMAL(10,2),ID_CLIENTE INT,FOREIGN KEY (ID_CLIENTE) references CLIENTE(ID_CLIENTE),PRIMARY KEY (OS));"+
                             "CREATE TABLE IF NOT EXISTS USUARIO(ID_USUARIO  SERIAL NOT NULL ,NOME  VARCHAR (45) NOT NULL,ENDERECO VARCHAR (50),CPF VARCHAR (14) NOT NULL, FUNCAO VARCHAR (45),TELEFONE VARCHAR (14),PRIMARY KEY(ID_USUARIO));"+
                             "CREATE TABLE IF NOT EXISTS ADMINISTRADO(ID SERIAL NOT NULL,LOGIN VARCHAR (20),SENHA VARCHAR(20));";


                // sb.append("CREATE TABLE IF NOT EXISTS REGISTRATIO (id INT NOT NULL,teste VARCHAR(100),user VARCHAR(255),PRIMARY KEY ( id ));");
                // sb.append("");
                //sb.append("CREATE TABLE IF NOT EXISTS USARIO (id INT NOT NULL,teste VARCHAR(100),user VARCHAR(255),PRIMARY KEY ( id ))");
                //sb.append("");


                stmt.executeUpdate(sql);

            }catch (SQLException TE){

                System.out.println("DEU RUIM"+TE);
            }

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

    }//end main

}//end JDBCExample