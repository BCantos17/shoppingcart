package com.revature.delegate.implementation;

import com.revature.beans.Address;
import com.revature.delegate.BusinessDelegate;
import com.revature.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class BusinessDelegateImpl implements BusinessDelegate{
    private BillingService billingService;

    @Autowired
    public void setBillingService(BillingService billingService) {this.billingService = billingService;}

    public ResponseEntity<Address> addAddress(Address address) {return billingService.addAddress(address);}
}
