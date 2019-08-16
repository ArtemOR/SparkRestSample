import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static spark.Spark.*;

public class Main {

    static Logger logger = LoggerFactory.getLogger(Main.class);
    private static Map<String, User> users = new HashMap();
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        port(8081);
        post("/users", (request, response) -> {
            String json_user = request.body();
            User user = gson.fromJson(json_user, User.class);
            if (user == null) {
                response.status(400);
                return "User not Created";

            }
            String id = UUID.randomUUID().toString();
            user.setId(id);
            users.put(id, user);
            response.status(200);

            return gson.toJson(users.get(id));
        });

        get("/users", (request, response) ->
                gson.toJson(users.values()));

    }
}
