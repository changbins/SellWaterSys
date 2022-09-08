package com.example.waterdeliverysystem.model;

public class Customer {


    private int id;

    private String customerName;
    private String address;
    private String tel;
    private int ticket;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public Customer() {
    }


    public Customer(int id, String customerName, String address, String tel, int ticket) {
        this.id = id;
        this.customerName = customerName;
        this.address = address;
        this.tel = tel;
        this.ticket = ticket;
    }
}
