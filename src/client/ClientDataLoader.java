package client;

import common.baseObjects.*;
import common.exceptions.ScanValidation;

import java.util.Scanner;

public abstract class ClientDataLoader {
    protected final Scanner scanner = new Scanner(System.in);

    protected String loadDragonName() {
        System.out.println("Введите имя дракона");
        return ScanValidation.nextNonEmptyLine();
    }

    protected Coordinates loadDragonCoordinates() {
        System.out.println("Введите х не более 461");
        int x = ScanValidation.nextInt();
        while (x > 461) {
            System.out.println("Число не должно превышать 461");
            x = ScanValidation.nextInt();
        }
        System.out.println("Введите y:");
        Long y = ScanValidation.nextLong();
        return new Coordinates(x, y);
    }

    protected int loadDragonAge() {
        System.out.println("Введите возраст дракона");
        int age = ScanValidation.nextInt();
        while (age <= 0) {
            System.out.println("дракон должен быть рожден :/");
            age = ScanValidation.nextInt();
        }
        return age;
    }

    protected String loadDragonDescription() {
        System.out.println("Введите описание дракона");
        String description = scanner.nextLine();
        if (description.equals("")) {
            return null;
        }
        return description;
    }

    protected Integer loadDragonWingspan() {
        System.out.println("Введите размах крыльев дракона");
        int wingspan = ScanValidation.nextInt();
        while (wingspan <= 0) {
            System.out.println("Размах крылье всегда больше чем 0 !");
            wingspan = ScanValidation.nextInt();
        }
        return wingspan;
    }

    protected DragonType loadDragonType() {
        System.out.println("Введите один из возможных типов дракона");
        for (DragonType dragonType : DragonType.values()) {
            System.out.println(dragonType.toString());
        }
        return ScanValidation.nextDragonType();
    }

    protected String loadKillerName() {
        System.out.println("Введите имя убийцы");
        return ScanValidation.nextNonEmptyLine();
    }

    protected int loadKillerWeight() {
        System.out.println("Введите вес убийцы");
        int age = ScanValidation.nextInt();
        while (age <= 0) {
            System.out.println("убийца не может весить меньше 1 :/");
            age = ScanValidation.nextInt();
        }
        return age;
    }

    protected EyeColor loadKillerEyeColor() {
        System.out.println("Введите цвет глаз убийцы");
        for (EyeColor color : EyeColor.values()) {
            System.out.println(color.toString());
        }
        return ScanValidation.nextEyeColor();
    }

    protected HairColor loadKillerHairColor() {
        System.out.println("Введите цвет глаз убийцы");
        for (HairColor color : HairColor.values()) {
            System.out.println(color.toString());
        }
        return ScanValidation.nextHairColor();
    }

    protected Country loadKillerNationality() {
        System.out.println("Введи да насианалнаст Джамшуда");
        for (Country nationality : Country.values()) {
            System.out.println(nationality.toString());
        }
        return ScanValidation.nextKillerNationality();
    }

    /**
     * @return common.baseObjects.Location(Double x, float y, String name)
     */
    protected Location loadKillerLocation() {
        System.out.println("Известна ли координата убийцы?");
        System.out.println("Если известна, то напишите \"yes\", в противном случае - нажмите Enter");
        String s = scanner.nextLine();
        if (s.equals("")) {
            return null;
        }
        if (!s.equals("yes")) {
            System.out.println("Некорректный ввод");
            return loadKillerLocation();
        }
        System.out.println("Введите координату х:");
        Double x = ScanValidation.nextDouble();

        System.out.println("Введите координату y:");
        float y = (float) ScanValidation.nextDouble();

        System.out.println("Введите название локации");
        String name = ScanValidation.nextNonEmptyLine();
        return new Location(x, y, name);
    }

    protected Person loadKiller() {
        System.out.println("Известен ли убийца дракона и есть ли он вообще?");
        System.out.println("Если есть, то напишите \"yes\", есть нет - пропустите Enter.");
        String answer = scanner.nextLine();
        while (!answer.equals("yes")) {
            if (answer.equals("")) return null;
            System.out.println("Некорректный ввод, введите \"yes\" или же нажмите Enter.");
            answer = scanner.nextLine();
        }
        return new Person(loadKillerName(), loadKillerWeight(), loadKillerEyeColor(), loadKillerHairColor(),
                loadKillerNationality(), loadKillerLocation());
    }

    public Dragon loadDragonFromData() {
        return new Dragon(loadDragonName(), loadDragonCoordinates(), loadDragonAge(), loadDragonDescription(),
                loadDragonWingspan(), loadDragonType(), loadKiller());
    }
}
