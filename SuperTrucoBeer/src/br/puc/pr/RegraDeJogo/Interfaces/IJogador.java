package br.puc.pr.RegraDeJogo.Interfaces;

import br.puc.pr.Auxiliar.AtributosEnum;

public interface IJogador {

    AtributosEnum EscolheAtributo() throws InterruptedException;

    void Aprender();



}
