package web;

import dao.IDao;
import entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @Autowired
    private IDao<Category> categoryDao;

    @GetMapping("/categories")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
        return "categories"; // JSP name
    }
}
