<<<<<<< HEAD
import jpabook.jpashop.domain.*;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setTeam(team);
            member1.setName("member1");
            em.persist(member1);

            Member member2 = new Member();
            member2.setTeam(teamB);
            member2.setName("member2");
            em.persist(member2);

            em.flush();
            em.clear();
//            List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
            // SQL : select * from Member;
            // SQL : select * from Team where TEAM_ID = xxx
            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();    // member테이블과 team테이블을 같이 조회(join)


//            Member m = em.find(Member.class, member1.getId());
//            System.out.println("a = " + m.getTeam().getClass());
//
//            System.out.println("================================");
//            m.getTeam().getName();          // 초기화
//            System.out.println("================================");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
=======
import jpabook.jpashop.domain.*;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setTeam(team);
            member1.setName("member1");
            em.persist(member1);

            Member member2 = new Member();
            member2.setTeam(teamB);
            member2.setName("member2");
            em.persist(member2);

            em.flush();
            em.clear();
//            List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
            // SQL : select * from Member;
            // SQL : select * from Team where TEAM_ID = xxx
            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();    // member테이블과 team테이블을 같이 조회(join)


//            Member m = em.find(Member.class, member1.getId());
//            System.out.println("a = " + m.getTeam().getClass());
//
//            System.out.println("================================");
//            m.getTeam().getName();          // 초기화
//            System.out.println("================================");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
>>>>>>> 7ef2dc0fd420941bf2eef0bbc256547f91d7a77f
