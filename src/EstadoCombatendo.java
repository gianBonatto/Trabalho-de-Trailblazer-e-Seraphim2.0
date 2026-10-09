
public class EstadoCombatendo extends AbstractState<Trailblazer> {

    private int resistenciaPatrulha;

    public EstadoCombatendo(Trailblazer character) {
        super(character);
    }

    @Override
    public void enter() {
        resistenciaPatrulha = 3;

        System.out.println("[Trailblazer] Patrulha inimiga detectada!");
        System.out.println("[Trailblazer] Sistemas de defesa ativados.");
    }

    @Override
    public void execute() {
        Trailblazer agente = getCharacter();

        if (!agente.isOperacional()) {
            return;
        }

        agente.receberDano(5);

        System.out.println("[Trailblazer] Integridade: "
                + agente.getIntegridade());

        if (!agente.isOperacional()) {
            System.out.println(
                    "[Trailblazer] Veiculo incapacitado!");
            return;
        }

        resistenciaPatrulha--;

        System.out.println("[Trailblazer] Disparando contra a patrulha.");
        System.out.println("[Trailblazer] Resistencia inimiga: "
                + resistenciaPatrulha);

        if (resistenciaPatrulha <= 0) {
            System.out.println(
                    "[Trailblazer] Patrulha eliminada!");

            agente.setState(new EstadoMinerando(agente));
        }
    }

    @Override
    public void leave() {
        System.out.println(
                "[Trailblazer] Encerrando protocolo de combate.");
        System.out.println(
                "[Trailblazer] Sistemas de defesa desativados.");
    }
}
