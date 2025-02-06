package br.puc.pr.RegraDeJogo.Jogadores;

import br.puc.pr.Auxiliar.AtributosEnum;
import br.puc.pr.Auxiliar.InputReaderService;
import br.puc.pr.Auxiliar.LegendaService;
import br.puc.pr.RegraDeJogo.Interfaces.IJogador;
import br.puc.pr.RegraDeJogo.Jogador;

import java.util.Scanner;

public class Player extends Jogador implements IJogador {

    private final Scanner input = new Scanner(System.in);
    private final InputReaderService inputReaderService = new InputReaderService();

    public Player(String nome, int legendCode) {
        super(nome,legendCode);
    }

    @Override
    public AtributosEnum EscolheAtributo() {
        System.out.print(LegendaService.getLegendCode(getLegendCode()));
        System.out.println(super.getNome() + " sua vez de jogar!");
        System.out.print("Aperte 'ENTER' para mostrar sua carta");
        input.nextLine();
        System.out.println();
        getCartas().getCartaVez().showCarta();
        System.out.println("Digite o código do atributo que você deseja: ");
        System.out.print(">> ");
        int userEnum = inputReaderService.ReadInteger(AtributosEnum.TIPO.getType(), AtributosEnum.SRM.getType());
        System.out.println();
        return AtributosEnum.getByType(userEnum);
    }

    @Override
    public void Aprender() {
        return;
    }

}
