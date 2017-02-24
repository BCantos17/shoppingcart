package com.revature.service;

import com.revature.beans.Price;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("price")
public interface PriceService {

    @RequestMapping(value = "/insert",
            method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Price> insert (@RequestBody Price price);

    @RequestMapping(value = "/update",
            method = RequestMethod.PUT,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Price> update (@RequestBody Price price);

    @RequestMapping(value = "/findByCartId/{cartId}",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Price> findByCartId(@PathVariable("cartId") String cartId);
}
