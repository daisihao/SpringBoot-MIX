package com.daisihao.service;

import java.util.concurrent.Future;

public interface AsyncService {
    Future<String> doTask1() throws Exception;
    Future<String> doTask2() throws Exception;
    Future<String> doTask3() throws Exception;
}
