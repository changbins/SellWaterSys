package com.example.waterdeliverysystem.service;

import com.example.waterdeliverysystem.mapper.WorkerMapper;
import com.example.waterdeliverysystem.model.Customer;
import com.example.waterdeliverysystem.model.Worker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @Auther:sunny_wwu
 * @Data:2022-06-27  10:43
 * @Description:waterdeliverysystem-com.example.waterdeliverysystem.service
 * @Version：1.0
 * @Detail：
 * */
@Service
public class WorkerServiceImp implements WorkerService {
    @Autowired
    WorkerMapper workerMapper;

    @Override
    public List<Worker> getWorkerList() {
        return workerMapper.getWorkerList();
    }

    @Override
    public List<Worker> getWorkerListByPage(int page, int rows) {

        PageHelper.startPage(page,rows);

        List<Worker> workerList = workerMapper.getWorkerList();

        PageInfo<Worker> info = new PageInfo<>(workerList);
        return info.getList();
    }

    @Override
    public int addWorker(Worker worker) {
        return workerMapper.addWorker(worker);
    }

    @Override
    public Worker getWorkerById(int id) {
        return workerMapper.getWorkerById(id);
    }

    @Override
    public int updateWorker(Worker worker) {
        return workerMapper.updateWorker(worker);
    }


    @Override
    public int deleteWorkerById(int id) {
        return workerMapper.deleteWorkerById(id);
    }

    @Override
    public List<Worker> getWorkerListByWorkerName(String wrker) {
        return workerMapper.getWorkerListByWorkerName(wrker);
    }

}
