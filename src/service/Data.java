package service;


public class Data {
    public static final int EMPLOYEE = 10;
    public static final int PROGRAMMER = 11;
    public static final int DESIGNER = 12;
    public static final int ARCHITECT = 13;

    public static final int PC = 21;
    public static final int LAPTOP = 22;
    public static final int PRINTER = 23;

    //Employee  :  10, id, name, age, salary
    //Programmer:  11, id, name, age, salary
    //Designer  :  12, id, name, age, salary, bonus
    //Architect :  13, id, name, age, salary, bonus, stock
    public static final String[][] EMPLOYEES = {
            {"11", "1", "ChunKit Yip", "22", "7000" },
            {"13", "2", "Lawrence Ng", "22", "18000", "15000", "2000"},
            {"11", "3", "Ming Meng", "22", "7000"},

    };

    //The following EQUIPMENTS array corresponds to the elements of the EMPLOYEES array above
    //PC      :21, model, display
    //Laptop  :22, model, price
    //Printer :23, name, type
    public static final String[][] EQUIPMENTS = {
            {"22", "MacBook Pro 13-inch Intel Core i5", "1699"},
            {"22", "MacBook Pro 16-inch  6-Core Processor 512GB Storage", "2199"},
            {"22", "Lenovo ThinkPad X1 Extreme", "1640"},
    };
}

