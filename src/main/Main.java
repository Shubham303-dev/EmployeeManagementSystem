package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bean.Employee;
import dao.EmployeeDaoImpl;
import dao.EmployeeDaoIntrf;

public class Main {
    public static void main(String[] args) {
        String name;
        int id;
        EmployeeDaoIntrf dao=new EmployeeDaoImpl();
        System.out.println("Welcome to Employee management application");

    try {
        	
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println("1. Add Employee\n" +
                    "2. Show All Employee\n" +
                    "3. Show Employee based on id \n" +
                    "4. Update the employee\n" +
                    "5. Delete the employee\n");

            System.out.println("Enter Choice: ");
            int ch=Integer.parseInt(br.readLine());
            switch (ch){
                case 1:
                    Employee emp=new Employee();
                    System.out.println("Enter ID : ");
                     id=Integer.parseInt(br.readLine());
                    System.out.println("Enter name ");
                     name=(String)br.readLine();
                    System.out.println("Enter Salary ");
                    double salary=Double.parseDouble(br.readLine());
                    System.out.println("Enter age");
                    int age=Integer.parseInt(br.readLine());
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    dao.createEmployee(emp);
                    break;
                case 2:
                    dao.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter id to show the details ");
                    int empid=Integer.parseInt(br.readLine());
                    dao.showEmployeeBasedOnID(empid);
                    break;
                case 4:
                    System.out.println("Enter id to update the details");
                    int empid1=Integer.parseInt(br.readLine());
                    System.out.println("Enter the new name");
                     name=(String)br.readLine();
                    dao.updateEmployee(empid1,name);
                    break;
                case 5:
                    System.out.println("Enter the id to delete");
                    id=Integer.parseInt(br.readLine());
                    dao.deleteEmployee(id);
                    break;

                case 6:
                    System.out.println("Thank you for using our Application !!!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice !");
                    break;


            }

        }while (true);
    }
    
    catch(IOException e) {
    	e.printStackTrace();
    }
        
    }
}