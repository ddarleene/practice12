public class Student{
    String name;
    double currentScholarship;
    double newScholarship;
    public Student(String name, double currentScholarship, double newScholarship){
        this.name=name;
        this.currentScholarship=currentScholarship;
        this.newScholarship=newScholarship;
    }

    public String getName() {
        return name;
    }
    public double getCurrentScholarship() {
        return currentScholarship;
    }

    public double getNewScholarship() {
        return newScholarship;
    }
    public double getScholarshipIncrease(){
        return newScholarship-currentScholarship;
    }
}