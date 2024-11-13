package ma.enset.university.web;


import ma.enset.university.entities.Product;
import ma.enset.university.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestService {
    @Autowired
    /* permet de faire une injection de dependance veut dire qu'on va acceder a la base de donnee
    et specifiquement a cette table pour faire des manipulations
     */

    ProductRepository productRepository;

    //retourne tous les products
    @GetMapping("/products")
    public List<Product> products(){
        return productRepository.findAll();
    }


    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable Long id){
        return productRepository.findById(id).get();
    }
}
