/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oakfitnessjava.test;

import com.mycompany.oakfitnessjava.entities.Evenement;
import com.mycompany.oakfitnessjava.entities.Repas;
import com.mycompany.oakfitnessjava.services.EvenementCRUD;
import com.mycompany.oakfitnessjava.services.RepasCRUD;
import com.mycompany.oakfitnessjava.entities.Exercice;
import com.mycompany.oakfitnessjava.entities.ProgrammeNutritionnel;
import com.mycompany.oakfitnessjava.entities.ProgrammeSportif;
import com.mycompany.oakfitnessjava.services.ExerciceCRUD;
import com.mycompany.oakfitnessjava.services.ProgrammeNutritionnelCRUD;
import com.mycompany.oakfitnessjava.services.ProgrammeSportifCRUD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author Heni Nechi
 */
public class MainClass {

    public static void main(String[] args) throws ParseException, MessagingException {
        // Execute this everyday at 00:00
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                EvenementCRUD ecrud = new EvenementCRUD();
                List<Evenement> J1 = ecrud.isJ1();
                if (!J1.isEmpty()) {
                    try {
                        ecrud.EnvoyeEmailJ1(J1, "heni.m.nechi@gmail.com, heni.nechi@esprit.tn");
                        System.out.println("Message sent!");
                    } catch (MessagingException ex) {
                        Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DAY_OF_MONTH, 20);
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);

        System.out.println(date.getTime());
        timer.scheduleAtFixedRate(task, date.getTime(), 86400000);

        //MyConnection mc = new MyConnection();
        /*EvenementCRUD ecrud = new EvenementCRUD();
        List<Evenement> J1 = ecrud.isJ1();
        SimpleDateFormat sdf = new SimpleDateFormat(
                "yyyy-MM-dd");
        Evenement ev = new Evenement(4, sdf.parse("2022-02-20"), "test5", "test5", "test5", "test5");
        ecrud.ajouterEvenement2(ev);
        System.out.println(ecrud.isJ1());*/
        //ecrud.EnvoyeEmailJ1(J1, "heni.m.nechi@gmail.com, heni.nechi@esprit.tn, hani.nechi@yahoo.fr");
        // ExerciceCRUD ecrud = new ExerciceCRUD();
        //ProgrammeSportifCRUD pscrud = new ProgrammeSportifCRUD();
        //ProgrammeSportif ps = new ProgrammeSportif(1,1,1,"test");
        // pscrud.ajouterProgrammeSportif2(ps); 
        //Exercice ex = new Exercice("test3","test3","test3","test3","test3","test3");
        //Exercice ex2 = new Exercice("test3","test3","test3","test3","test3","test3");
        //ecrud.ajouterExercice2(ex2);
        //System.out.println(ex.getIDExercice());
        /*ecrud.ajouterExercice2(ex2);*/
        //ecrud.AjouterExerciceAProgramme(10,27); 
        //System.out.println(pscrud.AfficherExercicesDeProgramme(10));
        //ecrud.supprimerExerciceDeProgramme(2);
        /*System.out.println(ecrud.afficherExercice());
        Exercice ex2 = new Exercice("test4","test4","test4","test4","test4","test4");
        ecrud.ModifierExercice(ex2, 2);
        ecrud.supprimerExercice(1);
        System.out.println(ecrud.afficherExercice());
        
        EvenementCRUD ecrud = new EvenementCRUD();
        Evenement ev = new Evenement("test3","test3","test3","test3");
        ecrud.ajouterEvenement2(ev);
        System.out.println(ecrud.afficherEvenement());
        Evenement ev2 = new Evenement("test4","test4","test4","test4");
        ecrud.ModifierEvenement(ev2, 3);
        //ecrud.supprimerExercice(1);
        System.out.println(ecrud.afficherEvenement()); 
        
        RepasCRUD rcrud = new RepasCRUD();
        Repas r = new Repas("test3","test3","test3","test3");
        rcrud.ajouterRepas2(r);
        System.out.println(rcrud.afficherRepas());
        Repas r2 = new Repas("test4","test4","test4","test4");
        rcrud.ModifierRepas(r2, 3);
        //ecrud.supprimerExercice(1);
        System.out.println(rcrud.afficherRepas()); 

        ProgrammeSportifCRUD pscrud = new ProgrammeSportifCRUD();
        ProgrammeSportif ps = new ProgrammeSportif(1, 1,1, 1,"test");
        pscrud.ajouterProgrammeSportif2(ps,ex);
        System.out.println(pscrud.afficherProgrammeSportif());
        ProgrammeSportif ps2 = new ProgrammeSportif(2, 2, ex2.getIDExercice(), 2,"test2");
        pscrud.ModifierProgrammeSportif(ps2,ex,2);
        //ecrud.supprimerExercice(1);
        System.out.println(pscrud.afficherProgrammeSportif());*/
        RepasCRUD rcrud = new RepasCRUD();
        //ExerciceCRUD ecrud = new ExerciceCRUD();
        //ProgrammeNutritionnelCRUD pncrud = new ProgrammeNutritionnelCRUD();
        //ProgrammeSportifCRUD pscrud = new ProgrammeSportifCRUD();

        //ProgrammeNutritionnel pn = new ProgrammeNutritionnel(1,1,100,"test2");
        Repas r = new Repas("test3", "test3", "test3", 250, "test3");
        //ProgrammeSportif ps = new ProgrammeSportif(1, 1,1, 1,"test");
        //Exercice ex = new Exercice("test28","test28","test28","test28","test28","test28");
        //ecrud.ajouterExercice2(ex);
        //ecrud.AjouterExerciceAProgramme(10, 28);
        //pncrud.ajouterProgrammeNutritionnel2(pn);
        //rcrud.ajouterRepas2(r);
        //rcrud.AjouterRepasAProgramme(1, 2);
        // System.out.println(pncrud.AfficherRepasDeProgramme(1));
        //ystem.out.println(pscrud.AfficherExercicesDeProgramme(10));
        //System.out.println(rcrud.afficherRepas());*/
        /*SimpleDateFormat sdf = new SimpleDateFormat(
    "yyyy-MM-dd");
        EvenementCRUD ecrud = new EvenementCRUD();
        Evenement ev = new Evenement(4,sdf.parse("2022-06-08"),"test4","test4","test4","test4");
        //ecrud.ajouterEvenement2(ev);
        System.out.println(ecrud.EvenementCreatedby(2));
        System.out.println(ecrud.afficherEvenement());
        System.out.println(ecrud.BetweenDatesEvenement(sdf.parse("2022-03-01"), sdf.parse("2022-12-31")));
       // Evenement ev2 = new Evenement(2,sdf.parse("2022-09-28"),"test4","test4","test4","test4");*/

    }
}
