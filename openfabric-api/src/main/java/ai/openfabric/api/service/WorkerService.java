package ai.openfabric.api.service;

import ai.openfabric.api.model.Worker;

import java.util.List;

public interface WorkerService {

    List<Worker> getWorkers(String page,String limit);

    String startWorker(String workerId);

    String  stopWorker(String workerId);

    Worker getWorker(String workerId);
}
