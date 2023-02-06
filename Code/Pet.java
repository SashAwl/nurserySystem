/**
 * Pet - класс, наследуемый от Animal
 */

public class Pet extends Animal{
    Boolean levelStressReduction;

    public Boolean getLevelStressReduction() {
        return this.levelStressReduction;
    }

    public void setLevelStressReduction(Boolean levelStressReduction) {
        this.levelStressReduction = levelStressReduction;
    }
}
