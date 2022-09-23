package br.com.fiap.fordclub.controller;

import br.com.fiap.fordclub.controller.model.request.CustomerRequest;
import br.com.fiap.fordclub.controller.model.response.CustomerResponse;
import br.com.fiap.fordclub.entity.Customer;
import br.com.fiap.fordclub.service.CreateCustomerService;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CreateCustomerController {

    private final CreateCustomerService createCustomerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse execute(@RequestBody @Valid CustomerRequest request) throws ServiceException {

        var createdCustomer = this.createCustomerService.execute(Customer.builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .email(request.getEmail())
                        .document(request.getDocument())
                        .build());

        return CustomerResponse.builder()
                .uuid(createdCustomer.getUuid())
                .firstName(createdCustomer.getFirstName())
                .lastName(createdCustomer.getLastName())
                .email(createdCustomer.getEmail())
                .document(createdCustomer.getDocument())
                .status(createdCustomer.getStatus().toString())
                .wallet(createdCustomer.getWallet())
                .createdAt(createdCustomer.getCreatedAt())
                .updatedAt(createdCustomer.getUpdatedAt())
                .build();
    }


}
