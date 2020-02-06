package com.project.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.project.demo.model.Authorization;
import com.project.demo.model.BaseUser;
import com.project.demo.repository.AuthorizationRepository;
import com.project.demo.repository.BaseUserRepository;

@Controller @RequestMapping("/users")
public class UserController {
	@Autowired
	private BaseUserRepository repo;
	@Autowired
	private AuthorizationRepository authRepo;
	
	//Read
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("users", this.repo.findAll());
		return "userList";
	}
	
	@GetMapping("/{id}")
	public String getById(@PathVariable long id, Model model) throws ResponseStatusException {
		Optional<BaseUser> entity = repo.findById(id);
		List<BaseUser> list = new ArrayList<BaseUser>();
		
		if(!entity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		list.add(entity.get());
		model.addAttribute("users", list);
		
		return "userList";
	}
		
	@PostMapping
	public String searchByName(@RequestParam String name, Model model) {
		List<BaseUser> list = new ArrayList<BaseUser>();
		list.add(repo.findByUsername(name));
		
		if(!list.isEmpty()) {
			model.addAttribute("users", list);
		}
		
		return "userList";
	}
	
	//Create
	@GetMapping("/create")
	public String getForm(Model model) {
		BaseUser entity = new BaseUser();
		entity.setAuthorizations(new ArrayList<Authorization>());
		
		model.addAttribute("user", entity);
		model.addAttribute("authorizations", authRepo.findAll());
		return "userForm";
	}
	
	@PostMapping("/create")
	public String addOne(@Valid @ModelAttribute("user") BaseUser entity, BindingResult bR,
							@RequestParam(value="auths", required=false) long[] auths, Model model) throws ResponseStatusException {
		List<Authorization> authList = new ArrayList<Authorization>();
		
		if (bR.hasErrors() || auths.length == 0)	{
			return "userForm";
		}
		
		for(long i : auths) {
			Authorization a = authRepo.getOne(i);					
			authList.add(a);
		}
		
		entity.setAuthorizations(authList);
		
		
        entity.setPassword(new BCryptPasswordEncoder().encode(entity.getPassword()));	
		
		repo.save(entity);
		return "redirect:../users";
	}
	
	//Update
	@GetMapping("/alter/{id}")
	public String getAlterForm(@PathVariable long id, Model model) {
		Optional<BaseUser> entity = repo.findById(id);
		
		if(!entity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		model.addAttribute("authorizations", authRepo.findAll());
		
		model.addAttribute("user", entity.get());
		return "userForm";
	}
	
	@PostMapping("/alter/{id}")
	public String alterOne(@Valid @ModelAttribute BaseUser entity, BindingResult bR,
			@RequestParam(value="auths", required=false) long[] auths, Model model) throws ResponseStatusException {
		List<Authorization> authList = new ArrayList<Authorization>();
		
		if (bR.hasErrors() || auths.length == 0)	{
			return "userForm";
		}
		
		for(long i : auths) {
			Authorization a = authRepo.getOne(i);					
			authList.add(a);
		}
		
		entity.setAuthorizations(authList);
		
		
        entity.setPassword(new BCryptPasswordEncoder().encode(entity.getPassword()));	
		
		repo.save(entity);
		return "redirect:../../users";
	}
	
	//Delete
	@GetMapping("/delete/{id}")
	public String deleteOne(@PathVariable long id, Model model) {
		Optional<BaseUser> entity = repo.findById(id);
		
		if(!entity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		repo.delete(entity.get());		
		return "redirect:../../users";
	}
}
