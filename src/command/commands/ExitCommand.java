package command.commands;

import command.Command;
import command.CommandExecutor;

public class ExitCommand implements Command {
    private CommandExecutor executor;

    public ExitCommand(CommandExecutor executor) {
        this.executor = executor;
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "завершить программу";
    }

    @Override
    public void execute(String args) {
        System.out.println("Завершение программы...");
        executor.stop();
    }
}
