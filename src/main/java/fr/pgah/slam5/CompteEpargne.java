package fr.pgah.slam5;

public class CompteEpargne extends Compte { // classe deriver de compte

    private final double Taux = 0.01;

    public CompteEpargne(boolean estEtranger, int numCompte) {
        super(estEtranger, numCompte);

    }

    @Override
    public void appliquertInterets() {

        solde = (int) (solde * (1 + Taux));

    }

    @Override
    public String toString() {
        String provenance;

        if (estEtranger) {
            provenance = "etrangr";
        } else {
            provenance = "nom-etranger";
        }

        return "\n\tCompte compte epargne  " + numCompte + ": solde = " + solde + "(" + provenance + ")";

    }

    @Override
    public boolean offreGarantiesSuffiantesPour(int montant) {

        return solde >= montant / 2;
    }
}
