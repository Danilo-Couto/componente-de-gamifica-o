import java.util.*;

public class Armazenamento {

    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserByName(String name) {
        for (User u : users) {
            if (u.getName().equals(name)) {
                return u;
            }
        }
        throw new UserNotFoundException("Usuário não encontrado");
    }

    public void storePoints(String userName, String type, int points) {
        User user = getUserByName(userName);
        HashMap<String, Integer> userPointMap = user.pointMap;

        if (userPointMap.containsKey(type)) {
            userPointMap.put(type, userPointMap.get(type) + points);
        }
        user.addPoints(type, points);
    }

    public Integer GetPointsByTypeAndByUser(User user, String type) {
        return user.getPointMap().get(type);
    }

    public List<User> getUsersWithPoints() {
        List<User> usersWithPointsList = new LinkedList<>();

        for (User u: users) {
            if (!(u.pointMap.isEmpty())) usersWithPointsList.add(u);
        }
        return usersWithPointsList;
    }

    public Set<String> getPointsEverStored() {
        Set<String> allTypesOfPoints = new HashSet<>();

        for (User u : users) {
            if (!u.pointMap.keySet().isEmpty()) {
                allTypesOfPoints.addAll(u.pointMap.keySet());
            }
        }
        return allTypesOfPoints;
    }

}

