package com.example.a.sabjimall.models;

/**
 * Created by A on 27/12/2017.
 */

public class Fruit {
    int i;
    String pname;
    String price;
    String pqnt;
    String addqnt;


  //  String _Fname,_Lname,_mail,_dob,_mob,_addr;


    // Empty constructor
    public Fruit(){

    }
    // constructor
  /*  public Fruit(int id, String pid,  byte[] img){
        this._pid=pid;
        this._id = id;
        // this._fname = fname;
        this._img = img;

    }
*/
    // constructor
  /*  public Fruit(String pid,byte[] img){
        this._pid=pid;
        //this._fname = fname;
        this._img = img;

    }*/


    public Fruit(int id, String name, String price,String qnt,String addqnt){
        this.pname=name;
        this.price=price;
        this.pqnt=qnt;
        this.addqnt=addqnt;
        this.i=id;

    }

    // constructor
    public Fruit(String name, String price,String qnt,String addqnt){
        this.pname=name;
        this.price=price;
        this.pqnt=qnt;
        this.addqnt=addqnt;

    }

    public int getI(){return this.i;}

    public void setI(int i){ this.i=i;}
    // getting ID

    public String getPname(){
        return this.pname;
    }

    // setting id
    public void setPname(String pname){
        this.pname = pname;
    }

    // getting first name
    public String getPrice(){
        return this.price;
    }

    // setting first name
    public void setPrice(String price){
        this.price = price;
    }

    //getting profile pic
  /*  public byte[] getImage(){
        return this._img;
    }*/

    //setting profile pic
    /*public void setImage(byte[] b){
        this._img=b;
    }*/


    public String getPqnt(){
        return this.pqnt;
    }

    // setting first name
    public void setPqnt(String pqnt){
        this.pqnt = pqnt;
    }

    public String getAddqnt(){
        return this.addqnt;
    }

    // setting first name
    public void setAddqnt(String addqnt){
        this.addqnt = addqnt;
    }






}
