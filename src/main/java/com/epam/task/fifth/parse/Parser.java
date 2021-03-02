package com.epam.task.fifth.parse;


import com.epam.task.fifth.entity.TextComponent;

public interface Parser {
    TextComponent parse(final String text);
}
