package com.epam.task.fifth.entity.expression;

public class TerminalExpressionPlus extends AbstractMathExpression{
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() + context.popValue());
    }
}
