package com.rahuls.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.rahuls.elastic.model.Users;

import java.util.List;

public interface UsersRepository extends ElasticsearchRepository<Users, Long> {
	List<Users> findByName(String text);

	List<Users> findBySalary(Long salary);
}
