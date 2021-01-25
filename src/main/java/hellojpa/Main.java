package hellojpa;

import hellojpa.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / http://minkuk-jo.com
 * @since 2021. 01. 26.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, JPA");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("hello");
            em.persist(member);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();
    }

}
