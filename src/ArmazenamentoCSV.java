import java.util.*;

public class ArmazenamentoCSV implements Armazenamento{

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

    @Override
    public void storePointsByUser(String userName, String type, int points) {
        User user = getUserByName(userName);
        HashMap<String, Integer> userPointMap = user.pointMap;

        if (userPointMap.containsKey(type)) {
            userPointMap.put(type, userPointMap.get(type) + points);
        }
        user.addPoints(type, points);
    }

    @Override
    public Integer getPointsByTypeAndByUser(User user, String type) {
        return user.getPointMap().get(type);
    }


    @Override
    public List<User> getUsersWithPoints() {
        List<User> usersWithPointsList = new LinkedList<>();

        for (User u: users) {
            if (!(u.pointMap.isEmpty())) usersWithPointsList.add(u);
        }
        return usersWithPointsList;
    }

    @Override
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

