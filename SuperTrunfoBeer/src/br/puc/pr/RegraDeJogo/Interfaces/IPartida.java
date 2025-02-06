package br.puc.pr.RegraDeJogo.Interfaces;

import br.puc.pr.RegraDeJogo.Carta;
import br.puc.pr.RegraDeJogo.Jogador;

import java.util.ArrayList;

public interface IPartida {

    void DestribuirCartas() throws Exception;

    void IniciarJogo() throws Exception;

    void PassarCartas(Jogador beneficiado, ArrayList<Carta> cartas);

    void Disputa() throws Exception;

    boolean ConfereCartas();

    void ConfereCampeao();

    void AdicionarJogadores();

}
