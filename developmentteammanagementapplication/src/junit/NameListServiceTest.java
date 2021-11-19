package junit;


import domain.Employee;
import org.junit.Test;
import team.service.NameListService;
import team.service.TeamException;

/**
 * To test the NameListServiceTest class method
 */
public class NameListServiceTest {

    //To display all the employee info
    @Test
    public void testGetAllEmployees() {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length ; i++) {
            System.out.println(employees[i]);
        }
    }

    //To display the specific employee info by id
    @Test
    public void testGetEmployee() {
        NameListService service = new NameListService();
        int id = 104;
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
            //e as exception
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
