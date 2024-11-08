package me.sqsw.buildandroll.config;

import com.pusher.rest.Pusher;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PusherConfig {

    private Pusher pusher;

    @Value("${pusher.appId}")
    private String appId;

    @Value("${pusher.key}")
    private String key;

    @Value("${pusher.secret}")
    private String secret;

    @Value("${pusher.cluster}")
    private String cluster;

    @PostConstruct
    public void init() {
        pusher = new Pusher(appId, key, secret);
        pusher.setCluster(cluster);
    }

    @Bean
    public Pusher getPusher() {
        return pusher;
    }
}
