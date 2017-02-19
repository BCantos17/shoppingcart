package com.revature.service.implementation;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.revature.beans.Address;
import com.revature.beans.CreditCard;
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

    /************************************ Address MicroService **********************************/
    public ResponseEntity<Address> insertAddress(Address address) {
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
        final String addressURI = UriComponentsBuilder.fromHttpUrl(addressHost).path("address/insert").build().toUriString();
        ResponseEntity<Address> addressResponseEntity = rest.exchange(addressURI, HttpMethod.POST, entity, Address.class);
        return addressResponseEntity;
    }

    public ResponseEntity<Address> saveAddress(Address address) {
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
        final String addressURI = UriComponentsBuilder.fromHttpUrl(addressHost).path("address/save").build().toUriString();
        ResponseEntity<Address> addressResponseEntity = rest.exchange(addressURI, HttpMethod.PUT, entity, Address.class);
        return addressResponseEntity;
    }

    public ResponseEntity<List<Address>> findAddressByCustomerId(Integer customerId) {
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

    /************************************ Credit card MicroService **********************************/

    public ResponseEntity<CreditCard> insertCreditCard(CreditCard creditCard) {
        RestTemplate rest;

        Application creditCardApplication = discoveryClient.getApplication("creditCard");
        // Get a random instance of a service to prevent overloading one service.
        InstanceInfo creditCardInstanceInfo = creditCardApplication.getInstances().get(random.nextInt(creditCardApplication.getInstances().size()));
        String creditCardHost = "http://" + creditCardInstanceInfo.getHostName() + ":"
                + creditCardInstanceInfo.getPort() + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CreditCard> entity = new HttpEntity<>(creditCard, headers);
        rest = new RestTemplate();
        final String creditCardURI = UriComponentsBuilder.fromHttpUrl(creditCardHost).path("creditCard/insert").build().toUriString();
        ResponseEntity<CreditCard> addressResponseEntity = rest.exchange(creditCardURI, HttpMethod.POST, entity, CreditCard.class);
        return addressResponseEntity;
    }

    public ResponseEntity<CreditCard> saveCreditCard(CreditCard creditCard) {
        RestTemplate rest;

        Application creditCardApplication = discoveryClient.getApplication("creditCard");
        // Get a random instance of a service to prevent overloading one service.
        InstanceInfo creditCardInstanceInfo = creditCardApplication.getInstances().get(random.nextInt(creditCardApplication.getInstances().size()));
        String creditCardHost = "http://" + creditCardInstanceInfo.getHostName() + ":"
                + creditCardInstanceInfo.getPort() + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CreditCard> entity = new HttpEntity<>(creditCard, headers);
        rest = new RestTemplate();
        final String creditCardURI = UriComponentsBuilder.fromHttpUrl(creditCardHost).path("creditCard/save").build().toUriString();
        ResponseEntity<CreditCard> creditCardResponseEntity = rest.exchange(creditCardURI, HttpMethod.PUT, entity, CreditCard.class);
        return creditCardResponseEntity;
    }

    public ResponseEntity<List<CreditCard>> findCreditCardByCustomerId(Integer customerId) {
        RestTemplate rest;

        Application creditCardApplication = discoveryClient.getApplication("creditCard");
        // Get a random instance of a service to prevent overloading one service.
        InstanceInfo creditCardInstanceInfo = creditCardApplication.getInstances().get(random.nextInt(creditCardApplication.getInstances().size()));
        String creditCardHost = "http://" + creditCardInstanceInfo.getHostName() + ":"
                + creditCardInstanceInfo.getPort() + "/";
        rest = new RestTemplate();
        final String creditCardURI = UriComponentsBuilder.fromHttpUrl(creditCardHost).path("creditCard/customer/").path(customerId.toString()).build().toUriString();

        ResponseEntity<CreditCard[]> creditCardResponseEntity = null;
        List<CreditCard> creditCards = new ArrayList<>();

        try{
            creditCardResponseEntity = rest.getForEntity(creditCardURI, CreditCard[].class);
            creditCards = Arrays.asList(creditCardResponseEntity.getBody());
        } catch(RuntimeException e){
            creditCardResponseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(creditCards,
                creditCardResponseEntity.getStatusCode());
    }

    public ResponseEntity<Serializable> deleteCreditCard(String id) {
        RestTemplate rest;

        Application creditCardApplication = discoveryClient.getApplication("creditCard");
        // Get a random instance of a service to prevent overloading one service.
        InstanceInfo creditCardInstanceInfo = creditCardApplication.getInstances().get(random.nextInt(creditCardApplication.getInstances().size()));
        String creditCardHost = "http://" + creditCardInstanceInfo.getHostName() + ":"
                + creditCardInstanceInfo.getPort() + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Address> entity = new HttpEntity<>(headers);
        rest = new RestTemplate();
        final String creditCardURI = UriComponentsBuilder.fromHttpUrl(creditCardHost).path("creditCard/delete/").path(id).build().toUriString();
        ResponseEntity<Serializable> creditCardResponseEntity = rest.exchange(creditCardURI, HttpMethod.DELETE, entity, Serializable.class);
        return creditCardResponseEntity;
    }
}
