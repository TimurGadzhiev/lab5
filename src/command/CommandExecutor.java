package command;

import collection.CollectionManager;
import file.FileManager;
import command.commands.*;
import model.VehicleFiller;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для выполнения команд, введенных пользователем.
 * Хранит список всех доступных команд, ищет команду по имени и выполняет её.
 * Работает в цикле: получает строку от пользователя, разбирает её на
 * имя команды и аргументы, находит соответствующую команду в списке и выполняет.
 */
public class CommandExecutor {
    /** Список всех доступных команд */
    private List<Command> commands;

    /** Менеджер коллекции для работы с данными */
    private CollectionManager manager;

    /** Заполнитель для ввода данных */
    private VehicleFiller filler;

    /** Менеджер для работы с файлами */
    private FileManager fileManager;

    /** Флаг работы программы (true - работает, false - завершается) */
    private boolean isRunning;

    /**
     * Конструктор, создающий исполнитель команд.
     * Инициализирует список команд и создает все доступные команды.
     *
     * @param manager менеджер коллекции
     * @param filler заполнитель для ввода данных
     * @param fileManager менеджер для работы с файлами
     */
    public CommandExecutor(CollectionManager manager, VehicleFiller filler, FileManager fileManager) {
        this.manager = manager;
        this.filler = filler;
        this.fileManager = fileManager;
        this.commands = new ArrayList<>();
        this.isRunning = true;
        initCommands();
    }

    /**
     * Инициализирует список всех доступных команд.
     * Создает объекты всех команд и добавляет их в список.
     */
    private void initCommands() {
        commands.add(new HelpCommand());
        commands.add(new InfoCommand(manager));
        commands.add(new ShowCommand(manager));
        commands.add(new AddCommand(manager, filler));
        commands.add(new UpdateIdCommand(manager, filler));
        commands.add(new RemoveByIdCommand(manager));
        commands.add(new ClearCommand(manager));
        commands.add(new SaveCommand(manager, fileManager));
        commands.add(new ExecuteScriptCommand(this));
        commands.add(new ExitCommand(this));
        commands.add(new AddIfMaxCommand(manager, filler));
        commands.add(new ShuffleCommand(manager));
        commands.add(new ReorderCommand(manager));
        commands.add(new RemoveAllByTypeCommand(manager));
        commands.add(new RemoveAnyByTypeCommand(manager));
        commands.add(new FilterLessThanTypeCommand(manager));
    }

    /**
     * Выполняет команду по строке ввода.
     * Разбирает строку на имя команды и аргументы, находит команду в списке и выполняет.
     *
     * @param input строка ввода от пользователя
     */
    public void executeCommand(String input) {
        if (input == null || input.isEmpty()) {
            return;
        }
        String[] parts = input.trim().split(" ");
        String commandName = parts[0];
        String argument = "";
        if (parts.length > 1) {
            argument = parts[1];
        }

        for (Command cmd : commands) {
            if (cmd.getName().equals(commandName)) {
                try {
                    cmd.execute(argument);
                } catch (Exception e) {
                    System.err.println("Ошибка при выполнении команды");
                }
                return;
            }
        }
        System.out.println("Неизвестная команда!");

    }

    /**
     * Возвращает список всех зарегистрированных команд.
     *
     * @return список команд
     */
    public List<Command> getCommands() {
        return commands;
    }

    /**
     * Проверяет, работает ли программа.
     *
     * @return true, если программа работает, false если завершается
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Останавливает программу.
     * Устанавливает флаг isRunning в false, что приводит к завершению главного цикла.
     */
    public void stop() {
        this.isRunning = false;
    }

}
