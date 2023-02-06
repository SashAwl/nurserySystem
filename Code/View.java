import java.util.ArrayList;
import java.util.Date;

/**
 * View -  класс, содержащий методы, инициализирующие основные действия в приложении пользователем
 * addNewAnimal(...) - инициализирует процесс записи в БД информации о новом животном
 * defineClassAnimal(TypeAnimals typeAnimals) - инициализирует процесс определения класса для заданного животных
 * getCommandsAnimal(String name, TypeAnimals typeAnimal, Date birthdate) - инициализирует запрос списка команд животного
 * teachAnimal(String name, TypeAnimals typeAnimal, Date birthdate, Command newCommand) - инициализирует процесс обновления
 * * БД с занесением в нее новой команды животного
 */

public class View {
    public void addNewAnimal(String name, TypeAnimals typeAnimals, Date birthdate,
                             ArrayList<Command> commands) throws Exception {
        Logic logicItem = new Logic();
        logicItem.addNoteNewAnimal(name, typeAnimals, birthdate, commands);
    }

    public ClassAnimals defineClassAnimal(TypeAnimals typeAnimals) throws Exception {
        Logic logicItem = new Logic();
        return logicItem.defineClass(typeAnimals);
    }

    public ArrayList<Command> getCommandsAnimal(String name, TypeAnimals typeAnimals, Date birthdate) throws Exception {
        Logic logicItem = new Logic();
        return logicItem.getListCommands(name, typeAnimals, birthdate);
    }

    public Boolean teachAnimal(String name, TypeAnimals typeAnimal, Date birthdate, Command newCommand) throws Exception {
        Logic logicItem = new Logic();
        return logicItem.teachAnimalNewCommand(name, typeAnimal, birthdate, newCommand);
    }
}
