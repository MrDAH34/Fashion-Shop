package com.project.FashionShop.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.project.FashionShop.model.Product;
import com.project.FashionShop.service.impl.productServiceImpl;

@Controller
public class productController {
    @Autowired
    private productServiceImpl productServiceImpl;

    @GetMapping("/home")
    public String goHome() {
        return "index";
    }

    @GetMapping("/products/tables")
    public String tablesHome(Model model) {
        List<Product> products = productServiceImpl.listAllProduct();
        model.addAttribute("products", products);
        return "tables";
    }

    @GetMapping("/products/create")
    public String createProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/products/create")
    public String updateProduct(@ModelAttribute("product") Product product) {
        product.setProductDate(LocalDate.now());
        productServiceImpl.saveProduct(product);
        return "redirect:/products/tables";
    }

    @GetMapping("/products/{productId}/delete")
    public String deleteProduct(@PathVariable Long productId) {
        productServiceImpl.deleteById(productId);
        return "redirect:/products/tables";
    }

    @GetMapping("/products/{productId}/edit")
    public String formEdit(@PathVariable Long productId, Model model) {
        Product product = productServiceImpl.findById(productId);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @PostMapping("/products/{productId}/edit")
    public String updateEdit(@PathVariable Long productId, @ModelAttribute Product product) {
        product.setId(productId);
        productServiceImpl.updateProduct(product);
        return "redirect:/products/tables";
    }

    @GetMapping("/products/search")
    public String searchProduct(@RequestParam(value = "name") String name, Model model) {
        List<Product> products = productServiceImpl.searchByName(name);
        model.addAttribute("product", products);
        return "tables";
    }

}
