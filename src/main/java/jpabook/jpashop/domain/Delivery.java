package jpabook.jpashop.domain;

import static jakarta.persistence.FetchType.*;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Delivery extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "DELIVERY_ID")
  private Long id;

  @OneToOne(mappedBy = "delivery", fetch = LAZY)
  private Order order;

  @Embedded
  private Address address;

  private DeliveryStatus status;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public DeliveryStatus getStatus() {
    return status;
  }

  public void setStatus(DeliveryStatus status) {
    this.status = status;
  }
}
