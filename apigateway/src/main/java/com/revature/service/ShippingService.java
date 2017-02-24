package com.revature.service;

import com.revature.beans.Shipping;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient("shipping")
public interface ShippingService {
    @RequestMapping(value = "/insert",
            method = RequestMethod.POST,
            produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Shipping> insert(@RequestBody Shipping shipping);

    @RequestMapping(value = "/save",
            method = RequestMethod.PUT,
            produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Shipping> save(@RequestBody Shipping shipping);

    @RequestMapping(value = "/cart/{cartId}",
            method = RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Shipping> findByCartId(@PathVariable("cartId") String cartId);

    @RequestMapping(value = "/invoice/{invoiceId}",
            method = RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Shipping> findByInvoiceId(@PathVariable("invoiceId") String invoiceId);

    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.DELETE)
    ResponseEntity delete(@PathVariable("id") String id);
}
