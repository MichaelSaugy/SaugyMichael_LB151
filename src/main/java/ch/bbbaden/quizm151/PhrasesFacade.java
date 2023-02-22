/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.bbbaden.quizm151;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Saugy
 */
@Stateless
public class PhrasesFacade extends AbstractFacade<Phrases> {

    @PersistenceContext(unitName = "ch.bbbaden_QuizM151_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PhrasesFacade() {
        super(Phrases.class);
    }
    
}
