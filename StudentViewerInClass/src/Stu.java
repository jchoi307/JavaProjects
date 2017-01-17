/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matt
 */
public class Stu {
    
    private String name;
    private String major;
    private String gender;
    private String tuition;
    private String living;
    private String aid;
    private String hope;
    private String concat;
    public static String school = "GPC";
   
    public Stu(String name, String major, String gender, String tuition, String[] attributes) {
       this.name = name;
       this.major = major;
       this.gender = gender;
       this.tuition = tuition;
       this.living = attributes[0];
       this.aid = attributes[1];
       this.hope = attributes[2];
       
    }
    public String getName() {
       return name;
    }
    public String getMajor() {
       return major;
    }
    public String getGender() {
        return gender;
    }
    public String getTuition() {
        return tuition;
    }
    public String getLiving() {
        return living;
    }
    public String getAid() {
        return aid;
    }
    public String getHope() {
        return hope;
    }
    @Override
    public String toString() {
        concat = name + " (" + gender + ") - " + major + " - Undergraduate\n"
                + "\t- " + tuition + "\n";
        if (living.length() > 0) {
            concat += "\t- " + living + "\n";
        }
        if (aid.length() > 0) {
            concat += "\t- " + aid + "\n";
        }
        if (hope.length() > 0) {
            concat += "\t- " + hope + "\n";
        }
        return concat;
    }
}
