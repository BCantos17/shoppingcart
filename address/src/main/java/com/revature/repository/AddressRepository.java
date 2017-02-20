package com.revature.repository;

import com.revature.beans.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AddressRepository extends MongoRepository<Address, String> {
    @Override
    Address insert(Address address);

    @Override
    Address save(Address address);

    @Override
    List<Address> findAll();

    List<Address> findByCustomerId(int customerId);

    @Override
    void delete(String id);
}
