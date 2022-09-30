package DAO;

import BeanClass.Complain;
import BeanClass.Employee;
import BeanClass.Engineer;
import BeanClass.EngineerComplainDTO;
import Exceptions.ComplainException;

import java.util.List;

public interface EmployeeDao {


    public String  registerEmployee(Employee employee);
    public String loginEmployee(String userName,String password);
    public String  registerComplain(Complain complain);
    public String viewComplainStatus();
    public List<EngineerComplainDTO> viewAllComplain(int id) throws ComplainException;
    public String changePassword(int ENId,String password);


}
