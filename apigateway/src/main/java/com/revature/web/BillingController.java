package com.revature.web;

import com.revature.beans.Address;
import com.revature.delegate.BusinessDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/billing")
public class BillingController {

    private BusinessDelegate delegate;

    @Autowired
    public void setDelegate(BusinessDelegate delegate) {this.delegate = delegate;}

    @RequestMapping(value = "/address/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        return delegate.addAddress(address);
    }

    @RequestMapping(value = "/address/update",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        return delegate.updateAddress(address);
    }

    @RequestMapping(value = "/address/byId/{customerId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Address>> findByCustomerId(@PathVariable Integer customerId) {
        return delegate.findByCustomerId(customerId);
    }

    @RequestMapping(value = "/address/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Address> deleteAddress(@PathVariable String id) {
        return delegate.deleteAddress(id);
    }
}
