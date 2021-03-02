package com.epam.task.fifth.parse;

import com.epam.task.fifth.entity.TextComponent;
import com.epam.task.fifth.entity.TextComposite;

import java.util.Arrays;

public abstract class AbstractParser implements Parser {

    private Parser successor;

    protected Parser getSuccessor() {
        return successor;
    }

    public AbstractParser(final Parser successor) {
        this.successor = successor;
    }

    @Override
    public TextComposite parse(final String inputText){
        String splitter = getSplitter();
        String[] components = inputText.split(splitter);
        Parser tempSuccessor = getSuccessor();
        TextComposite composite = new TextComposite();
        Arrays.stream(components).forEach(component -> {
            TextComponent textComponent = tempSuccessor.parse(component);
            composite.addTextComponent(textComponent);
        });
        return composite;
    }

    protected abstract String getSplitter();

}
