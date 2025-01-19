package br.com.yann.forumHub.domain.user;

import br.com.yann.forumHub.domain.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
