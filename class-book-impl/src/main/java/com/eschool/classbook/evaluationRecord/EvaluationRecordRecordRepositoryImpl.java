package com.eschool.classbook.evaluationRecord;

import com.eschool.classbook.group.GroupEntity;
import com.eschool.classbook.mark.Mark;
import com.eschool.openapi.v1.model.EvaluationRecordDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@AllArgsConstructor
public class EvaluationRecordRecordRepositoryImpl implements EvaluationRecordRepository {
    private EntityManager entityManager;

    @Override
    public List<EvaluationRecordDto> getEvaluationRecords(Long subjectId, Long teacherId,
                                                          Long groupId, Long studentId,
                                                          LocalDateTime startDate, LocalDateTime endDate) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<GroupEntity> criteriaQuery = criteriaBuilder.createQuery(GroupEntity.class);
        Root<GroupEntity> entityRoot = criteriaQuery.from(GroupEntity.class);

        Predicate subjectsPredicate =
            buildJoinEqualPredicate("subjects", "id", subjectId, criteriaBuilder, entityRoot);
        Predicate teachersPredicate =
            buildJoinEqualPredicate("teachers", "id", subjectId, criteriaBuilder, entityRoot);
        Predicate studentsPredicate =
            buildJoinEqualPredicate("students", "id", subjectId, criteriaBuilder, entityRoot);
        Predicate groupsPredicate =
            groupId == null ? null : criteriaBuilder.equal(entityRoot.get("id"), groupId);
        Predicate datePredicate = null;


        if (startDate != null && endDate != null) {

        } else if(startDate != null) {
            datePredicate = buildJoinBetweenPredicate("marks", "creationDate",
                startDate, LocalDateTime.now(), criteriaBuilder, entityRoot);
        }


        List<Predicate> predicates = Stream.of(
            subjectsPredicate, teachersPredicate, studentsPredicate, groupsPredicate, datePredicate)
                .filter(Objects::nonNull).collect(Collectors.toList());

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        List<GroupEntity> resultList = entityManager.createQuery(criteriaQuery).getResultList();

        return null;
    }

    private Predicate buildJoinEqualPredicate(String joiningField, String parameter, Object value,
                                              CriteriaBuilder criteriaBuilder, Root<GroupEntity> entityRoot) {
        if (value != null) {
            Join<Object, Object> objectJoin = entityRoot.join(joiningField);
            return criteriaBuilder.equal(objectJoin.get(parameter), value);
        } else {
            return null;
        }
    }

    private Predicate buildJoinBetweenPredicate(String joiningField, String parameter, Object firstValue, Object secondValue,
                                                CriteriaBuilder criteriaBuilder, Root<GroupEntity> entityRoot) {
        if (firstValue != null && secondValue != null) {
            Join<GroupEntity, Mark> objectJoin = entityRoot.join(joiningField);
            Path<Date> objectPath = objectJoin.get(parameter);
            criteriaBuilder.between(objectPath.get(parameter),firstValue, secondValue);
        } else {
            return null;
        }
    }
}
