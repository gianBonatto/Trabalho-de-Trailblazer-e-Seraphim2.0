
public class EstadoMinerando extends AbstractState<Trailblazer> {

    public EstadoMinerando(Trailblazer character) {
        super(character);
    }

    @Override
    public void enter() {
        System.out.println("[Trailblazer] Iniciando mineração.");
        System.out.println("[Trailblazer] Perfuratrizes ativadas.");
    }

    @Override
    public void execute() {
        Trailblazer agente = getCharacter();

        if (agente.isCargaCompleta()) {
            agente.setState(new EstadoAguardandoExtracao(agente));
            return;
        }

        agente.adicionarCarga(20);

        System.out.println("[Trailblazer] Minério coletado.");
        System.out.println("[Trailblazer] Carga: "
                + agente.getCarga() + "/"
                + agente.getCapacidadeCarga());

        if (agente.isCargaCompleta()) {
            System.out.println(
                    "[Trailblazer] Carga completa! Extração necessária.");

            agente.setState(new EstadoAguardandoExtracao(agente));
        }
    }

    @Override
    public void leave() {
        System.out.println("[Trailblazer] Encerrando mineração.");
        System.out.println("[Trailblazer] Perfuratrizes desativadas.");
    }
}
