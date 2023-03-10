/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.bbbaden.quizm151;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import javax.naming.InitialContext;
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
public class DBConnection {

    //Returns random Word and category from table phrases (word - category)
    public String getRndmPhrase() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("ch.bbbaden_QuizM151_war_1.0-SNAPSHOTPU").createEntityManager();

        // Call the named query "Phrases.findAll"
        List<Phrases> phrasesList = entityManager.createNamedQuery("Phrases.findAll", Phrases.class).getResultList();

        // Do something with the list of Phrases
        for (Phrases phrases : phrasesList) {
            System.out.println(phrases.getPhrase());
        }

        // Close the entity manager
        entityManager.close();

        Random rndm = new Random();
        int rndmIndex = rndm.nextInt(phrasesList.size());
        Phrases phrase = phrasesList.get(rndmIndex);
        String result = phrase.getPhrase() + " - " + phrase.getIdCategory().getName() + " - " + phrase.getId();
        System.out.println(result);

        return result;
    }

    public void saveToDB(String username, int balance, int numberOfRounds , String start, String end) throws IllegalStateException, SecurityException, SystemException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ch.bbbaden_QuizM151_war_1.0-SNAPSHOTPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserTransaction transaction = null;
        try {
            transaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();
            entityManager.joinTransaction();

            Games newGame = new Games(); 
            newGame.setName(username);
            newGame.setNumberOfRounds(numberOfRounds);
            newGame.setBalance(balance);
            newGame.setStart(start);
            newGame.setEnd(end);

            try {
                entityManager.persist(newGame);
            } catch (Exception e) {
                System.out.println("Daten nicht hinzugef??gt!");
            }

            transaction.commit();
        } catch (Exception ex) {
            try {
                if (transaction != null) {
                    transaction.rollback();
                }
            } catch (Exception e) {
                System.out.println("rollback error");
            }
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public List<Games> getLeaderborard() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("ch.bbbaden_QuizM151_war_1.0-SNAPSHOTPU").createEntityManager();

        // Call the named query "Phrases.findAll"
        List<Games> gameList = entityManager.createNamedQuery("Games.findAll", Games.class).getResultList();

        // Do something with the list of Phrases
        Collections.sort(gameList, new Comparator<Games>() {
            public int compare(Games o1, Games o2) {
                int comp = o2.getBalance() - o1.getBalance();
                return comp;
            }
        });
        return gameList;
    }

    public void updateTimesFailed(int id) throws IllegalStateException, SecurityException, SystemException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch.bbbaden_QuizM151_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        UserTransaction transaction = null;
        
        try {
            transaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();
            em.joinTransaction();
            Phrases phrase = em.find(Phrases.class, id);
            if (phrase != null) {
                phrase.setTimesFailed(phrase.getTimesFailed()+1);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        
        
    }
}
