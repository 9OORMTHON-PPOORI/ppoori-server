package dev.goormthon.jejucart.domain.policy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

    @Query(
            value =
                    "select * from policy " +
                            "where category = :category " +
                            "and target like %:target% ; ",
            nativeQuery = true
    )    List<Policy> findPolicies(@Param("target") String target, @Param("category") String category);
}
