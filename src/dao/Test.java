package dao;


import com.google.gson.Gson;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 3/27/13
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    static Gson gson = new Gson();

    public static void main(String[] args) {
        dao.model.Test test = new dao.model.Test();
        test.setName("rain");
        test.setEmail("zizihjk@gmail.com");

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(test);

        dao.model.Test result = (dao.model.Test)session.get(dao.model.Test.class,test.getId());
        System.out.println(gson.toJson(result));

        /*Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        User user2 = (User)session.get(User.class,user.getId());
        List<User>  = session.createCriteria(User.class).list();

        //update
        user2.setName("test");
        session.update(user2);
        session.saveOrUpdate();

        tx.commit();
        session.close();*/

    }

}
