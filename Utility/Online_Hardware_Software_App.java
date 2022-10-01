package Utility;

import BeanClass.Employee;
import BeanClass.Engineer;
import DAO.EmployeeDao;
import DAOImpl.EmployeeDAOImpl;
import UseCases.EmployeeLogin;
import UseCases.EngineerLogin;
import UseCases.HODlogin;
import UseCases.HodUsecase;

import java.util.Scanner;

public class Online_Hardware_Software_App {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Hardware & Software Management World");
        System.out.println("Select any option to continue");
        System.out.println
                ("\n1. Login as HOD\n2. Login as an Engineer\n3. Register as an Employee\n4. Login as an Employee\n5. Exit");
        int opt=sc.nextInt();
        switch(opt){
            case 1:
                HODlogin.main();
                break;

            case 2:
                EngineerLogin.main();
                break;

            case 3:
                EmployeeDao emd=new EmployeeDAOImpl();
                System.out.println("Enter Employee's detail");
                System.out.println("Enter Employee Id: ");
                int id= sc.nextInt();
                System.out.println("Enter Employee name: ");
                String name=sc.next();
                System.out.println("Enter Employee email: ");
                String mail= sc.next();
                System.out.println("Enter Employee password: ");
                String password=sc.next();


                Employee emp=new Employee(id,name,mail,password);
                System.out.println(emd.registerEmployee(emp));
                System.out.println("Enter to login: ");
                EmployeeLogin.main();
                break;

            case 4:
                EmployeeLogin.main();
                break;

            case 6:

                break;

        }
        System.out.println("Thank You for visiting");

    }

}
