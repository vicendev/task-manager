package org.ua.task.manager.controller;

import org.ua.task.manager.entities.Task;
import org.ua.task.manager.services.TaskService;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuController {

    Scanner scanner = new Scanner(System.in);
    final TaskService taskService = new TaskService(scanner);

    public void taskManagerMenu () {

        List<Task> taskList = new ArrayList<>();
        boolean exit = false;

        while (!exit) {
            System.out.println(
              """
              \nMenu:
              1. Agregar Tareas
              2. Ver Tareas
              3. Marcar Tarea como completada
              4. Eliminar Tarea
              5. Salir
             """);

            try {
                System.out.print("Selecciona una opcion: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {

                    case 1:
                        Task newTask = taskService.createTask();
                        taskList.add(newTask);
                        break;

                    case 2:
                        taskService.displayAllTask(taskList);
                        break;

                    case 3:
                        taskService.markTaskAsComplete(taskList);
                        break;
                    case 4:
                        taskService.removeTask(taskList);
                        break;

                    case 5:
                        exit = true;
                        break;

                    default:
                        System.out.println("Opcion selecionada no soportada!");
                }
            } catch (Exception e) {
                System.out.println("Debes introducir un número.");
            }
        }
    }
}
