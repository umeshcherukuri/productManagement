package com.example.product.Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product.Management.dto.product;

public interface productRepo  extends JpaRepository<product,Integer>{

}
