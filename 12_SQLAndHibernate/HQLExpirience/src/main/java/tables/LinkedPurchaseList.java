package tables;

import keys.SubscriptionKey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {
    @EmbeddedId
    private SubscriptionKey key;
    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;
    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;
    private int price;
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public SubscriptionKey getKey() {
        return key;
    }

    public void setKey(SubscriptionKey key) {
        this.key = key;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setcourseid(int courseId) {
        this.courseId = courseId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
