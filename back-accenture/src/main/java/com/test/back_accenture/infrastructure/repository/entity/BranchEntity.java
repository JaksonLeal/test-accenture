package com.test.back_accenture.infrastructure.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("branches")
public class BranchEntity {

    @Id
    private Long id;

    private String name;
    private Long franchiseId;

    public BranchEntity(Long id, String name, Long franchiseId) {
        this.id = id;
        this.name = name;
        this.franchiseId = franchiseId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getFranchiseId() {
        return franchiseId;
    }
}
