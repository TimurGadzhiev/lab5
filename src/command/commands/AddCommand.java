package command.commands;

import collection.CollectionManager;
import command.Command;
import model.VehicleFiller;
import model.Vehicle;

/**
 * Команда для добавления нового элемента в коллекцию.
 * Запрашивает у пользователя данные для нового транспортного средства
 * через VehicleFiller и добавляет его в коллекцию.
 */
public class AddCommand implements Command {

    /** Заполнитель для ввода данных транспортного средства */
    private VehicleFiller filler;

    /** Менеджер коллекции для добавления элемента */
    private CollectionManager manager;

    /**
     * Конструктор команды add.
     *
     * @param manager менеджер коллекции, в который будет добавлен элемент
     * @param filler заполнитель для ввода данных пользователем
     */
    public AddCommand(CollectionManager manager, VehicleFiller filler) {
        this.manager = manager;
        this.filler = filler;
    }


    /**
     * @return "add"
     */
    @Override
    public String getName() {
        return "add";
    }

    /**
     * @return "добавить новый элемент"
     */
    @Override
    public String getDescription() {
        return "добавить новый элемент";
    }

    /**
     * Выполняет команду add.
     * Создает новый объект Vehicle, заполняет его через VehicleFiller,
     * добавляет в коллекцию через CollectionManager и выводит присвоенный ID.
     *
     * @param args аргументы команды (не используются)
     */
    @Override
    public void execute(String args) {
        Vehicle vehicle = new Vehicle();
        filler.fill(vehicle);
        try {
            manager.add(vehicle);
            System.out.println("Элемент успешно добавлен с ID: " + vehicle.getId());
        } catch (Exception e) {
            System.err.println("Ошибка при добавлении");
        }
    }
}
