package za.ac.cput.services;

import za.ac.cput.domain.CustomerOrder;

import java.util.List;

public interface ICustomerOrderService extends IService<CustomerOrder,String> {
    List<CustomerOrder> getall();
}
