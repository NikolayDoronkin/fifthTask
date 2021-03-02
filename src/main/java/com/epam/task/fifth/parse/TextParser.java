package com.epam.task.fifth.parse;


public class TextParser extends AbstractParser {

    private final static String textSplitter = "\s+\t";

    public TextParser(final Parser successor) {
        super(successor);
    }

    @Override
    protected String getSplitter() {
        return textSplitter;
    }

}
