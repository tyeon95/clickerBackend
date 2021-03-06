package io.muic.webapp.api.repository;

import io.muic.webapp.api.entity.Helper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by tyeon on 3/26/17.
 */
@RepositoryRestResource(exported = false)
public interface HelperRepository extends JpaRepository<Helper, Long> {
}
