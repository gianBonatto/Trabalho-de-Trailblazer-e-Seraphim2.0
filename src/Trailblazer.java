
public class Trailblazer implements Agente<Trailblazer> {

    private State<Trailblazer> state;

    private int integridade;
    private int carga;
    private final int capacidadeCarga;

    public Trailblazer() {
        this.integridade = 100;
        this.carga = 0;
        this.capacidadeCarga = 100;
    }

    @Override
    public void update() {
        if (state != null) {
            state.execute();
        }
    }

    @Override
    public void setState(State<Trailblazer> novoEstado) {
        if (novoEstado == null) {
            throw new IllegalArgumentException(
                    "O estado não pode ser nulo.");
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

        System.out.println("[Trailblazer] " + anterior
                + " -> " + state.getClass().getSimpleName());

        state.enter();
    }

    @Override
    public void printStats(String estado) {
        System.out.println("=== TRAILBLAZER ===");
        System.out.println("Estado: " + estado);
        System.out.println("Integridade: " + integridade);
        System.out.println("Carga: " + carga + "/" + capacidadeCarga);
    }


    public boolean isEmCombate() {
        return state instanceof EstadoCombatendo;
    }


    public void adicionarCarga(int quantidade) {
        if (quantidade > 0) {
            carga = Math.min(capacidadeCarga, carga + quantidade);
        }
    }

    public void receberDano(int dano) {
        if (dano > 0) {
            integridade = Math.max(0, integridade - dano);
        }
    }

    public boolean isCargaCompleta() {
        return carga >= capacidadeCarga;
    }

    public boolean isOperacional() {
        return integridade > 0;
    }

    public int getCarga() {
        return carga;
    }

    public int getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public int getIntegridade() {
        return integridade;
    }
}
