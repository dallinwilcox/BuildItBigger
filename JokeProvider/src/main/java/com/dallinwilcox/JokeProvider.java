package com.dallinwilcox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

// Jokes come from http://www.rd.com/jokes/kids/
//referenced http://www.javapractices.com/topic/TopicAction.do?Id=62

public class JokeProvider {
    private Random rand = new Random();
    private List<String> jokes = new ArrayList<String>(Arrays.asList(
            "Q: Why does a chicken coop have two doors?\n" +
                "\n" + "A: If it had four, it would be a chicken sedan.",
            "Q: What do you call a parade of rabbits hopping backwards?\n" +
                "\n" + "A: a receding hare-line.",
            "Q: What do you call an old snowman?\n" + "\n" + "A: Water!",
            "Q: What's the different between a cat and a comma?\n" +
                "\n" + "A: A cat has claws at the end of paws; A comma is a pause at the end of a clause.",
            "Q: Which dinosaur knew the most words?\n" +
                "\n" + "A: The thesaurus.",
            "Q: What does a nosey pepper do?\n" +
                "\n" + "A: Gets jalape\u00F1o business!"
    ));

    public String getRandomJoke()
    {
        return jokes.get(rand.nextInt(jokes.size()));
    }
}
