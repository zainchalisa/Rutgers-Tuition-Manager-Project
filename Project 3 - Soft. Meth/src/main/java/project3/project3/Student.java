package project3.project3;

/**
 * This class creates student objects with the given fields Profile, Major,
 * and Date.
 *
 * @author zainchalisa
 * @author nanaafriyie
 */
public abstract class Student implements Comparable {

    // Made visibility type protected so subclasses can access
    // these instance values
    protected Profile profile;
    protected Major major;
    protected int creditCompleted;

    public static final int THIRTY = 30;
    public static final int SIXTY = 60;
    public static final int NINETY = 90;
    public static final int MIN_CREDITS = 3;
    public static final int SUPER_MAX_CREDITS = 24;

    // Superclass needs default constructor for subclass to call on

    /**
     * This method sets the profile based off user inputs
     *
     * @param profile profile of the student (first, last, dob)
     */
    public Student(Profile profile) {
        this.profile = profile;
    }

    /**
     * Creates a student object with the given parameters
     *
     * @param profile         profile of the student (first, last, dob)
     * @param major           major of the student
     * @param creditCompleted credits completed towards major of student
     */
    public Student(Profile profile, Major major, int creditCompleted) {
        this.profile = profile;
        this.major = major;
        this.creditCompleted = creditCompleted;
    }

    public boolean isValid(int creditEnrolled) {
        if (creditEnrolled < MIN_CREDITS || creditEnrolled >
                SUPER_MAX_CREDITS) {
            return false;
        } else {
            return true;
        }
    } //polymorphism // don't have to override in all subclasses

    public abstract double tuitionDue(int creditsEnrolled);
    //polymorphism // implement differently in subclasses

    public abstract boolean isResident(); //polymorphism

    /**
     * Getter method for credits the student completed
     *
     * @return returns the credits the student completed
     */
    public int getCreditCompleted() {
        return this.creditCompleted;
    }


    /**
     * Provides the standing of thr student depending on credits completed
     *
     * @return returns the standing of the student
     */
    public Standing getStanding() {

        int credits = this.creditCompleted;
        if (credits < THIRTY) {
            return Standing.Freshman;
        } else if (credits >= THIRTY && credits < SIXTY) {
            return Standing.Sophomore;
        } else if (credits >= SIXTY && credits < NINETY) {
            return Standing.Junior;
        } else {
            return Standing.Senior;
        }
    }

    /**
     * Getter method for the students profile
     *
     * @return returns the profile of the student
     */
    public Profile getProfile() {
        return this.profile;
    }

    /**
     * Getter method for the students major
     *
     * @return returns the major of the student
     */
    public Major getMajor() {
        return this.major;
    }

    /**
     * Setter method used to change the students major
     *
     * @param major major which your changing
     */
    public void setMajor(Major major) {
        this.major = major;
    }

    /**
     * Overrides the toString() method for the student object
     *
     * @return returns the student object
     */
    @Override
    public String toString() {
        return "" + profile + " " + "(" + getMajor().getCoreCode() + " " +
                major + " " + getMajor().getSchool() + ") " +
                "credits completed: " + creditCompleted + " (" +
                getStanding() + ")";
    }

    /**
     * Compares two student objects to one another
     *
     * @param obj the object to be compared.
     * @return returns if the object is greater, less, or equal
     */
    public int compareTo(Object obj) {
        Student student = (Student) obj;
        if (student.profile != null) {
            return this.profile.compareTo(student.profile);
        } else {
            return 1;
        }
    }

    /**
     * Overrides the equals method for a student object
     *
     * @param obj which object is checked if it's equal to another
     * @return return false if it's not a student
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            return (student.profile.equals(this.profile));
        } else {
            return false;
        }
    }

}