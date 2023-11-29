package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Inheritance(strategy = InheritanceType.JOINED)             // 데이터가 각 테이블에 나눠져서 들어감
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)         // 데이터가 Item테이블에 몰빵되어서 들어감
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)         // 데이터가 Movie테이블에 몰빵되어서 들어감
@DiscriminatorColumn
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;
}
