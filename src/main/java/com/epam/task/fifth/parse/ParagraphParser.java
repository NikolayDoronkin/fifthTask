package com.epam.task.fifth.parse;


public class ParagraphParser extends AbstractParser {

    private final static String paragraphSplitter = "(\\.\\s)";

    public ParagraphParser(final Parser successor) {
        super(successor);
    }

    @Override
    protected final String getSplitter() {
        return paragraphSplitter;
    }

}
