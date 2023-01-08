package server.commands;

import common.AvailableCommands;
import server.ServerStatusRegister;
import common.ResultPattern;

public class Clear extends Command {
    public Clear(AvailableCommands command) {
        super(command);
    }

    @Override
    public ResultPattern execute() {
        report = new ResultPattern();
        ServerStatusRegister.dragons.clear();
        ServerStatusRegister.idList.clear();
        report.getReports().add("Все элементы были успешно удалены!");
        return report;
    }
}
