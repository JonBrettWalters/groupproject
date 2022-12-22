package com.groupeight.bloglife.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.groupeight.bloglife.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
	List<Post> findAll();
	List<Post> findAllById(Long id);
	<S extends Post> S save(Post entity);
	void deleteById(Long id);
}
