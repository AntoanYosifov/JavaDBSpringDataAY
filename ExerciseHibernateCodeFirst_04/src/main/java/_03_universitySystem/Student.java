package _03_universitySystem;

import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "students")
public class Student extends Person {
    @Column(name = "average_grade", nullable = false)
    private float averageGrade;

    private int attendance;
    @ManyToMany
    @JoinTable(
            name = "students_courses", joinColumns = @JoinColumn(name = "student_id"
            , referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "courses_id", referencedColumnName = "id")
    )
    private Set<Course> courses;

    protected Student() {
        super();
        this.courses = new HashSet<>();
    }

    protected Student(String firstName, String lastName, String phoneNumber, float averageGrade, int attendance) {
        super(firstName, lastName, phoneNumber);
        this.averageGrade = averageGrade;
        this.attendance = attendance;

    }

    protected Student(String firstName, String lastName, float averageGrade, int attendance) {
        super(firstName, lastName);
        this.averageGrade = averageGrade;
        this.attendance = attendance;

    }

    public float getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(float averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }
}
