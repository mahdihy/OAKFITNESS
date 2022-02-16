/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oakfitnessjava.services;

import com.mycompany.oakfitnessjava.entities.Evenement;
import com.mycompany.oakfitnessjava.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Heni Nechi
 */
public class EvenementCRUD {
    
    Connection cnxx;

    public EvenementCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void ajouterEvenement() {
        String Request = "INSERT INTO Evenement (IDCreatorEvenement,DateEvenement,TitreEvenement,DescrEvenement,AdresseEvenement,TypeEvenement)"
                + " VALUES ('test','test',test','test','test','test')";
        Statement st;
        try {
            st = cnxx.createStatement();
            st.executeUpdate(Request);
            System.out.println("Evenement Ajouter avec succes!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public void ajouterEvenement2(Evenement E){
    String Request = "INSERT INTO Evenement (IDCreatorEvenement,DateEvenement,TitreEvenement,DescrEvenement,AdresseEvenement,TypeEvenement)"
                + " VALUES (?,?,?,?,?,?)";
    
    PreparedStatement  pst;
    try {
        java.sql.Date sqlDate = new java.sql.Date(E.getDateEvenement().getTime());
            pst = cnxx.prepareStatement(Request);
            pst.setInt(1, E.getIDCreatorEvenement());
            pst.setDate(2, sqlDate);
            pst.setString(3, E.getTitreEvenement());
            pst.setString(4, E.getDescrEvenement());
            pst.setString(5, E.getAdresseEvenement());
            pst.setString(6, E.getTypeEvenement());
            pst.executeUpdate();
                        System.out.println("Evenement ajouté avec succés");
 } catch (SQLException ex) {
            System.err.println(ex.getMessage());    
        }
    
    }
    

    public List<Evenement> afficherEvenement() {
         List<Evenement> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM Evenement";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Evenement e = new Evenement();
                e.setIDEvenement(rs.getInt(1));
                e.setIDCreatorEvenement(rs.getInt(2));
                e.setDateEvenement(rs.getDate(3));
                e.setTitreEvenement(rs.getString(4));
                e.setDescrEvenement(rs.getString(5));
                e.setAdresseEvenement(rs.getString(6));
                e.setTypeEvenement(rs.getString(7));
                myList.add(e);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            //   return null;
        }
        return myList;
    }
      
      public void supprimerEvenement(int id)
      {
                  String Request = "DELETE FROM Evenement WHERE IDEvenement='"+id+"' ";
                          PreparedStatement pst;

try {
            pst = cnxx.prepareStatement(Request);
            pst.executeUpdate();
                        System.out.println("Evenement supprimé avec succés");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
          
      }

      
      public void ModifierEvenement(Evenement E, int id)
      {
           String req = "UPDATE Evenement SET IDCreatorEvenement='"+E.getIDCreatorEvenement()+"' DateEvenement ='"+E.getDateEvenement()+"' TitreEvenement ='"+E.getTitreEvenement()+"',DescrEvenement ='"+E.getDescrEvenement()+"',AdresseEvenement ='"+E.getAdresseEvenement()+"', TypeEvenement ='"+E.getTypeEvenement()+"' WHERE IDEvenement = '"+id+"'";
          PreparedStatement pst;

try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
                        System.out.println("Evenement modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
          
      }
}