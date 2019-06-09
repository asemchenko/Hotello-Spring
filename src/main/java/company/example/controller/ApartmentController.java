package company.example.controller;

import company.example.model.entity.ApartmentCriteria;
import company.example.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApartmentController {
    @Autowired
    private ApartmentService apartmentService;

    @GetMapping("/findApartment")
    public String findApartment(ApartmentCriteria criteria, Model model) {
        model.addAttribute("apartments", apartmentService.findApartments(criteria));
        return "searchResult";
    }
}
