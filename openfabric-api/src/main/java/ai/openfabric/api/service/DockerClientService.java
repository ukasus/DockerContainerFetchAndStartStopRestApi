package ai.openfabric.api.service;

import com.github.dockerjava.api.model.Container;

import java.util.List;

public interface DockerClientService {

    List<Container> getContainers();

    String startContainer(String containerId);

    String stopContainer(String containerId);
}
