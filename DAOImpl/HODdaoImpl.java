package DAOImpl;

import BeanClass.Complain;
import BeanClass.Engineer;
import DAO.HodDao;
import Exceptions.ComplainException;
import Exceptions.EngineerException;
import Utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HODdaoImpl implements HodDao {

    @Override
    public String loginHOD(String userName, String password) {

        String msg="Login Failed";


        try( Connection con= DBUtil.provideConnection()) {
            PreparedStatement ps=con.prepareStatement("select * from HOD where HODEmail=? AND HODPassword=?");
            ps.setString(1,userName);
            ps.setString(2,password);

            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                String hod=rs.getString("HODName");
                msg="Welcome "+hod;
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
    public String registerEngineer(Engineer engineer) {

        String msg="Registration Failed";

        try( Connection con= DBUtil.provideConnection()){

            PreparedStatement ps=con.prepareStatement("insert into Engineer values(?,?,?,?,?)");
            ps.setInt(1,engineer.getENId());
            ps.setString(2,engineer.getENName());
            ps.setString(3,engineer.getENEmail());
            ps.setString(4,engineer.getENNPassword());
            ps.setString(5,engineer.getENCategory());

            int ans=ps.executeUpdate();
            while(ans>0)
            {
                msg="Engineer registered sucessfully";
            }

        }catch(SQLException se){
            se.getMessage();
        }

        return msg;
    }

    @Override
    public List<Engineer> getRegisteredEngineers() throws EngineerException {
        List<Engineer>engineers=new ArrayList<>();
        try(Connection con=DBUtil.provideConnection()){
            PreparedStatement ps=con.prepareStatement("select * from Engineer");

            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int engineerId=rs.getInt("ENId");
                String engineerName=rs.getString("ENName");
                String engineerEmail=rs.getString("ENEmail");
                String engineerPassword=rs.getString("ENNPassword");
                String engineerCat=rs.getString("ENCategory");

                Engineer e1=new Engineer(engineerId,engineerName,engineerEmail,engineerPassword,engineerCat);
                 engineers.add(e1);
            }

        } catch (SQLException e) {
            throw new EngineerException("Could not register this entry");
        }

        return engineers;
    }

    @Override
    public String removeEngineers(int engId) {
         String msg="Data not found with this id";
         try (Connection con=DBUtil.provideConnection()){

             PreparedStatement ps= con.prepareStatement("delete from Engineer where ENId=?");
             ps.setInt(1,engId);

             int ans=ps.executeUpdate();
             if(ans>0){
                 msg="Engineer deleted successfully";
             }

         } catch (SQLException e) {
             e.getMessage();
         }

        return msg;
    }

    @Override
    public List<Complain> getAllRaisedComplain() throws ComplainException {

        List<Complain>complain=new ArrayList<>();
        try(Connection con=DBUtil.provideConnection()){
            PreparedStatement ps=con.prepareStatement("select * from Complain");

            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int compId=rs.getInt("ComplainId");
                String complainName=rs.getString("CName");
                String complainCat=rs.getString("Catagory");

                Complain c1=new Complain(compId,complainName,complainCat);
                complain.add(c1);
            }

        } catch (SQLException e) {
            throw new ComplainException("There is no raised complain");
        }

        return complain;

    }

    @Override
    public String assignProblem(int engId, String engName, String engCat, int complainId, String complainStatus) {
        String msg="Can not assign";

        try (Connection con=DBUtil.provideConnection()){
            PreparedStatement ps=con.prepareStatement("insert into EngineerComplainDTO values(?,?,?,?,?)");
            ps.setInt(1,engId);
            ps.setString(2,engName);
            ps.setString(3,engCat);
            ps.setInt(4,complainId);
            ps.setString(5,complainStatus);

            int ans=ps.executeUpdate();
            if(ans>0){
                msg="Problem assigned successfully";
            }

        } catch (SQLException e) {
            e.getMessage();
        }

        return msg;
    }
}
