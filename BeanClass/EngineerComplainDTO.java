package BeanClass;

public class EngineerComplainDTO {
    private int ENId;
    private String ENName;
    private String ENCategory;
    private int EComplainId;

    private String ECName;
    private String ComplainStatus;

    public EngineerComplainDTO() {

    }

    public EngineerComplainDTO(int ENId, String ENName, String ENCategory, int EComplainId, String ECName, String complainStatus) {
        this.ENId = ENId;
        this.ENName = ENName;
        this.ENCategory = ENCategory;
        this.EComplainId = EComplainId;
        this.ECName = ECName;
        this.ComplainStatus = complainStatus;
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

    public String getENCategory() {
        return ENCategory;
    }

    public void setENCategory(String ENCategory) {
        this.ENCategory = ENCategory;
    }

    public int getEComplainId() {
        return EComplainId;
    }

    public void setEComplainId(int EComplainId) {
        this.EComplainId = EComplainId;
    }

    public String getECName() {
        return ECName;
    }

    public void setECName(String ECName) {
        this.ECName = ECName;
    }

    public String getComplainStatus() {
        return ComplainStatus;
    }

    public void setComplainStatus(String complainStatus) {
        ComplainStatus = complainStatus;
    }

    @Override
    public String toString() {
        return "EngineerComplainDTO{" +
                "ENId=" + ENId +
                ", ENName='" + ENName + '\'' +
                ", ENCategory='" + ENCategory + '\'' +
                ", EComplainId=" + EComplainId +
                ", ECName=" + ECName +
                ", ComplainStatus='" + ComplainStatus + '\'' +
                '}';
    }
}
