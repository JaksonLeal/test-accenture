package com.test.back_accenture.infrastructure.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("franchises")
public class FranchiseEntity {

    @Id
    private Long id;

    private String name;

    public FranchiseEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
