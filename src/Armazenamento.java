import java.util.List;
import java.util.Set;

public interface Armazenamento {
    void storePointsByUser(String userName, String type, int points);
    Integer getPointsByTypeAndByUser(User user, String type);
    List<User> getUsersWithPoints();
    Set<String> getPointsEverStored();
}
