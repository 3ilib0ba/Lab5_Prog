package main;

import commands.Execute;
import commands.exceptions.ExitException;

import java.util.Scanner;

public class StartConsole {
    public static void StartConsoleMode(MyTreeMap MyMap){
        try {
            new Execute(false, MyMap, new Scanner(System.in));
        } catch (ExitException e) {
            System.out.println(e.getMessage());
        }
    }
}
