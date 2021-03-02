package com.epam.task.fifth.entity;

import java.util.Objects;

public class LexemeLeaf implements TextComponent{

    private String stringLine;

    public LexemeLeaf(final String stringLine) {
        this.stringLine = stringLine;
    }

    public String getStringLine() {
        return stringLine;
    }

    public void setStringLine(final String stringLine) {
        this.stringLine = stringLine;
    }


    @Override
    public void addTextComponent(TextComponent component) {
    }

    @Override
    public void removeTextComponent(TextComponent component) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LexemeLeaf that = (LexemeLeaf) o;
        return Objects.equals(stringLine, that.stringLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stringLine);
    }

    @Override
    public String toString() {
        return "LexemeLeaf{" +
                "stringLine='" + stringLine + '\'' +
                '}';
    }
}
