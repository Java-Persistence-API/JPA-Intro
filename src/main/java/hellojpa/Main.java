package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.MemberType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.Date;

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
//            member.setId(1L);
            member.setName("Hardy");
            member.setAge(30);
            member.setMemberType(MemberType.ADMIN);
            member.setRegDate(new Date());
            member.setCreateDateTime(LocalDateTime.now());

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
