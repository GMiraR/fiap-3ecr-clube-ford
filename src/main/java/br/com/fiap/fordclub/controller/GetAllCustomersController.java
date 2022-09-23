package br.com.fiap.fordclub.controller;

import br.com.fiap.fordclub.entity.Customer;
import br.com.fiap.fordclub.entity.RewardCategory;
import br.com.fiap.fordclub.service.GetAllCategoriesService;
import br.com.fiap.fordclub.service.GetAllCustomersService;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class GetAllCustomersController {

    private final GetAllCustomersService getAllCustomersService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> execute() throws ServiceException {

        return this.getAllCustomersService.execute();
    }
}
