package com.revature.controller;

import com.revature.beans.Price;
import com.revature.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PriceController {

    private PriceService service;
    @Autowired
    public void setService(PriceService service) {this.service = service;}


    @RequestMapping(value = "/insert",
                    method = RequestMethod.POST,
                    consumes= MediaType.APPLICATION_JSON_VALUE,
                    produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Price> insert (@RequestBody Price price){

        ResponseEntity<Price> returnEntity;
        try {
            returnEntity = new ResponseEntity(service.insertPrice(price), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/update",
                    method = RequestMethod.PUT,
                    consumes= MediaType.APPLICATION_JSON_VALUE,
                    produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Price> update (@RequestBody Price price){

        ResponseEntity<Price> returnEntity;
        try {
            returnEntity = new ResponseEntity(service.updatePrice(price), HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/findByCartId/{cartId}",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Price> findByCartId(@PathVariable String cartId){

        ResponseEntity<Price> returnEntity;
        try {
            returnEntity = new ResponseEntity(service.findByCartId(cartId), HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }


    @RequestMapping(value = "/findAll",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Price> findAll(){

        ResponseEntity<Price> returnEntity;
        try {
            returnEntity = new ResponseEntity(service.findAll(), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }


    @RequestMapping(value = "/deleteAll",
            method = RequestMethod.DELETE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public void deleteAll(){
        service.deleteAll();
    }

}
