package common;

import java.io.Serializable;
import java.util.ArrayList;

public class ResultPattern implements Serializable {
    public ArrayList<String> getReports() {
        return reports;
    }

    public void setReports(ArrayList<String> reports) {
        this.reports = reports;
    }

    private ArrayList<String> reports = new ArrayList<>();

    public String getInstructionTitle() {
        return instructionTitle;
    }

    public void setInstructionTitle(String instructionTitle) {
        this.instructionTitle = instructionTitle;
    }

    private String instructionTitle;

    public boolean isTimeToExit() {
        return timeToExit;
    }

    public void setTimeToExit(boolean timeToExit) {
        this.timeToExit = timeToExit;
    }

    private boolean timeToExit = false;

    @Override
    public String toString() {
        return "ResultPattern{" +
                "reports=" + reports +
                ", instructionTitle='" + instructionTitle + '\'' +
                ", timeToExit=" + timeToExit +
                '}';
    }
}
