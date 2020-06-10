package com.example.model;

public class User {
    String code;

    String projname;

    String custId;
    public User(String c, String p, String Id) {
        this.code=c;
        this.projname=p;
        this.custId=Id;


    }
    public User() {
        
    }
    
    public void setCode(String code){
        this.code=code;
    }
    public String getCode(){
        return this.code;
    }
    public void setProjname(String projname){
        this.projname=projname;
    }
    public String getProjname(){
        return this.projname;
    }
    public void setCustId(String custId){
        this.custId=custId;
    }
    public String getCustId(){
        return this.custId;
    }

}