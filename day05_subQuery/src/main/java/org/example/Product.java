package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id @GeneratedValue
    @Column(name="PRODUCT_ID")
    private Long id;

    private String name;
    private int price;
    private int priceAmount;


}
