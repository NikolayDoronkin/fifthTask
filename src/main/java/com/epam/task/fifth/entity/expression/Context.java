package com.epam.task.fifth.entity.expression;

import java.util.ArrayDeque;
import java.util.Stack;

public class Context {

    private Stack<Integer> contextValue = new Stack<>();

    public Integer popValue() {
        return contextValue.pop();
    }

    public void pushValue(Integer value) {
        this.contextValue.push(value);
    }

}
