package com.insart.tasker.test;

import com.insart.tasker.entities.Task;
import com.insart.tasker.enums.TaskStatus;
import com.insart.tasker.services.TaskService;
import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class TaskTest extends DBUnitConfig{

        private TaskService service = new TaskService();
        private EntityManager em = Persistence.createEntityManagerFactory("DBUnitEx").createEntityManager();

        @Before
        public void setUp() throws Exception {
            super.setUp();
            beforeData = new FlatXmlDataSetBuilder().build(
                    Thread.currentThread().getContextClassLoader()
                            .getResourceAsStream("resources/task-data.xml"));

            tester.setDataSet(beforeData);
            tester.onSetup();
        }

        public TaskTest(String name) {
            super(name);
        }

        @Test
        public void testGetAll() throws Exception {
            List<Task> tasks = service.getAll();

            IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                    Thread.currentThread().getContextClassLoader()
                            .getResourceAsStream("resources/task-data.xml"));

            IDataSet actualData = tester.getConnection().createDataSet();
            Assertion.assertEquals(expectedData, actualData);
            Assert.assertEquals(expectedData.getTable("task").getRowCount(), tasks.size());
        }

        @Test
        public void testSave() throws Exception {
            Task task = new Task();
            task.setTitle("title");
            task.setDescription("description");
            task.setStatus(TaskStatus.DO);
            task.setCreated(new Date());
            task.setUpdated(new Date());

            service.save(task);

            IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                    Thread.currentThread().getContextClassLoader()
                            .getResourceAsStream("resources/task-data-save.xml"));

            IDataSet actualData = tester.getConnection().createDataSet();

            String[] ignore = {"id"};
            Assertion.assertEqualsIgnoreCols(expectedData, actualData, "task", ignore);
        }


    }


