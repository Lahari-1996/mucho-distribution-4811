package DAOImpl;

import BeanClass.EngineerComplainDTO;
import DAO.EngineerDao;
import Exceptions.ComplainException;
import Exceptions.EngineerException;
import Utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EngineerDAOImpl implements EngineerDao {
    @Override
    public String loginEngineer(String userName, String password) throws EngineerException {
        String msg="Login Failed";


        try( Connection con= DBUtil.provideConnection()) {
            PreparedStatement ps=con.prepareStatement("select * from Engineer where ENEmail=? AND ENNPassword=?");
            ps.setString(1,userName);
            ps.setString(2,password);

            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                String eng=rs.getString("ENName");
                msg="Welcome "+eng;
            }
            else {
                throw new EngineerException("Wrong userid/password");
            }


        } catch (SQLException e) {
            e.getMessage();
        }


        return msg;
    }

    @Override
    public List<EngineerComplainDTO> viewAssignedComplain(int id) throws ComplainException {

        List<EngineerComplainDTO>ecd=new ArrayList<>();
        try(Connection con=DBUtil.provideConnection()){
            PreparedStatement ps=con.prepareStatement("select * from EngineerComplainDTO where ENId=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int engId=rs.getInt("ENId");
                String engName=rs.getString("ENName");
                String engCat=rs.getString("ENCategory");
                int compId= rs.getInt("EComplainId");
                String compName=rs.getString("CName");
                String compStatus=rs.getNString("ComplainStatus");

                EngineerComplainDTO ed=new EngineerComplainDTO(engId,engName,engCat,compId,compName,compStatus);
                ecd.add(ed);
            }

        } catch (SQLException e) {
            throw new ComplainException("There is no assigned complain");
        }

        return ecd;
    }

    @Override
    public String updateStatus(int ComplainId,String sts) {
        String msg="Nothing to update";
        try(Connection con=DBUtil.provideConnection()) {
            PreparedStatement ps=con.prepareStatement("Update EngineerComplainDTO set ComplainStatus=? where EComplainId=?");
            ps.setString(1,sts);
            ps.setInt(2,ComplainId);

            int ans=ps.executeUpdate();
            if(ans>0)
            {
                msg="Complain Status updated successfully";
            }

        } catch (SQLException e) {
            e.getMessage();
        }

        return msg;
    }

    @Override
    public List<EngineerComplainDTO> viewAttendedComplain(int id) throws ComplainException {

        List<EngineerComplainDTO>ecd=new ArrayList<>();
        try(Connection con=DBUtil.provideConnection()){
            PreparedStatement ps=con.prepareStatement("select * from EngineerComplainDTO where ENId=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int engId=rs.getInt("ENId");
                String engName=rs.getString("ENName");
                String engCat=rs.getString("ENCategory");
                int compId= rs.getInt("EComplainId");
                String compName=rs.getString("CName");
                String compStatus=rs.getNString("ComplainStatus");

                EngineerComplainDTO ed=new EngineerComplainDTO(engId,engName,engCat,compId,compName,compStatus);
                ecd.add(ed);
            }

        } catch (SQLException e) {
            throw new ComplainException("There is no assigned complain");
        }

        return ecd;

    }

    @Override
    public String changePassword(int ENId,String password) {
        String msg="Can not change";

        try (Connection con=DBUtil.provideConnection()){
            PreparedStatement ps=con.prepareStatement("Update Engineer set ENNPassword=? where ENId=?");
            ps.setString(1,password);
            ps.setInt(2,ENId);

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
