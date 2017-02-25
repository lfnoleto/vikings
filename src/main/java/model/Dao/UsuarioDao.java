package model.Dao;

import connection.ConnectionFactory;
import model.vo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Created by lucas on 03/01/17.
 */
public class UsuarioDao {


    public void create(Usuario u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;


        try {

            stmt = con.prepareStatement("Insert into usuario (nome,senha) VALUE (?,?)");
            stmt.setString(1,u.getNome());
            stmt.setString(2,u.getSenha());
            stmt.executeUpdate();


            System.out.println("passo no dao"+ u.getNome());

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("deu erro no select");

        }finally {
            ConnectionFactory.closeConnetion(con,stmt);
        }



    }




   public void consulta(){

       Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null;








    }



}
