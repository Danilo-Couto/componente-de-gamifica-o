# Componente de Gamificação

Projeto final do curso de Orientação a Objetos com Java by Instituto Tecnológico da Aeronáutica

Este repositório contém um componente de gamificação desenvolvido utilizando TDD (Desenvolvimento Orientado por Testes). O componente é capaz de armazenar diferentes tipos de pontos que os usuários podem receber. Abaixo estão as especificações e orientações sobre como o componente foi desenvolvido e como pode ser utilizado.

## Sobre este Curso

Sobre este Curso
Neste curso, assumimos que você já sabe projetar e desenvolver programas mais complexos em Java, com método e organização graças às boas práticas e princípios exercitados no curso anterior; mas você talvez não se sinta ainda confortável em projetar programas usando técnicas ágeis, como o desenvolvimento guiado por testes (TDD). 

O objetivo deste curso é expor você aos princípios e práticas de desenvolvimento guiado por testes, tanto para modelar quanto para desenvolver aplicações e componentes de software, sem abandonar os conceitos e princípios de orientação a objetos aprendidos no curso anterior. De fato, pregamos que tais conceitos e princípios fortalecem o emprego do TDD no desenvolvimento ágil de software com mais qualidade. Este curso terá um grande foco em atividades hands-on, permitindo a você captar todos os aspectos práticos da técnica e facilitar a sua aplicação quando estiver projetando e desenvolvendo software de maneira ágil nos próximos cursos.

Os conceitos de desenvolvimento de software com Java apresentados neste curso incluem o seguinte: revisão de testes de unidade; automação de testes; desenvolvimento guiado por testes; ciclo do TDD; refatoração de código de produção; ciclo de refatoração; uso de objetos stubs e mocks; boas práticas no TDD; modelagem de software por meio do TDD.

Ao final deste curso, você terá amadurecido de tal modo suas habilidades de programação que será capaz de implementar, agora usando o TDD, versões modificadas e estendidas do componente de gamificação constante do Trabalho de Conclusão da Especialização, com base nas boas práticas exercitadas neste curso.

Nível	Intermediário
Compromisso	32 horas
Classificação média do usuário 4.7

## Estrutura do Componente

O componente é composto por duas classes principais:

1. **Placar**: Contém a lógica principal do componente de gamificação.
2. **Armazenamento**: Responsável por armazenar e recuperar informações de um arquivo.

### Classe Armazenamento

A classe `Armazenamento` realiza as seguintes operações:

- **Armazenar pontos para um usuário**: Registra que um usuário recebeu uma quantidade de um tipo de ponto. Por exemplo, o usuário "guerra" recebeu "10" pontos do tipo "estrela".
- **Recuperar pontos de um usuário**: Retorna a quantidade de pontos de um tipo específico que um usuário possui. Por exemplo, quantos pontos do tipo "estrela" o usuário "guerra" possui.
- **Listar todos os usuários**: Retorna todos os usuários que já receberam algum tipo de ponto.
- **Listar todos os tipos de pontos**: Retorna todos os tipos de pontos que já foram registrados para algum usuário.

### Classe Placar

A classe `Placar` é composta por uma instância da classe `Armazenamento` e realiza as seguintes operações:

- **Registrar pontos para um usuário**: Registra que um usuário recebeu uma quantidade de um tipo de ponto.
- **Recuperar todos os pontos de um usuário**: Retorna todos os pontos de um usuário. Por exemplo, se o usuário "guerra" possui "20" pontos do tipo "moeda" e "25" pontos do tipo "estrela", esses valores serão retornados.
- **Ranking de pontos**: Retorna o ranking de um tipo de ponto específico, ordenado do usuário que possui mais pontos para o que possui menos.

## Requisitos

Para desenvolver o componente, os seguintes requisitos foram atendidos:

- Armazenamento dos dados em arquivo.
- Desenvolvimento utilizando TDD.
- Testes de unidade para as classes `Armazenamento` e `Placar`.
- Testes de integração entre as classes `Armazenamento` e `Placar`.
- Uso de mocks para a instância de `Armazenamento` nos testes da classe `Placar`.

## Formas de Implementar o Armazenamento em Arquivo

A classe `Armazenamento` pode utilizar diversas formas para armazenar os dados em arquivo, como:

- Arquivos de texto simples.
- Arquivos JSON.
- Arquivos CSV.

A escolha da forma de armazenamento fica a critério do desenvolvedor.
