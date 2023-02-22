/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.bbbaden.quizm151;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Saugy
 */
@Entity
@Table(name = "phrases")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phrases.findAll", query = "SELECT p FROM Phrases p"),
    @NamedQuery(name = "Phrases.findById", query = "SELECT p FROM Phrases p WHERE p.id = :id"),
    @NamedQuery(name = "Phrases.findByPhrase", query = "SELECT p FROM Phrases p WHERE p.phrase = :phrase"),
    @NamedQuery(name = "Phrases.findByTimesFailed", query = "SELECT p FROM Phrases p WHERE p.timesFailed = :timesFailed")})
public class Phrases implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "phrase")
    private String phrase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timesFailed")
    private int timesFailed;
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category idCategory;
    @JoinColumn(name = "id_difficulty", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Difficulty idDifficulty;

    public Phrases() {
    }

    public Phrases(Integer id) {
        this.id = id;
    }

    public Phrases(Integer id, String phrase, int timesFailed) {
        this.id = id;
        this.phrase = phrase;
        this.timesFailed = timesFailed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public int getTimesFailed() {
        return timesFailed;
    }

    public void setTimesFailed(int timesFailed) {
        this.timesFailed = timesFailed;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    public Difficulty getIdDifficulty() {
        return idDifficulty;
    }

    public void setIdDifficulty(Difficulty idDifficulty) {
        this.idDifficulty = idDifficulty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phrases)) {
            return false;
        }
        Phrases other = (Phrases) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.bbbaden.quizm151.Phrases[ id=" + id + " ]";
    }
    
}
