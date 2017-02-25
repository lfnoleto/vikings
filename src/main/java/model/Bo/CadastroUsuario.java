package model.Bo;

import model.Dao.UsuarioDao;

import model.vo.Usuario;

/**
 * Created by lucas on 03/01/17.
 */
public class CadastroUsuario {



   UsuarioDao usuarioDao = new UsuarioDao();





    public void salva(Usuario e){
        //usuario.getNome() == null || usuario.getNome().trim().equals("")

        if (e.getNome()!=null && e.getSenha() !=null){

            try {

                usuarioDao.create(e);

                System.out.println("passo  casdastro");

            }catch (Exception i){

                System.out.println("erro no cadastro: "+e.getNome() +i);
            }






        }else{

            System.out.println("deu erro no cadastro");


        }

    }



}
