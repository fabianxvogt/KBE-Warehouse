package warehouse;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Price {

    private @Id @GeneratedValue Long id;
    private String parent;
    private double value;

    Price() {}

    Price(String parent, double value) {
        this.role = parent;
        this.value = value;
    }

    public Long getId() {
        return this.id;
    }

    public String getParent() {
        return this.parent;
    }

    public double getValue() {
        return this.value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setParent(String role) {
        this.role = role;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Price))
            return false;
        Price p = (Price) o;
        return Objects.equals(this.id, p.id) && Objects.equals(this.value, p.value)
                && Objects.equals(this.parent, p.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.parent, this.value);
    }

    @Override
    public String toString() {
        return "Price{" + "id=" + this.id + ", value='" + this.value + '\'' + ", parent='" + this.parent + '\'' + '}';
    }
}