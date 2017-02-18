package com.revature.controller;

import com.revature.beans.CreditCard;
import com.revature.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/creditCard")
public class CreditCardController {
    private CreditCardService service;

    @Autowired
    public void setService(CreditCardService service) {this.service = service;}

    @RequestMapping(value = "/insert",
            method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCard> insert(@RequestBody CreditCard creditCard){
        ResponseEntity<CreditCard> returnEntity;
        try {
            returnEntity = new ResponseEntity(service.insert(creditCard), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/save",
            method = RequestMethod.PUT,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCard> save(@RequestBody CreditCard creditCard){
        ResponseEntity<CreditCard> returnEntity;
        try {
            returnEntity = new ResponseEntity(service.save(creditCard), HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/findAll",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CreditCard>> findAll(){
        ResponseEntity<List<CreditCard>> returnEntity;
        try {
            List<CreditCard> creditCards = service.findAll();
            if (creditCards == null)
                returnEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
            else
                returnEntity = new ResponseEntity<>(creditCards, HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/customer/{customerId}",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CreditCard>> findByCustomerId(@PathVariable Integer customerId){
        ResponseEntity<List<CreditCard>> returnEntity;
        List<CreditCard> creditCards = new ArrayList<>();
        try {
            creditCards = service.findByCustomerId(customerId);
            if (creditCards.size() == 0)
                returnEntity = new ResponseEntity(creditCards, HttpStatus.NOT_FOUND);
            else
                returnEntity = new ResponseEntity<>(creditCards, HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(creditCards, HttpStatus.BAD_REQUEST);
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
