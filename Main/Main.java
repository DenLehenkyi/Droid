package Main;

import Battle.Battle;
import BenderDroid.BenderDroid;
import Droid.Droid;
import PowerDroid.PowerDroid;
import VoltDroid.VoltDroid;
import Game.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static final String YELLOW = "\u001b[33m=";
    public static final String RED = "\u001B[31m";

    public static final String WHITE = "\u001b[0m";

    public static void printListOfDroids(ArrayList<Droid> Droids) {
        if (Droids.isEmpty()) {
            printText("Список дроїдів порожній. Спочатку додайте їх.", RED);
            printLine(50, YELLOW);
            return;
        }
        for (Droid droid : Droids) {
            System.out.println(droid);
            printLine(50, YELLOW);
        }
    }

    public static void printLine(int n, String color) {
        int i = 0;

        while (i < n) {
            System.out.print(color + '=');
            i++;
        }
        System.out.print(WHITE);
        System.out.println();
    }

    public static void printText(String text, String color) {
        System.out.print(color);
        System.out.println(text);
        System.out.print(WHITE);
    }

    public static void initialisation(ArrayList<Droid> Droids) {
        Menu menu = new Menu();

        menu.initialisation(Droids);
    }


    public static void fight1vs1(ArrayList<Droid> Droids) {
        Battle battle = new Battle();

        battle.fight1vs1(Droids);

    }

    public static void fightTeamVsTeam(ArrayList<Droid> Droids) {
        Battle battle = new Battle();

        battle.fightTeamVsTeam(Droids);
    }

    public static void reproduceFightFromFile() {
        Battle battle = new Battle();

        battle.reproduceFightFromFile();
    }


    public static void main(String[] args) {
        ArrayList<Droid> Droids = new ArrayList<>();

        Menu menu = new Menu();
        menu.Menu(Droids);

    }

}