package com.revature.delegate.implementation;

import com.revature.beans.Address;
import com.revature.beans.CreditCard;
import com.revature.delegate.BusinessDelegate;
import com.revature.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BusinessDelegateImpl implements BusinessDelegate{
    private BillingService billingService;

    @Autowired
    public void setBillingService(BillingService billingService) {this.billingService = billingService;}

    public ResponseEntity<Address> insertAddress(Address address) {return billingService.insertAddress(address);}
    public ResponseEntity<Address> saveAddress(Address address) {return billingService.saveAddress(address);}
    public ResponseEntity<List<Address>> findAddressByCustomerId(Integer customerId) {return billingService.findAddressByCustomerId(customerId);}
    public ResponseEntity deleteAddress(String id) {return billingService.deleteAddress(id);}


    public ResponseEntity<CreditCard> insertCreditCard(CreditCard creditCard) {return billingService.insertCreditCard(creditCard);}
    public ResponseEntity<CreditCard> saveCreditCard(CreditCard creditCard) {return billingService.saveCreditCard(creditCard);}
    public ResponseEntity<List<CreditCard>> findCreditCardByCustomerId(Integer customerId) {return billingService.findCreditCardByCustomerId(customerId);}
    public ResponseEntity deleteCreditCard(String id) {return billingService.deleteCreditCard(id);}
}
