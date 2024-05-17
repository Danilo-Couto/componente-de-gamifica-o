import java.util.List;
import java.util.Set;

public class Placar {
    private ArmazenamentoCSV armazenamento;

    public Placar() {
    }

    public void addUser(User user) {
        armazenamento.addUser(user);
    }

    public User getUserByName(String user) {
        return armazenamento.getUserByName(user);
    }

    public void storePointsByUser(String user, String type, int i) {
        armazenamento.storePointsByUser(user, type, i);
    }

    public void setArmazenamento(ArmazenamentoCSV a) {
        this.armazenamento = a;
    }

    public Integer getPointsByTypeAndByUser(User user, String type) {
        return armazenamento.getPointsByTypeAndByUser(user, type);
    }

    public List<User> getUsersWithPoints() {
        return armazenamento.getUsersWithPoints();
    }

    public Set<String> getPointsEverStored() {
        return armazenamento.getPointsEverStored();
    }

    public List<User> getRanking(String type) {
        return armazenamento.getRanking(type);
    }
}
