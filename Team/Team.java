package Team;

import Droid.Droid;

import java.util.ArrayList;

public class Team {
    private String team_name;

    private ArrayList<Droid> team = new ArrayList<>();
    private int score;

    public Team() {

    }

    public String getTeamName() {
        return team_name;
    }

    public void setName(String name) {
        this.team_name = name;
    }

    public Droid getDroid(int index){
        if (index >= 0 && index < team.size()) {
            return team.get(index);
        }
        else {
            return null;
        }
    }

    public void setDroids(Droid droid) {
        this.team.add(droid);
    }
    public int getSize(){
        return this.team.size();
    }

    public int getScore() {
        return score;
    }


    public void increaseScore(){
        this.score += 1;
    }
    @Override
    public String toString() {
        return
                "Ім'я команди - " + team_name + '.' + "\n" +
                        "Cписок учасників команди - " + "\n" + team + '.' + "\n";
    }

}
