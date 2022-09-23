package br.com.fiap.fordclub.service;

import br.com.fiap.fordclub.entity.Customer;
import br.com.fiap.fordclub.repository.CustomerRepository;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GetAllCustomersService {

    private final CustomerRepository repository;

    public List<Customer> execute() throws ServiceException {
        try {
            var customers = repository.findAll();

            if (customers.isEmpty()) {
                throw new ServiceException("Não há clientes cadastrados.");
            }

            return customers;
        } catch (Exception e) {
            throw new ServiceException("Problemas ao buscar clientes.");
        }

    }
}