
public interface Agente<C> {

    void printStats(String estado);

    void update();

    void setState(State<C> state);
}
