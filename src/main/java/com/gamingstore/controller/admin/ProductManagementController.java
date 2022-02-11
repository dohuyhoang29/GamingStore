package com.gamingstore.controller.admin;

import com.gamingstore.model.Category;
import com.gamingstore.model.Product;
import com.gamingstore.service.CategoryService;
import com.gamingstore.service.ProductService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductManagementController {

  @Autowired
  private ProductService productService;
  @Autowired
  private CategoryService categoryService;

  @GetMapping("/admin/product/show_product")
  public String showProductManagement(Model model) {
    model.addAttribute("listProduct", productService.getAllProduct());

    return "/admin/product/product_management";
  }

  @GetMapping("/admin/product/insert")
  public String showFormProduct(Model model) {
    Iterable<Category> listCategory = categoryService.findAllCategory();
    model.addAttribute("product", new Product());
    model.addAttribute("listCategory", listCategory);

    return "/admin/product/form_product";
  }

  @PostMapping("/admin/product/save")
  public String save(@Valid Product product, BindingResult result, Model model) {
    if (result.hasErrors()) {
      Iterable<Category> listCategory = categoryService.findAllCategory();
      model.addAttribute("listCategory", listCategory);

      return "/admin/product/form_product";
    }

    productService.save(product);

    return "redirect:/admin/product/show_product ";
  }

  @GetMapping("/admin/product/edit/{id}")
  public String editProduct(@PathVariable("id") Integer id, Model model) {
    Product product = productService.getProductById(id);
    Iterable<Category> listCategory = categoryService.findAllCategory();

    model.addAttribute("product", product);
    model.addAttribute("listCategory", listCategory);

    return "/admin/product/form_product";
  }
}
