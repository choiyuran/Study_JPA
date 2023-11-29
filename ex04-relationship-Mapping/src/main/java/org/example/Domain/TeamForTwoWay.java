package org.example.Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class TeamForTwoWay {
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    @Column(name = "name")
    private String username;

    //Arraylist로 초기화하는것을 관례로 많이 쓴다.
    @OneToMany(mappedBy = "team") // team으로 맵핑되어있단느 것을 명시
    private List<MemberForOneWaySolveProblem> members = new ArrayList<>();



}
