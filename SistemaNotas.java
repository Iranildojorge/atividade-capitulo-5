/**
 * Coordena o fluxo do sistema e recebe o repositório pelo construtor.
 * Depende da interface RepositorioNotas, não de uma classe concreta.
 */
public class SistemaNotas {
    private final BoletimAluno boletim;
    private final RepositorioNotas repositorio;
    private final ServicoEmail servicoEmail;

    public SistemaNotas(
        BoletimAluno boletim,
        RepositorioNotas repositorio,
        ServicoEmail servicoEmail
    ) {
        this.boletim = boletim;
        this.repositorio = repositorio;
        this.servicoEmail = servicoEmail;
    }

    public void salvarNotas() {
        repositorio.salvarNotas(boletim.obterNotas());
    }

    public void enviarResultado(String destinatario) {
        servicoEmail.enviarResultado(destinatario, boletim.calcularMedia());
    }
}
