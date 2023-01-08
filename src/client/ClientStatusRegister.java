package client;

import common.baseObjects.Dragon;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class ClientStatusRegister {
    public static ArrayList<Dragon> dragons = new ArrayList<>();

    public static HashSet<Integer> idList = new HashSet<>();

    public static Date date;

    public static File currentFile;

    public static byte[] jsonData;

}
