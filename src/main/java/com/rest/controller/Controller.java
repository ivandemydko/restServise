package com.rest.controller;

import com.rest.entity.Address;
import com.rest.repository.AddressRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
@Api(tags = "address")
public class Controller {

    @Autowired
    private AddressRepository repository;

    @PostMapping(value = "/save")
    @ApiOperation(value = "Save new Address", notes = "It permits to save a new address")
    public Address saveAddress(@RequestBody Address address) {
        return repository.saveAddress(address);
    }

    @GetMapping(value = "/id/{id}")
    @ApiOperation(value = "get Address", notes = "It permits to get address by id")
    public Address getAddress(@PathVariable long id) {
        return repository.getAddress(id);
    }

    @PutMapping(value = "/update")
    @ApiOperation(value = "update Address", notes = "It permits to update Address")
    public Address updateAddress(@RequestBody Address address) {
        return repository.updateAddress(address);
    }

    @DeleteMapping(value = "/delete")
    @ApiOperation(value = "delete Address", notes = "It permits to delete Address")
    public boolean deleteAddress(@RequestBody Address address) {
        return repository.deleteAddress(address);
    }
}
