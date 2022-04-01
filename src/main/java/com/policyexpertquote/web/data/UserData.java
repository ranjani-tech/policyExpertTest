package com.policyexpertquote.web.data;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class UserData {
    private String salutation;
    private String firstname;
    private String lastname ;
    private Calendar dob;
    private String martialstatus;
    private String occupation;
    private String otheroccupation;
    private String mobileno;
    private String email;
    public UserData (){}
    public UserData(String salutation,
                    String firstname,
                    String lastname,
                    String dobStr, String martialstatus, String occupation, String otheroccupation, String mobileno, String email) throws Throwable {
        this.salutation=salutation;
        this.firstname=firstname;
        this.lastname=lastname;
        this.dob=the_date_of(dobStr);
        this.martialstatus = martialstatus;
        this.occupation = occupation;
        this.otheroccupation = otheroccupation;
        this.mobileno = mobileno;
        this.email = email;
    }
    public Calendar the_date_of(String strDate) throws Throwable {
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        //Date date = format.parse(strDate);
        //return date;
        //return LocalDate.parse(strDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        //LocalDate date = LocalDate.parse(strDate, dateFormatter);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        cal.setTime(sdf.parse(strDate));// all done
        return cal;

    }
    public Calendar getDob() {
        return dob;
    }

    public void setDob(Calendar dob) {
        this.dob = dob;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }


    public String getMartialstatus() {
        return martialstatus;
    }

    public void setMartialstatus(String martialstatus) {
        this.martialstatus = martialstatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOtheroccupation() {
        return otheroccupation;
    }

    public void setOtheroccupation(String otheroccupation) {
        this.otheroccupation = otheroccupation;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return this.salutation
                + " " + this.firstname
                + " " + this.lastname
                + " " + this.dob
                + " " + this.martialstatus
                + " " + this.occupation
                + " " + this.otheroccupation
                + " " + this.mobileno
                + " " + this.email

                ;
    }
}
