# Atividade prática — Esse sistema precisa mudar!

## Integrantes
- Nathalia Brandão
- Iranildo Nunes
- Tailana Batista

## Descrição
Refatoração de um sistema de notas em Java, aplicando encapsulamento, separação de responsabilidades e inversão de dependência.

## Arquivos e responsabilidades
- `BoletimAluno.java`: mantém as notas privadas, valida valores entre 0 e 10 e calcula a média.
- `RepositorioNotas.java`: interface que define o contrato de persistência.
- `MySQLRepositorio.java`: simula o salvamento em MySQL.
- `PostgresRepositorio.java`: implementação alternativa para demonstrar a troca do repositório.
- `ServicoEmail.java`: simula o envio de e-mail.
- `SistemaNotas.java`: coordena os serviços e recebe o repositório pelo construtor.
- `Main.java`: executa os cenários solicitados.

## Requisitos
É necessário ter o JDK instalado para compilar e executar localmente. Não é necessário configurar banco de dados ou servidor de e-mail: ambos são simulados no console.

## Como compilar e executar
No terminal, dentro da pasta que contém os arquivos:

```bash
javac *.java
java Main
```

## Soluções aplicadas
### Encapsulamento e ocultação de informações
A lista de notas é `private`. A classe valida as notas ao adicioná-las e `obterNotas()` retorna uma cópia não modificável, evitando que código externo altere a coleção interna.

### Média
A média é a soma das notas dividida pela quantidade. Quando não existem notas, o método retorna `0.0`.

### Princípio da Responsabilidade Única (SRP)
O boletim gerencia e calcula notas; o repositório cuida da persistência; o serviço de e-mail simula a comunicação; e `SistemaNotas` coordena o fluxo.

### Princípio da Inversão de Dependência (DIP)
`SistemaNotas` recebe um objeto do tipo `RepositorioNotas` pelo construtor. Como depende da interface, pode usar `MySQLRepositorio` ou `PostgresRepositorio` sem precisar alterar a classe coordenadora.

## Cenários demonstrados
- Adiciona as notas 8.0, 9.0 e 7.0.
- Exibe a média 8.00.
- Tenta adicionar 12.0 e captura a exceção; a nota inválida não é registrada.
- Simula o salvamento das notas e o envio de e-mail.
- Substitui a implementação MySQL pela implementação PostgreSQL sem modificar `SistemaNotas`.

## Observação
As classes de persistência e e-mail são demonstrações em console; não realizam conexões reais.
