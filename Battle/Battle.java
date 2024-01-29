package Battle;

import Droid.Droid;
import Team.Team;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static Main.Main.*;


public class Battle {


    public void fight1vs1(ArrayList<Droid> Droids) {
        Scanner scan = new Scanner(System.in);
        printText("\t\t\t\t\t\t\t\t\t\tЗапуск арени 1х1.", RED);
        printLine(50, YELLOW);
        if (Droids.isEmpty()) {
            System.out.println("Список дроїдів порожній. Спочатку додайте їх.");
            printLine(50, RED);
            return;
        }
        if (Droids.size() < 2) {
            System.out.println("Потрібно хоча би 2 дроїди.");
            printLine(50, RED);
            return;
        }


        printText("Для початку виберіть 2-х дроїдів для цього потрібно ввести їхні імена.", RED);
        System.out.println("Список доступних дроїдів:");
        printListOfDroids(Droids);

        System.out.println("Введіть ім'я 1-го дроїда: ");
        String droid1_name = scan.nextLine().toLowerCase();
        System.out.println("Введіть ім'я 2-го дроїда: ");
        String droid2_name = scan.nextLine().toLowerCase();


        ArrayList<Droid> fight_droids = new ArrayList<>();
        for (Droid droid : Droids) {
            if (droid.getName().toLowerCase().equals(droid1_name) || droid.getName().toLowerCase().equals(droid2_name)) {
                fight_droids.add(droid);
            }
        }

        if (fight_droids.size() != 2) {
            System.out.println("Не вдалося знайти обох дроїдів. Перевірте імена і спробуйте ще раз.");
            printLine(50, YELLOW);
            return;
        }

        Random random = new Random();
        int attacker_index = random.nextInt(2);

        Droid attacker = new Droid(fight_droids.get(attacker_index));
        Droid defender = new Droid(fight_droids.get(1 - attacker_index));


        printLine(50, YELLOW);
        int count_of_kicks = 0;
        int round = 1;

        printText("Першим атакує " + attacker.getName() + '.', RED);
        while (defender.getHealth() >= 0 && attacker.getHealth() >= 0) {
            printLine(50, YELLOW);
            System.out.println(RED);
            System.out.println("\t\t\t\t\t\tРаунд " + round++);
            System.out.println(WHITE);
            System.out.println("\t\t" + attacker.getName() + " " + attacker.getHealth() + " hp" + " атакує " + defender.getName() + " " + defender.getHealth() + " hp");
            attacker.fight(defender);
            System.out.println("\t\t" + defender.getName() + " " + defender.getHealth() + " hp" + " атакує " + attacker.getName() + " " + attacker.getHealth() + " hp");
            defender.fight(attacker);


            if (attacker.getHealth() <= 0 || defender.getHealth() <= 0) {
                break;
            }
            count_of_kicks++;
        }
        System.out.println(defender);
        System.out.println(attacker);
        printLine(50, YELLOW);

        if (attacker.getHealth() > 0) {
            System.out.println("Переміг " + attacker + "Кількість ударів: " + count_of_kicks + '.');
            printLine(50, YELLOW);
            printText("Знадобилось " + round + " раундів для дроїда - " + attacker.getName() + ",щоб перемогти дроїда - " + defender.getName() + ".", RED);
            attacker = fight_droids.get(0);
            defender = fight_droids.get(1);
            printLine(50, YELLOW);
            return;
        }
        if (attacker.getHealth() == defender.getHealth()) {
            printLine(50, YELLOW);
            System.out.println("Нічия! Здоров'я - " + droid1_name + " " + attacker.getHealth() + "\n" + "Здоров'я - " + droid2_name + " " + defender.getHealth());
            printText("Знадобилось " + round + " раундів для нічиї між суперниками.", RED);
            attacker = fight_droids.get(0);
            defender = fight_droids.get(1);
            printLine(50, YELLOW);
            return;
        }

        if (defender.getHealth() > 0) {
            System.out.println("Переміг " + defender + "Кількість ударів: " + count_of_kicks + '.');
            printLine(50, YELLOW);
            printText("Знадобилось " + round + " раундів для дроїда - " + defender.getName() + ",щоб перемоги дроїда - " + attacker.getName() + ".", RED);
            attacker = fight_droids.get(0);
            defender = fight_droids.get(1);
            printLine(50, YELLOW);
            return;
        }

    }

