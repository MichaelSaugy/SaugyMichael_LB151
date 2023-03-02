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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.naming.NamingException;
import javax.transaction.SystemException;

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
    private String answerGrid;
    private boolean setupDone = false;
    private char consonant;
    private String solutionGuess;
    private boolean wordGuessed = false;
    private Date start = new Date();
    private int id_phrase;
    private int currentPhrase = 1;

    private boolean spinDisabled = false;
    private boolean vowelsLeft = true;

    public String getUsername() {
        return username;
    }

    public List<Games> getLeaderboard() {
        return db.getLeaderborard();
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

    public int getCurrentPhrase() {
        return currentPhrase;
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
            setLives(1);
            loseLive();
        } else {
            spinResult = "Betrag: " + rand.nextInt(201);
        }
    }

    public String getAnswerGrid() {
        if (!wordGuessed) {
            answerGrid = "";
            for (QuizLetter letter : letters) {
                answerGrid += letter + "";
            }
        }
        return formatText(answerGrid, 24);
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

            if (!consonantsLeft()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Es sind keine Konsonanten mehr übrig, geben sie die Lösung ein oder Kaufen sie Vokale!", "Es sind keine Konsonanten mehr überig, geben sie die Lösung ein oder Kaufen sie Vokale!"));
            }

        }
    }

    private boolean consonantsLeft() {

        String consonants = "bcdfghjklmnpqrstvwxyz";
        for (int i = 0; i < consonants.length(); i++) {
            boolean consonantLeft = false;
            for (QuizLetter letter : letters) {
                if (Character.toLowerCase(letter.getValue()) == consonants.charAt(i)) {
                    if(letter.isHidden()){
                        consonantLeft = true;
                    }
                }
            }
            if (consonantLeft) {
                return true;
            }
        }
        return false;
    }

    public void showVowels() {
        if (vowelsLeft && balance >= 50) {
            vowelsLeft = false;
            balance -= 50;
            String vowels = "aeiouäöü";
            for (int i = 0; i < vowels.length(); i++) {
                boolean allShown = true;
                for (QuizLetter letter : letters) {
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
        answerGrid = solution;
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
                db.updateTimesFailed(id_phrase);
                restart();
            } catch (Exception e) {

            }

        }
    }

    public void restart() {
        currentPhrase++;
        if (!wordGuessed) {
            balance = 0;
            currentPhrase = 1;
        }
        System.out.println(currentPhrase);
        lives = 3;
        vowelsLeft = true;
        setupDone = false;
        spinDisabled = false;

        String rndmPhrase = db.getRndmPhrase();

        try {

            solution = rndmPhrase.split(" - ")[0];
            category = rndmPhrase.split(" - ")[1];
            id_phrase = Integer.valueOf(rndmPhrase.split(" - ")[2]);

        } catch (Exception e) {
            System.out.println("Error with Phrase");
        }

        setupLetters();
        wordGuessed = false;
    }

    public void saveGame() throws IllegalStateException, SecurityException, SystemException, NamingException {
        if (balance > 0) {
            db.saveToDB(username, balance, currentPhrase, start.toString(), new Date().toString());
        }
        restart();
        balance = 0;
        currentPhrase = 1;
    }

}
