package br.com.fiap.fordclub.service;

import br.com.fiap.fordclub.entity.Customer;
import br.com.fiap.fordclub.repository.CustomerRepository;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GetCustomerByDocumentService {

    private final CustomerRepository customerRepository;

    public Customer execute(String document) throws ServiceException {
        try {
            var savedCustomer =
                    customerRepository.findCustomerByDocument(document);

            if(Objects.isNull(savedCustomer)){
                throw new ServiceException("Cliente não existente.");
            }

            return savedCustomer;
        } catch (Exception e){
            throw new ServiceException("Problemas ao buscar cliente.");
        }

    }
}