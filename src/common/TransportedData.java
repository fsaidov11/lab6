package common;

import common.baseObjects.Dragon;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

public class TransportedData implements Serializable {
    public ArrayList<Dragon> dragons = new ArrayList<>();

    public HashSet<Integer> idList = new HashSet<>();

    public Date date;

    public File currentFile;

    public byte[] jsonData;

    public byte[] getJsonData() {
        return jsonData;
    }

    public void setJsonData(byte[] jsonData) {
        this.jsonData = jsonData;
    }

    @Override
    public String toString() {
        return "TransportedData{" +
                "dragons=" + dragons +
                ", idList=" + idList +
                ", date=" + date +
                ", currentFile=" + currentFile +
                ", jsonData=" + Arrays.toString(jsonData) +
                '}';
    }

    public File getCurrentFile() {
        return currentFile;
    }

    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public HashSet<Integer> getIdList() {
        return idList;
    }

    public void setIdList(HashSet<Integer> idList) {
        this.idList = idList;
    }

    public ArrayList<Dragon> getDragons() {
        return dragons;
    }

    public void setDragons(ArrayList<Dragon> dragons) {
        this.dragons = dragons;
    }
}
