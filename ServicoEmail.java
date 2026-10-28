/** Simulação de envio de e-mail para demonstrar a separação de responsabilidades. */
public class ServicoEmail {
    public void enviarResultado(String destinatario, double media) {
        System.out.println(
            "E-mail (simulação) enviado para " + destinatario
            + " com a média " + String.format("%.2f", media)
        );
    }
}
