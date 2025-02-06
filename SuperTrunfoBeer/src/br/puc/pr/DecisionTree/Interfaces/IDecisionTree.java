package br.puc.pr.DecisionTree.Interfaces;

import br.puc.pr.Auxiliar.AtributosEnum;

public interface IDecisionTree {

    void addNo(Double heuristica, AtributosEnum atributo);

    AtributosEnum getHighestAtributo();

}
