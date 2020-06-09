package com.example.shraddha.travellersguide;

public class userData
{
    private String fname;
    private String lname;
    private String contact_no;
    private String email;

    public userData() {
    }

    public String getFname() {
        return fname;
    }

    public userData(String fname, String lname, String contact_no, String email) {
        this.fname = fname;
        this.lname = lname;
        this.contact_no = contact_no;
        this.email = email;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }



    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "userData{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", contact_no='" + contact_no + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
