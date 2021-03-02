package com.epam.task.fifth.logic;

import com.epam.task.fifth.entity.TextComponent;
import com.epam.task.fifth.entity.TextComposite;
import com.epam.task.fifth.entity.LexemeLeaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class TextLogicTest {

    private final TextLogic textLogic = new TextLogic();

    @Test
    public void testSortParagraphsByNumberOfSentences() {
        //given
        TextComponent firstParagraph = new TextComposite(
                Arrays.asList(
                        new TextComposite(
                                Arrays.asList(
                                        new LexemeLeaf("A"),
                                        new LexemeLeaf("asd")
                                )
                        ),
                        new TextComposite(
                                Collections.singletonList(
                                        new LexemeLeaf("B")
                                )
                        )
                )
        );

        TextComponent secondParagraph = new TextComposite(
                Collections.singletonList(
                        new TextComposite(
                                Arrays.asList(
                                        new LexemeLeaf("Test"),
                                        new LexemeLeaf("123")
                                )
                        )
                )
        );

        TextComposite expected = new TextComposite(Arrays.asList(secondParagraph, firstParagraph));

        TextComposite unsortedParagraphs = new TextComposite(Arrays.asList(firstParagraph, secondParagraph));

        //when
        TextComposite actual = textLogic.sortParagraphsByNumbersOfSentences(unsortedParagraphs);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortWordsByLength() {
        //given
        TextComponent firstLexeme = new LexemeLeaf("ashf");
        TextComponent secondLexeme = new LexemeLeaf("A");

        TextComposite expected = new TextComposite(Arrays.asList(secondLexeme, firstLexeme));

        TextComposite unsortedLexemes = new TextComposite(Arrays.asList(firstLexeme, secondLexeme));

        //when
        TextComposite actual = textLogic.sortWordsByLength(unsortedLexemes);

        Assert.assertEquals(expected, actual);
    }
}