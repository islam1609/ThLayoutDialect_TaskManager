package Thymeleaf.Layout.Dialect.springboot.Controllers;

import Thymeleaf.Layout.Dialect.springboot.DB.DBManager;
import Thymeleaf.Layout.Dialect.springboot.DB.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String indexPage(Model model){
        ArrayList<Task> tasks = DBManager.getAllTasks();
        model.addAttribute("tasks", tasks);
    return "/homePage";
    }
    @GetMapping(value = "/details/{taskId}")
    public String details(@PathVariable(name = "taskId") Long id,
                          Model model) {
        Task task = DBManager.getTask(id);
        model.addAttribute("task",task);
        return "details";
    }

    @GetMapping(value = "/addTask")
    public String addTask(){
        return "addTask";
    }

    @PostMapping(value = "/addTask")
    public String addTask(@RequestParam(name = "taskName") String name,
                          @RequestParam(name = "taskDeadlineDate") String deadlineDate,
                          @RequestParam(name = "taskIsCompleted") String isCompleted){
        Task task = new Task();
        task.setName(name);
        task.setDeadlineDate(deadlineDate);
        task.setIsCompleted(isCompleted);

        DBManager.addTask(task);

        return "redirect:/";
    }

    @PostMapping(value = "/deleteTask/{taskId}")
    public String deleteItem(@PathVariable(name = "taskId") Long id){
        DBManager.deleteTask(id);
        return "redirect:/";
    }

    @PostMapping(value = "/saveTask")
    public String saveTask(@RequestParam(name = "taskName") String name,
                          @RequestParam(name = "taskDeadlineDate") String deadlineDate,
                          @RequestParam(name = "taskIsCompleted") String isCompleted,
                           @RequestParam(name = "taskId") Long id){
        Task task = new Task();
        task.setId(id);
        task.setName(name);
        task.setDeadlineDate(deadlineDate);
        task.setIsCompleted(isCompleted);

        DBManager.saveItem(task);

        return "redirect:/";
    }

}
