package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

public class JpaMain {

  public static void main(String args[]) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      Order order = em.find(Order.class, 1L);

      Long memberId = order.getMemberId(); // 이렇게 오더가 memberId를 갖고 있는 경우에는

      em.find(Member.class, memberId); // 그 memberId를 가지고 member 한번 더 찾아내야함. (객체지향적이지 않음)

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}
