<<<<<<< HEAD
import jpabook.jpashop.domain.*;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member1 = new Member();
            member1.setName("hello1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " + refMember.getClass());      // 프록시
            // 여기서는 false
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));   // 프록시가 초기화가 되었는지 확인하는 코드
            refMember.getName();            // 강제 초기화

            // 여기서는 true
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));
            em.clear();
            Hibernate.initialize(refMember);        // 강제 초기화

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

    public static void logic(Member m1, Member m2) {
        System.out.println("m1 == m2 : " + (m1 instanceof Member));
        System.out.println("m1 == m2 : " + (m2 instanceof Member));
    }
}
=======
import jpabook.jpashop.domain.*;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member1 = new Member();
            member1.setName("hello1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " + refMember.getClass());      // 프록시
            // 여기서는 false
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));   // 프록시가 초기화가 되었는지 확인하는 코드
            refMember.getName();            // 강제 초기화

            // 여기서는 true
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));
            em.clear();
            Hibernate.initialize(refMember);        // 강제 초기화

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

    public static void logic(Member m1, Member m2) {
        System.out.println("m1 == m2 : " + (m1 instanceof Member));
        System.out.println("m1 == m2 : " + (m2 instanceof Member));
    }
}
>>>>>>> 7ef2dc0fd420941bf2eef0bbc256547f91d7a77f
