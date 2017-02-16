package com.revature.controller;

import com.revature.beans.Address;
import com.revature.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    private AddressService service;

    @Autowired
    public void setService(AddressService service) {this.service = service;}

    @RequestMapping(value = "/address",
                    method = RequestMethod.POST,
                    consumes= MediaType.APPLICATION_JSON_VALUE,
                    produces=MediaType.APPLICATION_JSON_VALUE)
    public Address insert(@RequestBody Address address){
        return service.insert(address);
    }

    @RequestMapping(value = "/address/update",
            method = RequestMethod.PUT,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public Address save(@RequestBody Address address){
        return service.save(address);
    }

    @RequestMapping(value = "/address/customer/{customerId}",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Address> findByCustomerId(@PathVariable Integer customerId){
        return service.findByCustomerId(customerId);
    }

    @RequestMapping(value = "/address/delete/{id}",
            method = RequestMethod.DELETE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
