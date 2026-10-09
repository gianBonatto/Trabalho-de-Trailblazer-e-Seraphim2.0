
public class EstadoAguardandoExtracao extends AbstractState<Trailblazer> {

    private int ciclosDeEspera;

    public EstadoAguardandoExtracao(Trailblazer character) {
        super(character);
    }

    @Override
    public void enter() {
        ciclosDeEspera = 0;

        System.out.println("[Trailblazer] Mineracao concluida.");
        System.out.println("[Trailblazer] Solicitando extracao.");
        System.out.println("[Trailblazer] Aguardando Seraphim.");
    }

    @Override
    public void execute() {
        ciclosDeEspera++;

        System.out.println("[Trailblazer] Aguardando extracao...");
        System.out.println("[Trailblazer] Ciclos de espera: "
                + ciclosDeEspera);
    }

    @Override
    public void leave() {
        System.out.println(
                "[Trailblazer] Encerrando estado de espera.");
    }
}
