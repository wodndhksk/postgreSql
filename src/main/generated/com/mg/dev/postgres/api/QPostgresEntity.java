package com.mg.dev.postgres.api;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPostgresEntity is a Querydsl query type for PostgresEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPostgresEntity extends EntityPathBase<PostgresEntity> {

    private static final long serialVersionUID = 435894437L;

    public static final QPostgresEntity postgresEntity = new QPostgresEntity("postgresEntity");

    public final com.mg.dev.postgres.common.QBaseEntity _super = new com.mg.dev.postgres.common.QBaseEntity(this);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final StringPath modUser = _super.modUser;

    public final StringPath name = createString("name");

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    //inherited
    public final StringPath regUser = _super.regUser;

    public final StringPath title = createString("title");

    public QPostgresEntity(String variable) {
        super(PostgresEntity.class, forVariable(variable));
    }

    public QPostgresEntity(Path<? extends PostgresEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPostgresEntity(PathMetadata metadata) {
        super(PostgresEntity.class, metadata);
    }

}

