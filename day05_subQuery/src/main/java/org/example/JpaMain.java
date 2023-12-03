package org.example;


import javax.persistence.*;
import java.util.List;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member");
            member.setAge(10);

            member.setTeam(team);
            em.persist(team);

            em.flush();
            em.clear();

            // 서브쿼리 이거 안됨
            String query = "select mm from (select m.age from Member m) as mm";
//            String query = "select (select avg(m1.age) From Member m1) as AvgAge from Member m join Team t on m.username=t.name";
//            String query = "select m from Member m , Team t where m.username = t.name";
            
            List<Member> result = em.createQuery(query, Member.class).getResultList();

            tx.commit();
        } catch (Exception e) {
            System.err.println("버그 발견!!!" + e.getMessage());
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

}