package com.eschool.classbook.teacher;


import com.eschool.classbook.BaseEntity;
import com.eschool.classbook.credential.CredentialEntity;
import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.student.StudentEntity;
import com.eschool.classbook.subject.SubjectEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "teachers")
public class TeacherEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_generator")
    @SequenceGenerator(allocationSize = 1, name = "teacher_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = true)
    @JoinColumn(name="credential_id", nullable = false)
    private CredentialEntity credential;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "teachers")
    @ToString.Exclude
    @JsonBackReference
    private Set<GroupEntity> groups = new HashSet<>();

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "teachers")
    @ToString.Exclude
    @JsonBackReference
    private Set<StudentEntity> students = new HashSet<>();

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany
    @JoinTable(name = "teacher_subject",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    @ToString.Exclude
    private Set<SubjectEntity> subjects = new HashSet<>();

    public void addGroup(GroupEntity groupEntity) {
        groupEntity.getTeachers().add(this);
        groups.add(groupEntity);
    }

    public void removeGroup(GroupEntity groupEntity) {
        groupEntity.getTeachers().remove(this);
        groups.remove(groupEntity);
    }

    public void addStudent(StudentEntity studentEntity) {
        studentEntity.getTeachers().add(this);
        students.add(studentEntity);
    }

    public void removeStudent(StudentEntity studentEntity) {
        studentEntity.getTeachers().add(this);
        students.remove(studentEntity);
    }

    public void addSubject(SubjectEntity subjectEntity) {
        subjectEntity.getTeachers().add(this);
        subjects.add(subjectEntity);
    }

    public void removeSubject(SubjectEntity subjectEntity) {
        subjectEntity.getTeachers().add(this);
        subjects.remove(subjectEntity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TeacherEntity that = (TeacherEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(firstName, that.firstName)
                && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, firstName, lastName);
    }
}
