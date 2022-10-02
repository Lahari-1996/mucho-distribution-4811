package UseCases;

import BeanClass.Complain;
import BeanClass.Engineer;
import BeanClass.EngineerComplainDTO;
import DAO.HodDao;
import DAOImpl.HODdaoImpl;
import Exceptions.ComplainException;
import Exceptions.EngineerException;
import Utility.Online_Hardware_Software_App;

import java.util.List;
import java.util.Scanner;

public class HodUsecase {
    public static void optionsHOD() {
        Scanner sc=new Scanner(System.in);
        HodDao hd=new HODdaoImpl();
        System.out.println("Select any option to continue");
        System.out.println("\n1. Register new Engineer\n2. List of all Engineers\n3. Delete an Engineer" +
                "\n4. See all complains\n5. Assign problem to Engineer\n6. Exit");
        int opt=sc.nextInt();

        switch (opt){
            case 1:
                System.out.println("Enter Engineer's detail");
                System.out.println("Enter Engineer Id: ");
                int id= sc.nextInt();
                System.out.println("Enter Engineer name: ");
                String name=sc.next();
                System.out.println("Enter Engineer email: ");
                String mail= sc.next();
                System.out.println("Enter Engineer password: ");
                String password=sc.next();
                System.out.println("Enter engineer Category: Hardware/Software ");
                String cat=sc.next();

                Engineer eng=new Engineer(id,name,mail,password,cat);
                String ans=hd.registerEngineer(eng);
                System.out.println(ans);
                HodUsecase.optionsHOD();
                break;

            case 2:
                try {
                    List<Engineer>engineers=hd.getRegisteredEngineers();

                    engineers.forEach(e-> System.out.println(e));

                } catch (EngineerException e) {
                    System.out.println(e.getMessage());
                }

                HodUsecase.optionsHOD();
                break;

            case 3:
                System.out.println("Enter Engineer Id to delete the engineer: ");
                int enid=sc.nextInt();
                String delt=hd.removeEngineers(enid);
                System.out.println(delt);
                HodUsecase.optionsHOD();
                break;

            case 4:
                try {
                    List<Complain>complains=hd.getAllRaisedComplain();
                     complains.forEach(c-> System.out.println(c));


                } catch (ComplainException e) {
                    System.out.println(e.getMessage());
                }

                HodUsecase.optionsHOD();
                break;

            case 5:
                System.out.println("Enter complain  detail");
                System.out.println("Enter Engineer Id: ");
                int engid= sc.nextInt();
                System.out.println("Enter Engineer name: ");
                String engname=sc.next();
                System.out.println("Enter engineer Category: Hardware/Software ");
                String engcat=sc.next();
                System.out.println("Enter Complain Id: ");
                int comid= sc.nextInt();
                System.out.println("Enter Complain Category: Hardware/Software ");
                String comcat=sc.next();
                System.out.println("Enter complain status: ");
                String comstatus=sc.next();


                String ans2=hd.assignProblem(engid,engname,engcat,comid,comcat,comstatus);
                System.out.println(ans2);
                HodUsecase.optionsHOD();
                break;

            case 6:
                Online_Hardware_Software_App.mainpage();
                break;


        }
    }
}
