package UseCases;

import DAO.EmployeeDao;
import DAO.EngineerDao;
import DAOImpl.EmployeeDAOImpl;
import DAOImpl.EngineerDAOImpl;

import java.util.Scanner;

public class EmployeeLogin {

    public static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter username: ");
        String username=sc.next();
        System.out.println("Enter password");
        String password=sc.next();

        EmployeeDao empdao=new EmployeeDAOImpl();
        String empdetail=empdao.loginEmployee(username,password);

        System.out.println(empdetail);

EmployeeUsecase.EmployeeOption();
    }

}
