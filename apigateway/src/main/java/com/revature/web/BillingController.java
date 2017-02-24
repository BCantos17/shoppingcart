package com.revature.web;

import com.revature.beans.Address;
import com.revature.beans.CreditCard;
import com.revature.delegate.BusinessDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Billing controller.
 */
@RestController()
@RequestMapping("/billing")
public class BillingController {

    private BusinessDelegate delegate;

    @Autowired
    public void setDelegate(BusinessDelegate delegate) {this.delegate = delegate;}

    /************************************ Address controller  *******************************************/

    @RequestMapping(value = "/address/insert",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        return delegate.insertAddress(address);
    }

    @RequestMapping(value = "/address/save",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        return delegate.saveAddress(address);
    }

    @RequestMapping(value = "/address/byId/{customerId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Address>> findAddressByCustomerId(@PathVariable Integer customerId) {
        return delegate.findAddressByCustomerId(customerId);
    }

    @RequestMapping(value = "/address/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Address> deleteAddress(@PathVariable String id) {
        return delegate.deleteAddress(id);
    }

    /************************************ Credit card controller  *******************************************/
    @RequestMapping(value = "/creditCard/insert",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCard> insertCreditCard(@RequestBody CreditCard creditCard) {
        return delegate.insertCreditCard(creditCard);
    }

    @RequestMapping(value = "/creditCard/save",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCard> saveCreditCard(@RequestBody CreditCard creditCard) {
        return delegate.saveCreditCard(creditCard);
    }

    @RequestMapping(value = "/creditCard/byId/{customerId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CreditCard>> findCreditCardByCustomerId(@PathVariable Integer customerId) {
        return delegate.findCreditCardByCustomerId(customerId);
    }

    @RequestMapping(value = "/creditCard/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<CreditCard> deleteCreditCard(@PathVariable String id) {
        return delegate.deleteCreditCard(id);
    }
}
