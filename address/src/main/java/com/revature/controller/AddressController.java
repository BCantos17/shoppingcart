package com.revature.controller;

import com.revature.beans.Address;
import com.revature.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Address> insert(@RequestBody Address address){
        ResponseEntity<Address> returnEntity;
        try {
            returnEntity = new ResponseEntity(service.insert(address), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/address/update",
            method = RequestMethod.PUT,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> save(@RequestBody Address address){
        ResponseEntity<Address> returnEntity;
        try {
            returnEntity = new ResponseEntity(service.save(address), HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/address/customer/{customerId}",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Address>> findByCustomerId(@PathVariable Integer customerId){
        ResponseEntity<List<Address>> returnEntity;
        try {
            List<Address> addresses = service.findByCustomerId(customerId);
            if (addresses == null)
                returnEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
            else
                returnEntity = new ResponseEntity<>(addresses, HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/address/delete/{id}",
            method = RequestMethod.DELETE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable String id){
        ResponseEntity returnEntity;
        try {
            service.delete(id);
            returnEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            e.printStackTrace();
            returnEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }
}
