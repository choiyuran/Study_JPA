package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member1 = new Member();
            member1.setUsername("A");


            Member member2 = new Member();
            member2.setUsername("B");


            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("==============");

            em.persist(member1);     // 1, 51
            em.persist(member2);     // memory
            em.persist(member3);     // memory

            System.out.println("member1 = " + member1.getId());
            System.out.println("member1 = " + member2.getId());
            System.out.println("member1 = " + member3.getId());

            System.out.println("==============");

            tx.commit(); // 커밋을 하는 시점에서 쿼리가 날아가게 되어있음
        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
