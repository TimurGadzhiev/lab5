package command.commands;

import collection.CollectionManager;
import command.Command;
import model.Vehicle;
import model.VehicleFiller;


/**
 * Команда для обновления существующего элемента по его ID.
 * Запрашивает ID элемента, проверяет его существование,
 * затем запрашивает новые данные для элемента и обновляет его.
 */
public class UpdateIdCommand implements Command {

    /** Менеджер коллекции для обновления элемента */
    private CollectionManager manager;

    /** Заполнитель для ввода новых данных */
    private VehicleFiller filler;

    /**
     * Конструктор команды update.
     *
     * @param manager менеджер коллекции, содержащий элемент для обновления
     * @param filler заполнитель для ввода новых данных
     */
    public UpdateIdCommand(CollectionManager manager, VehicleFiller filler) {
        this.manager = manager;
        this.filler = filler;
    }

    /**
     * @return "update"
     */
    @Override
    public String getName() {
        return "update";
    }

    /**
     * @return "обновить значение элемента по ID"
     */
    @Override
    public String getDescription() {
        return "обновить значение элемента по ID";
    }

    /**
     * Выполняет команду update.
     * Проверяет наличие аргумента, парсит ID, проверяет существование элемента,
     * показывает текущие данные, запрашивает новые и обновляет элемент.
     *
     * @param args строка, содержащая ID обновляемого элемента
     */
    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            System.out.println("Необходимо указать ID элемента, который вы хотите поменять");
            return;
        }
        try {
            Long id = Long.parseLong(args.trim());
            if (!manager.containsId(id)) {
                System.out.println("Элемент с ID " + id + " не найден");
                return;
            }
            Vehicle newVehicle = new Vehicle();
            System.out.println("Введите новые данные для элемента:");
            filler.fill(newVehicle);

            if (manager.update(id, newVehicle)) {
                System.out.println("Элемент с ID " + id + " обновлен");
            }
        } catch (Exception e) {
            System.out.println("Ошибка!(Скорее всего вы ввели ID в неправильном формате)");
        }
    }
}
