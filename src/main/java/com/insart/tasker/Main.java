package com.insart.tasker;

import com.insart.tasker.test.TestTaskService;

public class Main {

    public static void main(String[] args) throws Exception {
        TestTaskService testTaskService=new TestTaskService();
        testTaskService.testAddTask();
    }
}

