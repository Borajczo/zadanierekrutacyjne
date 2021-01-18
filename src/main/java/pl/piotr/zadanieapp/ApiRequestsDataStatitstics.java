package pl.piotr.zadanieapp;

import org.springframework.context.annotation.Scope;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Scope("singleton")
public class ApiRequestsDataStatitstics {

    private static ApiRequestsDataStatitstics INSTANCE;

    public static ApiRequestsDataStatitstics getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ApiRequestsDataStatitstics();
        }

        return INSTANCE;
    }

    private static Map<String, Integer> pathCounterRequested = new ConcurrentHashMap<>();

    private static LinkedList<RequestCounterEntity> requestCounterEntityList = new LinkedList<>();

    public Map<String, Integer> addUserRequest(String userName) {

        if (pathCounterRequested.containsKey(userName)) {
            pathCounterRequested.computeIfPresent(userName, (k, v) -> v + 1);
        } else {
            pathCounterRequested.put(userName, 1);
        }

        return pathCounterRequested;
    }

    public static Map<String, Integer> getPathCounterRequested() {
        return pathCounterRequested;
    }

    public static LinkedList<RequestCounterEntity> getRequestCounterEntityList() {
        return requestCounterEntityList;
    }
}
