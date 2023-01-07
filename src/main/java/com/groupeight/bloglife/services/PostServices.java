package com.groupeight.bloglife.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupeight.bloglife.models.Post;
import com.groupeight.bloglife.models.User;
import com.groupeight.bloglife.repositories.PostRepository;

@Service
public class PostServices {
	
	@Autowired
	PostRepository postRep;
	
	public List<Post> allPosts(){
		return postRep.findAll();
	}
	public Post createPost(Post post) {
		return postRep.save(post);
	}
	public Post createPost(Post post, User user) {
		post.setUser(user);
		return postRep.save(post);
	}
	public Post updatePost(Post post) {
		return postRep.save(post);
	}
	public void deletePost(Long id) {
		postRep.deleteById(id);
	}
	public Post findPost(Long id) {
		Optional<Post> opPost = postRep.findById(id);
        if(opPost.isPresent()) {
            return opPost.get();
        } else {
            return null;
        }
	}
}
