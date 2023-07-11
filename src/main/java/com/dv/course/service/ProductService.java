package com.dv.course.service;

import com.dv.course.entities.Product;
import com.dv.course.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductsRepository productsRepository;

    public List<Product> findAll(){
        return productsRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return productsRepository.findById(id);
    }

}
