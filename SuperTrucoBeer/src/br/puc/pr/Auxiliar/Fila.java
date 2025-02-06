package br.puc.pr.Auxiliar;

import br.puc.pr.RegraDeJogo.Carta;

import java.util.ArrayList;

public class Fila {

    private ArrayList<Carta> cartas;
    private int primeiro;
    private int tamanho;

    public Fila() {
        this.cartas = new ArrayList<>();
        this.primeiro = -1;
        this.tamanho = 0;
    }

    public void add(Carta carta){
        if (primeiro == -1)
            primeiro++;
        cartas.add(carta);
        tamanho++;
    }

    public Carta remove(){
        Carta mem = null;
        if (tamanho > 0){
            mem = cartas.get(primeiro);
            primeiro++;
            tamanho--;
        }
        return mem;
    }

    public Carta getCartaVez(){
        return cartas.get(primeiro);
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public int getPrimeiro() {
        return primeiro;
    }

    public int getTamanho() {
        return tamanho;
    }
}
