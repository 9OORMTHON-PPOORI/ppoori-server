package dev.goormthon.ppoori.domain.relativity;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dev.goormthon.ppoori.global.enums.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class RelativityRepositoryImpl {

    private final JPAQueryFactory queryFactory;

    public List<Long> findPolicyIdsByRelativity(String category, String target) {
        QRelativity relativity = QRelativity.relativity;
        NumberPath<Float> dynamicPath = Expressions.numberPath(Float.class, target);

        return queryFactory
                .select(relativity.policyId)
                .from(relativity)
                .where(relativity.category.eq(Category.valueOf(category))
                        .and(dynamicPath.goe(0.4f)))
                .orderBy(dynamicPath.desc())
                .limit(10)
                .fetch();
    }
}
