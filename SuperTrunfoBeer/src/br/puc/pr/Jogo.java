package br.puc.pr;

import br.puc.pr.Auxiliar.LegendaService;
import br.puc.pr.RegraDeJogo.Partida;

import java.util.Scanner;

public class Jogo {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        MenuStart();

        Partida partida = new Partida(5);

        partida.IniciarJogo();

        System.out.println("!!Partida iniciada com sucesso!!");
        System.out.print("Aperte 'ENTER' para iniciar a partida!");
        input.nextLine();
        System.out.println();



        int partidas = 0;


        while (partida.ConfereCartas()){

            ControleRodadas(++partidas);


            partida.Disputa();

        }

        partida.ConfereCampeao();

    }

    private static void MenuStart(){
        System.out.print("\033[0;96m");
        System.out.println("    +=================+");
        System.out.println("    |       / \\       |");
        System.out.println("    |      /   \\      |");
        System.out.println("    |     /     \\     |");
        System.out.println("    |    /       \\    |");
        System.out.println("    |   /         \\   |");
        System.out.println("    |  /           \\  |");
        System.out.println("    | /             \\ |");
        System.out.println("    |/               \\|");
        System.out.print("\033[0;95m");
        System.out.println("    +SUPER TRUNFO BEER+ ");
        System.out.print("\033[0;96m");
        System.out.println("    |\\               /|");
        System.out.println("    | \\             / |");
        System.out.println("    |  \\           /  |");
        System.out.println("    |   \\         /   |");
        System.out.println("    |    \\       /    |");
        System.out.println("    |     \\     /     |");
        System.out.println("    |      \\   /      |");
        System.out.println("    |       \\ /       |");
        System.out.println("    +=================+");
        System.out.println();
    }

    private static void ControleRodadas(int partidas){
        System.out.println(LegendaService.getLegendCode(-1));
        System.out.print("Aperter 'ENTER' para a próxima rodada");
        input.nextLine();
        System.out.println(" >>RODADA " + (partidas) + "<<");
    }
}
