package Model.Beans;

/**
 *
 * @author Gohu
 */
public class Intern {

    private int id;
    private String firstName;
    private String lastName;
    private String schoolGroup;

    public Intern(int id, String firstName, String lastName, String schoolGroup) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.schoolGroup = schoolGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSchoolGroup() {
        return schoolGroup;
    }

    public void setSchoolGroup(String schoolGroup) {
        this.schoolGroup = schoolGroup;
    }
}
