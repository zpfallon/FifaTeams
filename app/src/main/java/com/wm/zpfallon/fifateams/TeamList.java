package com.wm.zpfallon.fifateams;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by zpfallon on 12/16/14.
 * This class will house the Team list.
 * To access the actual list, call getTeamList() and do ArrayList methods on it.
 */

public class TeamList extends Application {
    private ArrayList<Team> teamList;

    public TeamList(){
        teamList = new ArrayList<>();
    }

    public void setTeamList(ArrayList<Team> teamList){
        this.teamList = teamList;
    }
    public ArrayList<Team> getTeamList(){
        return teamList;
    }
}
