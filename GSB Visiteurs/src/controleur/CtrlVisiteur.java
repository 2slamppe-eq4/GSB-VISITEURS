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
        String msg = ""; // message à afficher en cas d'erreur
        // récupérer les valeurs saisies
        if (getVue() != null) {
            Equipier equipierSelect = (Equipier) getVue().getjComboBoxEquipier().getSelectedItem();
            Date dateSaisie = getVue().getjDateChooserDatePresence().getDate();
            if (equipierSelect != null || dateSaisie != null) {
                Jour dateSelect = new Jour(dateSaisie.getTime());
                try {
                    // n° d'identification de cet équipier
                    int id = equipierSelect.getId();
                    // récupérer la liste des présences actuelles pour cet équipier
                    equipierSelect.setLesPresences(daoPresence.getListePresences(id));
                    // rechercher la date saisie dans cette liste
                    Presence presenceRecherchee = equipierSelect.rechercherUnePresence(dateSelect);
                    if (presenceRecherchee != null) {
                        // si elle est déjà présente, mettre à jour la vue
                        // code état concerné
                        CodeEtat ce = presenceRecherchee.getEtatPresence();
                        this.getVue().getModeleJComboBoxEtatPresence().setSelectedItem(ce);
//                        System.out.println("état : " + ce.toString());
                    }
                } catch (DaoException ex) {
                    msg = "CtrlPresence - presenceAfficher() - " + ex.getMessage();
                    JOptionPane.showMessageDialog(vue, msg, "Saisie des présences", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
