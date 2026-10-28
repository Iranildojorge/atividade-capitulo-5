import java.util.List;

/** Simulação de persistência em MySQL; não conecta a um banco real. */
public class MySQLRepositorio implements RepositorioNotas {
    @Override
    public void salvarNotas(List<Double> notas) {
        System.out.println("Notas salvas no MySQL (simulação): " + notas);
    }
}
