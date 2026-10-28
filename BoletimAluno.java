import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Mantém e valida as notas do aluno e calcula a média. */
public class BoletimAluno {
    private final List<Double> notas = new ArrayList<>();

    public void adicionarNota(double nota) {
        if (!Double.isFinite(nota) || nota < 0.0 || nota > 10.0) {
            throw new IllegalArgumentException(
                "A nota deve ser um número entre 0 e 10."
            );
        }
        notas.add(nota);
    }

    /** Retorna uma cópia não modificável, sem expor a lista interna. */
    public List<Double> obterNotas() {
        return Collections.unmodifiableList(new ArrayList<>(notas));
    }

    public double calcularMedia() {
        if (notas.isEmpty()) {
            return 0.0;
        }

        double soma = 0.0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }
}
