package UseCases;

import BeanClass.Complain;
import BeanClass.EngineerComplainDTO;
import DAO.EmployeeDao;
import DAO.EngineerDao;
import DAOImpl.EmployeeDAOImpl;
import DAOImpl.EngineerDAOImpl;
import Exceptions.ComplainException;
import Utility.Online_Hardware_Software_App;

import java.util.List;
import java.util.Scanner;

public class EmployeeUsecase {
    public static void EmployeeOption(){

        Scanner sc=new Scanner(System.in);
        EmployeeDao em=new EmployeeDAOImpl();
        System.out.println("Select any option to continue");
        System.out.println("\n1. Register Complain\n2. View complain status\n3. View All Probllems\n4. Change Password\n5. Main Menu");
        int opt=sc.nextInt();

        switch (opt){
            case 1:
                System.out.println("Complain name: ");
                String cn=sc.next();
                System.out.println("Enter Complain Category: ");
                String cat=sc.next();

                String ans=em.registerComplain(cn,cat);
                System.out.println(ans);

                EmployeeUsecase.EmployeeOption();
                break;

            case 2:
                System.out.println("Enter Complain id to view status: ");
                int id=sc.nextInt();
                List<EngineerComplainDTO>lists=em.viewComplainStatus(id);
                System.out.println(lists);

                EmployeeUsecase.EmployeeOption();
                break;

            case 3:
                System.out.println("Enter complainer name");
                String cn2=sc.next();
                try {
                    List<Complain>allcomp=em.viewAllComplain(cn2);
                    System.out.println(allcomp);
                } catch (ComplainException e) {
                    System.out.println(e.getMessage());
                }
                EmployeeUsecase.EmployeeOption();
                break;

            case 4:
                System.out.println("Enter Employee id to change password: ");
                int id4=sc.nextInt();
                System.out.println("Enter new password: ");
                String pass=sc.next();

                String ans4=em.changePassword(id4,pass);
                System.out.println(ans4);

                EmployeeUsecase.EmployeeOption();
                break;

            case 5:
                Online_Hardware_Software_App.mainpage();
                break;


        }



    }
}
