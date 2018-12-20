package com.jokeme.thejoker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TheJoker {

    private List<String> jokesList = new ArrayList<>();

    public String getAJokes() {
        if (jokesList != null && jokesList.size() == 0) {
            jokesList.add("Did you hear about the crook who stole a calendar? He got twelve months.");
            jokesList.add("To this day, the boy that used to bully me at school still takes my lunch money. On the plus side, he makes great Subway sandwiches.");
            jokesList.add("At what age is it appropriate to tell my dog that he's adopted?");
            jokesList.add("The first computer dates back to Adam and Eve. It was an Apple with limited memory, just one byte. And then everything crashed.");
            jokesList.add("Alcohol is a perfect solvent: It dissolves marriages, families and careers.");
            jokesList.add("I asked my North Korean friend how it was there, he said he couldn't complain.");
            jokesList.add("That one liner 'i'm not drinking too much tonight' never goes as planned...");
            jokesList.add("I just asked my husband if he remembers what today is... Scaring men is easy.");
            jokesList.add("A man walks into a bar with a roll of tarmac under his arm and says: \"Pint please, and one for the road.\"");
            jokesList.add("Why did the blonde stare at a frozen orange juice can for 2 hours? Because it said \"concentrate\"!");
        }

        return jokesList.get(ThreadLocalRandom.current().nextInt(jokesList.size()));
    }

}
