package sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ggladko97 on 21.03.17.
 */
public class ManageUsers {

    private static SessionFactory factory = new Configuration().configure(new File("/home/ggladko97/Documents/JFX2/src/main/java/sample/hibernate.cfg.xml")).buildSessionFactory();

    public List<UsersEntity> listOfUsers() {
        List<UsersEntity> list =  new ArrayList<UsersEntity>();
        Session session = factory.openSession();
        List result = session.createSQLQuery("select * from users ").addEntity(UsersEntity.class).list();

        list.addAll(result);
        System.out.println(result);
        return list;
    }

}
