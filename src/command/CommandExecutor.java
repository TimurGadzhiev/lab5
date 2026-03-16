package command;

import collection.CollectionManager;
import file.FileManager;
import command.commands.*;
import model.VehicleFiller;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    private List<Command> commands;
    private CollectionManager manager;
    private VehicleFiller filler;
    private FileManager fileManager;
    private boolean isRunning;

    public CommandExecutor(CollectionManager manager, VehicleFiller filler, FileManager fileManager) {
        this.manager = manager;
        this.filler = filler;
        this.fileManager = fileManager;
        this.commands = new ArrayList<>();
        this.isRunning = true;
        initCommands();
    }

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
    public List<Command> getCommands() {
        return commands;
    }
    public boolean isRunning() {
        return isRunning;
    }
    public void stop() {
        this.isRunning = false;
    }

}
