package com.company;

import javax.swing.text.IconView;

public class Calc extends Compf {
    private StackInt s;
    public int hex = 0;

    private static int char2int(char c) {
        return (int)c - (int)'0';
    }

    @Override
    protected int symOther(char c) {
        if (c < '0' || c > '9') {
            System.out.println("Недопустимый символ: " + c);
            System.exit(0);
        }
        return SYM_OTHER;
    }

    @Override
    protected void nextOper(char c) {
        int second = s.pop();
        int first = s.pop();
        switch (c) {
            case '+':
                s.push(first + second); break;
            case '-':
                s.push(first - second); break;
            case '*':
                s.push(first * second); break;
            case '/':
                s.push(first / second); break;
        }
    }

    @Override
    protected void nextOther(char c) {

        if (num > 1){
            int a = s.pop();

            if (10*a+char2int(c) >= 4000) {
                System.out.println("Введите др число");
            }
            else s.push(10*a+char2int(c));
        }
        else s.push(char2int(c));

    }

    public Calc() {
        s = new StackInt();
    }

    @Override
    public final void compile(char[] str) {
        super.compile(str);
        hex = (int)s.top();
        System.out.println("" + s.top());
    }

}
