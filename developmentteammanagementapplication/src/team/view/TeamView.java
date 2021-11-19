package team.view;

import domain.Employee;
import domain.Programmer;
import team.service.NameListService;
import team.service.TeamException;
import team.service.TeamService;

public class TeamView {

    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu() throws TeamException {

        boolean flag = true;
        char menu = 0;
        while(flag) {
            if (menu != '1') {
                listAllEmployee();
            }

            System.out.println("1: Team list 2: Adding team member 3: Removing team member 4: Exit (Please enter 1 to 4 only): ");
             menu = TSUtility.readMenuSelection();
            //Because at the TSUtility class , I was using c !='1' ,
            //therefore , I need to use case 1 , 2, 3 ,4
            switch(menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    removeMember();
                    break;
                case '4':
                    System.out.print("Making sure to exit(Y/N): ");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        flag = false;
                        System.out.println("Exiting....Later!");
                    }
                    break;

            }
        }
    }

    private void listAllEmployee() {
        System.out.println("List all the employee info");
        System.out.println("----------------------------------------------------------------------------------------------");

        Employee[] employees = listSvc.getAllEmployees();
        if (employees == null || employees.length == 0) {
            System.out.println("There have no such as Employee.");
        } else {
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    private void getTeam() {
        System.out.println("Checking the development team info.");

        System.out.println("---------------------------------------Member list---------------------------------------\n");

        Programmer[] team = teamSvc.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("There have no member in the team right now!");
        } else {
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailsForTeam());
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    private void addMember() throws TeamException {
        System.out.println("Adding the member into development team.");
        System.out.println("---------------Adding member---------------");
        System.out.println("Please enter the new member current id: ");
        int id = TSUtility.readInt();

        try {
            Employee e = listSvc.getEmployee(id);
            teamSvc.addMember(e);
            System.out.println("Adding successfully");
        } catch (TeamException e) {
            System.out.println("Adding unsuccessful : " + e.getMessage());
        }
        //Press Enter to continue...
        TSUtility.readReturn();
    }

    private void removeMember() throws TeamException {
        System.out.println("Removing the current member from the development team.");
        System.out.println("---------------Removing member---------------");
        System.out.println("Please enter employee id you want to remove: ");
        int memberId = TSUtility.readInt();

        System.out.println("Press (Y) to confirm , else , Press (N): ");
        char isRemove = TSUtility.readConfirmSelection();
        if (isRemove == 'N') {
            return;
        } else {

        }
        try {
            teamSvc.removeMember(memberId);
            System.out.println("Remove successfully");
        } catch (TeamException e) {
            System.out.println("Removing unsuccessful : " + e.getMessage());
        }
        //Press Enter to continue...
        TSUtility.readReturn();

    }

    public static void main(String[] args) throws TeamException {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}
