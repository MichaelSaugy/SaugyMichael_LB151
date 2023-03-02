/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ch.bbbaden.quizm151;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Saugy
 */
@Named(value = "AdminBean")
@SessionScoped
public class AdminBean implements Serializable {
    private String name;
    private String password;
    private boolean nameCorrect;
    private boolean pwCorrect;

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    
    public String login(){
        nameCorrect = false;
        
        if("Admin".equals(name)){
            nameCorrect=true;
        }
        if("Admin123".equals(password)){
            pwCorrect = true;
        }
        System.out.println("Name: " + name + " PW: " + password);
        if(nameCorrect && pwCorrect){
            pwCorrect=false;
            nameCorrect=false;
            System.out.println("Als Admin registriert");
            return "/quiz/admin.xhtml";
        }else{
            pwCorrect=false;
            nameCorrect=false;
            return "/quiz/adminLogin.xhtml";
        }
    }
}
