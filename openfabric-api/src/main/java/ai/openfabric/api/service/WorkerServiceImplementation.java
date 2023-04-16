package ai.openfabric.api.service;

import ai.openfabric.api.model.Worker;
import ai.openfabric.api.repository.WorkerRepository;
import ai.openfabric.api.util.DockerContainerToWorkerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class WorkerServiceImplementation implements WorkerService{

    @Autowired
    DockerClientService dockerClientService;

    @Autowired
    WorkerRepository workerRepository;


    @Override
    public List<Worker> getWorkers(String page,String limit) {
        //Updating the worker data in db.
        dockerClientService.getContainers().forEach(e->{
            Worker worker= DockerContainerToWorkerMapper.INSTANCE().mapToWorker(e);
            workerRepository.save(worker);
        });
        //fetching the data from db with pagination support
        Pageable paginationObject = PageRequest.of(Integer.parseInt(page), Integer.parseInt(limit));
        List<Worker> workers= StreamSupport.stream(workerRepository.findAll(paginationObject).spliterator(), false)
                .collect(Collectors.toList());
        return workers;
    }

    @Override
    public String startWorker(String workerId) {

        return dockerClientService.startContainer(workerId);
    }

    @Override
    public String stopWorker(String workerId) {
        return dockerClientService.stopContainer(workerId);
    }

    @Override
    public Worker getWorker(String workerId) {
        Optional<Worker> workerOptional=workerRepository.findById(workerId);
        return workerOptional.isPresent()?workerOptional.get():null;
    }
}
