package modele.metier;

import java.util.Map.Entry;

/**
 *
 * @author nbourgeois
 */
public class Equipier {

    private int id;
    private String nom;
    private String prenom;
    private boolean dimanche;
    private ListeVisiteurs lesPresences;

    public Equipier() {
        this.id = 0;
        this.nom = "";
        this.prenom = "";
        this.dimanche = false;
        lesPresences = new ListeVisiteurs();
    }

    public Equipier(int id, String nom, String prenom, boolean dimanche) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dimanche = dimanche;
        lesPresences = new ListeVisiteurs();
    }

    //----------------------------------------------------------------------
    //  Gestion de la liste des présences
    //----------------------------------------------------------------------
    public boolean ajouterUnePresence(Visiteur unePresence) {
        return lesPresences.put(unePresence.getJour(), unePresence) == null;
    }

    public boolean supprimerUnePresence(Jour unJour) {
        return lesPresences.remove(unJour) != null;
    }

    public Visiteur rechercherUnePresence(Jour unJour) {
        Visiteur p= lesPresences.get(unJour);
        return p;
    }

    //----------------------------------------------------------------------
    //  toString
    //  Accesseurs et Mutateurs
    //----------------------------------------------------------------------    
    @Override
    public String toString() {
        return String.format("%1$-5s%2$-20s%3$-20s", id, nom, prenom);
    }

    /**
     * Etat complet de l'objet : pour le test et le débogage
     * @return 
     */
    public String versChaine() {
        String resu = "";
        resu += "Equipier{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dimanche=" + dimanche;
        resu += "\n\tPrésences :\n";
        for (Entry<Jour, Visiteur> entree : lesPresences.entrySet()) {
            Visiteur p = entree.getValue();
            resu += "\t\t" + p + "\n";
        }
        resu += '}';
        return resu;
    }
    
    
    public boolean isDimanche() {
        return dimanche;
    }

    public void setDimanche(boolean dimanche) {
        this.dimanche = dimanche;
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

    public ListeVisiteurs getLesPresences() {
        return lesPresences;
    }

    public void setLesPresences(ListeVisiteurs lesPresences) {
        this.lesPresences = lesPresences;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
