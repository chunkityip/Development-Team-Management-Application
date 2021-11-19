package domain;


import team.service.Status;

public class Programmer extends Employee{

    private int memberid;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int id) {
        this.memberid = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return  getDetails() + ", Programmer" +
                ", " + status +
                ", equipment=" + equipment.getDescription();
    }

    //Cause the employee info too long , I will put the repeat info into this method
    public String getTeamBaseDetails() {
        return memberid + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary();
    }
    public String getDetailsForTeam() {
        return  getTeamBaseDetails() +"\tProgrammer";
    }
}

