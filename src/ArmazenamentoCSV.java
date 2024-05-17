import java.io.*;
import java.util.*;

public class ArmazenamentoCSV implements Armazenamento {

    private static final String ARQUIVO = "pontos.csv";
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
        Map<String, Integer> userPointMap = user.pointMap;

        if (userPointMap.containsKey(type)) {
            userPointMap.put(type, userPointMap.get(type) + points);
        }
        user.addPoints(type, points);
        try {
            writeCSV();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer getPointsByTypeAndByUser(User user, String type) {
        try {
            List<User> listUser = readCSV();
            for (User u : listUser) {
                if (u.getName().equals(user.getName())) {
                    return u.getPointMap().getOrDefault(type, 0);
                }
            }
            throw new UserNotFoundException("Usuário não encontrado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getUsersWithPoints() {
        List<User> usersWithPointsList = new LinkedList<>();
        try {
            List<User> listUser = readCSV();
            for (User u : listUser) {
                if (!(u.pointMap.isEmpty())) usersWithPointsList.add(u);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return usersWithPointsList;
    }

    @Override
    public Set<String> getPointsEverStored() {
        Set<String> allTypesOfPoints = new HashSet<>();

        try {
            List<User> listUser = readCSV();
            for (User u : listUser) {
                if (!u.pointMap.keySet().isEmpty()) {
                    allTypesOfPoints.addAll(u.pointMap.keySet());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allTypesOfPoints;
    }

    public void writeCSV() throws IOException {
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(ARQUIVO))); // PrintWriter para escrever os novos dados.

        for (User user : users) {
            StringBuilder userData = new StringBuilder(user.getName() + ",");
            for (Map.Entry<String, Integer> entry : user.getPointMap().entrySet()) {
                userData.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
            }
            writer.println(userData);
        }
        writer.close();
    }

    public List<User> readCSV() throws IOException {
        List<User> userList = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] userData = line.split(",");
            String userName = userData[0];

            Map<String, Integer> pointMap = new HashMap<>();

            for (int i = 1; i < userData.length; i++) {
                String[] pointData = userData[i].split(":");
                String type = pointData[0];
                int points = Integer.parseInt(pointData[1]);
                pointMap.put(type, points);
            }

            userList.add(new User(userName, pointMap));
        }

        reader.close();
        return userList;
    }

    public List<User> getRanking(String type) {
        List<User> userList = new LinkedList<>();

        try {
            List<User> listUser = readCSV();
            for (User u : listUser) {
                Integer points = u.getPointMap().getOrDefault(type, 0);
                if (points > 0) {
                    User newUser = new User(u.getName());
                    newUser.addPoints(type, points);
                    userList.add(newUser);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        userList.sort((u1, u2) -> u2.getPointMap().getOrDefault(type, 0).compareTo(u1.getPointMap().getOrDefault(type, 0)));

        return userList;
    }

}

