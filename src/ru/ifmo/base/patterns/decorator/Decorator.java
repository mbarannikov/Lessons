package ru.ifmo.base.patterns.decorator;

import java.time.LocalDateTime;

public class Decorator {
    public static void main(String[] args) {
        ILogger logger = new Logger();
        logger.write("срочное сообщение");
        ILogger dateLogger = new DateTimeDecorator(logger);
        dateLogger.write("срочное сообщение");

        ILogger codeLogger = new CodeDecorator(logger);
        codeLogger.write("срочное сообщение");

        ILogger dateCodeLogger = new CodeDecorator(
                new DateTimeDecorator(new Logger()
                ));
        dateCodeLogger.write("срочное сообщение");

        ILogger codeDateLogger = new DateTimeDecorator(codeLogger);
        codeDateLogger.write("срочное сообщение");

    }
}

interface ILogger {
    void write(String message);
}

// класс, реализующий основной функционал
class Logger implements ILogger {
    @Override
    public void write(String message) {
        System.out.println(message);
    }
}

// базовый декоратор (родительский класс для остальных декораторов)
// должен иметь общий интерфейс с классом реализующим основной функционал
class BaseDecorator implements ILogger {
    // должен иметь ссылку на объект c типом общего интерфейса
    private ILogger logger;

    public BaseDecorator(ILogger logger) {
        this.logger = logger;
    }

    @Override
    public void write(String message) {
        logger.write(message);
    }
}

// декораторы
class DateTimeDecorator extends BaseDecorator {
    public DateTimeDecorator(ILogger logger) {
        super(logger);
    }

    @Override
    public void write(String message) {
        String newMessage = message + " date: " + LocalDateTime.now();
        super.write(newMessage);
    }
}

class CodeDecorator extends BaseDecorator {
    public CodeDecorator(ILogger logger) {
        super(logger);
    }

    @Override
    public void write(String message) {
        String newMessage = message + " code: " + Math.random();
        super.write(newMessage);
    }
}