    public void fightTeamVsTeam(ArrayList<Droid> Droids) {
        Scanner scan = new Scanner(System.in);
        if (Droids.isEmpty()) {
            System.out.println("Список дроїдів порожній. Спочатку додайте їх.");
            printLine(50, YELLOW);
            return;
        } else if (Droids.size() < 4) {
            System.out.println("Дроїдів повино бути мінімум 4.");
            return;
        }
        ArrayList<Droid> Copy_Of_Droids = new ArrayList<>();
        for (Droid droid : Droids) {
            Copy_Of_Droids.add(new Droid(droid));
        }

        int count_of_droids = Copy_Of_Droids.size() / 2;
        printLine(100, RED);
        printText("\t\t\t\t\t\t\t\t\t\t\tБій " + count_of_droids + "x" + count_of_droids + '.', RED);
        printLine(100, RED);
        Team team1 = new Team();
        Team team2 = new Team();

        System.out.println("Команди будуть сформовані порівно.");
        System.out.println("Для того щоб запустити бій команда на команду потрібно сформувати команди.");
        System.out.println("Введіть назву 1-ої команди:");
        String team1_name = scan.nextLine();
        team1.setName(team1_name);

        printText("Сформуйте першу команду:", RED);
        System.out.println("Виберіть дроїдів для 1-ої команди.");
        printText("Список дроїдів.", RED);
        printLine(50, YELLOW);

        printListOfDroids(Copy_Of_Droids);
        createTeam(team1, Copy_Of_Droids, count_of_droids);
        System.out.println(team1);

        System.out.println("Введіть назву 2-ої команди:");
        String team2_name = scan.nextLine();
        team2.setName(team2_name);
        System.out.println("Виберіть дроїдів для 2-ої команди.");
        System.out.println("Список дроїдів");
        printListOfDroids(Copy_Of_Droids);
        createTeam(team2, Copy_Of_Droids, count_of_droids);
        System.out.println(team2);
        printLine(50, YELLOW);

        System.out.println("2 команди успішно сформовано!");
        printLine(50, YELLOW);
        printText("\t\t\t\t\t\t\tБій команди - " + team1.getTeamName() + " проти команди - " + team2.getTeamName() + '.', RED);
        int round_for_fight = 1;
        Random random = new Random();

        int count_rounds = count_of_droids;
        Droid droid_from_team1 = null;
        Droid droid_from_team2 = null;

        boolean team1GoesFirst = random.nextBoolean();
        List<Integer> usedIndexesTeam1 = new ArrayList<>();
        List<Integer> usedIndexesTeam2 = new ArrayList<>();

        for (int i = 0; i < count_rounds; i++) {
            if (team1GoesFirst) {
                droid_from_team1 = selectDroid(team1, usedIndexesTeam1, random);
                droid_from_team2 = selectDroid(team2, usedIndexesTeam2, random);

            } else {
                droid_from_team2 = selectDroid(team2, usedIndexesTeam2, random);
                droid_from_team1 = selectDroid(team1, usedIndexesTeam1, random);

            }

            //fightTeam(droid_from_team1, droid_from_team2, team1, team2, count_rounds, round_for_fight);

            recordFightInFile(droid_from_team1, droid_from_team2, team1, team2, count_rounds, round_for_fight);
        }

        System.out.println("Проведений бій успішно записано у файл!");
    }


    private Droid selectDroid(Team team, List<Integer> usedIndexes, Random random) {
        int fight_team;
        do {
            fight_team = random.nextInt(team.getSize());
        } while (usedIndexes.contains(fight_team));
        usedIndexes.add(fight_team);
        return team.getDroid(fight_team);
    }


    public static void createTeam(Team team, ArrayList<Droid> Droids, int count_of_droids) {
        ArrayList<Droid> droidsCopy = new ArrayList<>(Droids); // Створюємо копію списку

        for (int i = 0; i < count_of_droids; i++) {
            boolean foundDroid = false;

            while (!foundDroid) {
                System.out.println("Введіть ім'я дроїда ");
                String droid_name = scan.nextLine().toLowerCase();
                for (Droid droid : droidsCopy) {
                    if (droid.getName().equals(droid_name)) {
                        team.setDroids(droid);
                        Droids.remove(droid);
                        foundDroid = true;
                        break;
                    }


                }
                if (!foundDroid) {
                    printText("Дроїда з таким іменем не знайдено. Спробуйте ще раз.", RED);

                }

            }
            if (team.getSize() == count_of_droids) {
                printLine(50, YELLOW);
                printText("Команду " + team.getTeamName() + " успішно сформовано!", RED);
                printLine(50, YELLOW);
            }
        }
    }

