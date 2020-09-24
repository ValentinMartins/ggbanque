package fr.pgah.slam5;

public class Compte {

    private int solde;
    private boolean estEtranger;
    private int numCompte; // 1 compte epargene 2 compte courant
    private double taux = 0.01;

    // dictionnaire vs liste un dico permet a partir d une celf de retrouver la
    // valeur rapidement contrairement a la liste qui parcoure tout le tableau
    public Compte(boolean estEtranger, int numCompte) {

        this.estEtranger = estEtranger;
        this.numCompte = numCompte;
    }

    public int getSolde() {
        return solde;
    }

    public boolean getEstEstranger() {
        return estEtranger;
    }

    public void appliquertInterets(double taux) {
        if (typeComptes == 1) {
            solde = (int) (solde * (1 + taux));
        }

    }

    public void crediter(int montant) {
        solde += montant;

    }

    public String toString() {
        String provenance;
        String nom;
        if (estEtranger) {
            provenance = "etrangr";
        } else {
            provenance = "nom-etranger";
        }
        if (typeComptes == 1) {
            nom = "epargne";
        } else {
            nom = "courant";
        }
        return "\n\tCompte " + nom + " " + numCompte + ": solde = " + solde + "(" + provenance + ")";

    }

    public boolean offreGarantiesSuffiantesPour(int montant) {
        if (typeComptes == 1) {
            return solde >= montant / 2;
        } else {
            return solde >= 2 * montant / 3;
        }

    }
}
