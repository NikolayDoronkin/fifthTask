package com.epam.task.fifth.logic;

import com.epam.task.fifth.entity.LexemeLeaf;
import com.epam.task.fifth.entity.TextComponent;
import com.epam.task.fifth.entity.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class TextLogic {

    //first task
    public final TextComposite sortParagraphsByNumbersOfSentences(TextComposite paragraph) {
        List<TextComponent> compositeList = paragraph.getComponentsList();
        List<TextComponent> childrenToSort = new ArrayList<>(compositeList);
        childrenToSort.sort((first, second) -> {
            List<TextComponent> firstComposite = ((TextComposite) first).getComponentsList();
            List<TextComponent> secondComposite = ((TextComposite) second).getComponentsList();
            return firstComposite.size() - secondComposite.size();
        });
        return new TextComposite(childrenToSort);
    }

    //second task
    public TextComposite sortWordsByLength(TextComposite sentence) {

        List<TextComponent> wordList = sentence.getComponentsList();

        List<TextComponent> wordListToSort = new ArrayList<>(wordList);

        wordListToSort.sort((first, second) -> {
            String firstLexeme = ((LexemeLeaf) first).getStringLine();
            String secondLexeme = ((LexemeLeaf) second).getStringLine();
            return firstLexeme.length() - secondLexeme.length();
        });

        return new TextComposite(wordListToSort);
    }

}
