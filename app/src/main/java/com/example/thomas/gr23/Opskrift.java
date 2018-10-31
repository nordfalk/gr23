package com.example.thomas.gr23;

public class Opskrift {

    int id;
    int pris;
    int niveau;
    String navn;
    String opskrift;
    int billede;

    @Override
    public String toString() {
        return this.navn + ", \n"+ this.opskrift;
    }

    public Opskrift(int id, int pris, int niveau, String navn, String opskrift, int billede){
        this.id = id;
        this.pris = pris;
        this.niveau = niveau;
        this.navn = navn;
        this.opskrift = opskrift;
        this.billede = billede;

    }
}
