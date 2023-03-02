/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ch.bbbaden.quizm151;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Saugy
 */
@Named(value = "leaderboardBean")
@SessionScoped
public class LeaderboardBean implements Serializable {

    /**
     * Creates a new instance of LeaderboardBean
     */
    DBConnection db = new DBConnection();
    private int rowIndex = 1;

    public int getRowIndex() {
        return rowIndex++;
    }
    
    public List<Games> getLeaderboard(){
        rowIndex = 1;
        return db.getLeaderborard();
    }

    public LeaderboardBean() {
    }

}
