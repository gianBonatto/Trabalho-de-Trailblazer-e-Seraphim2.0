
public class EstadoVigilancia extends AbstractState<Seraphim> {

    public EstadoVigilancia(Seraphim character) {
        super(character);
    }

    @Override
    public void enter() {
        System.out.println("[Seraphim] Iniciando vigilancia.");
        System.out.println("[Seraphim] Sensores ativados.");
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


        if (agente.isPatrulhaDetectada()) {
            System.out.println(
                    "[Seraphim] Patrulha inimiga identificada!");

            if (!trailblazer.isEmCombate()) {
                trailblazer.setState(
                        new EstadoCombatendo(trailblazer));
            }

            agente.setState(new EstadoSuporte(agente));
            return;
        }



        if (trailblazer.isCargaCompleta()) {
            System.out.println(
                    "[Seraphim] Carga completa detectada!");

            agente.setState(new EstadoExtracao(agente));
            return;
        }


        System.out.println(
                "[Seraphim] Monitorando o perimetro.");
        System.out.println(
                "[Seraphim] Nenhuma ameaca detectada.");
    }

    @Override
    public void leave() {
        System.out.println(
                "[Seraphim] Encerrando vigilancia.");
        System.out.println(
                "[Seraphim] Alterando configuracao dos sensores.");
    }
}
