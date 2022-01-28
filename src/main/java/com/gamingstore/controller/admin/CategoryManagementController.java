package com.gamingstore.controller.admin;

import com.gamingstore.GamingStoreApplication;
import com.gamingstore.model.Category;
import com.gamingstore.service.CategoryService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryManagementController {
  @Autowired
  private CategoryService service;

  @GetMapping("/admin/category/show_category")
  public String showCategoryManagement(Model model){
    Iterable<Category> listCategory = service.findAllCategory();
    model.addAttribute("listCategory", listCategory);

    return "/admin/category/category_management";
  }

  @GetMapping("/admin/category/insert")
  public String showFormCategory(Model model){
    model.addAttribute("category", new Category());
    model.addAttribute("status", GamingStoreApplication.UN_LOCK);

    return "/admin/category/form_category";
  }

  @PostMapping("/admin/category/save")
  public String insertCategory(@Valid Category category, BindingResult result) {
    if (result.hasErrors()){
      return "/admin/category/form_category";
    }

    service.saveCategory(category);

    return "redirect:/admin/category/show_category";
  }

  @GetMapping("/admin/category/edit/{categoryID}")
  public String showFormEditCategory(@PathVariable("categoryID") Integer categoryID, Model model) {
    Category category = service.findCategoryById(categoryID);
    model.addAttribute("category", category);
    model.addAttribute("status", category.getStatus());

    return "/admin/category/form_category";
  }
}
