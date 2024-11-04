package org.ua.task.manager.helpers;

import de.vandermeer.asciitable.AsciiTable;

import org.ua.task.manager.entities.Task;

import java.util.List;

public class DisplayHelper {

    public void displayTasks(List<Task> taskList) {

        AsciiTable displayTable = new AsciiTable();

        // Init Table Rules
        displayTable.getContext().setWidth(100);
        displayTable.addRule();
        displayTable.addRow("ID", "Titulo", "Descripcion", "Completado");
        displayTable.addRule();

        // Display Data Table Rules
        for (Task task : taskList) {
            displayTable.addRow(
                    task.getId(),
                    task.getTitle(),
                    task.getDescription(),
                    task.isCompleted()
            );
            displayTable.addRule();
        }

        // Render Table
        String render = displayTable.render();
        System.out.println(render);
    }
}
