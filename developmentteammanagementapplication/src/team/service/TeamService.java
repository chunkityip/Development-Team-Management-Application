package team.service;

import domain.Architect;
import domain.Desinger;
import domain.Employee;
import domain.Programmer;

/**
 * To manage,remove and add the develop team member(Programmer)
 */

public class TeamService {
    /*
    I need something that will be used throughout the
    application and in every instance need to know the variable.
    Therefore, I set the variable as static
     */
    private static int counter = 1;
    private final int MAX_MEMBER = 5; //this variable can't be change , so set to final
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int totalmember;

    public TeamService() {
    }

    /**
     * to display the current team employee info
     *
     * @return
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[totalmember];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * To add the specify team member.
     * Noted : There will have some situation need to avoid
     *
     * @param e
     */
    public void addMember(Employee e) throws TeamException {
        //The team already full , can't add it
        if (totalmember >= MAX_MEMBER) {
            throw new TeamException("The team already full , can't add");
        }

        /*
          If the member isn't a programmer , can't add it
          instanceof keyword : if "a" is a instance of "A" class , return true, else , return false
          at this time , if e isn't a Programmer , return false
         */
        if (!(e instanceof Programmer)) {
            throw new TeamException("The member isn't a programmer , can't add it.");
        }

        /*
          The current member already in the team
          Creating a new method call isExist
         */
        if (isExist(e)) {
            throw new TeamException("The current member already in the team");
        }

        /*
        The current member is busy or in vacation , unable to add it
        Because of the line 53 , we are sure the employee will be Programmer ,
        therefore , we can conversion p to e.
         */
        Programmer p = (Programmer) e;// will not show ClassCastException
        /*
        if (p.getStatus().getNAME().equals("BUSY"))
        OR
         */
        if ("BUSY".equals(p.getStatus().getNAME())) {
            throw new TeamException("The current member already in the team");
        } else if ("VACATION".equals(p.getStatus().getNAME())) {
            throw new TeamException("The current member is in the vacation. Let him/her take a break!");
        }

        /*
         Set the limit: One team can only have one ARCHITECT!
                        One team can only have two DESIGNER!
                        One team can only have three PROGRAMMER!
         */
        int numOfArch = 0, numOfDesi = 0, numOfProg = 0;
        for (int i = 0; i < totalmember; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Desinger) {
                numOfDesi++;
            } else if (team[i] instanceof Programmer) {
                numOfProg++;
            }
        }

        if (p instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("One team can only have one ARCHITECT!");
            }
        } else if (p instanceof Desinger) {
            if (numOfDesi >= 2) {
                throw new TeamException("One team can only have two DESIGNER!");
            }
        } else if (p instanceof Programmer) {
            if (numOfProg >= 3) {
                throw new TeamException("One team can only have three PROGRAMMER!");
            }
        }

        //Adding p( or e) into team array
        team[totalmember++] = p;
        p.setStatus(Status.BUSY);
        p.setId(counter++);
    }

    private boolean isExist(Employee e) {
        for (int i = 0; i < totalmember; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

        /**
         * To remove the member from the team
         */
        public void removeMember(int id) throws TeamException {
            //Because it is Array , once we remove the current member , we need to move next member forward
            //Therefore , set i as global so it can shares using i.
            int i = 0;
;            for (; i < totalmember; i++) {
                if (team[i].getId() == id) {
                    team[i].setStatus(Status.FREE);
                    break;
                }
            }

            //if it can't find the id we looking for (which mean have no such as employee)
            if (i == totalmember) {
                throw new TeamException("Can't find the id you enter for , remove unsuccessful");
            }

            //moving the next member forward
            for (int j = i + 1; j < totalmember; j++) {
                team[j - 1] = team[j];
            }

            team[--totalmember] = null;

        }


}

