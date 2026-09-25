package com.maiconamaral.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.maiconamaral.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	List<Post> findByAuthorId(String id);
	List<Post> findByTitleContainingIgnoreCase(String title);

	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitleCustom(String title);

	@Query("{ 'date': { $gte: ?0, $lte: ?1 }, $or: [ " +
	       "{ 'title': { $regex: ?2, $options: 'i' } }, " +
	       "{ 'body': { $regex: ?2, $options: 'i' } }, " +
	       "{ 'comments.text': { $regex: ?2, $options: 'i' } } " +
	       "] }")
	List<Post> searchPosts(Date fromDate, Date toDate, String searchTerm);
}
