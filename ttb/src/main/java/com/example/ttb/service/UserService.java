package com.example.ttb.service;


import com.example.ttb.model.response.V1GetUserResponse;
import com.example.ttb.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class UserService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<V1GetUserResponse> getUser(String customerId) {
        return customerRepository.retrieveCustomerTotalSales(1);
    }
}
