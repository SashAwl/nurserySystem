import java.util.ArrayList;
import java.util.Date;

/**
 * iProvider - класс-интерфейс, реализуемый классом Provider
 */
public interface iProvider {
    public boolean addNewAnimalDB(String name, TypeAnimals TypeAnimals, ClassAnimals classAnimals, Date birthdate,
                           ArrayList<Command> commands);
    public boolean isExistsAnimalDB(String name, TypeAnimals typeAnimals, Date birthdate);
    public ClassAnimals getInfoClass(TypeAnimals typeAnimals) throws Exception;
    public ArrayList<Command> getCommands(String name, TypeAnimals typeAnimal, Date birthdate) throws Exception;
    public Boolean addNewCommandDB(String name, TypeAnimals typeAnimal, Date birthdate, Command newCommand) throws Exception;
}


