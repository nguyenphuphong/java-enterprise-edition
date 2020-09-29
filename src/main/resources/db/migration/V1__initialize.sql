CREATE SEQUENCE sq_user_id;

CREATE TABLE tb_user (
    id INT NOT NULL DEFAULT sq_user_id.nextval PRIMARY KEY,
    password VARCHAR(255)
);

CREATE TABLE tb_user_info (
    user_id INT NOT NULL PRIMARY KEY,
    email VARCHAR(255),
    address VARCHAR(350),
    FOREIGN KEY (user_id) REFERENCES tb_user(id)
);

CREATE SEQUENCE sq_role_id;

CREATE TABLE tb_role (
    id INT NOT NULL DEFAULT sq_role_id.nextval PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE tb_user_roles (
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES tb_user(id),
    FOREIGN KEY (role_id) REFERENCES tb_role(id)
);

CREATE SEQUENCE sq_course_id;

CREATE TABLE tb_course (
    id INT NOT NULL DEFAULT sq_course_id.nextval PRIMARY KEY,
    title VARCHAR(255),
    description VARCHAR(1000),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES tb_user(id)
);
