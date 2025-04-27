package com.pedroa10.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedroa10.workshopmongo.domain.User;
import com.pedroa10.workshopmongo.dto.UserDTO;
import com.pedroa10.workshopmongo.repository.UserRepository;
import com.pedroa10.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newOBJ = findById(obj.getId());
		updateData(newOBJ, obj);
		return repo.save(newOBJ);
	}
	
	private void updateData(User newOBJ, User obj) {
		newOBJ.setName(obj.getName());
		newOBJ.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User( objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
