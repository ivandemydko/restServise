package com.rest.controller;

import com.rest.entity.Address;
import com.rest.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
public class Controller {

    @Autowired
    private AddressRepository repository;

    @PostMapping(value = "/save")
    public Address saveAddress(@RequestBody Address address) {
        return repository.saveAddress(address);
    }

    @GetMapping(value = "/id/{id}")
    public Address getAddress(@PathVariable long id) {
        return repository.getAddress(id);
    }

    @PutMapping(value = "/update")
    public Address updateAddress(@RequestBody Address address) {
        return repository.updateAddress(address);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteAddress(@RequestBody Address address) {
        return repository.deleteAddress(address);
    }
}
