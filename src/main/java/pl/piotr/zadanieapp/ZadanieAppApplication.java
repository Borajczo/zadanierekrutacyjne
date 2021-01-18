package pl.piotr.zadanieapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;


@SpringBootApplication
public class ZadanieAppApplication {

    @Autowired
    RequestCounterEntityDTO requestCounterEntityDTO;

    @PersistenceContext
    EntityManager entityManager;

    private ApiRequestsDataStatitstics apiRequestsDataStatitstics;


    public static void main(String[] args) {
        SpringApplication.run(ZadanieAppApplication.class, args);
    }


    @Scheduled(initialDelayString = "PT5S", fixedDelayString = "PT20S")
    void sameJob() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = apiRequestsDataStatitstics.getInstance().getPathCounterRequested();
        List<RequestCounterEntity> requestCounterList = new ArrayList<>();

        map.forEach((k, v) -> requestCounterList.add(new RequestCounterEntity(k,v)));
        requestCounterEntityDTO.saveAll(requestCounterList);
    }

    @Configuration
    @EnableScheduling
    @ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
    class schedulingConfiguration {}


}
