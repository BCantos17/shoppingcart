package com.revature.delegate.implementation;

import com.revature.beans.Address;
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

    public ResponseEntity<Address> addAddress(Address address) {return billingService.addAddress(address);}
    public ResponseEntity<Address> updateAddress(Address address) {return billingService.updateAddress(address);}
    public ResponseEntity<List<Address>> findByCustomerId(Integer customerId) {return billingService.findByCustomerId(customerId);}
    public ResponseEntity deleteAddress(String id) {return billingService.deleteAddress(id);}
}
