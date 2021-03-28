package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

public class TeamService {
    private static int count = 1;
    private int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total;

    public TeamService() {
        super();
    }

    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        //if the member is full , unable to add
        if (total >= MAX_MEMBER) {
            throw new TeamException("Memeber is full , unable to add");
        }
        //if the member isn't developer , unable to add
        if (!(e instanceof Programmer)) {
            throw new TeamException("The member isn't developer , unable to add");
        }

        if (isExist(e)) {
            throw new TeamException("The member already in develop team");
        }

        Programmer p = (Programmer) e;
        if ("BUSY".equals(p.getStatus().getNAME())) {
            throw new TeamException("The member already in develop team");
        } else if ("VOCATION".equals(p.getStatus().getNAME())) {
            throw new TeamException("Member in Vocation , unable to add");
        }

        //numOfArch mean the number of Architect
        //numOfDes mean the number of Designer
        //numOfPro mean the number of Programmer

        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Designer) {
                numOfDes++;
            } else if (team[i] instanceof Programmer) {
                numOfPro++;
            }
        }

        if (p instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException(("One team can only have one Architect"));
            }
        } else if (p instanceof Designer) {
            if (numOfArch >= 2) {
                throw new TeamException("One team can only have two designer");
            }
        } else if (p instanceof Programmer) {
            if (numOfPro >= 3) {
                throw new TeamException("One team can only have three programmer");
            }
        }

        p.setStatus(Status.BUSY);
        p.setMemberld(count++);

        team[total++] = p;
    }


    public boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getMemberId() == memberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        if (i == total) {
            throw new TeamException("Unable to found the Employee ID , delete unsuccessful");
        }

        for (int j = i + 1; j < total; j++) {
            team[j - 1] = team[j];
        }
        team[total - 1] = null;
        total--;
    }
}




