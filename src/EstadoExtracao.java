
public class EstadoExtracao extends AbstractState<Seraphim> {

    private int ciclosExtracao;

    public EstadoExtracao(Seraphim character) {
        super(character);
    }

    @Override
    public void enter() {
        ciclosExtracao = 0;

        System.out.println("[Seraphim] Iniciando extracao.");
        System.out.println("[Seraphim] Deslocando-se ate o Trailblazer.");
    }

    @Override
    public void execute() {
        Seraphim agente = getCharacter();
        Trailblazer trailblazer = agente.getTrailblazer();

        if (agente.isExtracaoConcluida()) {
            return;
        }

        if (!trailblazer.isOperacional()) {
            System.out.println(
                    "[Seraphim] Extracao interrompida!");
            return;
        }

        ciclosExtracao++;

        System.out.println("[Seraphim] Ciclo de extracao: "
                + ciclosExtracao);

        if (ciclosExtracao == 1) {
            System.out.println(
                    "[Seraphim] Aproximando-se da zona de extracao.");

        } else if (ciclosExtracao == 2) {
            System.out.println(
                    "[Seraphim] Acoplando ao Trailblazer.");
            System.out.println(
                    "[Seraphim] Transferindo carga.");

        } else if (ciclosExtracao >= 3) {
            System.out.println(
                    "[Seraphim] Carga recuperada com sucesso!");
            System.out.println(
                    "[Seraphim] Operacao concluida.");

            agente.concluirExtracao();
        }
    }

    @Override
    public void leave() {
        System.out.println(
                "[Seraphim] Encerrando protocolo de extracao.");
    }
}

