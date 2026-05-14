package pl.rengreen.taskmanager.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.rengreen.taskmanager.model.Task;
import pl.rengreen.taskmanager.service.TaskService;

import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
public class TaskControllerIT {

    @Container
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("taskdb")
            .withUsername("user")
            .withPassword("pass");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "update");
    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskService taskService;

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testEditTaskIntegration() throws Exception {
        // Prepare data in real DB
        Task task = new Task();
        task.setName("Integration Task");
        task.setDescription("Test with Testcontainers");
        taskService.createTask(task);
        
        Long id = task.getId();

        mockMvc.perform(get("/task/edit/" + id))
                .andExpect(status().isOk())
                .andExpect(view().name("views/filledTaskForm"))
                .andExpect(model().attribute("task", instanceOf(Task.class)));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testDeleteTaskIntegration() throws Exception {
        Task task = new Task();
        task.setName("To Delete");
        taskService.createTask(task);
        
        Long id = task.getId();

        mockMvc.perform(get("/task/delete/" + id))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/tasks"));
        
        // Verify deletion in real DB
        assert(taskService.getTaskById(id) == null);
    }
}
