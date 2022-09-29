package DAO;

import BeanClass.Engineer;

public interface HodDao {

    public String loginHOD(String userName,String password);
    public String  registerEngineer(Engineer engineer);
}
