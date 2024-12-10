package jpabook.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;


@Entity
@Table(name = "ORDERS")
public class Order {

  @Id
  @GeneratedValue
  @Column(name = "ORDER_ID")
  private Long id;

  @Column(name = "MEMBER_ID")
  private Long memberId; // 사실 memberId가 아니라

  // private Member member; // 이렇게 member 자체를 가지고 있어야 객체지향적인 설계임

  private LocalDateTime orderDate;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getMemberId() {
    return memberId;
  }

  public void setMemberId(Long memberId) {
    this.memberId = memberId;
  }

  public LocalDateTime getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(LocalDateTime orderDate) {
    this.orderDate = orderDate;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }
}
