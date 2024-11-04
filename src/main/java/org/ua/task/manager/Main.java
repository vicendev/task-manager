package org.ua.task.manager;

import com.github.lalyos.jfiglet.FigletFont;
import org.ua.task.manager.controller.MenuController;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        String asciiArt = FigletFont.convertOneLine("TASK MANAGER");
        System.out.println(asciiArt);

        MenuController menuController = new MenuController();

        menuController.taskManagerMenu();
    }
}
