package com.example.waterdeliverysystem.service;

import com.example.waterdeliverysystem.model.Customer;
import com.example.waterdeliverysystem.model.Worker;

import java.util.List;

/*
 * @Auther:sunny_wwu
 * @Data:2022-06-27  10:23
 * @Description:waterdeliverysystem-com.example.waterdeliverysystem.service
 * @Version：1.0
 * @Detail：
 * */
public interface WorkerService {



    public List<Worker> getWorkerList();

    public List<Worker> getWorkerListByPage(int page , int rows);

    int addWorker(Worker worker);

    public Worker getWorkerById(int id);

    public int updateWorker(Worker worker);

    public int deleteWorkerById(int id);

    public List<Worker> getWorkerListByWorkerName(String wrker);
}
