import jpa.LoginEntityManager;
import model.Login;

import java.util.List;


public class Test {

    public static void main(String[] args) {

        LoginEntityManager loginEntityManager = new LoginEntityManager();
        Login log = new Login();
        log.setLogin("sousou");
        log.setPassword("sousou");
        loginEntityManager.add(log);
        loginEntityManager.findByLoginAndPassword("sousou","sousou");


        List<Login> list=loginEntityManager.findAll();
        for  (Login m : list){
            System.out.println (m.getLogin());
        }



    }
}