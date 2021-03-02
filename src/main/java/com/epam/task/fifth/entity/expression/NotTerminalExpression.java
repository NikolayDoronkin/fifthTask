package com.epam.task.fifth.entity.expression;

public class NotTerminalExpression extends AbstractMathExpression{

    private int number;

    public NotTerminalExpression(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
