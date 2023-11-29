package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="ORDERS") //예약어인 경우가 많아 ORDERS로 사용한다.
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;
    private LocalDateTime orderDate;    //SpringBoot에서는 네이밍 관례를 변경할 수 있다. orderDate -> ORDER_DATE


//    private Member member;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
