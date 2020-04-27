package ru.ifmo.base.lesson14.hw;

import ru.ifmo.base.lesson14.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        int cntLOW = 0;
        int cntMEDIUM = 0;
        int cntHIGH = 0;
        int cntURGENT = 0;

        for (Message message : messageList
        ) {
            if (message.getPriority() == MessagePriority.LOW) cntLOW++;
            else if (message.getPriority() == MessagePriority.MEDIUM) cntMEDIUM++;
            else if (message.getPriority() == MessagePriority.HIGH) cntHIGH++;
            else cntURGENT++;
        }
        System.out.println("Message Priority.LOW count =" + cntLOW);
        System.out.println("Message Priority.MEDIUM count =" + cntMEDIUM);
        System.out.println("Message Priority.HIGH count =" + cntHIGH);
        System.out.println("Message Priority.URGENT count =" + cntURGENT);
        // TODO:  Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль

    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль

        ArrayList<Integer> cntArrayList = new ArrayList<>(10);
        while (cntArrayList.size() < 10) cntArrayList.add(0);
        for (Message message : messageList
        ) {
            int index = message.getCode();
            int value = cntArrayList.get(index);  //cntArrayList.get(indx) + 1;
            cntArrayList.set(index, value + 1);
        }
        for (int i = 0; i < cntArrayList.size(); i++) {
            Integer value = cntArrayList.get(i);
            if (value != 0) System.out.println("Код сообщения = " + i + " количество =" + value);
        }
    }

    private static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        ArrayList<Message> uniqArrayList = new ArrayList<>(messageList.size());
        int cnt = 0;
        for (Message message : messageList
        ) {
            if (!uniqArrayList.contains(message))  {
                uniqArrayList.add(message);
                cnt++;
            }
        }
        System.out.println("Уникальных сообщений = " + cnt);
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        List<Message> uniqArrayList = new ArrayList<>();
        for (Message message : messageList
        ) {
            if (!uniqArrayList.contains(message)) uniqArrayList.add(message);
        }
        System.out.println("Неповторяющиеся сообщения" + uniqArrayList);
        return uniqArrayList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        System.out.println("Перед удалением = " + messageList);
        Iterator<Message> messageIterator = messageList.listIterator();
        while (messageIterator.hasNext()){
            if(messageIterator.hasNext()){
                if(messageIterator.next().getPriority().equals(priority)){
                    messageIterator.remove();
                }
            }
        }
        System.out.println("После удаления = " + messageList);
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        System.out.println("Перед удалением = " + messageList);
        Iterator<Message> messageIterator = messageList.listIterator();
        while (messageIterator.hasNext()){
            if(messageIterator.hasNext()){
                if(!messageIterator.next().getPriority().equals(priority)){
                    messageIterator.remove();
                }
            }
        }
        System.out.println("После удаления = " + messageList);
    }

    public static void main(String[] args) {
        // вызов методов
        List<Message> messages = MessageGenerator.generate(5);
        System.out.println(messages);
        countEachPriority(messages);
        countEachCode(messages);
        uniqueMessageCount(messages);
        uniqueMessagesInOriginalOrder(messages);
        removeEach(messages,MessagePriority.URGENT);
        removeOther(messages, MessagePriority.LOW);
    }
}
