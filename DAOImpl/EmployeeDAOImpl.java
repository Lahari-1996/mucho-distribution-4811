package DAOImpl;

import BeanClass.Complain;
import BeanClass.Employee;
import BeanClass.EngineerComplainDTO;
import DAO.EmployeeDao;
import Exceptions.ComplainException;
import Utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDao {
    @Override
    public String registerEmployee(Employee employee) {
        String msg="Registration Failed";

        try( Connection con= DBUtil.provideConnection()){

            PreparedStatement ps=con.prepareStatement("insert into Employee values(?,?,?,?)");
            ps.setInt(1,employee.getEId());
            ps.setString(2,employee.getEName());
            ps.setString(3,employee.getEEmail());
            ps.setString(4,employee.getEPassword());


            int ans=ps.executeUpdate();
            while(ans>0)
            {
                msg="Employee registered sucessfully";
            }

        }catch(SQLException se){
            se.getMessage();
        }

        return msg;
    }

    @Override
    public String loginEmployee(String userName, String password) {
        String msg="Login Failed";


        try( Connection con= DBUtil.provideConnection()) {
            PreparedStatement ps=con.prepareStatement("select * from Employee where EEmail=? AND EPassword=?");
            ps.setString(1,userName);
            ps.setString(2,password);

            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                String emp=rs.getString("EName");
                msg="Welcome "+emp;
            }
            else {
                msg="Wrong Username/Password";
            }


        } catch (SQLException e) {
            e.getMessage();
        }


        return msg;
    }

    @Override
    public String registerComplain(String cname,String ccat) {

        String msg="Registration Failed";

        try( Connection con= DBUtil.provideConnection()){

            PreparedStatement ps=con.prepareStatement("insert into Complain(CName,Catagory) values(?,?)");
            ps.setString(1,cname);
            ps.setString(2,ccat);


            int ans=ps.executeUpdate();
            while(ans>0)
            {
                msg="Complain registered sucessfully";
            }

        }catch(SQLException se){
            se.getMessage();
        }

        return msg;

    }

    @Override
    public List<EngineerComplainDTO>viewComplainStatus(int cid) {

        List<EngineerComplainDTO>list=new ArrayList<>();
        try(Connection con=DBUtil.provideConnection()) {

            PreparedStatement ps=con.prepareStatement("select * from EngineerComplainStatus where ComplainId=?");
            ps.setInt(1,cid);

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int engid=rs.getInt("ENId");
                String engname=rs.getString("ENName");
                String engcat=rs.getString("ENCategory");
                int compid=rs.getInt("ComplainId");
                String compName=rs.getString("ECName");
                String compstatus=rs.getString("ComplainStatus");

                EngineerComplainDTO edto=new EngineerComplainDTO(engid,engname,engcat,compid,compName,compstatus);

                list.add(edto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return list;

    }

    @Override
    public List<Complain> viewAllComplain(String name) throws ComplainException {
        List<Complain>complains=new ArrayList<>();
        try(Connection con=DBUtil.provideConnection()){
            PreparedStatement ps=con.prepareStatement("select * from Complain where CName=?");
            ps.setString(1,name);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int compId=rs.getInt("ComplainId");
                String compName=rs.getString("CName");
                String compCat=rs.getString("Catagory");


                Complain c=new Complain(compId,compName,compCat);
                complains.add(c);
            }

        } catch (SQLException e) {
            throw new ComplainException("There is no complain");
        }

        return complains;
    }

    @Override
    public String changePassword(int EId, String password) {
        String msg="Can not change";

        try (Connection con= DBUtil.provideConnection()){
            PreparedStatement ps=con.prepareStatement("Update Employee set EPassword=? where EId=?");
            ps.setString(1,password);
            ps.setInt(2,EId);

            int ans=ps.executeUpdate();
            if(ans>0){
                msg="Password changed successfully";
            }

        } catch (SQLException e) {
            e.getMessage();
        }

        return msg;
    }
}
