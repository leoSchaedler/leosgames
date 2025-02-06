using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using System.Diagnostics; // permite criar um log de debug no outputs window

namespace BattleShip_Game
{
    public partial class Form1 : Form
    {
        List<Button> playerPosition;    // Cria uma lista para todos botoes de posicao do jogador
        List<Button> enemyPosition;    // Cria uma lista para todos botoes de posicao da maquina
        Random rand = new Random();    // Cria uma nova instancia para a classe random nomeada rand
        int totalShips = 3;        // Indica o numero total de frotas do jogador
        int totalenemy = 3;     // Indica o numero total de frotas da maquina
        int rounds = 10;        // Indica o numero de rounds de cada participante, sendo 5 para cada.
        int playerTotalScore = 0;       // Indica a pontuacao inicual do jogador
        int enemyTotalScore = 0;        // Indica a pontuacao inicial da maquina

        public Form1()
        {
            InitializeComponent();
            loadbuttons();      // Carrega os botoes do jogador e da maquina ao sistema
            attackButton.Enabled = false;       // Desativa o botao de ataque do jogador
            enemyLocationList.Text = null;      // 
        }

        private void playerPicksPosition(object sender, EventArgs e)
        {
            // essa funcao vai permitir o jogador escolher 3 posicoes no mapa
            // 
            if (totalShips > 0)
            {
                // se o total de navios for maior que 0, se checa:
                var button = (Button)sender;
                // Qual botao fora clicado
                button.Enabled = false;
                // desativa aquele botao
                button.Tag = "playerShip";
                // coloca uma tag nele chamada de playerShip
                button.BackColor = System.Drawing.Color.Blue;
                // muda a cor para azul
                totalShips--;
                // diminui o numero total de navios em 1
            }
            if (totalShips == 0)
            {
                // se o jogador tiver pegado todos 3 navios
                // se executa:
                attackButton.Enabled = true;
                // ativa o botao de ataque
                attackButton.BackColor = System.Drawing.Color.Red;
                // da a cor vermelha de background
                helpText.Top = 55;
                // move o botao help text para o topo 55
                helpText.Left = 230;
                // move o botao help text para a esquerda 230
                helpText.Text = "2) Agora pegue a posicao de ataque do drop down";
                // muda o help text para cima
            }
        }

        private void attackEnemyPosition(object sender, EventArgs e)
        {
            // essa funcao ira permitir o jogador fazer movimentos na posicao da maquina
            // chencando se o jogador consegue escolher uma localizacao do drop list
            if (enemyLocationList.Text != "")
            {
                // se a local eh escolhido corretamente se faz
                var attackPos = enemyLocationList.Text;
                // cria uma variavel chamada attack pos que recebe o valor de texto do menu drop down
                attackPos = attackPos.ToLower();
                // muda o valor de string para lower case para se equiparar ao nome do botao
                int index = enemyPosition.FindIndex(a => a.Name == attackPos);
                // nesse int se ira executar o index da posicao do inimigo e procurar a string pega pelo jogador
                // quando achada, será salva dentro da variavel local index

                // na funcao if abaixo se linkara o numero do index à enemy position list(lista de posicao da maquina)
                // e ira checar se há mais rounds para o jogador
                // se tiver, se executa
                if (enemyPosition[index].Enabled && rounds > 0)
                {
                    rounds--;
                    // reduz em 1 os rounds
                    roundsText.Text = "Rounds " + rounds;
                    // atualiza o texto de rounds

                    if (enemyPosition[index].Tag == "enemyship")
                    {
                        // se a posicao que o jogador escolheu tiver uma tag de navio inimigo se executa
                        enemyPosition[index].Enabled = false;
                        // desativa esse botao
                        enemyPosition[index].BackgroundImage = Properties.Resources.fireIcon;
                        // muda a imagem do background para fireicon
                        enemyPosition[index].BackColor = System.Drawing.Color.DarkBlue;
                        // muda a cor do background para azul escuro
                        playerTotalScore++;
                        // aumenta em 1 a pontuacao do jogador
                        playerScore.Text = "" + playerTotalScore;
                        // atualiza a pontuacao do jogador na label do jogador
                        enemyPlayTimer.Start();
                        // comeca o tempo da cpu para a maquina fazer sua jogada
                    }
                    else
                    {
                        // se o jogador pegar um local onde o navio inimigo nao esta
                        enemyPosition[index].Enabled = false;
                        // se desativa o botao
                        enemyPosition[index].BackgroundImage = Properties.Resources.missIcon;
                        // muda o back ground imagem para missicon
                        enemyPosition[index].BackColor = System.Drawing.Color.DarkBlue;
                        // muda o background para azul escuro
                        enemyPlayTimer.Start();
                    }
                        
            }
        }
        else
        {
            // se o jogador nao escolher nenhuma posicao do drop list, os avisa:
            MessageBox.Show("Escolha o local da drop list");
        }
    }
        private void enemyAttackPlayer(object sender, EventArgs e)
        {
            // funcao para fazer a maquina fazer um movimento no jogador

            // se a posicao do jogador eh mais que zero e se tem mais rounds para jogar
            // entao se fara isso nessa funcao
            if (playerPosition.Count > 0 && rounds > 0)
            {
                rounds--; // reduzira um round do total
                roundsText.Text = "Rounds" + rounds;    // mostra o numero atualizado de rounds na label

                int index = rand.Next(playerPosition.Count);    // cria uma nova int index e bota um botao aleatorio do jogador

                if (playerPosition[index].Tag == "playerShip")
                {
                    // se o index tiver a tag playership entao se executa

                    playerPosition[index].BackgroundImage = Properties.Resources.fireIcon;
                    // muda para o fireicon

                    enemyMoves.Text = "" + playerPosition[index].Text;
                    // mostra qual botao foi atacado
                    playerPosition[index].Enabled = false;
                    // desativa o botao
                    playerPosition[index].BackColor = System.Drawing.Color.DarkBlue;
                    // muda a cor do background para azul escuro
                    playerPosition.RemoveAt(index);
                    // remove o botao da lista de posicao do jogador a fim de a maquina nao atacar novamente
                    enemyTotalScore++;
                    // adicionar mais ao placar da maquina
                    enemyScore.Text = "" + enemyTotalScore;
                    // mostra a pontuacao da maquina na label
                    enemyPlayTimer.Stop();
                    // para o tempo para a maquina
                }
                else
                {
                    // se a tag do jogador nao for playership
                    // se executa
                    playerPosition[index].BackgroundImage = Properties.Resources.missIcon;
                    // mostra o incone miss icon no botao
                    enemyMoves.Text = "" + playerPosition[index].Text;
                    // atualiza o local de ataque da maquina na label 2
                    playerPosition[index].Enabled = false;
                    // desativa o botao maquina atacada
                    playerPosition[index].BackColor = System.Drawing.Color.DarkBlue;
                    // muda a cor do background para azule escuro
                    playerPosition.RemoveAt(index);
                    // remove o botao da lista, para nao ser atacado pela maquina
                    enemyPlayTimer.Stop();
                    // para o tempo da maquina
                }
            }
            // abaixo esta a funcao do if que checara se o nos o jogador ganhamos, deu empate ou derrota

            // se os rounds forem menos que 1 ou a pontuacao do jogador eh maior que 2 ou a pontuacao da maquina eh maior que 2

            if (rounds < 1 || playerTotalScore > 2 || enemyTotalScore > 2)
            {
                if (playerTotalScore > enemyTotalScore)
                {
                    // se a pontuacao do jogador eh maior que da maquina , o jogador vence
                    MessageBox.Show("Você venceu", "Vitória");
                }
                if (playerTotalScore == enemyTotalScore)
                {
                // se a pontuacao do jogador igual a da maquina , ocorre empate
                MessageBox.Show("Não houve vencedor", "Empate");
                }
                if (enemyTotalScore > playerTotalScore)
                {
                // se a pontuacao da maquina eh maior que do jogador , a maquina vence e diz
                MessageBox.Show("Lhe falta ódio, por isso foi derrotado", "Derrota");
                }
        }

        }

