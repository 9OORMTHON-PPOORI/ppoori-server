package dev.goormthon.jejucart.domain.policy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

    @Query(value = "select * from policy where target like \'%:word%\' and category = :category;", nativeQuery = true)
    List<Policy> findPolicies(@Param("word") String word, @Param("category") String category);
}
