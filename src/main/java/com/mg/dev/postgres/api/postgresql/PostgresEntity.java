package com.mg.dev.postgres.api.postgresql;

import com.mg.dev.postgres.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostgresEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postgres_id")
    private Long id;

    @Column(name = "postgres_no", length = 100)
    private int num;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description")
    private String description;

    @Builder
    public PostgresEntity(int num, String title, String name, String description) {
        this.num = num;
        this.title = title;
        this.name = name;
        this.description = description;
    }
}
