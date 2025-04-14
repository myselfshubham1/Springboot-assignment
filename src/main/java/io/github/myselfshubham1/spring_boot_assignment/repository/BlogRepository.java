package io.github.myselfshubham1.spring_boot_assignment.repository;

import io.github.myselfshubham1.spring_boot_assignment.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * uses to implement jpa so that we can use functions like save , findbyid, findby etc.
 */

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {



}
