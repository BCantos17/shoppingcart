package com.revature.repository;

import com.revature.beans.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends MongoRepository<Address, String> {
    @Override
    Address insert(Address address);

    @Override
    Address save(Address address);

    @Override
    List<Address> findAll();

    List<Address> findByCustomerId(int customerId);

    void deleteById(String id);
}
