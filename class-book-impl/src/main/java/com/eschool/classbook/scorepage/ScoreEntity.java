package com.eschool.classbook.scorepage;

import com.eschool.classbook.BaseEntity;
import com.eschool.classbook.subject.SubjectEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "scores")
public class ScoreEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "score_page_generator")
    @SequenceGenerator(allocationSize = 1, name = "score_page_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "score")
    @Enumerated(EnumType.STRING)
    private Score score;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "score_subject",
            joinColumns = @JoinColumn(name = "score_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    @ToString.Exclude
    private Set<SubjectEntity> subjects = new HashSet<>();

    public void addSubject(SubjectEntity subjectEntity){
        subjectEntity.getScores().add(this);
        subjects.add(subjectEntity);
    }

    public void removeSubject(SubjectEntity subjectEntity){
        subjectEntity.getScores().remove(this);
        subjects.remove(subjectEntity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreEntity that = (ScoreEntity) o;
        return Objects.equals(id, that.id) && score == that.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, score);
    }
}
