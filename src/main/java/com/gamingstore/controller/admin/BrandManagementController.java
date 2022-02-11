package com.gamingstore.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrandManagementController {
  @GetMapping("/admin/brand/show_brand")
  public String showBrandManagement(Model model) {
    return "/admin/brand/brand_management";
  }
}
