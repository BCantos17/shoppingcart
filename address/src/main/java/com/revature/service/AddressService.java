package com.revature.service;

import com.revature.beans.Address;
import com.revature.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private AddressRepository repository;

    @Autowired
    public void setRepository(AddressRepository repository) {
        this.repository = repository;
    }

    public Address insert(Address address){
        return repository.insert(address);
    }
    public Address save(Address address){
        return repository.save(address);
    }
    public List<Address> findAll(){ return  repository.findAll(); }
    public List<Address> findByCustomerId(int customerId){
        return repository.findByCustomerId(customerId);
    }
    public void delete(String id){repository.delete(id);}
}
