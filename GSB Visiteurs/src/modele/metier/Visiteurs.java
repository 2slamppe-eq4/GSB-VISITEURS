/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

import java.util.List;

/**
 *
 * @author btssio
 */
public class Visiteurs {
    
    private String nom = null;
    private String prenom = null;
    private int cp = 0;
    private String ville = null;
    private String date_embauche = null;


    public Visiteurs(String nom, String prenom, int cp, String ville, String date_embauche) {
        this.nom = nom;
        this.prenom = prenom;
        this.cp = cp;
        this.ville = ville;
        this.date_embauche = date_embauche;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDate_embauche() {
        return date_embauche;
    }

    public void setDate_embauche(String date_embauche) {
        this.date_embauche = date_embauche;
    }
    
    
    
}
