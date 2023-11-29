package hellojpa;

import lombok.*;

import javax.persistence.*;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
//@SequenceGenerator(name="MEMBER_SEQ_GENERATOR", sequenceName = "MEMBER_SEQ", initialValue = 1, allocationSize = 50)
public class Member {

    // 기본키 생성을 데이터베이스에 위임하는 것이다.
    // MySQL에 Auto Increment

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="name",nullable = false)
    private String username;


}
