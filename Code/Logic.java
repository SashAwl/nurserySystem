import java.util.ArrayList;
import java.util.Date;

/**
 * Logic -  класс, содержащий методы, реализующие основную логику приложения
 * addNoteNewAnimal(...) - вызывает метод записи в БД информации о новом животном, предварительно проверяя,
 * * не существует ли уже такая запись в БД и определяя класс для нового животного
 * isExists(String name, TypeAnimals typeAnimals, Date birthdate) - вызывает метод проверки существования вводимых данных в  БД
 * defineClass(TypeAnimals typeAnimals) - вызывает метод, распределящий животных по классам
 * getListCommands(String name, TypeAnimals typeAnimal, Date birthdate) - вызывает метод, возвращающий список команд животного
 * teachAnimalNewCommand(String name, TypeAnimals typeAnimal, Date birthdate, Command newCommand) - вызывает метод обновления
 * * БД с занесением в нее новой команды
 */
public class Logic {
        public boolean addNoteNewAnimal(String name, TypeAnimals typeAnimals, Date birthdate,
                                        ArrayList<Command> commands) throws Exception {
            Logic logicItem = new Logic();
            logicItem.isExists(name, typeAnimals, birthdate);
            ClassAnimals classItem = logicItem.defineClass(typeAnimals);

            iProvider iprovider = new Provider();
            return iprovider.addNewAnimalDB(name, typeAnimals, classItem, birthdate, commands);
        }

        public boolean isExists(String name,TypeAnimals typeAnimals, Date birthdate) throws Exception {
            iProvider iprovider = new Provider();
            Boolean existing = iprovider.isExistsAnimalDB(name, typeAnimals, birthdate);

            if (existing) {
                throw new Exception("This animal already exists");
            }
            return false;
        }

        public ClassAnimals defineClass(TypeAnimals typeAnimals) throws Exception {
            iProvider iprovider = new Provider();
            return iprovider.getInfoClass(typeAnimals);
        }

        public ArrayList<Command> getListCommands(String name, TypeAnimals typeAnimal, Date birthdate) throws Exception{
            iProvider iprovider = new Provider();
            return iprovider.getCommands(name, typeAnimal, birthdate);
        }

        public Boolean teachAnimalNewCommand(String name, TypeAnimals typeAnimal, Date birthdate, Command newCommand) throws Exception {
            iProvider iprovider = new Provider();
            return iprovider.addNewCommandDB(name, typeAnimal, birthdate, newCommand);
        }
    }

