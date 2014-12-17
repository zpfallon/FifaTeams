package com.wm.zpfallon.fifateams;

/**
 * Created by zpfallon on 12/16/14.
 * Abstract team data into a class
 */
public class Team {
    String name;
    String att;
    String mid;
    String def;

    public Team(){

    }
    public Team(String name,String att, String mid, String def){
        this.name = name;
        this.att = att;
        this.mid = mid;
        this.def = def;
    }

    @Override
    public String toString(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAtt(){
        return this.att;
    }

    public void setAtt(String att){
        this.att = att;
    }

    public String getMid(){
        return this.mid;
    }

    public void setMid(String mid){
        this.mid = mid;
    }

    public String getDef(){
        return this.def;
    }

    public void setDef(String def){
        this.def = def;
    }
}
