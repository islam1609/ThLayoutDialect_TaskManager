package Thymeleaf.Layout.Dialect.springboot.DB;

import java.util.ArrayList;

public class DBManager {
   private static ArrayList<Task> tasks = new ArrayList<>();
   private static Long id=4L;

    static {
        tasks.add(new Task(1L,"JavaEE first Sprint task","2022-05-20","YES"));
        tasks.add(new Task(2L,"Change oil in Toyota Corolla","2022-04-14","YES"));
        tasks.add(new Task(3L,"Clear house and vegetables ","2022-07-24","NO"));
    }

    public static ArrayList<Task> getAllTasks(){
        return tasks;
    }

    public static void addTask(Task task){
        task.setId(id);
        tasks.add(task);
        id++;
    }

    public static Task getTask(Long id){
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst().orElse(null);
    }

    public static void deleteTaskForEach(Long id){
        for(Task ts :tasks){
            if(ts.getId()==id)
                tasks.remove(ts.getId());
        }
    }

    public static void deleteTask(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }

    public static void saveItem(Task task){
        for(Task ts :tasks) {
               if (ts.getId() == task.getId()) {
                   tasks.set(task.getId().intValue() - 1,task);
               }
           }
    }
}
