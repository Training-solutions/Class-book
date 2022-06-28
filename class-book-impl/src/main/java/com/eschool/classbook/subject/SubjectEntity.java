package com.eschool.classbook.subject;

import com.eschool.classbook.BaseEntity;
import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.scorepage.ScoreEntity;
import com.eschool.classbook.student.StudentEntity;
import com.eschool.classbook.teacher.TeacherEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    @ManyToMany(mappedBy = "subjects")
    @ToString.Exclude
    private Set<GroupEntity> groups = new HashSet<>();

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "subjects")
    @ToString.Exclude
    private Set<ScoreEntity> scores = new HashSet<>();

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "subjects")
    @ToString.Exclude
    private Set<StudentEntity> students = new HashSet<>();

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "subjects")
    @ToString.Exclude
    private Set<TeacherEntity> teachers = new HashSet<>();

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
