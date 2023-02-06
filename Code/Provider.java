import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Provider - класс, содержащий методы для работы с базой данных; имплиментирует интерфейс iProvider с целью исключения
 * * зависимости более абстрактного класса Logic от менее абстрактного класса Provider
 * addNewAnimalDB(...) - записывает новые данные в БД и возвращает булево значение
 * isExistsAnimalDB(String name, TypeAnimals typeAnimals, Date birthdate) - проверяет, есть ли в БД животное с такими данными
 * getInfoClass(TypeAnimals typeAnimals) - запрашивает данные с сервера по распределению видов животных по классам и
 * * возвращает класс для текущего вида
 * getCommands(String name, TypeAnimals typeAnimal, Date birthdate) - возвращает список команд запрашиваемого животного
 * addNewCommandDB(String name, TypeAnimals typeAnimal, Date birthdate, Command newCommand) - дописывает в БД новую команду
 * * заданному животному
 */

public class Provider implements iProvider {
    @Override
    public boolean addNewAnimalDB(String name, TypeAnimals typeAnimals, ClassAnimals classAnimals,
                                  Date birthdate, ArrayList<Command> commands) {
        System.out.println("Successfully!");
        return true;
    }

    public boolean isExistsAnimalDB(String name, TypeAnimals typeAnimals, Date birthdate) {
        System.out.println("Searching in database..");
        return false;
    }

    public ClassAnimals getInfoClass(TypeAnimals typeAnimals) throws Exception {
        System.out.println("Class definition in progress..");

        List<String> petsList = new ArrayList<>(Arrays.asList("Dog", "Cat", "Hamster"));
        List<String> packList = new ArrayList<>(Arrays.asList("Hors", "Camel", "Donkey"));

        if (petsList.contains(typeAnimals)) {
            return ClassAnimals.pets;
        } else if (packList.contains(typeAnimals)) {
            return ClassAnimals.packAnimals;
        } else throw new Exception("Unknown class");
    }

    public ArrayList<Command> getCommands(String name, TypeAnimals typeAnimal, Date birthdate) throws Exception {
        if (typeAnimal.toString() == ("Dog")) {
            return new Dog().getCommands();
        }
        else if (typeAnimal.toString() == ("Cat")) {
            return new Cat().getCommands();
        }
        else if (typeAnimal.toString() == ("Hamster")) {
            return new Hamster().getCommands();
        }
        else if (typeAnimal.toString() == ("Hors")) {
            return new Hors().getCommands();
        }
        else if (typeAnimal.toString() == ("Camel")) {
            return new Camel().getCommands();
        }
        else if (typeAnimal.toString() == ("Donkey")) {
            return new Donkey().getCommands();
        }
        else throw new Exception("Unknown animal");
    }

    public Boolean addNewCommandDB(String name, TypeAnimals typeAnimal, Date birthdate, Command newCommand) throws Exception {
        Provider providerItem = new Provider();
        ArrayList<Command> listCommand = providerItem.getCommands(name, typeAnimal, birthdate);
        listCommand.add(newCommand);

        if (typeAnimal.toString() == ("Dog")) {
            new Dog().setCommands(listCommand);
            return true;
        }
        else if (typeAnimal.toString() == ("Cat")) {
            new Cat().setCommands(listCommand);
            return true;
        }
        else if (typeAnimal.toString() == ("Hamster")) {
            new Hamster().setCommands(listCommand);
            return true;
        }
        else if (typeAnimal.toString() == ("Hors")) {
            new Hors().setCommands(listCommand);
            return true;
        }
        else if (typeAnimal.toString() == ("Camel")) {
            new Camel().setCommands(listCommand);
            return true;
        }
        else if (typeAnimal.toString() == ("Donkey")) {
            new Donkey().setCommands(listCommand);
            return true;
        }
        else throw new Exception("Unknown animal");

    }
}