package BeanClass;

public class Engineer {
    private int ENId;
    private String ENName;
    private String ENEmail;
    private String ENNPassword;
    private String ENCategory;

    public Engineer() {

    }

    public Engineer(int ENId, String ENName, String ENEmail, String ENNPassword, String ENCategory) {
        this.ENId = ENId;
        this.ENName = ENName;
        this.ENEmail = ENEmail;
        this.ENNPassword = ENNPassword;
        this.ENCategory = ENCategory;
    }

    public int getENId() {
        return ENId;
    }

    public void setENId(int ENId) {
        this.ENId = ENId;
    }

    public String getENName() {
        return ENName;
    }

    public void setENName(String ENName) {
        this.ENName = ENName;
    }

    public String getENEmail() {
        return ENEmail;
    }

    public void setENEmail(String ENEmail) {
        this.ENEmail = ENEmail;
    }

    public String getENNPassword() {
        return ENNPassword;
    }

    public void setENNPassword(String ENNPassword) {
        this.ENNPassword = ENNPassword;
    }

    public String getENCategory() {
        return ENCategory;
    }

    public void setENCategory(String ENCategory) {
        this.ENCategory = ENCategory;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "ENId=" + ENId +
                ", ENName='" + ENName + '\'' +
                ", ENEmail='" + ENEmail + '\'' +
                ", ENNPassword='" + ENNPassword + '\'' +
                ", ENCategory='" + ENCategory + '\'' +
                '}';
    }

}
