package com.example.account.dto.converter;

import com.example.account.dto.AccountCustomerDto;
import com.example.account.dto.AccountDto;
import com.example.account.dto.CreateCustomerRequest;
import com.example.account.dto.CustomerDto;
import com.example.account.model.Account;
import com.example.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    private final CustomerAccountDtoConverter customerAccountDtoConverter;

    public CustomerDtoConverter(CustomerAccountDtoConverter converter) {
        this.customerAccountDtoConverter = converter;
    }

    public AccountCustomerDto convertToAccountCustomer(Optional<Customer> from) {
        return from.map(f -> new AccountCustomerDto(f.getId(), f.getName(), f.getSurname())).orElse(null);
    }

    public CustomerDto convertToCustomerDto(Customer from) {
        return new CustomerDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getAccounts()
                        .stream()
                        .map(customerAccountDtoConverter::convert)
                        .collect(Collectors.toSet()));

    }
    /*public Customer convertToCustomer(CustomerDto from) {
            return new Customer(
                    from.getId(),
                    from.getName(),
                    from.getSurname(),
                    from.getAccounts()
                            .stream()
                            .map(customerAccountDtoConverter::convertAccount)
                            .collect(Collectors.toSet()));

    }*/
    public Customer convertToNewCustomer(CreateCustomerRequest from) {
        return new Customer(
                from.getId(),
                from.getName(),
                from.getSurname(),
                new HashSet<>()); // Initialize an empty set for accounts
    }

}
