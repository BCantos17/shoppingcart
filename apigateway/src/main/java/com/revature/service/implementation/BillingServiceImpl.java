package com.revature.service.implementation;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.revature.beans.Address;
import com.revature.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class BillingServiceImpl implements BillingService{

    private static final Random random = new Random(System.currentTimeMillis());

    private EurekaClient discoveryClient;

    @Autowired
    public void setDiscoveryClient(EurekaClient discoveryClient) {this.discoveryClient = discoveryClient;}

    public ResponseEntity<Address> addAddress(Address address) {
        RestTemplate rest;

        Application addressApplication = discoveryClient.getApplication("address");
        // Get a random instance of a service to prevent overloading one service.
        InstanceInfo addressInstanceInfo = addressApplication.getInstances().get(random.nextInt(addressApplication.getInstances().size()));
        String addressHost = "http://" + addressInstanceInfo.getHostName() + ":"
                + addressInstanceInfo.getPort() + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Address> entity = new HttpEntity<>(address, headers);
        rest = new RestTemplate();
        final String addressURI = UriComponentsBuilder.fromHttpUrl(addressHost).path("address/add").build().toUriString();
        ResponseEntity<Address> addressResponseEntity = rest.exchange(addressURI, HttpMethod.POST, entity, Address.class);
        return addressResponseEntity;
    }

    public ResponseEntity<Address> updateAddress(Address address) {
        RestTemplate rest;

        Application addressApplication = discoveryClient.getApplication("address");
        // Get a random instance of a service to prevent overloading one service.
        InstanceInfo addressInstanceInfo = addressApplication.getInstances().get(random.nextInt(addressApplication.getInstances().size()));
        String addressHost = "http://" + addressInstanceInfo.getHostName() + ":"
                + addressInstanceInfo.getPort() + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Address> entity = new HttpEntity<>(address, headers);
        rest = new RestTemplate();
        final String addressURI = UriComponentsBuilder.fromHttpUrl(addressHost).path("address/update").build().toUriString();
        ResponseEntity<Address> addressResponseEntity = rest.exchange(addressURI, HttpMethod.PUT, entity, Address.class);
        return addressResponseEntity;
    }

    public ResponseEntity<List<Address>> findByCustomerId(Integer customerId) {
        RestTemplate rest;

        Application addressApplication = discoveryClient.getApplication("address");
        // Get a random instance of a service to prevent overloading one service.
        InstanceInfo addressInstanceInfo = addressApplication.getInstances().get(random.nextInt(addressApplication.getInstances().size()));
        String addressHost = "http://" + addressInstanceInfo.getHostName() + ":"
                + addressInstanceInfo.getPort() + "/";
        rest = new RestTemplate();
        final String addressURI = UriComponentsBuilder.fromHttpUrl(addressHost).path("address/customer/").path(customerId.toString()).build().toUriString();

        ResponseEntity<Address[]> addressResponseEntity = null;
        List<Address> addresses = new ArrayList<>();

        try{
            addressResponseEntity = rest.getForEntity(addressURI, Address[].class);
            addresses = Arrays.asList(addressResponseEntity.getBody());
        } catch(RuntimeException e){
            addressResponseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        System.out.println("In service " + addressResponseEntity.getStatusCode());
        return new ResponseEntity<>(addresses,
                addressResponseEntity.getStatusCode());
    }

    public ResponseEntity<Serializable> deleteAddress(String id) {
        RestTemplate rest;

        Application addressApplication = discoveryClient.getApplication("address");
        // Get a random instance of a service to prevent overloading one service.
        InstanceInfo addressInstanceInfo = addressApplication.getInstances().get(random.nextInt(addressApplication.getInstances().size()));
        String addressHost = "http://" + addressInstanceInfo.getHostName() + ":"
                + addressInstanceInfo.getPort() + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Address> entity = new HttpEntity<>(headers);
        rest = new RestTemplate();
        final String addressURI = UriComponentsBuilder.fromHttpUrl(addressHost).path("address/delete/").path(id).build().toUriString();
        ResponseEntity<Serializable> addressResponseEntity = rest.exchange(addressURI, HttpMethod.DELETE, entity, Serializable.class);
        return addressResponseEntity;
    }
}
