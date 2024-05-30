package dev.goormthon.ppoori.domain.relativity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RelativityRepository extends JpaRepository<Relativity, Long> {

    final static float MIN_RATE = 0.4f;
    final static int MAX_LENGTH = 10;

    @Query(
        value =
            "select policy_id from relativity " +
            "where category = :category " +
            "and :target >= " + MIN_RATE + " " +
            "order by :target desc " +
            "limit " + MAX_LENGTH + " "
        , nativeQuery = true
    )
    List<Long> findPolicyIdsByRelativity(@Param("category") String category, @Param("target") String target);
}
