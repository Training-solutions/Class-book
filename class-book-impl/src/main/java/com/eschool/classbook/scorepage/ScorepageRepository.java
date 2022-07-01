package com.eschool.classbook.scorepage;

import com.eschool.classbook.group.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScorepageRepository extends JpaRepository<ScoreEntity, Long> {
}
