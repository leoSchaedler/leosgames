package br.puc.pr.RegraDeJogo.Jogadores;

import br.puc.pr.Auxiliar.Atributos;
import br.puc.pr.Auxiliar.AtributosEnum;
import br.puc.pr.Auxiliar.LegendaService;
import br.puc.pr.DecisionTree.DecisionsTree;
import br.puc.pr.RegraDeJogo.Interfaces.IJogador;
import br.puc.pr.RegraDeJogo.Jogador;

public class IA extends Jogador implements IJogador {

    private Atributos aprendizdo;

    public IA(String nome, int legendCode) {
        super(nome, legendCode);
        this.aprendizdo = new Atributos(
                "Aprendizado",
                Double.MIN_VALUE,
                Double.MIN_VALUE,
                Double.MIN_VALUE,
                Double.MIN_VALUE,
                Double.MIN_VALUE
        );
    }


    @Override
    public AtributosEnum EscolheAtributo() throws InterruptedException {
        System.out.print(LegendaService.getLegendCode(getLegendCode()));
        System.out.println("Vez da " + super.getNome());
        Aprender();
        System.out.println(super.getNome() + " escolhendo atributo ...");
        AtributosEnum aux = ConstruirGrafo().getHighestAtributo();
        System.out.println("A " + getNome() + " escolheu o atributo " + aux.getName());
        Thread.sleep(650);
        return aux;
    }

    private double CalularHeuristica(double memoria, double carta){
        return carta/memoria;
    }


    private DecisionsTree ConstruirGrafo(){
        DecisionsTree grafo = new DecisionsTree(
                CalularHeuristica(aprendizdo.getABV(), getCartas().getCartaVez().getAtributos().getABV()),
                AtributosEnum.ABV);
        grafo.addNo(
                CalularHeuristica(aprendizdo.getFinalGravity(), getCartas().getCartaVez().getAtributos().getFinalGravity()),
                AtributosEnum.FINALGRAVITY);
        grafo.addNo(
                CalularHeuristica(aprendizdo.getIBU(), getCartas().getCartaVez().getAtributos().getIBU()),
                AtributosEnum.IBU);
        grafo.addNo(
                CalularHeuristica(aprendizdo.getOriginalGravity(), getCartas().getCartaVez().getAtributos().getOriginalGravity()),
                AtributosEnum.ORIGINALGRAVITY);
        grafo.addNo(
                CalularHeuristica(aprendizdo.getSRM(), getCartas().getCartaVez().getAtributos().getSRM()),
                AtributosEnum.SRM);
        return grafo;
    }

    @Override
    public void Aprender(){
        if (aprendizdo.getABV() < getCartas().getCartaVez().getAtributos().getABV())
            aprendizdo.setABV(getCartas().getCartaVez().getAtributos().getABV());
        if (aprendizdo.getIBU() < getCartas().getCartaVez().getAtributos().getIBU())
            aprendizdo.setIBU(getCartas().getCartaVez().getAtributos().getIBU());
        if (aprendizdo.getOriginalGravity() < getCartas().getCartaVez().getAtributos().getOriginalGravity())
            aprendizdo.setOriginalGravity(getCartas().getCartaVez().getAtributos().getOriginalGravity());
        if (aprendizdo.getFinalGravity() < getCartas().getCartaVez().getAtributos().getFinalGravity())
            aprendizdo.setFinalGravity(getCartas().getCartaVez().getAtributos().getFinalGravity());
        if (aprendizdo.getSRM() < getCartas().getCartaVez().getAtributos().getSRM())
            aprendizdo.setSRM(getCartas().getCartaVez().getAtributos().getSRM());
    }



}
