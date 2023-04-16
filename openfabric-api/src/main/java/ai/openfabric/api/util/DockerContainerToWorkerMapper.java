package ai.openfabric.api.util;

import ai.openfabric.api.model.ContainerPort;
import ai.openfabric.api.model.Worker;
import com.github.dockerjava.api.model.Container;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Arrays;

public class DockerContainerToWorkerMapper {

    private ModelMapper mapper;

    private final static DockerContainerToWorkerMapper INSTANCE=new DockerContainerToWorkerMapper();

    DockerContainerToWorkerMapper(){
        this.mapper = new ModelMapper();
    }

    public Worker mapToWorker(Container container){
       Worker worker=new Worker();
       ContainerPort[] containerPorts=this.mapper.map(container.getPorts(), ContainerPort[].class);
//
//       ai.openfabric.api.model.Container mappedContainer=this.mapper.map(container, ai.openfabric.api.model.Container.class);
//        if(containerPorts.length==0)
//            mappedContainer.setPorts(null);
//        else
//       mappedContainer.setPorts(new ArrayList<>(Arrays.asList(containerPorts)));
       StringBuilder st=new StringBuilder("");
        Arrays.stream(container.getNames()).forEach(e->{
            st.append(e);
            st.append(";");
        });
       worker.setId(container.getId());
       worker.setName(st.toString());
       worker.setPorts(containerPorts.length>0?new ArrayList<>(Arrays.asList(containerPorts)):null);
       worker.setImage(container.getImage());
       worker.setImageId(container.getImageId());
       worker.setCommand(container.getCommand());
       worker.setState(container.getState());
       worker.setStatus(container.getStatus());
       return worker;
    }

    public static DockerContainerToWorkerMapper INSTANCE(){
        return INSTANCE;
    }
}
