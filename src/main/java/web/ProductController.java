package web;

import dao.IDao;
import entities.Product;
import entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IDao<Product> productDao;

    @Autowired
    private IDao<Category> categoryDao;

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productDao.findAll());
        model.addAttribute("categories", categoryDao.findAll());
        return "products";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String name,
                             @RequestParam double price,
                             @RequestParam int categoryId) {
        Category cat = categoryDao.findById(categoryId);
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        p.setCategory(cat);
        productDao.create(p);
        return "redirect:/products";
    }
    @GetMapping("/")
    public String home() {
        return "redirect:/products";
    }
    
    @GetMapping("/products/{id}")
    public String showProduct(@PathVariable(required = false) Integer id, Model model) {
        if (id == null) return "redirect:/products";
        Product product = productDao.findById(id);
        model.addAttribute("product", product);
        return "product-detail";
    }

}
