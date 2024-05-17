# Componente de Gamificação

Este repositório contém um componente de gamificação desenvolvido utilizando TDD (Desenvolvimento Orientado por Testes). O componente é capaz de armazenar diferentes tipos de pontos que os usuários podem receber. Abaixo estão as especificações e orientações sobre como o componente foi desenvolvido e como pode ser utilizado.

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
