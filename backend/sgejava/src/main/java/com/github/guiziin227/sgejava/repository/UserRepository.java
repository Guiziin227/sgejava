package com.github.guiziin227.sgejava.repository;

import com.github.guiziin227.sgejava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
