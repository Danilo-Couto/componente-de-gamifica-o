import java.util.HashMap;

public class User {

    public String name;
    public HashMap<String, Integer> pointMap = new HashMap<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void addPoints(String type, int points){
        pointMap.put(type, points);
    }

    public HashMap<String, Integer> getPointMap() {
        return pointMap;
    }
}
