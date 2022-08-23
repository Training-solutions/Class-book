package com.eschool.classbook.subject;

import com.eschool.classbook.BaseEntity;
import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.score.ScoreEntity;
import com.eschool.classbook.student.StudentEntity;
import com.eschool.classbook.teacher.TeacherEntity;
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
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@ToString(callSuper = true)
@Entity
@Table(name = "subjects")
public class SubjectEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_generator")
    @SequenceGenerator(allocationSize = 1, name = "subject_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "subject_title", nullable = false, unique = true)
    private String subjectTitle;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "subjects", cascade = {CascadeType.MERGE})
    @ToString.Exclude
    @JsonBackReference
    @Column(updatable = false, insertable = false)
    private Set<GroupEntity> groups = new HashSet<>();

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "subjects", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @ToString.Exclude
    private Set<ScoreEntity> scores = new HashSet<>();

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "subjects", cascade = {CascadeType.MERGE})
    @ToString.Exclude
    @JsonBackReference
    private Set<StudentEntity> students = new HashSet<>();

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "subjects", cascade = {CascadeType.MERGE})
    @ToString.Exclude
    private Set<TeacherEntity> teachers = new HashSet<>();

    public void addGroup(GroupEntity groupEntity) {
        groupEntity.getSubjects().add(this);
        groups.add(groupEntity);
    }

    public void removeGroup(GroupEntity groupEntity) {
        groupEntity.getSubjects().remove(this);
        groups.remove(groupEntity);
    }

    public void addScore(ScoreEntity scoreEntity){
        scoreEntity.getSubjects().add(this);
        scores.add(scoreEntity);
    }

    public void removeScore(ScoreEntity scoreEntity){
        scoreEntity.getSubjects().remove(this);
        scores.remove(scoreEntity);
    }

    public void addStudent(StudentEntity studentEntity){
        studentEntity.getSubjects().add(this);
        students.add(studentEntity);
    }

    public void removeStudent(StudentEntity studentEntity){
        studentEntity.getSubjects().remove(this);
        students.remove(studentEntity);
    }

    public void addTeacher(TeacherEntity teacherEntity) {
        teacherEntity.getSubjects().add(this);
        teachers.add(teacherEntity);
    }

    public void removeTeacher(TeacherEntity teacherEntity) {
        teacherEntity.getSubjects().remove(this);
        teachers.remove(teacherEntity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectEntity that = (SubjectEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(subjectTitle, that.subjectTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectTitle);
    }
}
