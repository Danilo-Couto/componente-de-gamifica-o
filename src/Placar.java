import java.util.List;

public class Placar {
    private ArmazenamentoCSV armazenamento;

    public Placar() {
    }

    public void addUser(User user) {
        armazenamento.addUser(user);
    }

    public void storePointsByUser(String user, String type, int i) {
        armazenamento.storePointsByUser(user, type, i);
    }

    public void setArmazenamento(ArmazenamentoCSV a) {
        this.armazenamento = a;
    }

    public User getUserByName(String user) {
        return armazenamento.getUserByName(user);
    }

    public Integer getPointsByTypeAndByUser(User user, String type) {
        return armazenamento.getPointsByTypeAndByUser(user, type);
    }

    public List<User> getUsersWithPoints() {
        return armazenamento.getUsersWithPoints();
    }
}
