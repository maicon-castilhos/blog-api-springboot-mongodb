package com.maiconamaral.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maiconamaral.workshopmongo.domain.Post;
import com.maiconamaral.workshopmongo.resources.util.URL;
import com.maiconamaral.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title", required = false) String title) {
		String decodedTitle = URL.decode(title);
		List<Post> list = service.findByTitle(decodedTitle);
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> filterPosts(
			@RequestParam(value = "data", required = false) String data,
			@RequestParam(value = "fromDate", required = false) String fromDateStr,
			@RequestParam(value = "toDate", required = false) String toDateStr) {

		String decodedData = URL.decode(data);
		Date fromDate = URL.parseDate(fromDateStr);
		Date toDate = URL.parseDate(toDateStr);

		if (fromDate == null) {
			fromDate = new Date(0);
		}
		if (toDate == null) {
			toDate = new Date();
		}

		List<Post> list = service.searchPosts(fromDate, toDate, decodedData);
		return ResponseEntity.ok().body(list);
	}
}
