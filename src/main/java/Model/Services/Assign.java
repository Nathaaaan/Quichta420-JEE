package Model.Services;

import Model.Beans.Tutor;
import Model.Beans.Intern;
import Model.Beans.InternshipInfo;

/**
 *
 * @author Gohu
 */
public class Assign {

    private Tutor tutor;
    private Intern intern;
    private InternshipInfo internshipInfo;

    public Assign(Tutor tutor, Intern intern, InternshipInfo internshipInfo) {
        this.tutor = tutor;
        this.intern = intern;
        this.internshipInfo = internshipInfo;
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

    public InternshipInfo getInternshipInfo() {
        return internshipInfo;
    }

    public void setInternshipInfo(InternshipInfo internshipInfo) {
        this.internshipInfo = internshipInfo;
    }
}
