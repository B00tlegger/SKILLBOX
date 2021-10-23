import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tables.LinkedPurchaseList;
import tables.PurchaseList;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateSession.sessionFactoryInitialize();
        Session session = HibernateSession.getSession(sessionFactory);
        Transaction transaction = session.beginTransaction();

        HibernateSession.enterData(session);

        transaction.commit();

        String lpl = "FROM " + LinkedPurchaseList.class.getSimpleName();
        List<LinkedPurchaseList> linkedPurchaseLists = session.createQuery(lpl).getResultList();
        System.out.println(linkedPurchaseLists.size());

        String pl = "FROM " + PurchaseList.class.getSimpleName();
        List<PurchaseList> purchaseLists = session.createQuery(pl).getResultList();
        System.out.println(purchaseLists.size());


        session.close();
        sessionFactory.close();
    }
}
