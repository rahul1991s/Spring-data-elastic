package com.rahuls.elastic.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahuls.elastic.model.Users;
import com.rahuls.elastic.repository.UsersRepository;

@RestController
@RequestMapping("/rest/search")
public class SearchResource {

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	ElasticsearchTemplate template;

	@GetMapping(value = "/name/{text}")
	public List<Users> searchName(@PathVariable final String text) {
		return usersRepository.findByName(text);
	}


	@GetMapping(value = "/salary/{salary}")
	public List<Users> searchSalary(@PathVariable final Long salary) {
		return usersRepository.findBySalary(salary);
	}


	@GetMapping(value = "/all")
	public List<Users> searchAll() {
		List<Users> usersList = new ArrayList<>();
		Iterable<Users> userses = usersRepository.findAll();
		userses.forEach(usersList::add);
		return usersList;
	}

	// delete index
	@GetMapping(value = "/delete")
	public boolean delete() {
		return template.deleteIndex(Users.class);
	}

}
