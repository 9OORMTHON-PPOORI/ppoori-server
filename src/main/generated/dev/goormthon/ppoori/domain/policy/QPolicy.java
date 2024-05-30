package dev.goormthon.ppoori.domain.policy;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPolicy is a Querydsl query type for Policy
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPolicy extends EntityPathBase<Policy> {

    private static final long serialVersionUID = 1894729513L;

    public static final QPolicy policy = new QPolicy("policy");

    public final EnumPath<dev.goormthon.ppoori.global.enums.Category> category = createEnum("category", dev.goormthon.ppoori.global.enums.Category.class);

    public final ListPath<dev.goormthon.ppoori.domain.comment.Comment, dev.goormthon.ppoori.domain.comment.QComment> comments = this.<dev.goormthon.ppoori.domain.comment.Comment, dev.goormthon.ppoori.domain.comment.QComment>createList("comments", dev.goormthon.ppoori.domain.comment.Comment.class, dev.goormthon.ppoori.domain.comment.QComment.class, PathInits.DIRECT2);

    public final StringPath contact = createString("contact");

    public final StringPath department = createString("department");

    public final StringPath detail = createString("detail");

    public final NumberPath<Integer> hateRate = createNumber("hateRate", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> likeRate = createNumber("likeRate", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath subject = createString("subject");

    public final StringPath summary = createString("summary");

    public final StringPath title = createString("title");

    public QPolicy(String variable) {
        super(Policy.class, forVariable(variable));
    }

    public QPolicy(Path<? extends Policy> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPolicy(PathMetadata metadata) {
        super(Policy.class, metadata);
    }

}

