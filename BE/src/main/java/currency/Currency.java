package warehouse;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Currency {

    private @Id @GeneratedValue Long id;
    private String name;
    private String parent;
    private double valueToEuro;

    Currency() {}

    Employee(String name, String parent, double valueToEuro) {

        this.name = name;
        this.role = parent;
        this.valueToEuro = valueToEuro;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getParent() {
        return this.parent;
    }

    public double getValueToEuro() {
        return valueToEuro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(String role) {
        this.role = role;
    }

    public void setValueToEuro(double valueToEuro) {
        this.valueToEuro = valueToEuro;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Currency))
            return false;
        Currency c = (ProductType) o;
        return Objects.equals(this.id, c.id) && Objects.equals(this.name, c.name)
                && Objects.equals(this.valueToEuro, c.valueToEuro)
                && Objects.equals(this.parent, c.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.parent, this.valueToEuro);
    }

    @Override
    public String toString() {
        return "Currency{" + "id=" + this.id + ", name='" + this.name + ", value to € ='" + this.valueToEuro + '\'' + ", parent='" + this.parent + '\'' + '}';
    }
}