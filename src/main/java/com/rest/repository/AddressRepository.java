package com.rest.repository;

import com.rest.entity.Address;
import com.rest.errors.AddressNotExistException;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.Map;

@Repository
public class AddressRepository {
    private Map<Long, Address> addressList = new HashMap<>();

    {
        Address address1 = new Address((long) 1, "Kiev", "Donca", "34a", "22");
        Address address2 = new Address((long) 2, "Kiev", "Pobedi", "18b", "67");
        Address address3 = new Address((long) 3, "Doneck", "Schevchenko", "3", "489");
        addressList.put(address1.getId(), address1);
        addressList.put(address2.getId(), address2);
        addressList.put(address3.getId(), address3);
    }

    public Address getAddress(Long id) {
        return addressList.get(id);
    }

    public Address saveAddress(Address address) {
        return addressList.put(address.getId(), address);
    }

    public Address updateAddress(Address address) {
        boolean ifExist = addressList.entrySet()
                .stream()
                .anyMatch(x -> x.getKey().equals(address.getId()));
        if (!ifExist)
            throw new AddressNotExistException("Such address does not exist");
        return addressList.put(address.getId(), address);
    }

    public boolean deleteAddress(Address address) {
        return addressList.remove(address.getId(), address);
    }
}
