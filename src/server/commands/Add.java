package server.commands;


import common.AvailableCommands;
import common.baseObjects.Dragon;
import server.ServerStatusRegister;
import common.ResultPattern;
import common.exceptions.InvalidDataFromFileException;

public class Add extends Command {

    public Add(AvailableCommands command) {
        super(command);
    }

    protected Dragon dragonToAdd;

    protected void loadElement() throws InvalidDataFromFileException {
        if (ServerStatusRegister.readingTheScript) {
            ScriptDataLoader loader = new ScriptDataLoader();
            dragonToAdd = loader.loadDragonFromData();
        } else dragonToAdd = dataBase.getDragon();
    }

    protected void addElement() {
        ServerStatusRegister.dragons.add(dragonToAdd);
        report.getReports().add("Объект добавлен успешно!");
    }

    @Override
    public ResultPattern execute() throws InvalidDataFromFileException {
        report = new ResultPattern();
        loadElement();
        addElement();
        return report;
    }
}
