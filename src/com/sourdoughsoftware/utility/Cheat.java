package com.sourdoughsoftware.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Cheat {
    String filePathAnimatedArt = "Elsa";

    public void addAllPiesToInventory() {

    }

    public void doubleAttackPoints() {

    }

    public void showCheatArt() throws InterruptedException, IOException {
            String[] art = new String[0];
            try {
                art = Files.readString(Path.of("resources", filePathAnimatedArt)).split(Pattern.quote("\\n"),-1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String color = Colors.randomColor();
            for(int i = 0; i < art.length; i++) {
                System.out.println(color + art[i]);
                Thread.sleep(30);
                //System.out.print("\033[H\033[2J");
                //System.out.flush();
                if(System.getProperty("os.name").toLowerCase().contains("mac")) {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                }else {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                }
            }
    }

}