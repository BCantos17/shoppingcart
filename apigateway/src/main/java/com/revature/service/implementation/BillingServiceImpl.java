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
        /*System.out.println(addressInstanceInfo.getHomePageUrl() + " " +
                addressInstanceInfo.getInstanceId() + " " +
                addressInstanceInfo.getVIPAddress() + " " +
                addressInstanceInfo.getAppName());*/
        String addressHost = "http://" + addressInstanceInfo.getHostName() + ":"
                + addressInstanceInfo.getPort() + "/";
        /*http://laptop-djhbs8rc.home:55555/address/customer/1*/
        /*LAPTOP-DJHBS8RC.home:address:55555*/
        System.out.println(addressHost);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Address> entity = new HttpEntity<>(address, headers);
        rest = new RestTemplate();
        final String addressURI = UriComponentsBuilder.fromHttpUrl(addressHost).path("address/").build().toUriString();
        ResponseEntity<Address> addressResponseEntity = rest.exchange(addressURI, HttpMethod.POST, entity, Address.class);
        return addressResponseEntity;
    }
}
