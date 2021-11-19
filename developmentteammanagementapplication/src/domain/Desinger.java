package domain;

import team.service.Status;

public class Desinger extends Programmer{
    private double bouns;

    public Desinger() {
    }

    public Desinger(int id, String name, int age, double salary, Equipment equipment, double bouns) {
        super(id, name, age, salary, equipment);
        this.bouns = bouns;
    }

    public double getBouns() {
        return bouns;
    }

    public void setBouns(double bouns) {
        this.bouns = bouns;
    }

    @Override
    public String toString() {
        return getDetails() + ',' +
                ", Desinger" + ", " + getStatus() +
                ", bouns=" + bouns + ',' +
                getEquipment().getDescription();
    }

    public String getDetailsForTeam() {
        return  getTeamBaseDetails() +"\tDesigner\t" + getBouns();
    }
}

