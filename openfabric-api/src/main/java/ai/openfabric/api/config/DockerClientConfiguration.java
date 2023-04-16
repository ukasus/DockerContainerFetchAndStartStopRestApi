package ai.openfabric.api.config;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DockerClientConfiguration {

    private DockerClientConfig getDockerClientConfig(){
        DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
        return config;
    }

    @Bean
    public DockerClient initiateClient(){
        DockerClientConfig config=getDockerClientConfig();

        DockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(config.getDockerHost())
                .sslConfig(config.getSSLConfig()).build();

       DockerClient dockerClient = DockerClientImpl.getInstance(config, httpClient);
       return dockerClient;
    }

}
