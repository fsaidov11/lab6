package client;

import common.TransportedData;

public class ClientDataInstaller {
    private final TransportedData receiveData;

    public ClientDataInstaller(TransportedData receiveData) {
        this.receiveData = receiveData;
    }

    public void InstallFromTransported() {
        ClientStatusRegister.dragons = receiveData.getDragons();
        ClientStatusRegister.currentFile = receiveData.getCurrentFile();
        ClientStatusRegister.idList = receiveData.getIdList();
        ClientStatusRegister.date = receiveData.getDate();
    }

    public static TransportedData installInfoTransported() {
        TransportedData data = new TransportedData();
        data.setDragons(ClientStatusRegister.dragons);
        data.setJsonData(ClientStatusRegister.jsonData);
        data.setCurrentFile(ClientStatusRegister.currentFile);
        data.setIdList(ClientStatusRegister.idList);
        data.setDate(ClientStatusRegister.date);
        return data;
    }
}
