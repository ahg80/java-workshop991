package com.company;

public class EmployeeEntity {
    private String name;
    private String family;
    private int ID_code;//code melli
    private int education;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getID_code() {
        return ID_code;
    }

    public void setID_code(int ID_code) {
        this.ID_code = ID_code;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

}