        private void enemyPicksPositions(object sender, EventArgs e)
        {
            // essa funcao permitira a maquina escolher 3 posicoes no mapa
            // para isso se deve garantir que a maquina escolhera 3 posicoes no mapa

            int index = rand.Next(enemyPosition.Count);
            // cria uma variavel local chamada index e escolhera um botao aleatorio da enemy position list(lista de posicao da maquina)
            if (enemyPosition[index].Enabled == true && enemyPosition[index].Tag == null)
            {
                // quando se achar os botoes que devem ser checados e para saber se estao ativos e nao possuem tag
                enemyPosition[index].Tag = "enemyship";
                // adiciona a tag chamada enemy ship aos botoes 
                totalenemy--;
                // diminui o numero total de inimigos em 1

                Debug.WriteLine("Enemy Position " + enemyPosition[index].Text);
                // a linha acima vai mostrar na debug window qual botao a maquina escolheu
                // isso nos ajuda a descobrir se o jogo funciona como o esperado
            }
            else
            {
                // se condicao do topo nao coencidir, entao se executara novamente para selecionar as 3 posicoes e tags
                index = rand.Next(enemyPosition.Count);
            }
            if (totalenemy < 1)
            {
            // se a maquina escolheu 3 posicoes entao o timer para
            enemyPositionPicker.Stop();
            }
        }
        private void loadbuttons()
        {
            // Essa funcao ira carregar todos os botoes na lista declada acima
            // Carrega-se primeiramente todos os botoes do jogador e da maquina
            playerPosition = new List<Button> { w1, w2, w3, w4, w5, w6, w7, w8, w9, w10,x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, y1, y2, y3, y4, y5, y6, y7, y8, y9, y10, z1, z2, z3, z4,
            z5, z6, z7, z8, z9, z10, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, u1, u2, u3, u4, u5, u6, u7, u8, u9, u10, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, t1, t2, t3, t4, t5, t6, t7,
            t8, t9, t10, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
            enemyPosition = new List<Button> { a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, b1, b2, b3, b4, b5, b6, b7, b8 ,b9, b10, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, d1, d2, d3, d4, d5,
            d6, d7, d8, d9, d10, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, h1, h2, h3, h4, h5, h6, h7, h8, h9,h10,
            i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, k1, k2, k3, k4, k5, k6, k7, k8, k9, k10};

            // Esse loop que ira passar em cada posicao dos botoes da maquina
            // Depois os vai adicionar ao enemy locaton drop list para o jogador
            // Tambem vai remover todas tags das posicoes dos botoes da maquina
            for (int i = 0; i <enemyPosition.Count; i++)
            {
                enemyPosition[i].Tag = null;
                enemyLocationList.Items.Add(enemyPosition[i].Text);

            }
        }
    }
}