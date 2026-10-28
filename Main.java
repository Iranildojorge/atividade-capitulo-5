public class Main {
    public static void main(String[] args) {
        BoletimAluno boletim = new BoletimAluno();

        boletim.adicionarNota(8.0);
        boletim.adicionarNota(9.0);
        boletim.adicionarNota(7.0);

        System.out.printf("Média do aluno: %.2f%n", boletim.calcularMedia());

        try {
            boletim.adicionarNota(12.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Nota rejeitada: " + e.getMessage());
        }

        System.out.println("Notas registradas: " + boletim.obterNotas());

        RepositorioNotas repositorio = new MySQLRepositorio();
        SistemaNotas sistema = new SistemaNotas(
            boletim, repositorio, new ServicoEmail()
        );
        sistema.salvarNotas();
        sistema.enviarResultado("aluno@exemplo.com");

        // Demonstra troca de implementação sem alterar SistemaNotas.
        RepositorioNotas repositorioAlternativo = new PostgresRepositorio();
        SistemaNotas sistemaAlternativo = new SistemaNotas(
            boletim, repositorioAlternativo, new ServicoEmail()
        );
        sistemaAlternativo.salvarNotas();
    }
}
