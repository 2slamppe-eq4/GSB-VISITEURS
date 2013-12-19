package modele.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import modele.jdbc.Jdbc;
import modele.metier.Visiteurs;
import modele.dao.*;
import modele.metier.ListeVisiteurs;
import modele.metier.Visiteurs;


//La classe DaoVisiteur :
//On crée une liste visiteurs
//Ensuite on éxecute la requete 
//Puis on met les résultats de la requête dans la liste

public class DaoVisiteur {
        

        public ArrayList<Visiteurs> getListeVisiteurs() throws DaoException {
        ArrayList<Visiteurs> result = new ArrayList<Visiteurs>();

        String requete = "SELECT * FROM VISITEURS ";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Visiteurs visiteur = chargerUnVisiteur(rs);
                result.add(visiteur);
            }

        } catch (Exception ex) {
            throw new DaoException("DAO - getListeVisiteurs pour un visiteur : pb JDBC\n" + ex.getMessage());
        }
        return result;
        }
        
        
        
        
        private Visiteurs chargerUnVisiteur(ResultSet rs) throws DaoException {
        try {
            Visiteurs visiteur = new Visiteurs(null,null,0,null,null);
            String nom = rs.getString("VIS_NOM");
            String prenom = rs.getString("VIS_PRENOM");
            String adresse = rs.getString("VIS_ADRESSE");
            int cp = rs.getInt("VIS_CP");
            String ville = rs.getString("VIS_VILLE");
            String date_embauche = rs.getString("VIS_DATEEMBAUCHE");
            
            return visiteur;
            
        } catch (SQLException ex) {
            throw new DaoException("DaoPresence - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }

    }
    
    
}
