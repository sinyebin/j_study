
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        
        map.put("축구","안정환");
        map.put("야구","류현진");

        System.out.println(map.get("축구"));

        System.out.println(map.containsKey("축구"));
        System.out.println(map.containsKey("농구"));

        map.remove("축구");

        HashMap<String,List<String>> topicList = new HashMap<>();
        List<String> lst = new ArrayList<>();
        topicList.put("a",lst);
        
        topicList.get("a").add("cs1");
        topicList.get("a").add("cs2");

        for (String str: topicList.get("a")){
            System.out.println(str);
        }
    }
}
