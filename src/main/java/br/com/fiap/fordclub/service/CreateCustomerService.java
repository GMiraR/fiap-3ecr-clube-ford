package br.com.fiap.fordclub.service;

import br.com.fiap.fordclub.entity.Customer;
import br.com.fiap.fordclub.entity.enums.CustomerStatus;
import br.com.fiap.fordclub.repository.CustomerRepository;
import br.com.fiap.fordclub.service.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCustomerService {

    private final CustomerRepository customerRepository;

    public Customer execute(Customer customer) throws ServiceException {
        try {
            var customers =
                    customerRepository.findCustomersByDocumentAndEmail(customer.getDocument(), customer.getEmail());

            if(!customers.isEmpty()){
                throw new ServiceException("Cliente já existente.");
            }

            customer.setStatus(CustomerStatus.ACTIVE);

            return customerRepository.save(customer);
        } catch (Exception e){
            throw new ServiceException("Problemas ao cadastrar cliente.");
        }

    }
}
