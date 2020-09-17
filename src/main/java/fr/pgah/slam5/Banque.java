package fr.pgah.slam5;

import java.util.HashMap;
import java.util.Set;

public class Banque {

    private HashMap<Integer, Integer> comptes = new HashMap<>();
    private double taux = 0.01;
    private int numDernierCompte = 0;

    public int creeCompte() {
        int numCompte = numDernierCompte++;
        comptes.put(numCompte, 0);
        return numCompte;
    }

    public int getSolde(int numCompte) {
        return comptes.get(numCompte);
    }

    public void crediter(int numCompte, int montant) {
        int solde = comptes.get(numCompte);
        int nouveauSolde = solde + montant;
        comptes.put(numCompte, nouveauSolde);
    }

    public void appliquertInterets() {
        Set<Integer> numerosDesComptes = comptes.keySet();
        for (int num : numerosDesComptes) {
            int solde = comptes.get(num);
            int nouveauSolde = (int) (solde * (1 + taux));
            comptes.put(num, nouveauSolde);

        }
    }

    public String toString() {

        Set<Integer> numerosDesComptes = comptes.keySet();
        String res = "La banque gère " + numerosDesComptes.size() + " comptes.";
        for (int num : numerosDesComptes) {
            res += "\n\tCompte " + num + ": solde = " + comptes.get(num);

        }
        return res;
    }

    public boolean demandeEmprunt(int numCompte, int montant) {

        int solde = comptes.get(numCompte);
        return solde >= montant / 2;

    }
}