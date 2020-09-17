package fr.pgah.slam5;

public class Compte {

    private int solde;
    private boolean estEtranger;

    // dictionnaire vs liste un dico permet a partir d une celf de retrouver la
    // valeur rapidement contrairement a la liste qui parcoure tout le tableau
    public Compte(boolean esttranger) {

        this.estEtranger = esttranger;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int nouveauSolde) {
        this.solde = nouveauSolde;
    }

    public boolean getEstEstranger() {
        return estEtranger;
    }
}
