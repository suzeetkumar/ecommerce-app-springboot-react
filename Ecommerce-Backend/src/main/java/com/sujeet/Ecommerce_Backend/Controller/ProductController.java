package com.sujeet.Ecommerce_Backend.Controller;



import com.sujeet.Ecommerce_Backend.Model.Product;
import com.sujeet.Ecommerce_Backend.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
  private ProductService service;

    @RequestMapping("/products")
     public ResponseEntity<List<Product>> getAllProoduct(){
        List<Product> productlist=service.getAllProduct();
        if(productlist!=null)
          return  new ResponseEntity<>(productlist, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
     @RequestMapping("/product/{ProdId}")
     public ResponseEntity<Product> getProductById(@PathVariable int ProdId){
        Product product=service.getProductById(ProdId);
        if(product!=null)
            return new ResponseEntity<>(product,HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
     }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product,@RequestPart MultipartFile imageFile){
        try {
            Product product1=service.addProduct(product,imageFile);
            return new ResponseEntity<>(product1,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }

    }
    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte [] > getImageByProductId(@PathVariable int productId ){
        Product product1= service.getProductById(productId);
        byte [] imageFile=product1.getImageData();
        return ResponseEntity.ok().contentType(MediaType.valueOf(product1.getImageType())).body(imageFile);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct( @PathVariable int id,@RequestPart Product product,MultipartFile imageFile) {
        Product product1 = null;
        try {
            product1 = service.updateProduct(id, product, imageFile);
        } catch (Exception e) {
            return new ResponseEntity<>("failed to update ", HttpStatus.BAD_REQUEST);
        }
        if (product1 != null)
           return  new ResponseEntity<>("updated", HttpStatus.OK);
        else
            return new ResponseEntity<>("failed to update ", HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/product/{ProdId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int ProdId){

            Product product=service.getProductById(ProdId);
            if(product!=null){
                service.deleteProduct(ProdId);
                return new ResponseEntity<>("Deleted",HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("product not found",HttpStatus.NOT_FOUND);
            }
    }
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword){
        System.out.println("searching with" +keyword);
        List<Product> products=  service.searchProducts(keyword);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}
