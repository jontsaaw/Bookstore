package hh.swd20.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;


@ 
Controller
public class CategoryController {
@Autowired
private CategoryRepository categoryRepository;

@GetMapping("/categorylist")
public String categorylist(Model model) {
	model.addAttribute("categories", (List<Category>) categoryRepository.findAll());
	return "categorylist";
}

@GetMapping("/addcategory")
public String addCategory(Model model) {
    model.addAttribute("category", new Category());
    return "addcategory";
}

@PostMapping("/addcategory")
public String saveCategory(@ModelAttribute Category category) {
	categoryRepository.save(category);
	return "redirect:categorylist";
}
}
