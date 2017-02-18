package com.revature.service.implementation;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.revature.beans.Address;
import com.revature.beans.Customer;
import com.revature.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Random;

public class BillingServiceImpl implements BillingService{

    private static final Random random = new Random(System.currentTimeMillis());

    private EurekaClient discoveryClient;

    @Autowired
    public void setDiscoveryClient(EurekaClient discoveryClient) {this.discoveryClient = discoveryClient;}

    public ResponseEntity<Customer> insertCustomerAddress(Customer customer) {
        RestTemplate rest;

        Application addressApplication = discoveryClient.getApplication("address");
        // Get a random instance of a service to prevent overloading one service.
        InstanceInfo addressInstanceInfo = addressApplication.getInstances().get(random.nextInt(addressApplication.getInstances().size()));
        String addressHost = "http://" + addressInstanceInfo.getHostName() + ":" + addressInstanceInfo.getPort() + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Customer> entity = new HttpEntity<>(customer, headers);
        rest = new RestTemplate();
        final String addressURI = UriComponentsBuilder.fromHttpUrl(addressHost).path("address/address/").build().toUriString();
        ResponseEntity<Customer> addressResponseEntity = rest.exchange(addressURI, HttpMethod.POST, entity, Customer.class);
        return addressResponseEntity;
    }
}
