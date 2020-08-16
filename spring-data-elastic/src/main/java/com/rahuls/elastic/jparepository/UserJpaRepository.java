package com.rahuls.elastic.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahuls.elastic.model.Users;

public interface UserJpaRepository extends JpaRepository<Users, Long> {
}
