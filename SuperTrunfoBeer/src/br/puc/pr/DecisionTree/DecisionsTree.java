package br.puc.pr.DecisionTree;

import br.puc.pr.Auxiliar.AtributosEnum;
import br.puc.pr.DecisionTree.Interfaces.IDecisionTree;

import java.util.ArrayList;

public class DecisionsTree implements IDecisionTree {

    private No raiz;

    public DecisionsTree(Double heuristica, AtributosEnum atributo) {
        this.raiz = new No(heuristica, atributo);
    }


    @Override
    public void addNo(Double heuristica, AtributosEnum atributo) {
        No mem = raiz;
        while (!mem.isFolha()){
            if (heuristica > mem.getHeuristica())
                if (mem.getFilhoDireito() != null)
                    mem = mem.getFilhoDireito();
                else
                    break;
            else if (mem.getFilhoEsquerdo() != null)
                mem = mem.getFilhoEsquerdo();
            else
                break;
        }
        if (heuristica > mem.getHeuristica())
            mem.setFilhoDireito(new No(heuristica, atributo));
        else
            mem.setFilhoEsquerdo(new No(heuristica, atributo));
    }

    @Override
    public AtributosEnum getHighestAtributo() {
        No highest = raiz;
        while (highest.getFilhoDireito() != null)
            highest = highest.getFilhoDireito();
        return highest.getAtributo();
    }

    public ArrayList<No> BuscaAprofundada(){
        ArrayList<No> no = new ArrayList<>();
        BuscaProfunda(raiz, no);
        return no;
    }

    private void BuscaProfunda(No no, ArrayList<No> nos){
        if (no.getFilhoEsquerdo() != null){
            nos.add(no.getFilhoEsquerdo());
            BuscaProfunda(no.getFilhoEsquerdo(), nos);
        }
        if (no.getFilhoDireito() != null){
            nos.add(no.getFilhoDireito());
            BuscaProfunda(no.getFilhoDireito(), nos);
        }
    }
}
