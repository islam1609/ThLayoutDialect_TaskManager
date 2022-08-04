package Thymeleaf.Layout.Dialect.springboot.DB;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    Long id;
    String name;
    String deadlineDate;
    String isCompleted;
}

