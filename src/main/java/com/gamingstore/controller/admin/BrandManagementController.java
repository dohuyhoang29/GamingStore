package com.gamingstore.controller.admin;

import com.gamingstore.model.Brand;
import com.gamingstore.service.BrandService;
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
public class BrandManagementController {
  @Autowired
  private BrandService brandService;

  @Autowired
  private CategoryService categoryService;

  @GetMapping("/admin/brand/show_brand")
  public String showBrandManagement(Model model) {
    model.addAttribute("listBrand", brandService.getAllBrand());

    return "/admin/brand/brand_management";
  }

  @GetMapping("/admin/brand/insert")
  public String insertBrand(Model model) {
    model.addAttribute("listCategory", categoryService.findAllCategory());
    model.addAttribute("brand", new Brand());

    return "/admin/brand/form_brand";
  }

  @PostMapping("/admin/brand/save")
  public String saveBrand(@Valid Brand brand, BindingResult result) {
    if (result.hasErrors()) {
      return "/admin/brand/form_brand";
    }
    brandService.saveBrand(brand);

    return "redirect:/admin/brand/show_brand";
  }

  @GetMapping("/admin/brand/edit/{id}")
  public String editBrand(@Valid Brand brand, @PathVariable("id") Integer id, BindingResult result, Model model) {
    model.addAttribute("listCategory", categoryService.findAllCategory());
    model.addAttribute("brand", brandService.getBrandById(id));

    return "/admin/brand/form_brand";
  }
}
