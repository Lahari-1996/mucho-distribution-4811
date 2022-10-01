package UseCases;



import BeanClass.Engineer;
import BeanClass.EngineerComplainDTO;
import DAO.EngineerDao;
import DAOImpl.EngineerDAOImpl;
import Exceptions.ComplainException;
import Exceptions.EngineerException;

import java.util.List;
import java.util.Scanner;

public class EngineerUsecase {
    public static void optionsEngineer() {
        Scanner sc=new Scanner(System.in);
        EngineerDao edi=new EngineerDAOImpl();
        System.out.println("Select any option to continue");
        System.out.println("\n1. View Assigned Complain by HOD\n2. Update complain status\n3. View Attended Problems\n4. Change Password\n5. Exit");
        int opt=sc.nextInt();

        switch (opt){
            case 1:
                System.out.println("Enter Engineer Id: ");
                int id=sc.nextInt();
                try {
                    List<EngineerComplainDTO> assignedcomplain=edi.viewAssignedComplain(id);

                    assignedcomplain.forEach(e-> System.out.println(e));

                } catch (ComplainException e) {
                    System.out.println(e.getMessage());
                }

             EngineerUsecase.optionsEngineer();
                break;

            case 2:

                System.out.println("Enter Complain id to update complain status");
                int sid=sc.nextInt();
                System.out.println("Enter current status");
                String sts=sc.next();
                String st=edi.updateStatus(sid,sts);
                System.out.println(st);

                EngineerUsecase.optionsEngineer();

                break;

            case 3:
                System.out.println("Enter Engineer Id to view attended complains: ");
                int iden=sc.nextInt();
                try {
                    List<EngineerComplainDTO>list=edi.viewAttendedComplain(iden);
                    System.out.println(list);
                } catch (ComplainException e) {
                    System.out.println(e.getMessage());
                }
              EngineerUsecase.optionsEngineer();
                break;

            case 4:
                System.out.println("Enter Engineer id to change password: ");
                int id3=sc.nextInt();
                System.out.println("Enter new password: ");
                String pass=sc.next();

                String ans=edi.changePassword(id3,pass);
                System.out.println(ans);

                EngineerUsecase.optionsEngineer();
                break;

            case 5:
                break;

        }

        }
}
