package com.revature.controller;

import com.revature.beans.Invoice;
import com.revature.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("invoice")
public class InvoiceController {
    private InvoiceService service;

    @Autowired
    public void setService(InvoiceService service) {this.service = service;}

    @RequestMapping(value = "/insert",
            method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Invoice> insert(@RequestBody Invoice invoice){
        System.out.println(invoice);
        ResponseEntity<Invoice> returnEntity;
        try {
            returnEntity = new ResponseEntity(service.insert(invoice), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            e.printStackTrace();
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/save",
            method = RequestMethod.PUT,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Invoice> save(@RequestBody Invoice invoice){
        ResponseEntity<Invoice> returnEntity;
        try {
            returnEntity = new ResponseEntity(service.save(invoice), HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/findAll",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Invoice>> findAll(){
        ResponseEntity<List<Invoice>> returnEntity;
        try {
            List<Invoice> invoices = service.findAll();
            if (invoices == null)
                returnEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
            else
                returnEntity = new ResponseEntity<>(invoices, HttpStatus.OK);
        } catch (RuntimeException e) {
            returnEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return returnEntity;
    }

    @RequestMapping(value = "/customer/{customerId}",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Invoice>> findByCustomerId(@PathVariable Integer customerId){
        ResponseEntity<List<Invoice>> returnEntity;
        List<Invoice> invoices;
        try {
            invoices = service.findByCustomerId(customerId);
            if (invoices.size() == 0)
                returnEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
            else
                returnEntity = new ResponseEntity<>(invoices, HttpStatus.OK);
        } catch(RuntimeException e) {
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
