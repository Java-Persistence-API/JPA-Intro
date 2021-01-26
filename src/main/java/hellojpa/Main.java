package hellojpa;

import hellojpa.entity.Member;
import hellojpa.entity.MemberType;
import hellojpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
            Team teamA = new Team();
            teamA.setName("TeamA");
            em.persist(teamA);  // 1차 캐시에 저장됨

            Member member = new Member();
            member.setName("Hardy");
            member.setAge(30);
            member.setMemberType(MemberType.ADMIN);
            member.setRegDate(new Date());
            member.setCreateDateTime(LocalDateTime.now());
            member.setTeam(teamA);
            em.persist(member); // 1차 캐시에 저장됨

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());  // 1차 캐시에서 조회
            Team findTeam = findMember.getTeam();
            findTeam.getName();

            List<Member> members = findTeam.getMembers();
            for (Member m : members) {
                System.out.println("m = " + m);
            }

            tx.commit();

        } catch (Exception e) {
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();
    }

}
