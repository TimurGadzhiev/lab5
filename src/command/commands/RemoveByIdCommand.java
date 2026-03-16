package command.commands;

import collection.CollectionManager;
import command.Command;

public class RemoveByIdCommand implements Command {
    private CollectionManager manager;

    public RemoveByIdCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescription() {
        return "удалить элемент по id";
    }

    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            System.out.println("Необходимо указать ID элемента, который вы хотите поменять");
            return;
        }
        try {
            Long id = Long.parseLong(args.trim());
            if (manager.removeById(id)) {
                System.out.println("Элемент с ID " + id + " успешно удален");
            } else {
                System.out.println("Элемент с ID " + id + " не найден");
            }
        }catch (Exception e) {
            System.out.println("Ошибка!(Скорее всего вы ввели ID в неправильном формате)");
        }
    }
}
