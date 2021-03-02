package com.epam.task.fifth.parse;

import com.epam.task.fifth.entity.LexemeLeaf;
import com.epam.task.fifth.entity.TextComponent;

public class LexemeParser implements Parser {

    @Override
    public final TextComponent parse(final String text) {
        return new LexemeLeaf(text);
    }
}
