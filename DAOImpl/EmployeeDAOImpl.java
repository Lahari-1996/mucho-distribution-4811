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
    public String registerComplain(Complain complain) {

        String msg="Registration Failed";

        try( Connection con= DBUtil.provideConnection()){

            PreparedStatement ps=con.prepareStatement("insert into Complain values(?,?,?)");
            ps.setInt(1,complain.getComplainId());
            ps.setString(2,complain.getCName());
            ps.setString(3,complain.getCatagory());


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
    public String viewComplainStatus() {
        return null;
    }

    @Override
    public List<EngineerComplainDTO> viewAllComplain(int id) throws ComplainException {
        List<EngineerComplainDTO>ecd=new ArrayList<>();
        try(Connection con=DBUtil.provideConnection()){
            PreparedStatement ps=con.prepareStatement("select * from EngineerComplainDTO where EId=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int engId=rs.getInt("ENId");
                String engName=rs.getString("ENName");
                String engCat=rs.getString("ENCategory");
                int compId= rs.getInt("EComplainId");
                String compStatus=rs.getNString("ComplainStatus");

                EngineerComplainDTO ed=new EngineerComplainDTO(engId,engName,engCat,compId,compStatus);
                ecd.add(ed);
            }

        } catch (SQLException e) {
            throw new ComplainException("There is no complain");
        }

        return ecd;
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
