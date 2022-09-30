package DAO;

import BeanClass.Engineer;
import BeanClass.EngineerComplainDTO;
import Exceptions.ComplainException;
import Exceptions.EngineerException;

import java.util.List;

public interface EngineerDao {

    public String loginEngineer(String userName,String password);
    public List<EngineerComplainDTO> viewAssignedComplain(int id) throws ComplainException;
    public String updateStatus(int ComplainId);
    public List<EngineerComplainDTO> viewAttendedComplain(int id) throws ComplainException;
    public String changePassword(int EId,String password);



}
