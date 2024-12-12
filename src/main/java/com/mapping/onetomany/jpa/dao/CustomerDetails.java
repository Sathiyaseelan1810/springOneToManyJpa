package com.mapping.onetomany.jpa.dao;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CUSTOMER_DETAILS")
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String emailId;

    @OneToMany(targetEntity = ProductDetails.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fn_ky", referencedColumnName = "customerId", nullable = false)
    private List<ProductDetails> productDetails;


}
