package com.mapping.onetomany.jpa.repository;


import com.mapping.onetomany.jpa.dao.CustomerDetails;
import com.mapping.onetomany.jpa.dto.CustomResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepositoryAbst extends JpaRepository<CustomerDetails, Integer> {

    // Approach 1 : Directly from here using @query::
    @Query(value = "SELECT new com.mapping.onetomany.jpa.dto.CustomResponse(c.firstName, c.lastName, p.productName, p.productTotalPrice, p.productQty) FROM CustomerDetails c JOIN c.productDetails p")
    List<CustomResponse> getCustomResponse();

    // Approach 2: Comment line 18,19 and call the return method from service class

}
