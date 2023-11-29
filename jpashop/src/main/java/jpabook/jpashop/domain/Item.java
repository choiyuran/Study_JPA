package jpabook.jpashop.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    private String name;

    private Integer price;

    private Integer stockQuantity;
}
