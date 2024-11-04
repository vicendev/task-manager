package org.ua.task.manager.services;

import org.ua.task.manager.entities.Task;
import org.ua.task.manager.helpers.DisplayHelper;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TaskService {

    Scanner scanner;
    final DisplayHelper displayHelper = new DisplayHelper();

    public TaskService(Scanner scanner) {
        this.scanner = scanner;
    }

    public Task createTask() {
        System.out.print("\n==== Modulo Agregar Tarea ====\n");
        Task task = new Task();

        System.out.println("Escribe el titulo de la tarea: ");
        String title = scanner.nextLine();

        System.out.println("\nEscribe la descripcion de la tarea: ");
        String description = scanner.nextLine();

        task.setTitle(title);
        task.setDescription(description);

        // Display new task in table format
        System.out.print("\n==== Nueva tarea agregada ====\n");
        displayHelper.displayTasks(Collections.singletonList(task));

        return task;
    }

    public void displayAllTask(List<Task> taskList) {
        System.out.print("\n==== Modulo Ver Tareas ====\n");
        if (!validateListContent(taskList)) return;

        displayHelper.displayTasks(taskList);
    }

    public void markTaskAsComplete(List<Task> taskList) {
        System.out.print("\n==== Modulo Actualizar Tarea ====\n");
        if (!validateListContent(taskList)) return;

        displayHelper.displayTasks(taskList);
        try {
            System.out.println("\nSelecciona el ID de una tarea para actualizar: ");

            int selectedId = scanner.nextInt();

            taskList.stream()
                    .filter(task -> task.getId() == selectedId)
                    .findFirst()
                    .ifPresentOrElse(
                            task -> {
                                task.setCompleted(true);
                                System.out.println("\nTarea actualizada con éxito!\n");
                                displayHelper.displayTasks(Collections.singletonList(task));
                            },
                            () -> System.out.println("\nId de Tarea no encontrada.\n")
                    );

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, ingresa solo números.");
        }

    }

    public void removeTask(List<Task> taskList) {
        System.out.print("\n==== Modulo Actualizar Tarea ====\n");
        if (!validateListContent(taskList)) return;

        displayHelper.displayTasks(taskList);
        try {
            System.out.println("\nSelecciona el ID de una tarea para eliminar: ");
            int selectedId = scanner.nextInt();

            boolean isDeleted = taskList.removeIf(task -> task.getId() == selectedId);
            if (isDeleted) {
                System.out.println("\nTarea eliminada con exito!\n");
                return;
            }

            System.out.println("\nId Tarea no fue posible eliminar!\n");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, ingresa solo números.");
        }
    }

    private boolean validateListContent(List<Task> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("No hay tareas para mostrar.\n");
            return false;
        }

        return true;
    }
}
