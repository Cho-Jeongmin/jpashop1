package jpabook.jpashop.domain;

import static jakarta.persistence.FetchType.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "CATEGORY_ID")
  private Long id;

  private String name;

  @ManyToMany
  @JoinTable(name = "CATEGORY_ITEM",
      joinColumns = @JoinColumn(name = "CATEGORY_ID"),
      inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
  )
  private List<Item> items = new ArrayList<>();

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "PARENT_ID")
  private Category parent;

  @OneToMany(mappedBy = "parent")
  private List<Category> children = new ArrayList<>();
}
