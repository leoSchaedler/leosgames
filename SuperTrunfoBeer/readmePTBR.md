# SuperTrucoBeer (PT-BR)

## Visão Geral
SuperTrucoBeer é um jogo de cartas no estilo **Super Trunfo**, baseado em diferentes tipos de cerveja. Cada carta representa um estilo de cerveja e contém estatísticas utilizadas para competir contra outros jogadores.

## Recursos
- **Jogo de cartas por turnos**, semelhante ao Super Trunfo.
- **Baralho diversificado**, com estilos de cerveja reais e atributos autênticos.
- **Suporte para IA**, permitindo partidas contra o computador.
- **Lógica baseada em Árvores de Decisão** para tomadas de decisão estratégicas.

## Instalação
### Pré-requisitos
- Java 8 ou superior
- IDE como IntelliJ IDEA, Eclipse ou VS Code com suporte para Java

### Executando o Jogo
1. Obter arquivos do jogo.
2. Abra o projeto na sua IDE Java preferida.
3. Certifique-se de que todas as dependências estão resolvidas e construa o projeto.
4. Execute a classe principal `Jogo.java` para iniciar o jogo.

## Dados & Recursos
- **Dados das cervejas**: Localizados em `src/br/puc/pr/Data/`, contendo arquivos CSV e Excel com estatísticas.
- **Imagens das cervejas**: Disponíveis em `src/br/puc/pr/Data/Beers/Beers/`, fornecendo visuais para o jogo.

## Jogabilidade
1. Cada jogador começa com um baralho de cartas de cerveja.
2. Os jogadores alternam turnos escolhendo um atributo (ex.: Teor Alcoólico, Amargor).
3. O jogador com o melhor valor no atributo escolhido vence a rodada e ganha a carta do oponente.
4. O jogo continua até que um jogador tenha todas as cartas.