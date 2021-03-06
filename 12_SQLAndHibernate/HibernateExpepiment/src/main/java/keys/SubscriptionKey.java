package keys;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class SubscriptionKey implements Serializable {
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "course_id")
    private int courseId;

    public SubscriptionKey(int studentId, int courseId) {
        this.courseId = courseId;
        this.studentId = studentId;
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

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionKey subscriptionKey = (SubscriptionKey) o;
        return studentId == subscriptionKey.studentId && courseId == subscriptionKey.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }

}
