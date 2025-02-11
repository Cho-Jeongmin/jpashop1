package jpabook.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {

  // 값 타입을 통해 유효성도 공통적으로 지정할 수 있음
  @Column(length = 10)
  private String city;
  @Column(length = 20)
  private String street;
  @Column(length = 5)
  private String zipcode;

  // 값 타입에는 이런 의미있는 비즈니스 메소드를 만들 수 있음
  public String fullAddress() {
    return getCity() + " " + getStreet() + " " + getZipcode();
  }

  public boolean isValid() {
    // 유효한 주소인지 판단하는 메소드
    return true;
  }

  public String getCity() {
    return city;
  }

  public String getStreet() {
    return street;
  }

  public String getZipcode() {
    return zipcode;
  }

  private void setCity(String city) {
    this.city = city;
  }

  private void setStreet(String street) {
    this.street = street;
  }

  private void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(getCity(), address.getCity()) && Objects.equals(
        getStreet(), address.getStreet()) && Objects.equals(getZipcode(),
        address.getZipcode());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCity(), getStreet(), getZipcode());
  }

  // equals와 hashCode는 getter로 생성해야 프록시일 때에도 계산이 가능함
}
