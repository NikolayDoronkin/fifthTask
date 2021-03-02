package com.epam.task.fifth.logic;

import com.epam.task.fifth.entity.expression.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MathLogicCalculator {
    private ArrayList<AbstractMathExpression> listExpression;

    public MathLogicCalculator(String expression) {
        listExpression = new ArrayList<>();
        parse(expression);
    }

    private void parse(String expression) {
        for (String lexeme : expression.split("\\p{Blank}+")) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+' -> listExpression.add(new TerminalExpressionPlus());
                case '-' -> listExpression.add(new TerminalExpressionMinus());
                case '*' -> listExpression.add(new TerminalExpressionMultiply());
                case '/' -> listExpression.add(new TerminalExpressionDivide());
                default -> {
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        listExpression.add(new NotTerminalExpression(scanner.nextInt()));
                    }
                }
            }
        }
    }

    public String calculate() {
        Context context = new Context();
        for (AbstractMathExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        return Integer.toString(context.popValue());
    }

}
