package br.com.fiap.fordclub.repository;

import br.com.fiap.fordclub.entity.Customer;
import br.com.fiap.fordclub.repository.constants.DatabaseConstants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(value = DatabaseConstants.SELECT_CUSTOMERS_BY_DOCUMENT_AND_EMAIL, nativeQuery = true)
    List<Customer> findCustomersByDocumentAndEmail(@Param("document") String document,
                               @Param("email") String email);

    @Query(value = DatabaseConstants.SELECT_CUSTOMER_BY_DOCUMENT, nativeQuery = true)
    Customer findCustomerByDocument(@Param("document") String document);
}