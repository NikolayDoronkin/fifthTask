package com.epam.task.fifth.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextComposite implements TextComponent {

    private List<TextComponent> componentsList;

    public List<TextComponent> getComponentsList() {
        return componentsList;
    }

    public TextComposite(List<TextComponent> inputComponentsList) {
        componentsList = inputComponentsList;
    }

    public TextComposite() {
        componentsList = new ArrayList<>();
    }

    @Override
    public void addTextComponent(final TextComponent inputComponent) {
        if (inputComponent == null) {
            return;
        }
        componentsList.add(inputComponent);
    }

    @Override
    public void removeTextComponent(final TextComponent inputComponent) {
        componentsList.remove(inputComponent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextComposite that = (TextComposite) o;
        return Objects.equals(componentsList, that.componentsList);
    }

    @Override
    public String toString() {
        return "TextComposite{" +
                "componentsList=" + componentsList.toString() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentsList);
    }
}
