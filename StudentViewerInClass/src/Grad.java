/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matt
 */
public class Grad extends Stu {
    private String degree;
    private String concat;
    
    public Grad(String name, String major, String degree, String gender, String tuition, String[] attributes) {
       super(name,major,gender,tuition,attributes);
       this.degree = degree;
    }
    public String getDegree() {
       return degree;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }
    @Override
    public String toString() {
        concat = getName() + " (" + getGender() + ") - " + getMajor() + " - " + degree + "\n"
                + "\t- " + getTuition() + "\n";
        if (getLiving().length() > 0) {
            concat += "\t- " + getLiving() + "\n";
        }
        if (getAid().length() > 0) {
            concat += "\t- " + getAid() + "\n";
        }
        if (getHope().length() > 0) {
            concat += "\t- " + getHope() + "\n";
        }
        return concat;
    }
}
