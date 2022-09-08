package com.example.waterdeliverysystem.controller;


import com.example.waterdeliverysystem.model.Customer;
import com.example.waterdeliverysystem.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerWeb {

    @Autowired
    CustomerServiceImpl customerService;


    @GetMapping("/toCustomerList")
    public String toCustomerList(Model model){

        List<Customer> customerList = customerService.getCustomerList();
        model.addAttribute("list",customerList);

        return "customerList";
    }

    // toAddCustomer
    @GetMapping("/toAddCustomer")
    public String toAddCustomer(){



        return "addCustomer";
    }

    // handleAddCustomer
    @PostMapping("/handleAddCustomer")
    public String handleAddCustomer(Customer customer){

        customerService.addCustomer(customer);

        return "redirect:/toCustomerList";
    }

//  toUpdateCustomer
    @GetMapping("/toUpdateCustomer/{id}")
    public String toUpdateCustomer(@PathVariable int id , Model model){

        Customer customerById = customerService.getCustomerById(id);

        model.addAttribute("customer",customerById);

        return "updateCustomer";

    }

    // handleUpdateCustomer
    @PostMapping("/handleUpdateCustomer")
    public String handleUpdateCustomer(Customer customer){

        customerService.updateCustomer(customer);

        return "redirect:/toCustomerList";
    }

    //deleteCustomer
    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id){
        //接收来自数据库的查询数据
        customerService.deleteCustomerById(id);
        return "redirect:/toCustomerList";
    }

    //queryCustomer
    @GetMapping("queryCustomer")
    public String queryCustomer(String customerName,Model model){
        List<Customer> customerListByCustomerName = new ArrayList<Customer>();

        if (customerName == null || customerName.equals("")){
            customerListByCustomerName = customerService.getCustomerList();
        }else {
            customerListByCustomerName = customerService.getCustomerListByCustomerName(customerName);
        }

        model.addAttribute("list",customerListByCustomerName);
        return "customerList";
    }




}
