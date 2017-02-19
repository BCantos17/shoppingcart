package com.revature.controller;

import com.revature.beans.Shipping;
import com.revature.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
    private ShippingService service;

    @Autowired
    public void setService(ShippingService service) {this.service = service;}

    @RequestMapping(value = "/findAll",
            method = RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Shipping>> findAll(){
        ResponseEntity<List<Shipping>> returnEntity;
        try {
            List<Shipping> shippings = service.findAll();
            if (shippings == null)
                returnEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
            else
                returnEntity = new ResponseEntity<>(shippings, HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }
}
