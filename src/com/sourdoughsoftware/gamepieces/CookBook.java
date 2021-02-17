package com.sourdoughsoftware.gamepieces;

import com.sourdoughsoftware.GameState;
import com.sourdoughsoftware.utility.Node;

import java.util.ArrayList;
import java.util.Random;

import static com.sourdoughsoftware.utility.Colors.ANSI_BLUE;
import static com.sourdoughsoftware.utility.Colors.ANSI_UNDERLINE;
import static com.sourdoughsoftware.utility.Colors.ANSI_RESET;

public class CookBook {
    private ArrayList<String> recipes = new ArrayList<>();
    private ArrayList<String> currentRecipes = new ArrayList();

    public CookBook() {
        ArrayList<Pie> findablePies = GameState.getFindableWeapons();
        for(int i = 0; i < findablePies.size(); i+=2) {
            Node parent = GameState.getTree().find(findablePies.get(i)).getParent();
            String ingredient1 = findablePies.get(i).getName();
            String ingredient2 = findablePies.get(i+1).getName();
            String recipe = parent.getItem().getName() + " = " + ingredient1 + " + " + ingredient2;
            recipes.add(recipe);
        }
    }

    private void addRecipe() {
        Random rand = new Random();
        int index = rand.nextInt(recipes.size());
        if(recipes.size() >0) {
            String recipe = recipes.get(index);
            currentRecipes.add(recipe);
            recipes.remove(index);
        }
    }

    public String getRecipes() {
        StringBuilder cookBook = new StringBuilder();
        cookBook.append(ANSI_UNDERLINE);
        cookBook.append(ANSI_BLUE);
        cookBook.append("Pie Cookbook");
        cookBook.append(ANSI_RESET);
        for(int i = 0; i < currentRecipes.size(); i++) {
            cookBook.append("\n");
            cookBook.append(i).append(") ").append(currentRecipes.get(i));
        }
        return cookBook.toString();
    }

}
