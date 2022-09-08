package com.example.waterdeliverysystem.controller;

import com.example.waterdeliverysystem.model.Worker;
import com.example.waterdeliverysystem.service.WorkerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/*
 * @Auther:sunny_wwu
 * @Data:2022-06-27  10:20
 * @Description:waterdeliverysystem-com.example.waterdeliverysystem.controller
 * @Version：1.0
 * @Detail：
 * */
@Controller
public class WorkerWeb {

    @Autowired
    WorkerServiceImp workerService;


    @GetMapping("/toWorkerList")
    public String toWorkerList(Model model){

        List<Worker> workerList = workerService.getWorkerList();
        model.addAttribute("list",workerList);

        return "workerList";
    }


    // toAddCustomer
    @GetMapping("/toAddWorker")
    public String toAddCustomer(){

        return "addWorker";
    }
    //handleAddWorker
    @PostMapping("/handleAddWorker")
    public String handleAddWorker(Worker worker){

        workerService.addWorker(worker);

        return "redirect:/toWorkerList";
    }


    @GetMapping("/toUpdateWorker/{id}")
    public String toUpdateWorker(@PathVariable int id , Model model){

        Worker workerById = workerService.getWorkerById(id);

        model.addAttribute("worker",workerById);

        return "updateWorker";

    }
    //handleUpdateWorker
    @PostMapping("/handleUpdateWorker")
    public String handleUpdateWorker(Worker worker){

        workerService.updateWorker(worker);

        return "redirect:/toWorkerList";
    }

    //deleteWorker
    @GetMapping("/deleteWorker/{id}")
    public String deleteWorker(@PathVariable int id){
        workerService.deleteWorkerById(id);
        return "redirect:/toWorkerList";
    }


    //queryWorker
    @GetMapping("queryWorker")
    public String queryWorker(String workerName,Model model){

        List<Worker> workerListByworkerName = new ArrayList<>();

        if (workerName == null || workerName.equals("")){
            workerListByworkerName = workerService.getWorkerList();
        }else {
            workerListByworkerName = workerService.getWorkerListByWorkerName(workerName);
        }

        model.addAttribute("list",workerListByworkerName);
        return "workerList";
    }
}
