package server.commands;

import common.AvailableCommands;
import common.InstructionPattern;
import common.ResultPattern;
import server.interfaces.Executable;

import java.io.Serializable;
import java.util.Objects;

public abstract class Command implements Executable, Serializable {
    public String title;
    public String description;
    public AvailableCommands command;
    protected ResultPattern report;
    protected InstructionPattern dataBase;

    public ResultPattern getReport() {
        return report;
    }

    public void setReport(ResultPattern report) {
        this.report = report;
    }

    public InstructionPattern getDataBase() {
        return dataBase;
    }

    public void setDataBase(InstructionPattern dataBase) {
        this.dataBase = dataBase;
    }

    public Command(AvailableCommands command) {
        this.command = command;
        this.title = command.getTitle();
        this.description = command.getDescription();
        this.report = new ResultPattern();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command1 = (Command) o;
        return Objects.equals(title, command1.title) && Objects.equals(description, command1.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, command);
    }

    public String getDescription() {
        return description;
    }
}
