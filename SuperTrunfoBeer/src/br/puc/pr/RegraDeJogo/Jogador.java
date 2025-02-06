package br.puc.pr.RegraDeJogo;

import br.puc.pr.Auxiliar.AtributosEnum;
import br.puc.pr.Auxiliar.Fila;
import br.puc.pr.RegraDeJogo.Interfaces.IJogador;

public class Jogador implements IJogador
{

    private final String nome;

    private Fila cartas;

    private final int legendCode;


    public Jogador(String nome, int legendCode){
        this.nome = nome;
        this.cartas = new Fila();
        this.legendCode = legendCode;
    }

    public String getNome() {
        return nome;
    }

    public Fila getCartas() {
        return cartas;
    }

    public int getLegendCode() {
        return legendCode;
    }

    @Override
    public AtributosEnum EscolheAtributo() throws InterruptedException {
        return null;
    }

    @Override
    public void Aprender() {
        return;
    }

}
