package fr.pgah.slam5;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Banque {

    private HashMap<Integer, Compte> comptes = new HashMap<>();
    private double taux = 0.01;
    private int numDernierCompte = 0;

    public int creeCompte(boolean origine) {
        int numCompte = numDernierCompte++;
        Compte nouveau = new Compte(origine);
        comptes.put(numCompte, nouveau);
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
        for (Compte compte : comptes.values()) {

            compte.appliquertInterets(taux);

        }
    }

    public String toString() {

        Set<Integer> numerosDesComptes = comptes.keySet();
        String res = "La banque gère " + numerosDesComptes.size() + " comptes.";
        String provenance;

        for (int num : numerosDesComptes) {
            if (comptes.get(num).getEstEstranger()) {
                provenance = "etranger";
            } else {
                provenance = "non-etranger";
            }
            res += "\n\tCompte " + num + ": solde = " + comptes.get(num).getSolde() + "(" + provenance + ")";// comptes.get(num).getEstEtranger()?"etranger":"non-etranger"

        }
        return res;
    }

    public boolean demandeEmprunt(int numCompte, int montant) {

        int solde = comptes.get(numCompte).getSolde();
        return solde >= montant / 2;

    }
}