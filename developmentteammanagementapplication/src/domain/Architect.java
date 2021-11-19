package domain;

import team.service.Status;

public class Architect extends Desinger{

    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bouns, int stock) {
        super(id, name, age, salary, equipment, bouns);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String toString() {
        return getDetails() +
                ", Architect"  + ", " +
                getStatus() + ' ' +
                 ", bouns=" + getBouns() + ' ' +
                ',' + stock + ' ' + ',' +
                getEquipment().getDescription();
    }

    public String getDetailsForTeam() {
        return getTeamBaseDetails() +"\tProgrammer" + "\tArchitect\t" + getBouns() + "\t" + getStock();
    }
}
