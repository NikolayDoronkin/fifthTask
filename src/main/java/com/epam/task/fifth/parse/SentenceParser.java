package com.epam.task.fifth.parse;

import com.epam.task.fifth.entity.TextComponent;
import com.epam.task.fifth.entity.TextComposite;
import com.epam.task.fifth.logic.MathLogicCalculator;

import java.util.Arrays;

public class SentenceParser extends AbstractParser {

    private final static String sentenceSplitter = "\\s";

    public SentenceParser(final Parser successor) {
        super(successor);
    }

    @Override
    protected String getSplitter() {
        return sentenceSplitter;
    }

    @Override
    public TextComposite parse(String text) {
        text = findMathString(text);
        String[] words = text.split(sentenceSplitter);
        TextComposite composite = new TextComposite();
        Parser tempSuccessor = getSuccessor();
        Arrays.stream(words).forEach(component -> {
            TextComponent textComponent = tempSuccessor.parse(component);
            composite.addTextComponent(textComponent);
        });
        return composite;
    }

    private String findMathString(String text) {
        for (int first = 0; first < text.length(); first++) {
            if (text.charAt(first) == '[') {
                for (int second = first; second < text.length(); second++) {
                    if (text.charAt(second) == ']') {
                        String oldString = text.substring(first + 1, second);
                        text = text.replace(oldString, new MathLogicCalculator(oldString).calculate());
                        break;
                    }
                }
            }
        }
        return text;
    }

}
