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
                            "and subject like %:subject% ; ",
            nativeQuery = true
    )    List<Policy> findPolicies(@Param("subject") String subject, @Param("category") String category);
}
