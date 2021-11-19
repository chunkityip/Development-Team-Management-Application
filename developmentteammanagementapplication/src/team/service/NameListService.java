package team.service;


import domain.*;

//if not import Data package , it needs to write DATA.EMPLOYEES.length in the Constructor
import static team.service.Data.*;


public class NameListService  {

    private Employee[] employees;

    /**
     * Structure an employees array to the corresponding size according to the Date class.
     *
     * Moreover, build an objects based on the Date class
     * ( Employee, Programmer, Designer, and Architect) and other Equipment subclasses.
     *
     * Finally, store those objects into array.
     *
     */
    public NameListService() {
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
            /**
            In Data CLass , the number represent are store as String.

             position number(10)        id                      name                                age                      salary
             {"10" is EMPLOYEES[i][0], "1" is EMPLOYEES[i][1], "Marinette Esha" is EMPLOYEES[i][2], "22" is EMPLOYEES[i][3], "3000" is EMPLOYEES[i][4]}.
            Therefore,  need to use parseInt() to change String to Integer value.
             */
            int position = Integer.parseInt(EMPLOYEES[i][0]);
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            int salary = Integer.parseInt(EMPLOYEES[i][4]);

            Equipment equipment;
            double bonus;
            int stock;

            switch (position) {
                /**
                 * if position is EMPLOYEE , store the info into Employee object.
                 * if position is PROGRAMMER , store the info into Programmer object.
                 * if position is DESIGNER , store the info into Designer object.
                 * if position is ARCHITECT , store the info into Architect object.
                 */
                case EMPLOYEE://10
                    employees[i] = new Employee(id , name , age , salary);
                    break;
                case PROGRAMMER://11
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id , name , age , salary , equipment);
                    break;
                case DESIGNER://12
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Desinger(id , name , age , salary , equipment , bonus);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus , stock);
                    break;
            }
        }
    }

    //Getting the equipment from Data  static variable array call EQUIPMENTS[][]
    private Equipment createEquipment(int index) {
        /**
         * In Data CLass , the number represent are store as String.
         *
         *  os   version
         * "22", "macIOS 12"
         * Therefore,  need to use parseInt() to change String to Integer value.
         */
            int os = Integer.parseInt(EQUIPMENTS[index][0]);
            String version = EQUIPMENTS[index][1];
            switch (os) {
                case WINDOW://21
                    return new Window(version);
                case IOS://22
                    return new Ios(version);
            }
            return null;
    }
    /**
     * Getting all employee
     * @return
     */
    public Employee[] getAllEmployees() {
        return employees;
    }
    /**
     * Getting the employee id from employee object
     * @param id
     * @return
     */

    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        //User Defined Exceptions
        throw new TeamException("Can't find the Employee you looking out!");
    }
}
