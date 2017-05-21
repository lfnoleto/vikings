import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by lucas on 10/01/17.
 */
public class TestHibernateUsuario {


    public static void main(String []args){


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
        EntityManager em= emf.createEntityManager();




    }

}
