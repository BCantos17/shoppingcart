package com.revature.controller;

import com.revature.beans.Shipping;
import com.revature.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class ShippingController {
    private ShippingService service;

    @Autowired
    public void setService(ShippingService service) {this.service = service;}

    @RequestMapping(value = "/insert",
            method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shipping> insert(@RequestBody Shipping shipping){
        ResponseEntity<Shipping> returnEntity;
        try {
            returnEntity = new ResponseEntity(service.insert(shipping), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/save",
            method = RequestMethod.PUT,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shipping> save(@RequestBody Shipping shipping){
        ResponseEntity<Shipping> returnEntity;
        try {
            returnEntity = new ResponseEntity(service.save(shipping), HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/findAll",
            method = RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Shipping>> findAll(){
        ResponseEntity<List<Shipping>> returnEntity;
        try {
            List<Shipping> shippings = service.findAll();
            if (shippings.size() == 0)
                returnEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
            else
                returnEntity = new ResponseEntity<>(shippings, HttpStatus.OK);
        } catch (RuntimeException e) {
            e.printStackTrace();
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/cart/{cartId}",
            method = RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shipping> findByCartId(@PathVariable String cartId){
        ResponseEntity<Shipping> returnEntity;
        Shipping shipping = null;
        try {
            shipping = service.findByCartId(cartId);
            if (shipping == null)
                returnEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
            else
                returnEntity = new ResponseEntity<>(shipping, HttpStatus.OK);
        } catch (RuntimeException e) {
            e.printStackTrace();
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/invoice/{invoiceId}",
            method = RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shipping> findByInvoiceId(@PathVariable String invoiceId){
        ResponseEntity<Shipping> returnEntity;
        Shipping shipping = null;
        try {
            shipping = service.findByInvoiceId(invoiceId);
            if (shipping == null)
                returnEntity = new ResponseEntity(shipping, HttpStatus.NOT_FOUND);
            else
                returnEntity = new ResponseEntity<>(shipping, HttpStatus.OK);
        } catch (RuntimeException e) {
            e.printStackTrace();
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
