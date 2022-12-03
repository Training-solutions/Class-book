package com.eschool.classbook.evaluationRecord;

import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.mark.MarkEntity;
import com.eschool.classbook.subject.SubjectEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Repository
@AllArgsConstructor
public class EvaluationRecordRecordRepositoryImpl implements EvaluationRecordRepository {
    private EntityManager entityManager;

    @Override
    public List<GroupEntity> getEvaluationRecords(Long subjectId, Long teacherId,
                                                          Long groupId, Long studentId,
                                                          LocalDateTime startDate, LocalDateTime endDate) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<GroupEntity> criteriaQuery = criteriaBuilder.createQuery(GroupEntity.class);
        Root<GroupEntity> entityRoot = criteriaQuery.from(GroupEntity.class);

        Predicate subjectsPredicate =
            buildJoinEqualPredicate("subjects", "id", subjectId, criteriaBuilder, entityRoot);
        Predicate teachersPredicate =
            buildJoinEqualPredicate("teachers", "id", teacherId, criteriaBuilder, entityRoot);
        Predicate studentsPredicate =
            buildJoinEqualPredicate("students", "id", studentId, criteriaBuilder, entityRoot);
        Predicate groupsPredicate =
            groupId == null ? null : criteriaBuilder.equal(entityRoot.get("id"), groupId);
        Predicate datePredicate = buildDatePredicate("marks", "creationDate",
                startDate, endDate, criteriaBuilder, entityRoot);

        criteriaQuery.where(
                Stream.of(subjectsPredicate, teachersPredicate, studentsPredicate,
                                groupsPredicate, datePredicate)
                .filter(Objects::nonNull).toArray(Predicate[]::new));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    private Predicate buildJoinEqualPredicate(String joiningField, String parameter, Object value,
                                              CriteriaBuilder criteriaBuilder, Root<GroupEntity> entityRoot) {
        if (value != null) {
            Join<Object, Object> objectJoin = entityRoot.join(joiningField);
            return criteriaBuilder.equal(objectJoin.get(parameter), value);
        }
        return null;
    }

    private Predicate buildDatePredicate(String joiningField, String parameter,
                                         LocalDateTime firstValue, LocalDateTime secondValue,
                                         CriteriaBuilder criteriaBuilder, Root<GroupEntity> entityRoot) {
        if(firstValue != null && secondValue != null) {
            Join<SubjectEntity, MarkEntity> objectJoin = entityRoot.join("subjects").join(joiningField);
            return criteriaBuilder.between(objectJoin.get(parameter), firstValue, secondValue);
        }
        return null;
    }
}
