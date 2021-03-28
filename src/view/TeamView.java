package view;

import domain.Employee;
import domain.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu() throws TeamException {

        boolean loopFlag = true;
        char menu = 0;

        while(loopFlag) {
            if (menu != '1') {
                listAllEmployees();
            }

            System.out.print("1:Team list 2:Add team member 3:Delete team member 4:Exit Enter(1 - 4): ");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMemeber();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("Are you sure to Exit?(Y/N): ");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        }
    }

    private void listAllEmployees() {
        System.out.println("Display all Employee's info");
        System.out.println("------------------Development Team Management Application------------------");

        Employee[] employees = listSvc.getAllEmployees();
        if (employees == null || employees.length == 0) {
            System.out.println("No such of info!");
        } else {
            System.out.println("ID\t Name\t\t\tAge\tIncome\tJob\t\tActivity\tbonus\tstock\tEquipment");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        }
    }

    private void getTeam() {
        System.out.println("Check the situation of team.");

        System.out.println("------------------Development Team Management Application------------------");
        Programmer[] team = teamSvc.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("There have no member in the team yet!");
        } else {
            System.out.println("ID\t Name\t\t\tAge\tIncome\tJob\t\tActivity\tbonus\tstock\tEquipment");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailsForTeam());
            }
        }

    }


    private void addMemeber() {
        System.out.println("Add member");
        System.out.println("------------------Add number------------------");
        System.out.println("Enter the Employee ID: ");
        int id = TSUtility.readInt();

        try {
            Employee emp = listSvc.getEmployee(id);
            teamSvc.addMember(emp);
            System.out.println("Add successfully!");
            TSUtility.readReturn();
        } catch (TeamException e) {
            System.out.println("Add unsuccessfully!" + e.getMessage());
        }

    }

    private void deleteMember() throws TeamException {
        System.out.println("Delete member");
        System.out.println("------------------Delete number------------------");
        System.out.println("Enter the Employee ID: ");
        int memberID= TSUtility.readInt();

        System.out.println("Are you sure to delete(Y/N): ");
        char isDelete = TSUtility.readConfirmSelection();
        if (isDelete == 'N') {
            return;
        }
        try {
            teamSvc.removeMember(memberID);
            System.out.println("Delete successfully!");
        } catch (TeamException e) {
            System.out.println("Delete unsuccessfully!" + e.getMessage());
        }
        TSUtility.readReturn();
    }

    public static void main(String[] args) throws TeamException {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}
