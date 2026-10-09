
import java.util.ArrayList;

public class StateMachine {

    private final ArrayList<Agente<?>> agentes = new ArrayList<>();

    private final Trailblazer trailblazer;
    private final Seraphim seraphim;

    private int ciclo = 0;

    private static final int CICLO_PATRULHA = 3;
    private static final int MAX_CICLOS = 20;

    public StateMachine() {

        trailblazer = new Trailblazer();
        seraphim = new Seraphim(trailblazer);

        agentes.add(trailblazer);
        agentes.add(seraphim);

        trailblazer.setState(new EstadoMinerando(trailblazer));
        seraphim.setState(new EstadoVigilancia(seraphim));
    }

    public void run() {

        System.out.println("=================================");
        System.out.println(" RAYMOND & ABRAMOVICH - OPERACAO ");
        System.out.println("=================================");

        while (!seraphim.isExtracaoConcluida()
                && trailblazer.isOperacional()
                && ciclo < MAX_CICLOS) {

            ciclo++;

            System.out.println("\n===== CICLO " + ciclo + " =====");

            if (ciclo == CICLO_PATRULHA) {
                System.out.println(
                        "[Ambiente] Patrulha inimiga se aproximando!");

                seraphim.setPatrulhaDetectada(true);
            }

            for (Agente<?> agente : agentes) {
                agente.update();
            }
        }

        System.out.println("\n===== FIM DA OPERACAO =====");

        if (seraphim.isExtracaoConcluida()) {
            System.out.println(
                    "[Missao] Extracao concluida com sucesso!");

        } else if (!trailblazer.isOperacional()) {
            System.out.println(
                    "[Missao] Falha! Trailblazer incapacitado.");

        } else {
            System.out.println(
                    "[Missao] Limite de ciclos atingido.");
        }

        System.out.println("[Missao] Ciclos executados: " + ciclo);
    }
}
