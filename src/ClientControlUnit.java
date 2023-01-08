 import client.*;
import common.CompleteMessage;
import common.InstructionPattern;
import common.TransportedData;
import common.exceptions.InvalidDataFromFileException;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientControlUnit {
    static DatagramSocket ds;
    static DatagramPacket dp;
    static InetAddress host;
    static int port;
    static CompleteMessage receivedMessage;
    static CompleteMessage sendingMessage;

    public static void main(String[] args) throws IOException,  ClassNotFoundException {
        while (true) {
            sendData();
            getData();
            if (receivedMessage.getResultPattern().isTimeToExit()) {
                System.exit(0);
            }
        }
    }

    public static void sendData() throws IOException {
        Scanner commandScanner = new Scanner(System.in);
        String currentCommand = commandScanner.nextLine();
        ClientCommandManager commandManager = new ClientCommandManager(currentCommand);

        try {
            InstructionPattern instructionPattern = commandManager.execution(commandManager.instructionFetch());
            TransportedData transportedData = ClientDataInstaller.installInfoTransported();
            sendingMessage = new CompleteMessage(transportedData, instructionPattern);
            ds = new DatagramSocket();
            host = InetAddress.getByName("localhost");
            port = 6791;
            ByteArrayOutputStream o = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(o);
            out.writeObject(sendingMessage);
            byte[] buff = o.toByteArray();
            dp = new DatagramPacket(buff, buff.length, host, port);
            ds.send(dp);
        } catch (InvalidDataFromFileException e) {
            System.out.println(e.getMessage());
            sendData();
        } finally {
            ClientStatusRegister.jsonData = null;
        }
    }

    public static boolean receiveToByteArray(byte[] receiveData) throws IOException {
        ds.setSoTimeout(10000);
        dp = new DatagramPacket(receiveData, receiveData.length);
        try {
            ds.receive(dp);
            return true;
        } catch (SocketTimeoutException e) {
            System.out.println("Server is not available");
            return false;
        }
    }

    public static void getData() throws IOException, ClassNotFoundException {
        byte[] newArr = new byte[1048576];
        if (!receiveToByteArray(newArr)) {
            System.out.println("Press Enter to re-input command or type \"exit\" to finish the program");
            Scanner s = new Scanner(System.in);
            if (s.nextLine().trim().equals("exit")) {
                System.out.println("Finishing ...");
                System.exit(0);
            } else return;
        }

        ByteArrayInputStream i = new ByteArrayInputStream(newArr);
        ObjectInputStream in = new ObjectInputStream(i);
        receivedMessage = (CompleteMessage) in.readObject();
        ClientDataInstaller clientDataInstaller = new ClientDataInstaller(receivedMessage.getTransportedData());
        clientDataInstaller.InstallFromTransported();
        Demonstrator demonstrator = new Demonstrator(receivedMessage.getResultPattern());
        demonstrator.demonstrateCommandResult();
    }
}
