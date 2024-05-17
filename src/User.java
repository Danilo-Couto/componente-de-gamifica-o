import java.util.HashMap;
import java.util.Map;

public class User {

    public String name;
    public Map<String, Integer> pointMap = new HashMap<>();

    public User(String name) {
        this.name = name;
    }

    public User(String name, Map<String, Integer> pointMap) {
        this.name = name;
        this.pointMap = pointMap;
    }

    public String getName() {
        return name;
    }

    public void addPoints(String type, int points) {
        pointMap.put(type, points);
    }

    public Map<String, Integer> getPointMap() {
        return pointMap;
    }


}
