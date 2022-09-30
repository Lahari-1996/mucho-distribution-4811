package BeanClass;

public class Complain {
    private int ComplainId;
    private String CName;
    private String Catagory;

    public Complain() {

    }

    public Complain(int complainId, String CName, String catagory) {
        ComplainId = complainId;
        this.CName = CName;
        Catagory = catagory;
    }

    public int getComplainId() {
        return ComplainId;
    }

    public void setComplainId(int complainId) {
        ComplainId = complainId;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCatagory() {
        return Catagory;
    }

    public void setCatagory(String catagory) {
        Catagory = catagory;
    }

    @Override
    public String toString() {
        return "Complain{" +
                "ComplainId=" + ComplainId +
                ", CName='" + CName + '\'' +
                ", Catagory='" + Catagory + '\'' +
                '}';
    }
}
