package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CustomerOrder;
import za.ac.cput.repository.CustomerOrderRepository;

import java.util.List;

@Service
public class CustomerOrderService implements ICustomerOrderService {
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    CustomerOrderService(CustomerOrderRepository repo) {
        this.customerOrderRepository = repo;
    }
    private CustomerOrderService(){

    }
    @Override
    public CustomerOrder create (CustomerOrder customerOrder) {

        return customerOrderRepository.save(customerOrder);
    }
    @Override
    public CustomerOrder read(String OrderID){
        return customerOrderRepository.findById(OrderID).orElse(null);
    }
    @Override
    public CustomerOrder update(CustomerOrder customerOrder) {
        return customerOrderRepository.save(customerOrder);
    }

    @Override
    public List<CustomerOrder> getall() {
        return customerOrderRepository.findAll();
    }
}