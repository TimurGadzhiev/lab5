package command.commands;

import command.Command;
import command.CommandExecutor;

/**
 * Команда для завершения программы.
 * Останавливает главный цикл выполнения CommandExecutor.
 */
public class ExitCommand implements Command {

    /** Исполнитель команд для остановки */
    private CommandExecutor executor;

    /**
     * Конструктор команды exit.
     *
     * @param executor исполнитель команд, который будет остановлен
     */
    public ExitCommand(CommandExecutor executor) {
        this.executor = executor;
    }


    /**
     * @return "exit"
     */
    @Override
    public String getName() {
        return "exit";
    }

    /**
     * @return "завершить программу"
     */
    @Override
    public String getDescription() {
        return "завершить программу";
    }

    /**
     * Выполняет команду exit.
     * Выводит сообщение о завершении и останавливает CommandExecutor.
     *
     * @param args аргументы команды (не используются)
     */
    @Override
    public void execute(String args) {
        System.out.println("Завершение программы...");
        executor.stop();
    }
}
