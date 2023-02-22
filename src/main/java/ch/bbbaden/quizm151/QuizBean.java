/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.bbbaden.quizm151;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author Saugy
 */
@Named(value = "QuizBean")
@SessionScoped
public class QuizBean implements Serializable {

    private List<QuizLetter> letters = new ArrayList<>();
    private DBConnection db = new DBConnection();

    private String username;
    private String solution = "das ist nur ein test";
    private String category;
    private int balance;
    private int lives = 3;
    private String spinResult;
    private String placeHolder;
    private boolean setupDone = false;
    private char consonant;
    private String solutionGuess;
    private boolean wordGuessed = false;
    private String leaderboard;

    private boolean spinDisabled = false;
    private boolean vowelsLeft = true;

    public String getUsername() {
        return username;
    }

    public String getLeaderboard() {
        leaderboard = db.getLeaderborard();
        return leaderboard;
    }

    
    public void setUsername(String username) {
        System.out.println(username);
        this.username = username;
    }

    public String getSolutionGuess() {
        return solutionGuess;
    }

    public void setSolutionGuess(String solutionGuess) {
        this.solutionGuess = solutionGuess;
    }

    public String getSolution() {
        return solution;
    }

    public String getCategory() {
        return category;
    }

    public int getBalance() {
        return balance;
    }

    public int getLives() {
        return lives;
    }

    public String getSpinResult() {
        return spinResult;
    }

    public char getConsonant() {
        return consonant;
    }

    public boolean isSpinDisabled() {
        return spinDisabled;
    }

    public boolean isVowelsLeft() {
        return vowelsLeft;
    }

    public void setSpinDisabled(boolean canSpin) {
        this.spinDisabled = canSpin;
    }

    public void setConsonant(char konsonant) {
        this.consonant = konsonant;
    }

    public void setSolution(String loesung) {
        this.solution = loesung;
    }

    public void setCategory(String kategorie) {
        this.category = kategorie;
    }

    public void setBalance(int kontostand) {
        this.balance = kontostand;
    }

    public void setLives(int lebenspunkte) {
        this.lives = lebenspunkte;
    }

    public void spin() {
        Random rand = new Random();
        spinDisabled = true;

        if (3 >= rand.nextInt(101)) {
            spinResult = "Bankrot ._.";
            System.out.println("Du hast verloren");
        } else {
            spinResult = "Betrag: " + rand.nextInt(201);
        }
    }

    public String getPlaceHolder() {
        if (!wordGuessed) {
            placeHolder = "";
            for (QuizLetter letter : letters) {
                placeHolder += letter + " ";
            }
        }
        return formatText(placeHolder, 24);
    }

    private String formatText(String text, int lineLength) {
        String result = "";
        int numberOfWords = 0;
        for (String word : text.split(" ")) {
            numberOfWords++;
            result += word + " ";
            if (numberOfWords > lineLength - 1) {
                result += "<br/>";
                numberOfWords = 0;
            }
        }
        return result;
    }

    private void setupLetters() {
        if (!setupDone) {
            letters = new ArrayList<>();
            for (int i = 0; i < solution.length(); i++) {
                letters.add(new QuizLetter(solution.charAt(i)));
            }
            setupDone = true;
        }

    }

    public void guess() {

        String konsonanten = "bcdfghjklmnpqrstvwxyz";
        if (konsonanten.contains(String.valueOf(Character.toLowerCase(consonant)))) {
            spinDisabled = false;
            System.out.println("Konsonant: " + consonant);

            boolean letterGuessed = false;
            boolean allShown = true;
            for (QuizLetter letter : letters) {
                if (Character.toLowerCase(letter.getValue()) == Character.toLowerCase(consonant)) {
                    letter.show();
                    letterGuessed = true;
                }
            }
            for (QuizLetter letter : letters) {
                if (letter.isHidden()) {
                    allShown = false;
                }
            }
            setConsonant(' ');
            if (allShown) {
                wordGuessed();
            }

            if (letterGuessed) {
                //Get Money from spin
                balance += Integer.valueOf(spinResult.split(" ")[1]);
            } else {
                //loose a life
                System.out.println("Leben verloren");
                loseLive();
            }
        }
    }

    public void showVowels() {
        if (vowelsLeft && balance >= 50) {
            vowelsLeft = false;
            balance -= 50;
            String vowels = "aeiouäöü";
            for (int i = 0; i < vowels.length(); i++) {
                boolean allShown = true;
                for (QuizLetter letter : letters) {
                    System.out.println(Character.toLowerCase(letter.getValue()));
                    if (Character.toLowerCase(letter.getValue()) == vowels.charAt(i)) {
                        letter.show();
                    }
                }
                for (QuizLetter letter : letters) {
                    if (letter.isHidden()) {
                        allShown = false;
                    }
                }
                if (allShown) {
                    wordGuessed();
                    break;
                }
            }
        }

    }

    private void wordGuessed() {
        wordGuessed = true;
        System.out.println("Wort erraten!");
        placeHolder = solution;
    }

    public void guessSolution() {
        if (solutionGuess.equals(solution)) {
            wordGuessed();
        } else {
            loseLive();
        }
    }

    private void loseLive() {
        lives--;
        if (lives == 0) {
            System.out.println("Verloren!!");
            try {
                restart();
            } catch (Exception e) {

            }

        }
    }

    public void restart() {
        wordGuessed = false;
        if (lives == 0) {
            balance = 0;
        }
        lives = 3;
        setupDone = false;

        String rndmPhrase = db.getRndmPhrase();

        try {

            solution = rndmPhrase.split(" - ")[0];
            category = rndmPhrase.split(" - ")[1];
        } catch (Exception e) {
            System.out.println("Error with Phrase");
        }

        try {
            System.out.println("speichern...");
            safeGame();
            System.out.println("gespeichert");
        } catch (Exception e) {
            System.out.println("Fail");
            System.out.println(e);
        }
        setupLetters();
    }

    private void safeGame() throws IllegalStateException, SecurityException, SystemException, NamingException {
        if (balance > 0) {
            db.safeToDB(username, balance, new Date().toString(), new Date().toString());
        }
    }

}
