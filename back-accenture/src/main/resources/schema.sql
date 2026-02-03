CREATE TABLE IF NOT EXISTS franchises (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS branches (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    franchise_id BIGINT NOT NULL,
    CONSTRAINT fk_branch_franchise
        FOREIGN KEY (franchise_id) REFERENCES franchises(id)
);

CREATE TABLE IF NOT EXISTS products (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    stock INT NOT NULL,
    branch_id BIGINT NOT NULL,
    CONSTRAINT fk_product_branch
        FOREIGN KEY (branch_id) REFERENCES branches(id)
);
