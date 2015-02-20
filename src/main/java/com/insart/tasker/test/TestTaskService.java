package com.insart.tasker.test;

    import com.insart.tasker.entities.Task;
    import com.insart.tasker.enums.TaskStatus;
    import com.insart.tasker.services.TaskService;
    import org.junit.Test;
    import java.util.Date;
    public class TestTaskService {
        TaskService taskService=new TaskService();
        @Test
        public void testAddTask()throws Exception
        {//создаем новый таск для записи в БД
            Task task=new Task();
            task.setId((long)1);
            task.setTitle("title1");
            task.setDescription("description");
            task.setStatus(TaskStatus.DO);
            task.setCreated(new Date());
            task.setUpdated(new Date());
            //Записали в БД
            //Task newTask = taskService.addTask(task);
            //System.out.println(newTask);
        }
    }



