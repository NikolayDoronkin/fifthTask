package com.epam.task.fifth.parse;

public class ParserChainBuilder {

    public static AbstractParser buildChain() {
        return new TextParser(
                new ParagraphParser(
                        new SentenceParser(
                                new LexemeParser()
                        )
                )
        );
    }

}
