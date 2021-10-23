import keys.SubscriptionKey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import tables.Course;
import tables.LinkedPurchaseList;
import tables.PurchaseList;
import tables.Student;

import java.sql.Statement;
import java.util.List;

public class HibernateSession {
    public static SessionFactory sessionFactoryInitialize(){
        StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
    }

    public static Session getSession(SessionFactory sessionFactory){
        return sessionFactory.openSession();
    }

    public static void enterData(Session session){
        String hql = "FROM " + PurchaseList.class.getSimpleName();
        List<PurchaseList> purchaseLists = session.createQuery(hql).getResultList();
        purchaseLists.forEach(purchaseList -> {
            DetachedCriteria studentCriteria = DetachedCriteria.forClass(Student.class)
                    .add(Restrictions.eq("name", purchaseList.getStudentName()));
            Student student = (Student) studentCriteria.getExecutableCriteria(session).list().stream().findFirst().get();
            DetachedCriteria courseCriteria = DetachedCriteria.forClass(Course.class)
                    .add(Restrictions.eq("name", purchaseList.getCourseName()));
            Course course = (Course) courseCriteria.getExecutableCriteria(session).list().stream().findFirst().get();

            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            linkedPurchaseList.setKey(new SubscriptionKey(student.getId(), course.getId()));
            linkedPurchaseList.setStudentId(student.getId());
            linkedPurchaseList.setcourseid(course.getId());
            linkedPurchaseList.setPrice(course.getPrice());
            linkedPurchaseList.setSubscriptionDate(purchaseList.getSubscriptionDate());
            session.save(linkedPurchaseList);
        });
    }
}
