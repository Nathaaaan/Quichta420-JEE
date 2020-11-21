package Model.Services;

import Model.Beans.Tutor;
import Model.Beans.Intern;

/**
 *
 * @author Gohu
 */
public class Assign {

    private Tutor tutor;
    private Intern intern;
    private int internshipId;

    public Assign(Tutor tutor, Intern intern, int internshipId) {
        this.tutor = tutor;
        this.intern = intern;
        this.internshipId = internshipId;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Intern getIntern() {
        return intern;
    }

    public void setIntern(Intern intern) {
        this.intern = intern;
    }

    public int getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(int internshipId) {
        this.internshipId = internshipId;
    }
}
