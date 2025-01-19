CREATE TABLE topics (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        message TEXT NOT NULL,
                        creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        status VARCHAR(50),
                        author_id BIGINT NOT NULL,
                        course_id BIGINT NOT NULL,
                        FOREIGN KEY (author_id) REFERENCES users (id),
                        FOREIGN KEY (course_id) REFERENCES courses (id)
);
