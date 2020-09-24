package fr.pgah.slam5;

public class CompteCourant extends Compte {

    public CompteCourant(boolean estEtranger, int numCompte) {
        super(estEtranger, numCompte);

    }

    @Override
    public void appliquertInterets() {

    }

    @Override
    public String toString() {
        String provenance;

        if (estEtranger) {
            provenance = "etrangr";
        } else {
            provenance = "nom-etranger";
        }

        return "\n\tCompte compte courant  " + numCompte + ": solde = " + solde + "(" + provenance + ")";

    }

    @Override
    public boolean offreGarantiesSuffiantesPour(int montant) {
        return solde >= 2 * montant / 3;
    }
}
