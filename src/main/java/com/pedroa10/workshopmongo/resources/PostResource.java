package com.pedroa10.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedroa10.workshopmongo.domain.Post;
import com.pedroa10.workshopmongo.resources.util.URL;
import com.pedroa10.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/tittlesearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTittle(@RequestParam (value="text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTittle(text);
		return ResponseEntity.ok().body(list);
	}
}
