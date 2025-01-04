package com.example.product.Management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.Management.dto.product;
import com.example.product.Management.repo.productRepo;

@RestController
@RequestMapping("/p")
public class productController {
   @Autowired
   productRepo repo;
   @PostMapping("/product")
   public product saveProduct(@RequestBody product p)
   {
	return repo.save(p);
	   
   }
   @GetMapping("/product")
   public List<product> getProducts()
   {
	return repo.findAll();
	   
   }
   @GetMapping("/product/{id}")
   public ResponseEntity< product> getProduct(@PathVariable int id)
   {
	   Optional<product> p=repo.findById(id);
	 if(p.isPresent()) {
	 
		 return new ResponseEntity<>(p.get(),HttpStatus.OK);
	 }
	 else
	 {	 
	return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	 }  
   }
   @PutMapping("product/{id}")
   public ResponseEntity<product> updateProduct( @PathVariable int id,@RequestBody product pro)
   {
	   Optional<product> p=repo.findById(id);
	   if(p.isPresent())
	   {
		   p.get().setName(pro.getName());
		   p.get().setPrice(pro.getPrice());
		   return new ResponseEntity<>(p.get(),HttpStatus.OK);
	   }
	   
	   else
	   {
		   return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	   }
	   
   }
   @DeleteMapping("/product/{id}")
   public ResponseEntity<Void> deleteId(@PathVariable int id)
   {
	   Optional<product> p=repo.findById(id);
	   if(p.isPresent())
	   {
		   repo.deleteById(id);
		  return new ResponseEntity<>(HttpStatus.OK);
	   }
	   else
	   {
		   return new ResponseEntity<>( HttpStatus.OK);
	   }
	
	   
   }
}
