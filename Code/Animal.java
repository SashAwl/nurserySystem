import java.util.ArrayList;
import java.util.Date;

/**
 * Animal - абстрактный класс
 */
public abstract class Animal {
    private String name;
    private TypeAnimals typeAnimals;
    private ClassAnimals classAnimals;
    private Date birthdate;

    private ArrayList<Command> commands;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeAnimals getTypeAnimals() {
        return typeAnimals;
    }

    public void setTypeAnimals(TypeAnimals typeAnimals) {
        this.typeAnimals = typeAnimals;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public ClassAnimals getClassAnimals() {
        return classAnimals;
    }

    public void setClassAnimals(ClassAnimals classAnimals) {
        this.classAnimals = classAnimals;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<Command> commands) {
        this.commands = commands;
    }
}
