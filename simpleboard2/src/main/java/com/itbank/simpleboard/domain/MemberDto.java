package com.itbank.simpleboard.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class MemberDto {
    private Long id;
    private String username;
    private String userid;
    private String userpw;
    private String pnum;
    private String address;

}
