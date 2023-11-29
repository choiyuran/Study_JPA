package org.example.Domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMainOneWaySolveProblem {
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();


        tx.begin();

        try {
            TeamForTwoWay team = new TeamForTwoWay();
            team.setUsername("TeamA");
            em.persist(team);

            MemberForOneWaySolveProblem member = new MemberForOneWaySolveProblem();
            member.setUsername("member1");
//            member.changeTeam(team);
            member.setTeam(team); //팀과 멤버의 연관관계 맵핑 , JPA가 알아서 연관관계를 알아먹고 pk의 값을 가져온다
            em.persist(member);

            team.getMembers().add(member);
            // 이걸 지우면 캐시에 그대로 남아있어서
            // select 실행을 안하고 List에 안담긴다
//            em.flush();         // 1차 캐시를 다 날려줌
//            em.clear();
            
            TeamForTwoWay findTeam = em.find(TeamForTwoWay.class, team.getId());
            List<MemberForOneWaySolveProblem> members = findTeam.getMembers();

            for(MemberForOneWaySolveProblem m : members) {
                System.out.println("m : " + m.getUsername());
            }

            TeamForTwoWay findTeam2 = em.find(TeamForTwoWay.class, team.getId());
            int memberSize = findTeam2.getMembers().size();

            //영속성 컨텍스트에 이미 있기 때문에 select구문이 실행되지 않는다.
            //만약 쿼리문을 보고 싶다면 em.flush, em.clear를 사용한다.
//            MemberForOneWaySolveProblem findMember = em.find(MemberForOneWaySolveProblem.class, member.getId());
//            TeamForOneWay team1 = findMember.getTeam();
//            System.out.println(team1.getUsername());
//
//            //만약 팀을 바꾸고싶다면?
//            TeamForOneWay teamForOneWay = em.find(TeamForOneWay.class, 100L);
//            findMember.setTeam(teamForOneWay);

            //객체를 테이블에 맞춰서 데이터 중심으로 모델링하면, 협력관게를 만들 수 없다.
            // 외래 키 조인을 사용해서 연관된 테이블을 찾는다.
            // 객체는 참조를 사용해서 연관된 객체를 찾는다.
            // 테이블과 객체 사이에는 이런 큰 차이점이 있다.
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
