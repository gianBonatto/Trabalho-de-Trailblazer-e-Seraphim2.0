
public class Seraphim implements Agente<Seraphim> {

    private State<Seraphim> state;

    private final Trailblazer trailblazer;

    private boolean patrulhaDetectada;
    private boolean extracaoConcluida;

    public Seraphim(Trailblazer trailblazer) {
        this.trailblazer = trailblazer;
        this.patrulhaDetectada = false;
        this.extracaoConcluida = false;
    }

    @Override
    public void update() {
        if (state != null) {
            state.execute();
        }
    }

    @Override
    public void setState(State<Seraphim> novoEstado) {
        if (novoEstado == null) {
            throw new IllegalArgumentException(
                    "O estado nao pode ser nulo.");
        }

        if (state == novoEstado) {
            return;
        }

        String anterior = state == null
                ? "Nenhum"
                : state.getClass().getSimpleName();

        if (state != null) {
            state.leave();
        }

        state = novoEstado;

        System.out.println("[Seraphim] " + anterior
                + " -> " + state.getClass().getSimpleName());

        state.enter();
    }

    @Override
    public void printStats(String estado) {
        System.out.println("=== SERAPHIM ===");
        System.out.println("Estado: " + estado);
        System.out.println("Patrulha detectada: "
                + patrulhaDetectada);
        System.out.println("Extracao concluida: "
                + extracaoConcluida);
    }

    public void setPatrulhaDetectada(boolean detectada) {
        this.patrulhaDetectada = detectada;
    }

    public boolean isPatrulhaDetectada() {
        return patrulhaDetectada;
    }

    public void concluirExtracao() {
        this.extracaoConcluida = true;
    }

    public boolean isExtracaoConcluida() {
        return extracaoConcluida;
    }

    public Trailblazer getTrailblazer() {
        return trailblazer;
    }
}
