
public class EstadoSuporte extends AbstractState<Seraphim> {

    public EstadoSuporte(Seraphim character) {
        super(character);
    }

    @Override
    public void enter() {
        System.out.println("[Seraphim] Iniciando suporte.");
        System.out.println("[Seraphim] Protocolo de cobertura ativado.");
    }

    @Override
    public void execute() {
        Seraphim agente = getCharacter();
        Trailblazer trailblazer = agente.getTrailblazer();

        if (!trailblazer.isOperacional()) {
            System.out.println(
                    "[Seraphim] Trailblazer incapacitado!");
            return;
        }

        if (trailblazer.isEmCombate()) {
            System.out.println(
                    "[Seraphim] Fornecendo cobertura ao Trailblazer.");
            System.out.println(
                    "[Seraphim] Monitorando a patrulha inimiga.");
            return;
        }

        System.out.println(
                "[Seraphim] Ameaca neutralizada!");

        agente.setPatrulhaDetectada(false);
        agente.setState(new EstadoVigilancia(agente));
    }

    @Override
    public void leave() {
        System.out.println(
                "[Seraphim] Encerrando suporte.");
        System.out.println(
                "[Seraphim] Protocolo de cobertura desativado.");
    }
}
