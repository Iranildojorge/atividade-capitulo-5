import java.util.List;

/** Contrato para os serviços que persistem as notas. */
public interface RepositorioNotas {
    void salvarNotas(List<Double> notas);
}
