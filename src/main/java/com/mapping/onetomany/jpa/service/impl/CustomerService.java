package com.mapping.onetomany.jpa.service.impl;

import com.mapping.onetomany.jpa.dao.CustomerDetails;
import com.mapping.onetomany.jpa.dto.CustomResponse;
import com.mapping.onetomany.jpa.dto.CustomerDto;
import com.mapping.onetomany.jpa.repository.CustomerRepositoryAbst;
import com.mapping.onetomany.jpa.service.CustomerAbst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@PropertySource(value = "classpath:application-local.properties")
public class CustomerService extends ObjectMapper implements CustomerAbst {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Value("${sql.oneToManyQuery}")
    private String customSQL;
    @Autowired
    private CustomerRepositoryAbst customerRepositoryAbst;

    @Override
    public void postCustomer(CustomerDto customerDto) {
        log.info("Started storing the Customer details sent from DTO");
        this.customerRepositoryAbst.save(mapCustomerAccessFromTransfer(customerDto));
    }

    @Override
    public void postMultipleCustomers(List<CustomerDto> customerDtoList) {
        log.info("Started storing the multiple customers detail sent from DTO");
        this.customerRepositoryAbst.saveAll(mapCustomerAccessFromTransferList(customerDtoList));
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        log.info("Started fetching all the Customer details from DAO");
        return mapCustomerTransferFromAccessList(this.customerRepositoryAbst.findAll());
    }

    @Override
    public void deleteCustomer(Integer id) {
        log.info("Matched customer details deleted from DAO");
        this.customerRepositoryAbst.deleteById(id);
    }

    @Override
    public List<CustomResponse> getCustomizedDetails() {
        //return jdbcTemplate.query(customSQL, new BeanPropertyRowMapper<>(CustomResponse.class));
        //return jdbcTemplate.query(customSQL, new DataClassRowMapper<>(CustomResponse.class));
        return this.customerRepositoryAbst.getCustomResponse();
    }

    @Override
    public CustomerDto getMatchedCustomer(Integer id) {
        Optional<CustomerDetails> getCustomerDetail = this.customerRepositoryAbst.findById(id);
        log.info("Validated th customer details in DAO");
        if (getCustomerDetail.isPresent()) {
            CustomerDetails customerDetails = getCustomerDetail.get();
            return mapCustomerTransferFromAccess(customerDetails);
        } else
            throw new RuntimeException("No matched customer is found");
    }



}

