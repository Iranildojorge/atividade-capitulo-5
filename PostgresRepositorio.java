import java.util.List;

/** Implementação alternativa simulada para demonstrar a troca do repositório. */
public class PostgresRepositorio implements RepositorioNotas {
    @Override
    public void salvarNotas(List<Double> notas) {
        System.out.println("Notas salvas no PostgreSQL (simulação): " + notas);
    }
}
