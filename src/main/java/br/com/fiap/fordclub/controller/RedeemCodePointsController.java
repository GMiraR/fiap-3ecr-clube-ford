package br.com.fiap.fordclub.controller;

import br.com.fiap.fordclub.controller.model.response.CustomerResponse;
import br.com.fiap.fordclub.entity.Customer;
import br.com.fiap.fordclub.repository.CustomerRepository;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers/{customerUuid}/points/{codePoints}")
@RequiredArgsConstructor
public class RedeemCodePointsController {

    private final CustomerRepository repository;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse execute(@PathVariable String customerUuid, @PathVariable String codePoints) throws ServiceException {

        var customer = this.repository.findById(customerUuid);

        if(customer.isEmpty()){
            throw new ServiceException("Cliente não existente.");
        }

        if(codePoints.length() <= 6){
            throw new ServiceException("Código inválido.");
        }

        String pointsToRedeemStr = codePoints.substring(Math.max(codePoints.length() - 5, 0));
        Long pointToRedeem = Long.parseLong(pointsToRedeemStr);

        customer.get().addPointsToWallet(pointToRedeem);

        repository.save(customer.get());

        return CustomerResponse.builder()
                .uuid(customer.get().getUuid())
                .firstName(customer.get().getFirstName())
                .lastName(customer.get().getLastName())
                .wallet(customer.get().getWallet())
                .status(customer.get().getStatus().toString())
                .build();
    }
}
