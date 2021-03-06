package com.sourdoughsoftware.utility;

import com.sourdoughsoftware.Game;
import com.sourdoughsoftware.interaction.Actions;
import com.sourdoughsoftware.GameState;
import com.sourdoughsoftware.interaction.ChainOfEventException;
import com.sourdoughsoftware.interaction.Prompter;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;
import com.sourdoughsoftware.utility.PrintFiles;

/**
 * Welcome screen displays a welcome message to the player when the game begins.
 *
 * @author Tyrone Moore, Kelson Smith, and Gina Villegas
 * @version 1.0.0
 */
public class WelcomeScreen {
    private JukeBox openingCredits = new JukeBox("resources/LifeOfPiSoundTrack/Mr. Blue Sky.wav");
    private JukeBox gameMusic = new JukeBox("resources/LifeOfPiSoundTrack/Gamemusic.wav");
    public static final String WELCOME_MESSAGE = "Welcome to \"The Last Slice of Pi\"";
    PrintFiles p = new PrintFiles();

    /**
     * @return the welcome message
     */
    public static String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public void settingTheScene() {
        p.print("SettingTheScene");
        Prompter.prompt("Press Enter to continue...");
    }

    public void loadingScreen() {
        openingCredits.startJuke();
        openingCredits.turnTheDial((float) -10.69);
        p.print("GameLogo");
        Prompter.prompt("Press Enter to continue...");
    }

    public void splash() throws ParserConfigurationException, SAXException, IOException, ChainOfEventException {
        String begin = "\n1. Start new story\n" +
                "2. Continue from where you left off\n";
        String gameType = Prompter.prompt(begin);
        if (gameType.matches("1")) {
            openingCredits.stopJuke();
//            gameMusic.startJuke();
            gameMusic.turnTheDial((float) -8);
            Game myGame = new Game();
            myGame.start();
        }else if (gameType.matches("2")) {
            try {
                openingCredits.stopJuke();
//                gameMusic.startJuke();
                gameMusic.turnTheDial((float) -8);
                Game myGame = new Game();
                Prompter.prompt(Actions.load());
                myGame.start();
            }catch (Exception e) {
                splash();
            }
        }else {
            splash();
        }
    }
}
