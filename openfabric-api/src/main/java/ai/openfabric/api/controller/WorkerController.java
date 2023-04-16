package ai.openfabric.api.controller;

import ai.openfabric.api.model.Worker;
import ai.openfabric.api.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${node.api.path}/worker")
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @PostMapping(path = "/hello")
    public @ResponseBody String hello(@RequestBody String name) {

        return "Hello!" + name;
    }

    @GetMapping(path = "/workers")
    public @ResponseBody List<Worker> getWorkers(@RequestParam(name = "page") String page,@RequestParam(name = "limit") String limit) {
        return workerService.getWorkers(page,limit);
    }

    @PostMapping(path = "/startWorker")
    public @ResponseBody String startWorker(@RequestBody String workerId) {
        return workerService.startWorker(workerId);
    }

    @PostMapping(path = "/stopWorker")
    public @ResponseBody String stopWorker(@RequestBody String workerId) {
        return workerService.stopWorker(workerId);
    }


}
