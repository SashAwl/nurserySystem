/**
 * PackAnimal - класс, наследуемый от Animal
 */

public class PackAnimal extends Animal{
    Boolean cart;
    Integer loadCapacity;
    Boolean riding;

    public Boolean getCart() {
        return this.cart;
    }

    public void setCart(Boolean cart) {
        this.cart = cart;
    }

    public Integer getLoadCapacity() {
        return this.loadCapacity;
    }

    public void setLoadCapacity(Integer loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Boolean getRiding() {
        return this.riding;
    }

    public void setRiding(Boolean riding) {
        this.riding = riding;
    }
}
