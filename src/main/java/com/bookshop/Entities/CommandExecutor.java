package com.bookshop.Entities;

import java.util.List;
import java.util.ArrayList;

public class CommandExecutor {
    private List<LibraryCommands> commandList;

    public CommandExecutor() {
        this.commandList = new ArrayList<LibraryCommands>();
    }

    public void execute(LibraryCommands command, Book book) {
        this.commandList.add(command);
        command.executeLibCommand(book);
    }
}
