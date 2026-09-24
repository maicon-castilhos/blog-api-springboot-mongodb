package com.maiconamaral.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiconamaral.workshopmongo.domain.Post;
import com.maiconamaral.workshopmongo.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public List<Post> findByAuthor(String id) {
		return repo.findByAuthorId(id);
	}
}
