public class feeCal {

    private int homeFee = 600; //tl
    private int abroadFee = 1000; //tl
    private String name;
    private double totalFee = 0;
    private boolean isStudentHome = false;
    private int numberOfCourses = 0;


    public feeCal(String name, boolean isStudentHome, int numberOfCourses) {
        this.name = name;
        this.isStudentHome = isStudentHome;
        this.numberOfCourses = numberOfCourses;
    }
    public double calculateFee(){
        int pricePerCourse;

        if (this.isStudentHome){
            pricePerCourse = homeFee;
        }else {
            pricePerCourse = abroadFee;
        }
        totalFee = pricePerCourse * numberOfCourses;
        return totalFee;
    }

}
