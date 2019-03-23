package com.daisihao.controller;

import com.daisihao.service.AsyncService;
import com.daisihao.service.impl.AsyncServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Future;

@Controller
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("async")
    @ResponseBody
    public String asynchronous() throws Exception {
        long start = System.currentTimeMillis();
        System.out.println("开始时间"+start);
        Future<String> task1 = asyncService.doTask1();
        Future<String> task2 = asyncService.doTask2();
        Future<String> task3 = asyncService.doTask3();
        while (true){
            if(task1.isDone() && task2.isDone()&&task3.isDone()){
                break;
            }else{
                Thread.sleep(1000);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("结束时间为"+end);
        System.out.println("总执行时间为"+(end-start)+"毫秒");
        return "全部执行完成，时间为"+(end-start)+"毫秒";
    }
}
