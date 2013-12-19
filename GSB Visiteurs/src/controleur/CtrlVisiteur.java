package controleur;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modele.dao.*;
import modele.dao.DaoVisiteur;
import modele.metier.Visiteurs;

import vue.VueVisiteur;

/**
 * Contrôleur de la fenêtre VuePresence
 *
 * @author nbourgeois
 * @version 1 20 novembre 2013
 */
public class CtrlVisiteur extends CtrlAbstrait {
    
   private DaoVisiteur daoVisiteur= new DaoVisiteur();


    public CtrlVisiteur(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueVisiteur(this);
        
    }

   

    public void fichierQuitter() {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "Ambulances", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            this.getCtrlPrincipal().action(EnumAction.MENU_VISITEUR_QUITTER);
        }
    }

    
    public void chargerVisiteur() throws DaoException{
        
        List<Visiteurs> lesVisiteurs = daoVisiteur.getListeVisiteurs();
        
                int i=0;
                for(Visiteurs unVisiteur: lesVisiteurs){
                    ((DefaultTableModel)((VueVisiteur)vue).getTableau().getModel()).setRowCount(i+1);//modification des ligne tu tableau en fonction du nombre de ligne à entré
                    String nom= unVisiteur.getNom();// récupération des donnée a metre dans le tablau
                    String prenom=unVisiteur.getPrenom();// récupération des donnée a metre dans le tablau
                    int cp=unVisiteur.getCp();// récupération des donnée a metre dans le tablau
                    String ville=unVisiteur.getVille();// récupération des donnée a metre dans le tablau
                    String telephone=unVisiteur.getDate_embauche();// récupération des donnée a metre dans le tablau
                    DefaultTableModel tableau = (DefaultTableModel) ((VueVisiteur)vue).getTableau().getModel();
                    tableau.setValueAt(nom,i,0); //Insertion dasn le tableau 
                    tableau.setValueAt(prenom,i,1);//Insertion dasn le tableau
                    tableau.setValueAt(cp,i,2);//Insertion dasn le tableau
                    tableau.setValueAt(ville,i,3);//Insertion dasn le tableau
                    tableau.setValueAt(telephone,i,1);//Insertion dasn le tableau
                    
                    i++;
                }
    }  

    @Override
    public VueVisiteur getVue() {
        return (VueVisiteur) vue;
    }
        
    public void visiteurAfficher() {
        String msg = ""; // message à afficher en cas d'erreur
        // récupérer les valeurs saisies
        if (getVue() != null) {
            
        }
    }
}
