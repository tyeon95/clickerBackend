package io.muic.webapp.api.repository;

import io.muic.webapp.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by tyeon on 3/26/17.
 */
@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    List<User> findTop10ByOrderByHighscoreDesc();
}
