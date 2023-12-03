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
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            em.flush();
            em.clear();

            List<MemberDTO> result = em.createQuery("select new org.example.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
                    .getResultList();
            MemberDTO memberDTO = new MemberDTO();
            System.out.println("memberDTO username : " + result.get(0));

//            List<Address> result = em.createQuery("select o.address from Order o", Address.class)
//                    .getResultList();

            // 두개가 같음(조인을 명시적으로 해주는게 좋다)
//            List<Team> result = em.createQuery("select m.team from Member m join m.team", Team.class).getResultList();
//            List<Team> result = em.createQuery("select m.team from Member m", Team.class).getResultList();


//            List<Member> result = em.createQuery("select m from Member m", Member.class).getResultList();
//            Member findMember = result.get(0);
//            findMember.setAge(20);


//            TypedQuery<Member> query =  em.createQuery("select m from Member m where m.username = :username", Member.class);
//            query.setParameter("username", "member1");
//            Member singleResult = query.getSingleResult();
//            System.out.println("singleResult : " + singleResult.getUsername());


//            Member result = query.getSingleResult();
            // Spring Data JPA ->
//            System.out.println("result : " + result);

//            TypedQuery<Member> query1 =  em.createQuery("select m from Member m", Member.class);
//            TypedQuery<String> query2 =  em.createQuery("select m.username from Member m", String.class);
//            Query query3 =  em.createQuery("select m.username from Member m");


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