package com.revature.controller;

import com.revature.beans.Discount;
import com.revature.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/discount")
public class DiscountController {

    private DiscountService service;

    @Autowired
    public void setService(DiscountService service) {this.service = service;}

    @RequestMapping(value = "/insert",
            method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Discount> insert(@RequestBody Discount discount){
        ResponseEntity<Discount> returnEntity;
        try {
            returnEntity = new ResponseEntity(service.insert(discount), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/save",
            method = RequestMethod.PUT,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Discount> save(@RequestBody Discount discount){
        ResponseEntity<Discount> returnEntity;
        try {
            returnEntity = new ResponseEntity(service.save(discount), HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/code/{code}",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Discount> findByCodeAndUsedTrue(@PathVariable String code){
        ResponseEntity<Discount> returnEntity;
        Discount discount;
        try {
            discount = service.findByCodeAndUsedTrue(code);
            if (discount == null )
                returnEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
            else
                returnEntity = new ResponseEntity<>(discount, HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/product/{productId}",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Discount> findByProductId(@PathVariable String productId){
        ResponseEntity<Discount> returnEntity;
        Discount discount;
        try {
            discount = service.findByProductId(productId);
            if (discount == null )
                returnEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
            else
                returnEntity = new ResponseEntity<>(discount, HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/customer/{customerId}",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Discount> findByCustomerId(@PathVariable Integer customerId){
        ResponseEntity<Discount> returnEntity;
        Discount discount;
        try {
            discount = service.findByCustomerId(customerId);
            if (discount == null )
                returnEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
            else
                returnEntity = new ResponseEntity<>(discount, HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.DELETE)
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
