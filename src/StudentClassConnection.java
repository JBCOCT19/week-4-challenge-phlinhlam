public class StudentClassConnection {

    private String studClassID;
    private String studConID;
    private String classConID;
    private String dateEnroll;

    public StudentClassConnection() {
    }

    public StudentClassConnection(String studClassID, String studConID, String classConID) {
        this.studClassID = studClassID;
        this.studConID = studConID;
        this.classConID = classConID;
    }


    public String getStudClassID() {
        return studClassID;
    }

    public void setStudClassID(String studClassID) {
        this.studClassID = studClassID;
    }

    public String getStudConID() {
        return studConID;
    }

    public void setStudConID(String studConID) {
        this.studConID = studConID;
    }

    public String getClassConID() {
        return classConID;
    }

    public void setClassConID(String classConID) {
        this.classConID = classConID;
    }

    public String getDateEnroll() {
        return dateEnroll;
    }

    public void setDateEnroll(String dateEnroll) {
        this.dateEnroll = dateEnroll;
    }


}
