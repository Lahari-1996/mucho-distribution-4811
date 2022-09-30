package DAO;

import BeanClass.Complain;
import BeanClass.Engineer;
import BeanClass.EngineerComplainDTO;
import Exceptions.ComplainException;
import Exceptions.EngineerException;

import java.util.List;

public interface HodDao {

    public String loginHOD(String userName,String password);
    public String  registerEngineer(Engineer engineer);
    public List<Engineer>getRegisteredEngineers() throws EngineerException;
    public String removeEngineers(int engId);
    public List<Complain>getAllRaisedComplain() throws ComplainException;
    public String assignProblem(int engId,String engName,String engCat,int complainId,String complainStatus);
}
