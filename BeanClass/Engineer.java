package BeanClass;

public class Engineer {
    private int engID;
    private String engName;
    private String engPassword;
    private int problemId;
    private String problemType;

    public Engineer() {

    }

    public Engineer(int engID, String engName, String engPassword, int problemId, String problemType) {
        this.engID = engID;
        this.engName = engName;
        this.engPassword = engPassword;
        this.problemId = problemId;
        this.problemType = problemType;
    }
}
