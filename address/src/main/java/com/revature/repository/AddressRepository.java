package com.revature.repository;

import com.revature.beans.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AddressRepository extends MongoRepository<Address, Integer> {
    @Override
    <S extends Address> S insert(S address);

    List<Address> findByCustomerId(int customerId);

    @Override
    void delete(Integer id);
}
