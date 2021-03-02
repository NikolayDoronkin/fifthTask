package com.epam.task.fifth.parse;

import com.epam.task.fifth.entity.LexemeLeaf;
import com.epam.task.fifth.entity.TextComponent;
import com.epam.task.fifth.entity.TextComposite;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.*;

public class TextParserTest {

    private final Parser paragraphParser = Mockito.mock(ParagraphParser.class);

    private final Parser textParser = new TextParser(paragraphParser);

    @Test
    public void test() {
        //given
        String firstParagraphText = "Test 123.";
        String secondParagraphText = "A asd. B.";

        String text = firstParagraphText + "\s\t" + secondParagraphText;

        TextComponent firstParagraph = new TextComposite(
                Collections.singletonList(
                        new TextComposite(
                                Arrays.asList(
                                        new LexemeLeaf("Test"),
                                        new LexemeLeaf("123.")
                                )
                        )
                )
        );

        TextComponent secondParagraph = new TextComposite(
                Arrays.asList(
                        new TextComposite(
                                Arrays.asList(
                                        new LexemeLeaf("A"),
                                        new LexemeLeaf("asd")
                                )
                        ),
                        new TextComposite(
                                Collections.singletonList(
                                        new LexemeLeaf("B.")
                                )
                        )
                )
        );
        AbstractParser textParser = ParserChainBuilder.buildChain();

        TextComponent expected = new TextComposite(Arrays.asList(firstParagraph, secondParagraph));

        when(paragraphParser.parse(firstParagraphText)).thenReturn(firstParagraph);
        when(paragraphParser.parse(secondParagraphText)).thenReturn(secondParagraph);

        //when
        TextComponent actual = textParser.parse(text);

        //then
        Assert.assertEquals(expected, actual);

    }
}