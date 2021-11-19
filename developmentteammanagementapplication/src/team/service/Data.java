package team.service;

// Before learning mySQL , it is the database.
public class Data {
    /*
    Different position have different number to represent
    The reason of using upper case is to avoid the confusion between
    static variable and local variable in NameListService constructor
    */
    public static final int EMPLOYEE = 10;
    public static final int PROGRAMMER = 11;
    public static final int DESIGNER = 12;
    public static final int ARCHITECT = 13;

    /*
    Different os have different number to represent
    The reason of using upper case is to avoid the confusion between
    static variable and subclass Window in domain package
    */
    public static final int WINDOW = 21;
    public static final int IOS = 22;

    /*
     Employee  :  position number(10), id, name, age, salary
     Programmer:  position number(11), id, name, age, salary
     Designer  :  position number(12), id, name, age, salary, bonus
     Architect :  position number(13), id, name, age, salary, bonus, stock
     */
    public static final String[][] EMPLOYEES = {
        {"10", "1", "Marinette Esha", "22", "3000"},
        {"13", "2", "Tuulikki Lelio", "32", "18000", "15000", "2000"},
        {"11", "3", "Mahmud Riikka", "23", "7000"},
        {"11", "4", "Lawrence Ng", "24", "7300"},
        {"13", "5", "Tihomir Fergus", "30", "19800", "15000", "2500"},
        {"12", "6", "Jingquan Fong", "26", "9800", "5500"},
        {"12", "7", "Chunkit Yip", "27", "9600", "4800"}
    };
    /*
     The following equipments array corresponds to the elements of the employees array above
     Window  :21, model
     IOS     :22, model
    */
    public static final String[][] EQUIPMENTS = {
        {},
        {"22", "macIOS 12"},
        {"21", "window 10"},
        {"21", "window 10"},
        {"21", "window 10"},
        {"21", "window 10"},
        {"22", "macIOS 11"},
        {"21", "window 10"},
    };
}
