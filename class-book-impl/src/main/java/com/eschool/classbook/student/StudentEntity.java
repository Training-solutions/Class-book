package com.eschool.classbook.student;

import com.eschool.classbook.BaseEntity;
import com.eschool.classbook.credential.CredentialEntity;
import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.subject.SubjectEntity;
import com.eschool.classbook.teacher.TeacherEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@ToString(callSuper = true)
@Entity
@Table(name = "students")
public class StudentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
    @SequenceGenerator(allocationSize = 1, name = "student_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH}, orphanRemoval = true)
    @JoinColumn(name = "credential", nullable = false)
    private CredentialEntity credential;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JsonBackReference
    private GroupEntity group;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "student_teacher",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    @ToString.Exclude
    @JsonManagedReference
    private Set<TeacherEntity> teachers = new HashSet<>();

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    @ToString.Exclude
    @JsonManagedReference
    private Set<SubjectEntity> subjects = new HashSet<>();

    public void addTeacher(TeacherEntity teacherEntity){
        teacherEntity.getStudents().add(this);
        teachers.add(teacherEntity);
    }

    public void removeTeacher(TeacherEntity teacherEntity){
        teacherEntity.getStudents().remove(this);
        teachers.remove(teacherEntity);
    }

    public void addSubject(SubjectEntity subjectEntity){
        subjectEntity.getStudents().add(this);
        subjects.add(subjectEntity);
    }

    public void removeSubject(SubjectEntity subjectEntity){
        subjectEntity.getStudents().remove(this);
        subjects.remove(subjectEntity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(firstName, that.firstName)
                && Objects.equals(lastName, that.lastName)
                && Objects.equals(credential, that.credential)
                && Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, firstName, lastName, credential, group);
    }
}
