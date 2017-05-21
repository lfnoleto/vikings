package model.Dao;

import connection.ConnectionFactory;
import model.vo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by lucas on 03/01/17.
 */
public class UsuarioDao {


    public void create(Usuario u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;


        try {

            stmt = con.prepareStatement("Insert into usuario (login,senha) VALUE (?,?)");
            stmt.setString(1,u.getNome());
            stmt.setString(2,u.getSenha());
            stmt.executeUpdate();


            //System.out.println("passo no dao"+ u.getNome());

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error problem in select"+e);

        }finally {
            ConnectionFactory.closeConnetion(con,stmt);
        }



    }



    public boolean checkLogin(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;


        try {

            stmt = con.prepareStatement("SELECT * FROM ADMINISTRADO WHERE login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print(ex);
        } finally {
            ConnectionFactory.closeConnetion(con, stmt, rs);
        }


        return check;



    }

}
