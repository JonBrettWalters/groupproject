package com.groupeight.bloglife.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.groupeight.bloglife.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findAll();
	List<User> findAllById(Long id);
	Optional<User> findByEmail(String email);
}
