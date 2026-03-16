package command;

public interface Command {
    String getName(); //имя команды
    String getDescription(); //описание команды
    void execute(String args); //выполнить команду
}
