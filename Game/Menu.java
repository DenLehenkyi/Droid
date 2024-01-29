package Game;

import BenderDroid.BenderDroid;
import Droid.Droid;
import PowerDroid.PowerDroid;
import VoltDroid.VoltDroid;

import java.util.ArrayList;
import java.util.Scanner;

import static Main.Main.*;

public class Menu {
    public  void initialisation(ArrayList<Droid> Droids) {
        ArrayList<Droid> tmp_droids = new ArrayList<>();
        tmp_droids.add(new PowerDroid());
        tmp_droids.add(new VoltDroid());
        tmp_droids.add(new BenderDroid());

        System.out.println("Введіть кількість дроїдів, яких бажаєте створити: ");

        int count_droids = scan.nextInt();
        for (int i = 0; i < count_droids; i++) {
            printLine(50, YELLOW);
            System.out.println("Оберіть тип дроїда:");

            System.out.println("Доступні типи дроїдів: PowerDroid, VoltDroid, BenderDroid.");
            for (Droid dr : tmp_droids) {
                System.out.println("Характеристики " + dr.getDroid_type() + '.');
                System.out.println("Тип - " + dr.getDroid_type() + '.' + "\n" + "Здоров'я - " + dr.getHealth() + '.' + "\n" + "Броня - " + dr.getArmor() + '.' + "\n" + "Шкода - " + dr.getDamage() + '.');
                printLine(50, YELLOW);
            }
            System.out.println("Для вибору PowerDroid натисніть - 1.");
            System.out.println("Для вибору  VoltDroid натисніть - 2.");
            System.out.println("Для вибору  BenderDroid натисніть - 3.");

            printLine(50, YELLOW);
            int type = scan.nextInt();
            scan.nextLine();

            String name;

            switch (type) {
                case 1:
                    System.out.println("Ви вибрали тип PowerDroid!");
                    printLine(50, YELLOW);
                    System.out.println("Введіть ім'я: ");
                    name = scan.nextLine();
                    Droids.add(new PowerDroid(name));
                    printLine(50, YELLOW);
                    printText("Ви успішно додали дроїда - " + name + '.', RED);
                    break;
                case 2:
                    System.out.println("Ви вибрали тип VoltDroid!");
                    printLine(50, YELLOW);
                    System.out.println("Введіть ім'я: ");
                    name = scan.nextLine();
                    Droids.add(new VoltDroid(name));
                    printLine(50, YELLOW);
                    printText("Ви успішно додали дроїда - " + name + '.', RED);
                    break;
                case 3:
                    System.out.println("Ви вибрали тип BenderDroid!");
                    printLine(50, YELLOW);
                    System.out.println("Введіть ім'я: ");
                    name = scan.nextLine();
                    Droids.add(new BenderDroid(name));
                    printLine(50, YELLOW);
                    printText("Ви успішно додали дроїда - " + name + '.', RED);
                    break;
                default:
                    printText("Невідомий тип дроїда!", RED);
            }


        }
        printLine(50, YELLOW);

    }
    public void Menu(ArrayList<Droid> Droids) {
        Scanner scan = new Scanner(System.in);
        printLine(50, YELLOW);
        String text = "\t\t\t\t\t\t\t\t\t ГРА БИТВА ДРОЇДІВ";
        printText(text, RED);


        while (true) {
            printLine(50, YELLOW);
            printText("\t\t\t\t\t\t\t\t\t\t МЕНЮ", RED);
            printLine(50, YELLOW);
            System.out.println("Натисніть 1, якщо бажаєте створити дроїдів.");
            System.out.println("Натисніть 2, якщо бажаєте побачити список створених дроїдів.");
            System.out.println("Натисніть 3, якщо бажаєте запустити бій 1х1.");
            System.out.println("Натисніть 4, якщо бажаєте запустити бій команди на команди.");
            System.out.println("Натисніть 5, якщо бажаєте відтворити проведений бій зі збереженого файлу.");
            System.out.println("Натисніть 0, якщо бажаєте завершити гру.");
            printLine(50, YELLOW);
            int n = scan.nextInt();
            printLine(50, YELLOW);

            switch (n) {
                case 1:
                    initialisation(Droids);
                    break;
                case 2:
                    printListOfDroids(Droids);
                    break;
                case 3:
                    fight1vs1(Droids);
                    break;
                case 4:
                    fightTeamVsTeam(Droids);
                    break;
                case 5:
                    reproduceFightFromFile();
                    break;

                case 0:
                    System.out.println("Гру завершено!");
                    printLine(50, YELLOW);
                    return;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
                    break;
            }

        }
    }
}

