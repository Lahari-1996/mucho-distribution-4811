package UseCases;

import DAO.HodDao;
import DAOImpl.HODdaoImpl;

import java.util.Scanner;

public class HODlogin {

    public static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter username: ");
        String username=sc.next();
        System.out.println("Enter password");
        String password=sc.next();

        HodDao hdao=new HODdaoImpl();
        String hoddetail=hdao.loginHOD(username,password);

        System.out.println(hoddetail);
        HodUsecase.optionsHOD();

    }

}
