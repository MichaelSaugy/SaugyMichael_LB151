/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.bbbaden.quizm151;

/**
 *
 * @author Saugy
 */
public class QuizLetter {
    private final char value;
    private boolean hidden = true;

    public QuizLetter(char value) {
        if(value == ' '){
            value = '|';
            show();
        }
        
        this.value = value;
    }

    public char getValue() {
        return value;
    }
    
    public void show(){
        hidden = false;
    }
    public boolean isHidden(){
        return hidden;
    }
    
    public String toString(){
        if(hidden){
            return "_";
        }else{
            return value + "";
        }
    }
}
