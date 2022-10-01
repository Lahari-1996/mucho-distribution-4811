package UseCases;


import DAO.EngineerDao;
import DAOImpl.EngineerDAOImpl;
import Exceptions.EngineerException;

import java.util.Scanner;

public class EngineerLogin {
    public static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter username: ");
        String username=sc.next();
        System.out.println("Enter password");
        String password=sc.next();

        EngineerDao endao=new EngineerDAOImpl();
        String engdetail= null;
        try {
            engdetail = endao.loginEngineer(username,password);
            System.out.println(engdetail);

            EngineerUsecase.optionsEngineer();
        } catch (EngineerException e) {
            System.out.println(e.getMessage());;
        }




    }
}
