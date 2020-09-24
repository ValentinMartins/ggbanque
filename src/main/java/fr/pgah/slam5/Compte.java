package fr.pgah.slam5;

public class Compte {

    protected int solde; //
    protected boolean estEtranger;
    protected int numCompte; // 1 compte epargene 2 compte courant

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

    public void appliquertInterets() {

    }

    public void crediter(int montant) {
        solde += montant;

    }

    public String toString() {
        return "";
    }

    public boolean offreGarantiesSuffiantesPour(int montant) {
        return false;
    }
}
