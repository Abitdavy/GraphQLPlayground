package com.example.GraphQLPlayground.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
public class Customer {
    @Id
    @GeneratedValue
    private long id;
    private String customerName;
    private String customerAge;
}
