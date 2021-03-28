package domain;

import service.Status;

public class Programmer extends  Employee {

    /**
     memberId is used to record the ID of a member in the team
     after joining the development team

     */
    private int memberId;
    private Status status;
    private Equipment equipment;

    public Programmer() {
        super();
    }

    public Programmer(int id , String name , int age , double salary , Equipment equipment) {
        super(id, name , age , salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberld(int memberld) {
        this.memberId = memberld;
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

    protected String getMemberDetails() {
        return getMemberId() + "/" + getDetails();
    }


    public String getDetailsForTeam() {
            return getMemberDetails() + "\tProgrammer";
    }


    @Override
    public String toString() {
        return getDetails() + "\tProgrammer\t" + status + "\t" + equipment.getDescription();
    }
}

