package com.sujeet.Ecommerce_Backend.Service;

import com.sujeet.Ecommerce_Backend.Model.Product;
import com.sujeet.Ecommerce_Backend.Repository.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public class ProductService {
        @Autowired
    private ProdRepo repo;
        public List<Product> getAllProduct(){
           return repo.findAll();
        }
        public Product getProductById(int ProdId){
            return repo.findById(ProdId).orElse(null);
        }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
            return repo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageType(imageFile.getContentType());
        product.setImageName(imageFile.getOriginalFilename());
       return  repo.save(product);
    }

    public void deleteProduct(int prodId) {
            repo.deleteById(prodId);
    }
    public List<Product> searchProducts(String keyword){
            return repo.searchProducts(keyword);
    }
}
