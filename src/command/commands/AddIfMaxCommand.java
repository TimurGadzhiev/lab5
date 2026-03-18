package command.commands;

import collection.CollectionManager;
import command.Command;
import model.Vehicle;
import model.VehicleFiller;

/**
 * Команда для добавления элемента, если его мощность больше максимальной.
 * Сначала находит элемент с максимальной мощностью в коллекции,
 * затем добавляет новый элемент только если его мощность превышает найденную.
 */
public class AddIfMaxCommand implements Command {

    /** Менеджер коллекции для поиска максимума и добавления */
    private CollectionManager manager;

    /** Заполнитель для ввода данных */
    private VehicleFiller filler;

    /**
     * Конструктор команды add_if_max.
     *
     * @param manager менеджер коллекции для операций с коллекцией
     * @param filler заполнитель для ввода данных нового элемента
     */
    public AddIfMaxCommand(CollectionManager manager, VehicleFiller filler) {
        this.manager = manager;
        this.filler = filler;
    }

    /**
     * @return "add_if_max"
     */
    @Override
    public String getName() {
        return "add_if_max";
    }

    /**
     * @return "добавить элемент, если его мощность больше максимальной"
     */
    @Override
    public String getDescription() {
        return "добавить элемент, если его мощность больше максимальной";
    }

    /**
     * Выполняет команду add_if_max.
     * Если коллекция пуста, элемент добавляется автоматически.
     * Иначе находит максимальный элемент, запрашивает новый элемент,
     * сравнивает их мощности и добавляет новый только если он больше.
     *
     * @param args аргументы команды (не используются)
     */
    @Override
    public void execute(String args) {
        Vehicle maxVehicle = manager.getMax();
        if (maxVehicle == null) {
            System.out.println("Коллекция пуста. Элемент будет добавлен.");
            Vehicle newVehicle = new Vehicle();
            filler.fill(newVehicle);
            manager.add(newVehicle);
            System.out.println("Элемент успешно добавлен");
            return;
        }

        Vehicle newVehicle = new Vehicle();
        filler.fill(newVehicle);

        if (newVehicle.getEnginePower() > maxVehicle.getEnginePower()) {
            manager.add(newVehicle);
            System.out.println("Элемент добавлен");
        } else {
            System.out.println("Элемент не быд добавлен. Его мощность (" + newVehicle.getEnginePower() + ") не превышает максимальную (" + maxVehicle.getEnginePower() + ")");
        }
    }
}
