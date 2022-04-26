/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.port;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        // hataları detaylı olarak gösteriyor bu logger kütüphanesi
        Logger logger = LogManager.getLogger(App.class);
        logger.error("Hello worldd");

        int port = Integer.parseInt(System.getenv("PORT"));
        logger.error("Current port number: " + port);

        get("/", (req, res) -> "Hello world");
        get("/compute",
                (rq, rs) -> {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("result", "not compute.mustache");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());

        post("/compute", (req, res) -> {
            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            while (sc1.hasNext()) {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s", ""));
                inputList.add(value);

            }
            sc1.close();
            System.out.println(inputList);

            String input2 = req.queryParams("input2").replaceAll("\\s", "");
            int input2AsaInt = Integer.parseInt(input2);
            boolean result = App.search(inputList, input2AsaInt);
            Map<String, Boolean> map = new HashMap<String, Boolean>();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");

        },
                new MustacheTemplateEngine());

    }

    public static boolean search(ArrayList<Integer> array, int e) {
        System.out.println("Inside Search");
        if (array == null) {
            return false;
        }

        for (int elt : array) {
            if (elt == e) {
                return true;
            }
        }
        return false;
    }

}
