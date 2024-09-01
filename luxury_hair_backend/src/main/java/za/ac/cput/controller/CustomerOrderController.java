package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.CustomerOrder;
import za.ac.cput.services.CustomerOrderService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/CustomerOrder")
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService orderService;

    @PostMapping("/create")
    public CustomerOrder create(@RequestBody CustomerOrder customerOrder) {
        return orderService.create(customerOrder);
    }

    @GetMapping("/read/{orderId}")
    public CustomerOrder read(@PathVariable String orderId) {
        return orderService.read(orderId);
    }

    @GetMapping("/readall")
    public List<CustomerOrder> readAll() {
        return orderService.getall();
    }

    @PostMapping("/update")
    public CustomerOrder update(@RequestBody CustomerOrder customerOrder) {
        return orderService.update(customerOrder);
    }
}