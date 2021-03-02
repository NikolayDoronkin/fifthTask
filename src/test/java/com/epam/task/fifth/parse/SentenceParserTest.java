package com.epam.task.fifth.parse;

import com.epam.task.fifth.entity.TextComponent;
import com.epam.task.fifth.entity.TextComposite;
import com.epam.task.fifth.entity.LexemeLeaf;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class SentenceParserTest {

    private final Parser lexemeParser = Mockito.mock(LexemeParser.class);

    private final Parser sentenceParser = new SentenceParser(lexemeParser);

    @Test
    public void testParse() {
        //given
        String firstLexemeText = "A";
        String secondLexemeText = "[5 3 +]";

        String text = firstLexemeText + "\t" + secondLexemeText;

        TextComponent firstLexeme = new LexemeLeaf("A");
        TextComponent secondLexeme = new LexemeLeaf("[8]");
        //AbstractParser sentenceParser = ParserChainBuilder.buildChain();


        TextComponent expected = new TextComposite(Arrays.asList(firstLexeme, secondLexeme));

        /*when(lexemeParser.parse(firstLexemeText)).thenReturn(firstLexeme);
        when(lexemeParser.parse("[5 3 +]")).thenReturn(secondLexeme);*/

        //when
        TextComponent actual = sentenceParser.parse(text);

        //then
        Assert.assertEquals(expected, actual);
    }
}