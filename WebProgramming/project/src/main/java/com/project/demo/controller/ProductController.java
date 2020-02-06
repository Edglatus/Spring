package com.project.demo.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.project.demo.model.Product;
import com.project.demo.repository.ProductRepository;

@Controller @RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private ServletContext context;
	
	//Read
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("products", this.repo.findAll());
		return "productList";
	}
	
	@GetMapping("/{id}")
	public String getById(@PathVariable long id, Model model) throws ResponseStatusException {
		Optional<Product> entity = repo.findById(id);
		List<Product> list = new ArrayList<Product>();
		
		if(!entity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		list.add(entity.get());
		model.addAttribute("products", list);
		
		return "productList";
	}
	
	@PostMapping(params="name")
	public String searchByName(@RequestParam String name, Model model) {
		List<Product> list = repo.findByNameLike(name);
		
		if(!list.isEmpty()) {
			model.addAttribute("products", list);
		}
		
		return "productList";
	}
	
	//Create
	@GetMapping("/create")
	public String getForm(Model model) {
		model.addAttribute("product", new Product());
		return "productForm";
	}
	
	@PostMapping("/create")
	public String addOne(@Valid @ModelAttribute Product entity, BindingResult bR, @RequestParam("image") MultipartFile img, Model model){
		if (bR.hasErrors())	{
			return "productForm";
		}
		
		if (img.isEmpty()) {
            model.addAttribute("imgError", "No File Uploaded");
            return "productForm";
        } else if (!img.getContentType().equals(MediaType.IMAGE_JPEG_VALUE)) {
            model.addAttribute("imgError", "Unsupported Filetype");
            return "productForm";
        }
		
		try {
			String imageName = Calendar.getInstance().getTimeInMillis() + img.getOriginalFilename();
			Path imageDestination = Paths.get("src/main/resources/uploads/" + imageName);
			img.transferTo(imageDestination);
			
			entity.setImagePath(context.getContextPath() + "/images/" + imageName);
		} catch(Exception e) {
			Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		repo.save(entity);
		return "redirect:../products";
	}
	
	//Update
	@GetMapping("/alter/{id}")
	public String getAlterForm(@PathVariable long id, Model model) {
		Optional<Product> entity = repo.findById(id);
		
		if(!entity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		model.addAttribute("product", entity.get());
		return "productForm";
	}
	
	@PostMapping("/alter/{id}")
	public String alterOne(@Valid @ModelAttribute Product entity, BindingResult bR, @RequestParam("image") MultipartFile img,
							 Model model, @PathVariable long id) throws ResponseStatusException {
		Optional<Product> found = repo.findById(id);
		
		if (bR.hasErrors())	{
			return "productForm";
		}
		
		if(!found.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}		
		
		if (!img.isEmpty()) {
	        if (!img.getContentType().equals(MediaType.IMAGE_JPEG_VALUE)) {
	            model.addAttribute("imgError", "Unsupported Filetype");
	            return "productForm";
	        }
		
			try {
				String imageName = Calendar.getInstance().getTimeInMillis() + img.getOriginalFilename();
				Path imageDestination = Paths.get("src/main/resources/uploads/" + imageName);
				img.transferTo(imageDestination);
				
				entity.setImagePath(context.getContextPath() + "/images/" + imageName);
			} catch(Exception e) {
				Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, e);
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
        } else {
        	entity.setImagePath(found.get().getImagePath());
        }
		
		repo.save(entity);
		return "redirect:../../products";
	}
	
	//Delete
	@GetMapping("/delete/{id}")
	public String deleteOne(@PathVariable long id, Model model) {
		Optional<Product> entity = repo.findById(id);
		
		if(!entity.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		repo.delete(entity.get());		
		return "redirect:../../products";
	}
}
