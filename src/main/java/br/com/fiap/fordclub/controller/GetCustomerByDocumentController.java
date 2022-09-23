package br.com.fiap.fordclub.controller;

import br.com.fiap.fordclub.controller.model.response.CustomerResponse;
import br.com.fiap.fordclub.service.GetCustomerByDocumentService;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class GetCustomerByDocumentController {
    private final GetCustomerByDocumentService getCustomerByDocumentService;

    @GetMapping("/{document}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse execute(@PathVariable String document) throws ServiceException {

        var savedCustomer = this.getCustomerByDocumentService.execute(document);

        return CustomerResponse.builder()
                .uuid(savedCustomer.getUuid())
                .firstName(savedCustomer.getFirstName())
                .lastName(savedCustomer.getLastName())
                .email(savedCustomer.getEmail())
                .document(savedCustomer.getDocument())
                .status(savedCustomer.getStatus().toString())
                .wallet(savedCustomer.getWallet())
                .rewards(savedCustomer.getRewards())
                .createdAt(savedCustomer.getCreatedAt())
                .updatedAt(savedCustomer.getUpdatedAt())
                .build();
    }
}
