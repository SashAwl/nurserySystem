/**
 * Hamster - класс, наследуемый от Pet
 */

public class Hamster extends Pet{
    String keeping;
    Boolean washing;

    public String getKeeping() {
        return keeping;
    }

    public void setKeeping(String keeping) {
        this.keeping = keeping;
    }

    public Boolean getWashing() {
        return washing;
    }

    public void setWashing(Boolean washing) {
        this.washing = washing;
    }
}
