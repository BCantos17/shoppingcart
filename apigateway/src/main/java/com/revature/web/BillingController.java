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

    /**
     * Sets delegate.
     *
     * @param delegate the delegate
     */
    @Autowired
    public void setDelegate(BusinessDelegate delegate) {this.delegate = delegate;}

    /************************************ Address controller  @param address the address
     * @return the response entity
     */
    @RequestMapping(value = "/address/insert",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        return delegate.insertAddress(address);
    }

    /**
     * Update address response entity.
     *
     * @param address the address
     * @return the response entity
     */
    @RequestMapping(value = "/address/save",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        return delegate.saveAddress(address);
    }

    /**
     * Find address by customer id response entity.
     *
     * @param customerId the customer id
     * @return the response entity
     */
    @RequestMapping(value = "/address/byId/{customerId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Address>> findAddressByCustomerId(@PathVariable Integer customerId) {
        return delegate.findAddressByCustomerId(customerId);
    }

    /**
     * Delete address response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @RequestMapping(value = "/address/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Address> deleteAddress(@PathVariable String id) {
        return delegate.deleteAddress(id);
    }

    /************************************ Credit card controller  @param creditCard the credit card
     * @return the response entity
     */
    @RequestMapping(value = "/creditCard/insert",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCard> insertCreditCard(@RequestBody CreditCard creditCard) {
        return delegate.insertCreditCard(creditCard);
    }

    /**
     * Save credit card response entity.
     *
     * @param creditCard the credit card
     * @return the response entity
     */
    @RequestMapping(value = "/creditCard/save",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCard> saveCreditCard(@RequestBody CreditCard creditCard) {
        return delegate.saveCreditCard(creditCard);
    }

    /**
     * Find credit card by customer id response entity.
     *
     * @param customerId the customer id
     * @return the response entity
     */
    @RequestMapping(value = "/creditCard/byId/{customerId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CreditCard>> findCreditCardByCustomerId(@PathVariable Integer customerId) {
        return delegate.findCreditCardByCustomerId(customerId);
    }

    /**
     * Delete credit card response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @RequestMapping(value = "/creditCard/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<CreditCard> deleteCreditCard(@PathVariable String id) {
        return delegate.deleteCreditCard(id);
    }
}
