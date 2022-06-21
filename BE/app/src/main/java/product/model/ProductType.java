package product;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class ProductType {

  private @Id @GeneratedValue Long id;
  private String name;
  private Long parent;

  ProductType() {}

  ProductType(String name, Long parent) {

    this.name = name;
    this.parent = parent;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public Long getParent() {
    return this.parent;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setParent(Long parent) {
    this.parent = parent;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof ProductType))
      return false;
      ProductType c = (ProductType) o;
    return Objects.equals(this.id, c.id) && Objects.equals(this.name, c.name)
        && Objects.equals(this.parent, c.parent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.parent);
  }

  @Override
  public String toString() {
    return "ProductType{" + "id=" + this.id + ", name='" + this.name + '\'' + ", parent='" + this.parent.toString() + '\'' + '}';
  }
}