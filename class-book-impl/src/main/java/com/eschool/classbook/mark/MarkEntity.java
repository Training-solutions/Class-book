package com.eschool.classbook.mark;

import com.eschool.classbook.BaseEntity;
import com.eschool.classbook.subject.SubjectEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

@Setter
@Getter
@ToString(callSuper = true)
@Entity
@Table(name = "marks")
public class MarkEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mark_generator")
    @SequenceGenerator(allocationSize = 1, name = "mark_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "mark")
    @Enumerated(EnumType.ORDINAL)
    private Mark mark;

    @Setter(AccessLevel.PRIVATE)
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "subject_id")
    @JsonBackReference
    @ToString.Exclude
    private SubjectEntity subject;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarkEntity that = (MarkEntity) o;
        return Objects.equals(id, that.id) && mark == that.mark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark);
    }
}
