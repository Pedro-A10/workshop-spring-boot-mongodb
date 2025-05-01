package com.pedroa10.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.pedroa10.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	@Query("{ 'tittle': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTittle(String text);
	
	List<Post> findByTittleContainingIgnoreCase(String text);
	
}
