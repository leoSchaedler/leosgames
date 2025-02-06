package br.puc.pr.DecisionTree;

import br.puc.pr.Auxiliar.AtributosEnum;

public class No {

    private No filhoEsquerdo;
    private No filhoDireito;

    private Double heuristica;
    private AtributosEnum atributo;

    public No(Double heuristica, AtributosEnum atributo) {
        this.heuristica = heuristica;
        this.atributo = atributo;
    }

    public boolean isFolha(){
        return filhoDireito == null && filhoEsquerdo == null;
    }


    public No getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public No getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    public Double getHeuristica() {
        return heuristica;
    }

    public AtributosEnum getAtributo() {
        return atributo;
    }

    public void showNo() {
        System.out.println("    No: " + heuristica + "("+atributo.getName()+")");
        if (!isFolha()){
            if (filhoEsquerdo != null)
                System.out.println("    Filho esquerdo: " + filhoEsquerdo.getHeuristica()+ "("+filhoEsquerdo.getAtributo().getName()+")");
            if (filhoDireito != null)
                System.out.println("    Filho direito: " + filhoDireito.getHeuristica()+ "("+filhoDireito.getAtributo().getName()+")");
        }
    }
}
