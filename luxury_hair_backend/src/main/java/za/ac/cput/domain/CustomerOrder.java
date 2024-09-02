package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity

public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String orderID;
    private  int quantity;
    private  double totalPrice;
    private  String orderStatus;
    private String orderDate;
    private String shippingAddress;
    private String shippingMethod;
    private String paymentMethod;

    public CustomerOrder(){

    }
    public CustomerOrder(Builder builder){
        this.orderID=builder.orderID;
        this.quantity=builder.quantity;
        this.totalPrice=builder.totalPrice;
        this.orderDate=builder.orderDate;
        this.orderStatus=builder.orderStatus;
        this.shippingAddress=builder.shippingAddress;
        this.shippingMethod=builder.shippingMethod;
        this.paymentMethod=builder.paymentMethod;
    }

    public String getOrderID() {
        return orderID;
    }


    public int getQuantity() {
        return quantity;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public String getOrderDate() {
        return orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }
    public String getShippingMethod() {
        return shippingMethod;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof CustomerOrder customerOrder)) return false;
        return quantity== customerOrder.quantity && Double.compare(totalPrice, customerOrder.totalPrice)==0&& Objects.equals(orderID, customerOrder.orderID)&& Objects.equals(orderDate, customerOrder.orderDate)&& Objects.equals(orderStatus, customerOrder.orderStatus)&& Objects.equals(shippingAddress, customerOrder.shippingAddress)&& Objects.equals(shippingMethod, customerOrder.shippingMethod)&& Objects.equals(paymentMethod, customerOrder.paymentMethod);

    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, quantity, totalPrice, orderStatus, orderDate, shippingAddress, shippingMethod, paymentMethod);
    }
    public String toString(){
        return"Order{"+
                "orderID='" + orderID+'\''+
                ",quantity="+quantity+
                ",totalPrice="+totalPrice+
                ",orderDate="+orderDate+
                ",orderStatus='"+orderStatus+'\''+
                ",shippingAddress='"+shippingAddress+'\''+
                ",shippingMethod='"+shippingMethod+'\''+
                ",paymentMethod='"+paymentMethod+'\''+
                '}';
    }
    public static class Builder{
        private String orderID;
        private int quantity;
        private double totalPrice;
        private String orderStatus;
        private String orderDate;
        private String shippingAddress;
        private String shippingMethod;
        private String paymentMethod;

        public Builder setOrderID(String orderID){
            this.orderID=orderID;
            return this;
        }

        public Builder setQuantity(int quantity){
            this.quantity=quantity;
            return this;
        }
        public Builder setTotalPrice(double totalPrice){
            this.totalPrice=totalPrice;
            return this;
        }
        public Builder setOrderStatus(String orderStatus){
            this.orderStatus=orderStatus;
            return this;
        }
        public Builder setOrderDate(String orderDate){
            this.orderDate=orderDate;
            return this;
        }
        public Builder setShippingAddress(String shippingAddress){
            this.shippingAddress=shippingAddress;
            return this;
        }
        public Builder setShippingMethod(String shippingMethod){
            this.shippingMethod=shippingMethod;
            return this;
        }
        public Builder setPaymentMethod(String paymentMethod){
            this.paymentMethod=paymentMethod;
            return this;
        }
        public Builder copy(CustomerOrder customerOrder){
            this.orderID= customerOrder.orderID;
            this.quantity= customerOrder.quantity;
            this.totalPrice= customerOrder.totalPrice;
            this.orderStatus= customerOrder.orderStatus;
            this.orderDate= customerOrder.orderDate;
            this.shippingAddress= customerOrder.shippingAddress;
            this.shippingMethod= customerOrder.shippingMethod;
            this.paymentMethod= customerOrder.paymentMethod;
            return this;
        }
        public CustomerOrder build(){
            return new CustomerOrder(this);
        }
    }

}
