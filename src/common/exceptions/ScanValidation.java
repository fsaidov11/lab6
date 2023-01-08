package common.exceptions;

import common.baseObjects.*;
import server.ServerStatusRegister;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class {@code common.exceptions.ScanValidation} contains overridden methods
 * of class {@code Scanner} and not only to read data from {@code System.in}.
 * All these methods ask user to enter valid data while
 * detecting incorrect input.
 */
public class ScanValidation {

    /**
     * Asks user to enter {@code int} value while
     * catching {@link InputMismatchException} exception.
     *
     * @return entered {@code int} value.
     */
    public static int nextInt() {
        Scanner varScan = new Scanner(System.in);
        int obj;
        try {
            obj = varScan.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Введенная строка не является целым числом, введите корректное значение.");
            return nextInt();
        }
        return obj;
    }

    /**
     * Asks user to enter {@code double} value while
     * catching {@link InputMismatchException} exception.
     *
     * @return entered {@code double} value.
     */
    public static double nextDouble() {
        Scanner varScan = new Scanner(System.in);
        double obj;
        try {
            obj = varScan.nextDouble();
        } catch (InputMismatchException ex) {
            System.out.println("Введенная строка не является дробным десятичным числом, введите корректное значение.");
            return nextDouble();
        }
        return obj;
    }

    /**
     * Asks user to enter {@code long} value while
     * catching {@link InputMismatchException} exception.
     *
     * @return entered {@code long} value.
     */
    public static long nextLong() {
        Scanner varScan = new Scanner(System.in);
        long obj;
        try {
            obj = varScan.nextLong();
        } catch (InputMismatchException ex) {
            System.out.println("Введенная строка не является целым числом, введите корректное значение.");
            return nextLong();
        }
        return obj;
    }

    public static DragonType nextDragonType() {
        Scanner varScan = new Scanner(System.in);
        DragonType dragonType;
        try {
            String type = varScan.next();
            varScan.nextLine();
            dragonType = DragonType.valueOf(type);
        } catch (IllegalArgumentException ex) {
            System.out.println("Выберите существующий тип дракона, введите один из предложенных ранее.");
            return nextDragonType();
        }
        return dragonType;
    }

    public static EyeColor nextEyeColor() {
        Scanner varScan = new Scanner(System.in);
        EyeColor color;
        try {
            String c = varScan.next();
            if (c.equals("")) return null;
            varScan.nextLine();
            color = EyeColor.valueOf(c);
        } catch (IllegalArgumentException ex) {
            System.out.println("Выберите существующий цвет, введите один из предложенных ранее.");
            return nextEyeColor();
        }
        return color;
    }

    public static HairColor nextHairColor() {
        Scanner varScan = new Scanner(System.in);
        HairColor color;
        try {
            String c = varScan.next();
            varScan.nextLine();
            color = HairColor.valueOf(c);
        } catch (IllegalArgumentException ex) {
            System.out.println("Выберите существующий цвет, введите один из предложенных ранее.");
            return nextHairColor();
        }
        return color;
    }

    /**
     * Asks user to enter not empty {@code String} value
     * while detecting empty inputted {@code String}.
     *
     * @return entered not empty {@code String} value.
     */
    public static String nextNonEmptyLine() {
        Scanner varScan = new Scanner(System.in);
        String srt = varScan.nextLine();
        if (srt.equals("")) {
            System.out.println("Строка не может быть пустой. Введите её корректно.");
            return nextNonEmptyLine();
        }
        return srt;
    }

    public static Country nextKillerNationality() {
        Scanner varScan = new Scanner(System.in);
        Country nationality;
        try {
            String n = varScan.next();
            if (n.equals("")) return null;
            varScan.nextLine();
            nationality = Country.valueOf(n);
        } catch (IllegalArgumentException ex) {
            System.out.println("Выберите национальность убийцы, введите один из предложенных ранее.");
            return nextKillerNationality();
        }
        return nationality;
    }

    /**
     * @return valid {@code int} from file.
     * @throws InvalidDataFromFileException if Scanner meets not {@code int} in file.
     */
    public static int ReadNextInt() throws InvalidDataFromFileException {
        int obj;
        try {
            String str = ServerStatusRegister.scriptScanner.nextLine();
            obj = Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            throw new InvalidDataFromFileException("При создании объекта вместо целого числа int введено что-то другое.");
        }
        return obj;
    }

    /**
     * @return valid {@code double} from file.
     * @throws InvalidDataFromFileException if Scanner meets not {@code double} in file.
     */
    public static double ReadNextDouble() throws InvalidDataFromFileException {
        double obj;
        try {
            String str = ServerStatusRegister.scriptScanner.nextLine();
            obj = Double.parseDouble(str);
        } catch (NumberFormatException ex) {
            throw new InvalidDataFromFileException("При создании объекта вместо вещественного числа введено что-то другое.");
        }
        return obj;
    }

    /**
     * @return valid {@code long} from file.
     * @throws InvalidDataFromFileException if Scanner meets not {@code int}
     *                                      or {@code long} in file.
     */
    public static long ReadNextLong() throws InvalidDataFromFileException {
        long obj;
        try {
            String str = ServerStatusRegister.scriptScanner.nextLine();
            obj = Long.parseLong(str);
        } catch (NumberFormatException ex) {
            throw new InvalidDataFromFileException("При создании объекта вместо целого числа введено что-то другое.");
        }
        return obj;
    }

    /**
     * @return valid {@link DragonType} from file.
     * @throws InvalidDataFromFileException if Scanner meets not {@link DragonType} in file.
     */
    public static DragonType ReadNextDragonType() throws InvalidDataFromFileException {
        DragonType genre;
        try {
            String g = ServerStatusRegister.scriptScanner.nextLine();
            genre = DragonType.valueOf(g);
        } catch (IllegalArgumentException ex) {
            throw new InvalidDataFromFileException("Значение жанра введено некорректно.");
        }
        return genre;
    }

    public static EyeColor ReadNextEyeColor() throws InvalidDataFromFileException {
        EyeColor eyeColor;
        try {
            String color = ServerStatusRegister.scriptScanner.nextLine();
            eyeColor = EyeColor.valueOf(color);
        } catch (IllegalArgumentException e) {
            throw new InvalidDataFromFileException("такого цвета нет в базе");
        }
        return eyeColor;
    }

    public static HairColor ReadNextHairColor() throws InvalidDataFromFileException {
        HairColor hairColor;
        try {
            String color = ServerStatusRegister.scriptScanner.nextLine();
            hairColor = HairColor.valueOf(color);
        } catch (IllegalArgumentException e) {
            throw new InvalidDataFromFileException("такого цвета нет в базе");
        }
        return hairColor;
    }

    public static Country ReadNextCountry() throws InvalidDataFromFileException {
        Country country;
        try {
            String c = ServerStatusRegister.scriptScanner.nextLine();
            country = Country.valueOf(c);
        } catch (IllegalArgumentException e) {
            throw new InvalidDataFromFileException("такой страны нет в базе");
        }
        return country;
    }


    /**
     * @return valid non-empty {@code String} from file.
     * @throws InvalidDataFromFileException if Scanner meets empty {@code String} in file.
     */
    public static String ReadNextNonEmptyLine() throws InvalidDataFromFileException {
        String srt = ServerStatusRegister.scriptScanner.nextLine();
        if (srt.equals("")) {
            throw new InvalidDataFromFileException("Введена пустая строка, где её не должно быть.");
        }
        return srt;
    }
}