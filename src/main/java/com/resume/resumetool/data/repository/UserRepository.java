package com.resume.resumetool.data.repository;

import com.resume.resumetool.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface UserRepository extends JpaRepository<User, Long> {
}