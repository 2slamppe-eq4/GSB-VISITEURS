package controleur;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modele.dao.*;

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




   
  

    @Override
    public VueVisiteur getVue() {
        return (VueVisiteur) vue;
    }

    public void visiteurAfficher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
