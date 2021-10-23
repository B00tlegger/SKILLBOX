import keys.PurchaseKey;
import keys.SubscriptionKey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSession.sessionFactoryInitialize();
        Session session = HibernateSession.getSession(sessionFactory);

        Student student = session.get(Student.class, 16);

        System.out.println(student.getName() + " учится на " + student.getCourses().size() + " курсах ");
        student.getCourses().forEach(course1 -> {
            Subscription subscription = session.get(Subscription.class, new SubscriptionKey(student.getId(), course1.getId()));
            System.out.println("курс " + course1.getName() + ", преподает " + course1.getTeacher().getName()
                    + ", подписан на курс с " + subscription.getSubscriptionDate() + ", курс длится " + course1.getDuration() + " месяца" + "\n" +
                    " на нём учится " + course1.getStudents().size() + " студентов");
            PurchaseList purchaseList = session.get(PurchaseList.class, new PurchaseKey(student.getName(), course1.getName()));
            System.out.println(purchaseList.getStudentName() + " | " + purchaseList.getCourseName() + " | " + purchaseList.getPrice()
            + " | " + purchaseList.getSubscriptionDate());
        });





        session.close();
        sessionFactory.close();
    }
}