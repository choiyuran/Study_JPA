package com.itbank.simpleboard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="memberId")
    private Long id;
    private String username;
    private String userid;
    private String userpw;
    private String pnum;
    private String address;


}
