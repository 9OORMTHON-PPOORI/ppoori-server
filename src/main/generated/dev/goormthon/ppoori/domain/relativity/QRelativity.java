package dev.goormthon.ppoori.domain.relativity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRelativity is a Querydsl query type for Relativity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRelativity extends EntityPathBase<Relativity> {

    private static final long serialVersionUID = -497448375L;

    public static final QRelativity relativity = new QRelativity("relativity");

    public final EnumPath<dev.goormthon.ppoori.global.enums.Category> category = createEnum("category", dev.goormthon.ppoori.global.enums.Category.class);

    public final NumberPath<Long> pk = createNumber("pk", Long.class);

    public final NumberPath<Long> policyId = createNumber("policyId", Long.class);

    public final NumberPath<Float> rate_artist = createNumber("rate_artist", Float.class);

    public final NumberPath<Float> rate_industry = createNumber("rate_industry", Float.class);

    public final NumberPath<Float> rate_jobseeker = createNumber("rate_jobseeker", Float.class);

    public final NumberPath<Float> rate_newlyweds = createNumber("rate_newlyweds", Float.class);

    public final NumberPath<Float> rate_student = createNumber("rate_student", Float.class);

    public final NumberPath<Float> rate_worker = createNumber("rate_worker", Float.class);

    public QRelativity(String variable) {
        super(Relativity.class, forVariable(variable));
    }

    public QRelativity(Path<? extends Relativity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRelativity(PathMetadata metadata) {
        super(Relativity.class, metadata);
    }

}

