CREATE TABLE responses (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           topic_id BIGINT NOT NULL,
                           author_id BIGINT NOT NULL,
                           message TEXT NOT NULL,
                           creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                           FOREIGN KEY (topic_id) REFERENCES topics (id),
                           FOREIGN KEY (author_id) REFERENCES users (id)
);
