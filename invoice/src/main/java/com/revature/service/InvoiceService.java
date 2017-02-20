package com.revature.service;

import com.revature.beans.Invoice;
import com.revature.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    private InvoiceRepository repository;

    @Autowired
    public void setRepository(InvoiceRepository repository) {this.repository = repository;}

    public Invoice insert(Invoice invoice){ return repository.insert(invoice); }
    public Invoice save(Invoice invoice){ return repository.save(invoice); }
    public List<Invoice> findAll(){ return repository.findAll(); }
    public List<Invoice> findByCustomerId(Integer customerId){ return repository.findByCustomerId(customerId); }
    public void delete(String id){ repository.delete(id); }

}
