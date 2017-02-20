package com.revature.controller;

import com.revature.beans.Price;
import com.revature.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {
    private PriceService service;

    @Autowired
    public void setService(PriceService service) {this.service = service;}

    @RequestMapping(value = "/insert",
            method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Price> insert(@RequestBody Price price){
        ResponseEntity<Price> returnEntity;
        try {
            returnEntity = new ResponseEntity(service.insert(price), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/save",
            method = RequestMethod.PUT,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Price> save(@RequestBody Price price){
        ResponseEntity<Price> returnEntity;
        try {
            returnEntity = new ResponseEntity(service.save(price), HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/findAll",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Price>> findAll(){
        ResponseEntity<List<Price>> returnEntity;
        try {
            List<Price> prices = service.findAll();
            if (prices == null)
                returnEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
            else
                returnEntity = new ResponseEntity<>(prices, HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/product/{productId}",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Price>> findByProductId(@PathVariable String productId){
        ResponseEntity<List<Price>> returnEntity;
        List<Price> prices = new ArrayList<>();
        try {
            prices = service.findByProductId(productId);
            if (prices.size() == 0)
                returnEntity = new ResponseEntity(prices, HttpStatus.NOT_FOUND);
            else
                returnEntity = new ResponseEntity<>(prices, HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(prices, HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/invoice/{invoiceId}",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Price>> findByInvoiceId(@PathVariable String invoiceId){
        ResponseEntity<List<Price>> returnEntity;
        List<Price> prices = new ArrayList<>();
        try {
            prices = service.findByInvoiceId(invoiceId);
            if (prices.size() == 0)
                returnEntity = new ResponseEntity(prices, HttpStatus.NOT_FOUND);
            else
                returnEntity = new ResponseEntity<>(prices, HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(prices, HttpStatus.BAD_REQUEST);
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
