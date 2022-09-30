package BeanClass;

public class Employee {
    private int EId;
    private String EName;
    private String EEmail;
    private String EPassword;

    public Employee() {

    }

    public Employee(int EId, String EName, String EEmail, String EPassword) {
        this.EId = EId;
        this.EName = EName;
        this.EEmail = EEmail;
        this.EPassword = EPassword;
    }

    public int getEId() {
        return EId;
    }

    public void setEId(int EId) {
        this.EId = EId;
    }

    public String getEName() {
        return EName;
    }

    public void setEName(String EName) {
        this.EName = EName;
    }

    public String getEEmail() {
        return EEmail;
    }

    public void setEEmail(String EEmail) {
        this.EEmail = EEmail;
    }

    public String getEPassword() {
        return EPassword;
    }

    public void setEPassword(String EPassword) {
        this.EPassword = EPassword;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EId=" + EId +
                ", EName='" + EName + '\'' +
                ", EEmail='" + EEmail + '\'' +
                ", EPassword='" + EPassword + '\'' +
                '}';
    }
}
