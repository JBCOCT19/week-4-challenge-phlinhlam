public class Class {
    private String classID;
    private String className;
    private String description;

    public Class() {
    }

    public Class(String classID, String className, String description) {
        this.classID = classID;
        this.className = className;
        this.description = description;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "-------------------------" +"\n" +
                "All Classes" + "\n" +
                "Class ID: " + getClassID() +"\n"+
                "Class Name: " + getClassName() + "\n";
    }
}
