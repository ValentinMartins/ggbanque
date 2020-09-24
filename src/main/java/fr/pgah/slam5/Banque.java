package fr.pgah.slam5;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Banque {

    private HashMap<Integer, Compte> comptes;
    private double taux = 0.01;
    private int numDernierCompte = 0;

    public Banque(HashMap<Integer, Compte> comptes) {
        this.comptes = comptes;
    }

    public int creeCompte(boolean origine, int type) { // parametre de la methode
        int numCompte = numDernierCompte++;
        Compte compte;
        if (type == 1) {
            compte = new CompteEpargne(origine, numCompte);
        } else {
            compte = new CompteCourant(origine, numCompte);
        }

        comptes.put(numCompte, compte);
        return numCompte;
    }

    public int getSolde(int numCompte) {
        return comptes.get(numCompte).getSolde();
    }

    public void crediter(int numCompte, int montant) {
        Compte compte = comptes.get(numCompte);
        compte.crediter(montant);

    }

    public void appliquertInterets() {

        for (Compte compteInterets : comptes.values()) {

            compteInterets.appliquertInterets(taux);

        }

    }

    public String toString() {

        Set<Integer> numerosDesComptes = comptes.keySet();
        String res = "La banque gère " + numerosDesComptes.size() + " comptes.";

        for (int num : numerosDesComptes) {
            res = comptes.get(num).toString();

        }
        return res;
    }

    public boolean demandeEmprunt(int numCompte, int montant) {
        Compte compte = comptes.get(numCompte);
        return compte.offreGarantiesSuffiantesPour(montant);

    }
}