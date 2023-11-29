package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Locker {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;      // 읽기 전용이다,,,
}
