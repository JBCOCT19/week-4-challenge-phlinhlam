public class FacultyClassConnection {

    private String fcConnID;
    private String facID;
    private String facClassConID;

    public FacultyClassConnection() {
    }

    public FacultyClassConnection(String fcConnID, String facID, String facClassConID) {
        this.fcConnID = fcConnID;
        this.facID = facID;
        this.facClassConID = facClassConID;
    }

    public String getFcConnID() {
        return fcConnID;
    }

    public void setFcConnID(String fcConnID) {
        this.fcConnID = fcConnID;
    }

    public String getFacID() {
        return facID;
    }

    public void setFacID(String facID) {
        this.facID = facID;
    }

    public String getFacClassConID() {
        return facClassConID;
    }

    public void setFacClassConID(String facClassConID) {
        this.facClassConID = facClassConID;
    }
}