    public static void fightTeam(Droid droid1, Droid droid2, Team team1, Team team2, int count_rounds, int round_for_fight) {
        Droid droid_from_team1 = new Droid(droid1);
        Droid droid_from_team2 = new Droid(droid2);

        while (droid_from_team1.getHealth() >= 0 && droid_from_team2.getHealth() >= 0) {
            printLine(50, YELLOW);
            System.out.println(RED);

            System.out.println("\t\t\t\t\t\t\t\t\t\tРаунд " + round_for_fight++);
            System.out.println(WHITE);
            System.out.println("\t\t\t\t\t\t\t" + droid_from_team1.getName() + " " + droid_from_team1.getHealth() + " hp" + " атакує " + droid_from_team2.getName() + " " + droid_from_team2.getHealth() + " hp");
            droid_from_team1.fight(droid_from_team2);

            System.out.println("\t\t\t\t\t\t\t" + droid_from_team2.getName() + " " + droid_from_team2.getHealth() + " hp" + " атакує " + droid_from_team1.getName() + " " + droid_from_team1.getHealth() + " hp");
            droid_from_team2.fight(droid_from_team1);

            if (droid_from_team1.getHealth() <= 0) {
                printLine(50, YELLOW);
                printText("Дроїд " + droid_from_team2.getName() + '.' + "Команда (" + team2.getTeamName() + ')' + " переміг " + droid_from_team1.getName() + '.' + "За " + count_rounds + " раундів", RED);
                count_rounds = 1;

                team2.increaseScore();

            }
            if (droid_from_team2.getHealth() <= 0) {
                printLine(50, YELLOW);
                printText("Дроїд " + droid_from_team1.getName() + '.' + "Команда (" + team1.getTeamName() + ')' + " переміг " + droid_from_team2.getName() + '.', RED);
                count_rounds = 1;

                team1.increaseScore();

            }
        }
        System.out.println("Кількість очків в команди " + team1.getTeamName() + " - " + team1.getScore() + '.');
        System.out.println("Кількість очків в команди " + team2.getTeamName() + " - " + team2.getScore() + '.');

        printLine(50, YELLOW);
        if (team1.getScore() > team2.getScore()) {
            printText("\t\tПеремогла команда " + team1.getTeamName() + '.', RED);
        }
        if (team2.getScore() > team1.getScore()) {
            printText("\t\tПеремогла команда " + team2.getTeamName() + '.', RED);
        }
        if (team1.getScore() == team2.getScore()) {
            printText("\t\tНічия між командами " + team1.getTeamName() + " та " + team2.getTeamName() + '.', RED);

        }
    }

    public static void recordFightInFile(Droid droid_from_team1, Droid droid_from_team2, Team team1, Team team2, int count_rounds, int round_for_fight) {
        String fileName = "C:\\Users\\denle\\Desktop\\java_projects\\laba_3\\src\\main\\java\\Game\\droids.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
            writer.write("\t\t\t\t\t\t\tБій команди - " + team1.getTeamName() + " проти команди - " + team2.getTeamName() + '.');
            writer.write("Початок бою");

            writer.newLine();

            while (droid_from_team1.getHealth() >= 0 && droid_from_team2.getHealth() >= 0) {
                writer.newLine();
                writer.write("\t\t\t\t\t\t\t\t\t\tРаунд " + round_for_fight++);
                writer.newLine();
                writer.newLine();
                writer.write("\t\t\t\t\t\t\t" + droid_from_team1.getName() + " " + droid_from_team1.getHealth() + " hp" + " атакує " + droid_from_team2.getName() + " " + droid_from_team2.getHealth() + " hp");
                droid_from_team1.fight(droid_from_team2);
                writer.newLine();
                writer.write("\t\t\t\t\t\t\t" + droid_from_team2.getName() + " " + droid_from_team2.getHealth() + " hp" + " атакує " + droid_from_team1.getName() + " " + droid_from_team1.getHealth() + " hp");
                droid_from_team2.fight(droid_from_team1);
                writer.newLine();
                if (droid_from_team1.getHealth() <= 0) {
                    writer.write("Дроїд " + droid_from_team2.getName() + '.' + "Команда (" + team2.getTeamName() + ')' + " переміг " + droid_from_team1.getName() + '.' + "За " + count_rounds + " раундів");
                    count_rounds = 1;
                    team2.increaseScore();

                }
                if (droid_from_team2.getHealth() <= 0) {
                    writer.write("Дроїд " + droid_from_team1.getName() + '.' + "Команда (" + team1.getTeamName() + ')' + " переміг " + droid_from_team2.getName() + '.');
                    count_rounds = 1;

                    team1.increaseScore();

                }
            }

            // Всі результати бою вже записані, тепер закриваємо файл
            writer.write("Кількість очків в команди " + team1.getTeamName() + " - " + team1.getScore() + '.');
            writer.newLine();
            writer.write("Кількість очків в команди " + team2.getTeamName() + " - " + team2.getScore() + '.');
            writer.newLine();
            if (team1.getScore() > team2.getScore()) {
                writer.write("\t\tПеремогла команда " + team1.getTeamName() + '.');
            }
            if (team2.getScore() > team1.getScore()) {
                writer.write("\t\tПеремогла команда " + team2.getTeamName() + '.');
            }
            if (team1.getScore() == team2.getScore()) {
                writer.write("\t\tНічия між командами " + team1.getTeamName() + " та " + team2.getTeamName() + '.');
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reproduceFightFromFile() {
        String fileName = "C:\\Users\\denle\\Desktop\\java_projects\\laba_3\\src\\main\\java\\Game\\droids.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String currentRoundAttacker = null;
            String currentRoundDefender = null;


            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


