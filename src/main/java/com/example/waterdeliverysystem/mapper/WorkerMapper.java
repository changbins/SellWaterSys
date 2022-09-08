package com.example.waterdeliverysystem.mapper;

/*
 * @Auther:sunny_wwu
 * @Data:2022-06-27  10:19
 * @Description:waterdeliverysystem-com.example.waterdeliverysystem.mapper
 * @Version：1.0
 * @Detail：
 * */

import com.example.waterdeliverysystem.model.Customer;
import com.example.waterdeliverysystem.model.Worker;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WorkerMapper {

    @Select("select * from Worker")
    public List<Worker> getWorkerList();

    @Insert("insert into worker (workerName,salary,royalty)values(#{workerName}" +
            ",#{salary},#{royalty})")
    int addWorker(Worker worker);

    @Select("select * from worker where id = #{id}")
    public Worker getWorkerById(int id);

    @Update("update worker set workerName = #{workerName}," +
            "salary = #{salary},salary=#{salary} where id = #{id}")
    public int updateWorker(Worker worker);

    @Delete("delete from worker where id = #{id}")
    public int deleteWorkerById(int id);

    //queryCustomer
    @Select("select * from worker where workerName like concat ('%' ,#{workerName},'%')")
    public List<Worker> getWorkerListByWorkerName(String worker);
}
