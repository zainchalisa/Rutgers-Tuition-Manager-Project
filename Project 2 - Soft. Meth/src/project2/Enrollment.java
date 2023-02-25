package project2;

public class Enrollment {
    private EnrollStudent[] enrollStudents;
    private int size;

    public static final int ARRAY_ADDITIVE = 1;

    public Enrollment() {
        this.enrollStudents = new EnrollStudent[4];
        this.size = 0;
    }
    public void add(EnrollStudent enrollStudent){
        EnrollStudent[] newEnrollment = new EnrollStudent[enrollStudents.length + ARRAY_ADDITIVE];
        for (int i = 0; i < newEnrollment.length - 1; i++) {
            newEnrollment[i] = this.enrollStudents[i];
        }

        this.enrollStudents = newEnrollment;
        enrollStudents[size] = enrollStudent;
        size++;

    } //add to the end of array
    //move the last one in the array to replace the deleting index position
    public void remove(EnrollStudent enrollStudent){

        int indexHolder = 0;

        if(contains(enrollStudent)){
            for (int i = 0; i < size; i++) {
                if(enrollStudents[i] == enrollStudent){
                    indexHolder = i;
                    enrollStudents[i] = null;
                }
            }
        }

        for (int i = indexHolder; i < size - 1; i++) {
            if (i + 1 < size) {
                enrollStudents[i] = enrollStudents[i + 1];
            } else {
                enrollStudents[size] = null;
            }
        }
        size--;
    }

    public boolean contains(EnrollStudent enrollStudent){
        for (int i = 0; i < size; i++) {
            if(enrollStudents[i] == enrollStudent){
                return true;
            }
        }
        return false;
    }
    public void print() {
        for (int i = 0; i < size; i++){
            System.out.println(enrollStudents[i]);
        }
    } //print the array as is without sorting
}