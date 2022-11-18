package com.eschool.classbook.evaluationRecord;

import com.eschool.classbook.group.GroupEntity;
import com.eschool.openapi.v1.model.EvaluationRecordDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

        List<Predicate> predicates = new ArrayList<>();

        if (subjectId != null) {
            predicates.add(criteriaBuilder.equal(entityRoot.get("subjects").get("id"), subjectId));
        }

        if (teacherId != null) {
            predicates.add(criteriaBuilder.equal(entityRoot.get("teachers").get("id"), teacherId));
        }

        if (groupId != null) {
            predicates.add(criteriaBuilder.equal(entityRoot.get("id"), groupId));
        }

        if (studentId != null) {
            predicates.add(criteriaBuilder.equal(entityRoot.get("students").get("id"), teacherId));
        }

//        if(startDate != null || endDate != null) {
//            predicates.add(criteriaBuilder.between(entityRoot.get("subjects").get("marks").get("creationDate"), startDate));
//        }
//
//        if(endDate != null && endDate != null) {
//
//        }

        if(startDate != null && endDate==null) {
            predicates.add(criteriaBuilder.between(
                entityRoot.get("subjects").get("marks").get("creationDate"), startDate, LocalDateTime.now()));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        List<GroupEntity> resultList = entityManager.createQuery(criteriaQuery).getResultList();

        return null;
    }
}
