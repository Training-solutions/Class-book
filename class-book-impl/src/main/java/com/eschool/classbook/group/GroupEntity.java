package com.eschool.classbook.group;

import com.eschool.classbook.BaseEntity;
import com.eschool.classbook.student.StudentEntity;
import com.eschool.classbook.subject.SubjectEntity;
import com.eschool.classbook.teacher.TeacherEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "groups")
public class GroupEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_generator")
    @SequenceGenerator(allocationSize = 1, name = "group_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "group_title", nullable = false, unique = true)
    private String groupTitle;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "group")
    @ToString.Exclude
    @JsonManagedReference
    private Set<StudentEntity> students = new HashSet<>();

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany
    @JoinTable(name = "group_teacher",
                joinColumns = @JoinColumn(name = "group_id"),
                inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    @ToString.Exclude
    @JsonManagedReference
    private Set<TeacherEntity> teachers = new HashSet<>();

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany
    @JoinTable(name = "group_subject",
                joinColumns = @JoinColumn(name = "group_id"),
                inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    @ToString.Exclude
    @JsonManagedReference
    private Set<SubjectEntity> subjects = new HashSet<>();

    public void addStudent(StudentEntity studentEntity) {
        studentEntity.setGroup(this);
        students.add(studentEntity);
    }

    public void removeStudent(StudentEntity studentEntity) {
        studentEntity.setGroup(null);
        students.remove(studentEntity);
    }

    public void addTeacher(TeacherEntity teacherEntity) {
        teacherEntity.getGroups().add(this);
        teachers.add(teacherEntity);
    }

    public void removeTeacher(TeacherEntity teacherEntity) {
        teacherEntity.getGroups().remove(this);
        teachers.remove(teacherEntity);
    }

    public void addSubject(SubjectEntity subjectEntity) {
        subjectEntity.getGroups().add(this);
        subjects.add(subjectEntity);
    }

    public void removeSubject(SubjectEntity subjectEntity) {
        subjectEntity.getGroups().remove(this);
        subjects.remove(subjectEntity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GroupEntity that = (GroupEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(groupTitle, that.groupTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, groupTitle);
    }
}
