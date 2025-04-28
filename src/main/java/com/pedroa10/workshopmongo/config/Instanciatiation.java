package com.pedroa10.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pedroa10.workshopmongo.domain.Post;
import com.pedroa10.workshopmongo.domain.User;
import com.pedroa10.workshopmongo.repository.PostRepository;
import com.pedroa10.workshopmongo.repository.UserRepository;

@Configuration
public class Instanciatiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run (String... arg0) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User (null, "Maria Brown", "maria@gmail.com");
		User alex = new User (null, "Alex Green", "alex@gmail.com");
		User bob = new User (null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("28/04/2025"), "Mais um dia igual", "Tudo se repetiu hoje", maria);
		Post post2 = new Post(null, sdf.parse("28/04/2025"), "TFT BEST GAME OF THE YEAR", "TFT É BAUM D++++", maria);
		
		
		userRepository.saveAll(Arrays.asList(alex, maria, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
}
