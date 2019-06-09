package company.example.controller;


import company.example.model.entity.ApartmentOrder;
import company.example.service.OrderService;
import company.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Collection;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @PostMapping("/order")
    public String makeOrder(ApartmentOrder order, long apartmentId, Principal principal) {
        orderService.makeOrder(order, apartmentId, principal);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String getOrders(Principal principal, Model model) {
        Collection<ApartmentOrder> orders = orderService.getOrders(principal);
        model.addAttribute("orders", orders);
        if (userService.isAdmin(principal.getName())) {
            model.addAttribute("admin", true);
        } else {
            model.addAttribute("admin", false);
        }
        return "orders";
    }

    @PostMapping("/pay")
    public String pay(long orderId) {
        orderService.payForOrder(orderId);
        return "redirect:/orders";
    }

    @PostMapping("/disapprove")
    public String disapprove(long orderId) {
        orderService.disapproveOrder(orderId);
        return "redirect:/orders";
    }
}