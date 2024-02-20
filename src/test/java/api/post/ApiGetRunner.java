package api.post;

import com.intuit.karate.junit5.Karate;

public class ApiGetRunner {

    @Karate.Test
    Karate apiGet() {
        return Karate.run().relativeTo(getClass());
    }
}