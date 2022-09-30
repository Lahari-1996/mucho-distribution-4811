package BeanClass;

public class HOD {
   private String HODName;
    private String Address;
    private String HODEmail;
    private String HODPassword;

    public HOD() {

    }

    public HOD(String HODName, String address, String HODEmail, String HODPassword) {
        this.HODName = HODName;
        Address = address;
        this.HODEmail = HODEmail;
        this.HODPassword = HODPassword;
    }

    public String getHODName() {
        return HODName;
    }

    public void setHODName(String HODName) {
        this.HODName = HODName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getHODEmail() {
        return HODEmail;
    }

    public void setHODEmail(String HODEmail) {
        this.HODEmail = HODEmail;
    }

    public String getHODPassword() {
        return HODPassword;
    }

    public void setHODPassword(String HODPassword) {
        this.HODPassword = HODPassword;
    }

    @Override
    public String toString() {
        return "HOD{" +
                "HODName='" + HODName + '\'' +
                ", Address='" + Address + '\'' +
                ", HODEmail='" + HODEmail + '\'' +
                ", HODPassword='" + HODPassword + '\'' +
                '}';
    }
}
