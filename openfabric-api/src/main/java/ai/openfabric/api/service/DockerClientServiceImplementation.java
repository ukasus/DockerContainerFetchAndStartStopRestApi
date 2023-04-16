package ai.openfabric.api.service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DockerClientServiceImplementation implements DockerClientService {
    @Autowired
    private DockerClient dockerClient;
    @Override
    public List<Container> getContainers() {
       return dockerClient.listContainersCmd().exec();
    }

    @Override
    public String startContainer(String containerId) {
        try{dockerClient.startContainerCmd(containerId).exec();}
        catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
        return "Container started successfully!";
    }

    @Override
    public String stopContainer(String containerId) {
        try{dockerClient.startContainerCmd(containerId).exec();}
        catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
        return "Container stopped successfully!";
    }


}
