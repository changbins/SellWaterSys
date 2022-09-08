package com.example.waterdeliverysystem.model;

import java.util.Objects;

/*
 * @Auther:sunny_wwu
 * @Data:2022-06-27  10:14
 * @Description:waterdeliverysystem-com.example.waterdeliverysystem.mapper
 * @Version：1.0
 * @Detail：
 * */
public class Worker {

    private int id;
    private String workerName;
    private float salary;
    private float royalty;

    public Worker() {
    }

    public Worker(int id, String workerName, float salary, float royalty) {
        this.id = id;
        this.workerName = workerName;
        this.salary = salary;
        this.royalty = royalty;
    }


    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", workerName='" + workerName + '\'' +
                ", salary=" + salary +
                ", royalty=" + royalty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return id == worker.id &&
                Float.compare(worker.salary, salary) == 0 &&
                Float.compare(worker.royalty, royalty) == 0 &&
                Objects.equals(workerName, worker.workerName);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getRoyalty() {
        return royalty;
    }

    public void setRoyalty(float royalty) {
        this.royalty = royalty;
    }

}
