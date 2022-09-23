package br.com.fiap.fordclub.controller;

import br.com.fiap.fordclub.entity.Customer;
import br.com.fiap.fordclub.service.CustomerRedeemRewardService;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers/{customerUuid}/rewards/{rewardUuid}")
@RequiredArgsConstructor
public class CustomerRedeemRewardController {

    private final CustomerRedeemRewardService customerRedeemRewardService;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Customer execute(@PathVariable String customerUuid, @PathVariable String rewardUuid) throws ServiceException {

        return this.customerRedeemRewardService.execute(customerUuid, rewardUuid);
    }
}

