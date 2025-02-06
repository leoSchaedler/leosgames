package br.puc.pr.RegraDeJogo;

import br.puc.pr.Auxiliar.AtributosEnum;
import br.puc.pr.Auxiliar.InputReaderService;
import br.puc.pr.Auxiliar.LegendaService;
import br.puc.pr.RegraDeJogo.Interfaces.IPartida;
import br.puc.pr.RegraDeJogo.Jogadores.IA;
import br.puc.pr.RegraDeJogo.Jogadores.Player;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Partida implements IPartida {

    private final Scanner input = new Scanner(System.in);
    private final Random random = new Random();
    private final InputReaderService inputReaderService = new InputReaderService();

    private final int numeroDeCartas_Total;
    private final int numeroDeCartas;
    private int vez;

    private ArrayList<Jogador> jogadores;

    public Partida(int numerodecartasDistribuidas) {
        this.numeroDeCartas = numerodecartasDistribuidas;
        jogadores = new ArrayList<>();
        numeroDeCartas_Total = 30;
    }


    @Override
    public void IniciarJogo() throws Exception {

        AdicionarJogadores();

        DestribuirCartas();

        this.vez = random.nextInt(jogadores.size());
    }

    private void RemovePerdedores() {
        ArrayList<Jogador> jogadoresNew =  (ArrayList<Jogador>) jogadores.clone();
        for (Jogador jogador : jogadoresNew)
            if (jogador.getCartas().getTamanho() <= 0)
                jogadores.remove(jogador);
    }

    @Override
    public void Disputa() throws Exception{
        System.out.println();
        AtributosEnum atribuitoEscolhido = jogadores.get(vez).EscolheAtributo();
        ArrayList<Carta> cartasJogadas = new ArrayList<>();
        RemovePerdedores();
        for (Jogador jogador : jogadores) {
            jogador.Aprender();
            cartasJogadas.add(jogador.getCartas().remove());
        }
        int jogadorGanhador = -1;
        double maiorAtributo = Double.MIN_VALUE;
        double aux;
        for (int i = 0; i < cartasJogadas.size(); i++) {
                aux = 0;
                switch (Objects.requireNonNull(atribuitoEscolhido)) {
                    case ABV:
                        aux = cartasJogadas.get(i).getAtributos().getABV();
                        break;
                    case IBU:
                        aux = cartasJogadas.get(i).getAtributos().getIBU();
                        break;
                    case ORIGINALGRAVITY:
                        aux = cartasJogadas.get(i).getAtributos().getOriginalGravity();
                        break;
                    case FINALGRAVITY:
                        aux = cartasJogadas.get(i).getAtributos().getFinalGravity();
                        break;
                    case SRM:
                        aux = cartasJogadas.get(i).getAtributos().getSRM();
                        break;
                }
                if (aux > maiorAtributo) {
                    maiorAtributo = aux;
                    jogadorGanhador = i;
                }
        }
        System.out.print(LegendaService.getLegendCode(-1));
        try {
            System.out.println("Cartas em jogo:");
            for (int i = 0; i < cartasJogadas.size(); i++){
                    System.out.println(LegendaService.getLegendCode(jogadores.get(i).getLegendCode()));
                    System.out.println("Carta de: " + jogadores.get(i).getNome());
                    cartasJogadas.get(i).showCarta();
            }
            System.out.println();
            System.out.println(LegendaService.getLegendCode(jogadores.get(jogadorGanhador).getLegendCode()) + "  >>> O jogador vitorioso foi " + jogadores.get(jogadorGanhador).getNome() + " com o atributo de " + maiorAtributo + " " + Objects.requireNonNull(atribuitoEscolhido).getName() +  " <<<" +"\r");
            System.out.println();
            vez = jogadorGanhador;
            PassarCartas(jogadores.get(vez), cartasJogadas);
        } catch (Exception e){
            System.out.println(LegendaService.getLegendCode(-1) + "Não foi possível identificar um ganhador");
        }
        for (Jogador jogador : jogadores)
            System.out.println(LegendaService.getLegendCode(jogador.getLegendCode()) + "Número de cartas " + jogador.getNome() + ": " + jogador.getCartas().getTamanho());
    }

    @Override
    public void AdicionarJogadores(){
        System.out.print(LegendaService.getLegendCode(-1));
        System.out.println("Quantos jogadores? ");
        System.out.print(">>  ");
        int nJogadores = inputReaderService.ReadInteger();
        if (nJogadores < 2)
            while (nJogadores < 2){
                System.out.println("Pelo menos dois jogadores ... tente novamente");
                nJogadores = inputReaderService.ReadInteger();
            }
        if (nJogadores*numeroDeCartas > numeroDeCartas_Total)
            while (nJogadores*numeroDeCartas > numeroDeCartas_Total){
                System.out.println("Não terão cartas suficientes!");
                System.out.println("Tente novamente e digite outro número");
                System.out.println("(Sugerimos algo menor a " + (numeroDeCartas_Total/numeroDeCartas) + " jogadores)");
                System.out.print(">> ");
                nJogadores = inputReaderService.ReadInteger();
            }
        System.out.println();

        System.out.println("Quantos jogadores serão IA?");
        System.out.print(">>  ");
        int nJogadoresIA = inputReaderService.ReadInteger();
        while (nJogadoresIA > nJogadores){
            System.out.println("Número de IA maior do que jogadores!");
            System.out.println("Tente um número abaixo de " + (nJogadores+1));
            System.out.print(">> ");
            nJogadoresIA = inputReaderService.ReadInteger();
        }
        int nJogadoresH = nJogadores - nJogadoresIA;
        System.out.println();
        int code = 1;
        for (int i = 0; i < nJogadoresH; i++) {
            System.out.println("Digite o nome do jogador " + (i+1) + ": ");
            System.out.print(">>  ");
            String jogadorSubtitle = "[Jogador";
            if ((i+1) < 10)
                jogadorSubtitle += "0";
            jogadores.add(new Player(jogadorSubtitle + (i+1) + "] " + input.nextLine(), code++));
            System.out.println();
        }
        for (int i = 0; i < nJogadoresIA; i++)
            jogadores.add(new IA("IA"+(i+1), code++));
    }

    @Override
    public void DestribuirCartas() throws Exception{
        List<String> fileCartas = Files.readAllLines(Paths.get("src/br/puc/pr/Data/beers.csv"));
        boolean[] used = new boolean[fileCartas.size()];
        Arrays.fill(used, false);
        int distribuias = 0;
        int aux;
        for (int i = 0; i < numeroDeCartas; i++){
            for (Jogador jogador : jogadores){
                aux = random.nextInt(fileCartas.size());
                if (used[aux] || distribuias >= fileCartas.size())
                    if (distribuias >= fileCartas.size())
                        return;
                    else
                        while (used[aux])
                            aux = random.nextInt(fileCartas.size());
                jogador.getCartas().add(new Carta(fileCartas.get(aux)));
                used[aux] = true;
                distribuias++;
            }
        }
        for (Jogador jogador : jogadores)
            System.out.println(LegendaService.getLegendCode(jogador.getLegendCode()) + "Número de cartas " + jogador.getNome() + ": " + jogador.getCartas().getTamanho());
        System.out.println(LegendaService.getLegendCode(-1));
    }


    @Override
    public void PassarCartas(Jogador beneficiado, ArrayList<Carta> cartas) {
        cartas.forEach(carta -> beneficiado.getCartas().add(carta));
    }

    @Override
    public boolean ConfereCartas(){
        AtomicInteger contZero = new AtomicInteger(0);
        jogadores.forEach(jogador -> {
            if (jogador.getCartas().getTamanho() == 0)
                contZero.set(contZero.get()+1);
        });
        return (!(contZero.get() == jogadores.size()-1));
    }

    @Override
    public void ConfereCampeao(){
        AtomicInteger vencedor = new AtomicInteger(Integer.MIN_VALUE);
        AtomicReference<Jogador> mem = new AtomicReference<>();
        jogadores.forEach(jogador -> {
            if (jogador.getCartas().getTamanho() > vencedor.get()) {
                vencedor.set(jogador.getCartas().getTamanho());
                mem.set(jogador);
            }
        });
        System.out.println();
        if (mem.get() != null)
            System.out.println(LegendaService.getLegendCode(mem.get().getLegendCode()) + "      ->>>> O VENCEDOR FOI ==>> " + mem.get().getNome() + " ("+vencedor.get()+" cartas) <<<<-");
        else
            System.out.println(LegendaService.getLegendCode(-1) + "Não foi possivel identificar ganhadores");
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }
}
