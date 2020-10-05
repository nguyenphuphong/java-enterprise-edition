CREATE TABLE tb_course_users (
    user_id INT NOT NULL,
    course_id INT NOT NULL,
    PRIMARY KEY (user_id, course_id),
    FOREIGN KEY (user_id) REFERENCES tb_user(id),
    FOREIGN KEY (course_id) REFERENCES tb_course(id)
);
