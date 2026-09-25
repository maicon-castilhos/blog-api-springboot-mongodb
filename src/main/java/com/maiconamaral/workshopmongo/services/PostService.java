package com.maiconamaral.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiconamaral.workshopmongo.domain.Post;
import com.maiconamaral.workshopmongo.repository.PostRepository;
import com.maiconamaral.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public List<Post> findByAuthor(String id) {
		return repo.findByAuthorId(id);
	}

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String title) {
		return repo.findByTitleCustom(title);
	}

	public List<Post> searchPosts(Date fromDate, Date toDate, String searchTerm) {
		System.out.println("DEBUG: SearchTerm = " + searchTerm);
		System.out.println("DEBUG: FromDate = " + fromDate);
		System.out.println("DEBUG: ToDate = " + toDate);

		toDate = new Date(toDate.getTime() + 24 * 60 * 60 * 1000);

		return repo.searchPosts(fromDate, toDate, searchTerm);
	}
}
