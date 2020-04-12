package Fintess;

//Задача «Фитнес»
//В фитнес клубе есть три типа абонентов:
//    Разовый. По разовому абонементу клиенты могут посещать бассейн и тренажерный зал с 8 до 22 часов.
//    Дневной. По данному абонементу клиенты могут посещать тренажерный зал и групповые занятия (но не бассейн) с 8 до 16 часов.
//    Полный. По данному абонементу клиенты могут посещать тренажерный зал, бассейн и групповые занятия с 8 до 22 часов.
//
//Каждый абонемент хранит дату регистрации (текущая дата) и дату окончания регистрации.
//Каждый абонемент хранит информацию о владельце. Данные о владельце: имя, фамилия, год рождения.
//
//Фитнес содержит информацию об абонементах:
//    которые зарегистрированы в данный момент в тренажерном зале;
//    абонементах, которые зарегистрированы в бассейне;
//    абонементах, которые зарегистрированы на групповых занятиях.
//
//В каждой зоне (бассейн, тренажерный зал, групповые занятия) одновременно может быть зарегистрировано 20 абонентов.
//
//Когда  фитнес клуб закрывается, клиенты покидают его.
//
//Когда клиент приходит в фитнес клуб, он сообщает желаемую зону и показывает абонемент.
//Необходимо проверить может ли данный посетитель пройти в желаемую зону и пропустить его,
//если возможность существует; если посетитель не может пройти, необходимо сообщить ему причину.
//
//Посетитель не может пройти, если время абонемента не соответсвует текущему времени,
//если он пытается пройти в зону, которая не разрешена по его абонементу,
//если в зоне нет свободных мест.
//
//Реализовать возможность вывода информации о посетителях:
//сначала посетителях тренажерного зала, потом бассейна, потом групповых занятий.
//Выводить имя и фамилию посетителей в отсортированном порядке (сначала фамилия, потом имя).
//
//Реализовать возможность выводить информацию в консоль каждый раз, когда клиент посещает фитнес клуб.
//Информация для вывода:
//Фамилия
//Имя
//Вид занятия
//Дата и время посещения
//
//Методы вывода информации в консоль можно описать в отдельном классе Logger (методы можно сделать static)

import java.time.LocalDate;

public abstract class Abonent {
    private LocalDate startDate;
    private LocalDate finishDate;
    private Owner owner;
    private String currentZone; // null - ничего, ZAL - тренажерный зал, BAS - бассейн, GRP - групповые занятия
    private boolean pass;
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        if (finishDate.isAfter(startDate)){this.finishDate = finishDate;}
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setCurrentZone(String currentZone) {
        this.currentZone = currentZone;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public String getCurrentZone() {
        return currentZone;
    }

    public Abonent(LocalDate startDate, LocalDate finishDate, Owner owner) {
        this.startDate = startDate;
        setFinishDate(finishDate);
        this.owner = owner;
        pass = true;
    }

    public Owner getOwner() {
        return owner;
    }

    public boolean isPass() {
        return pass;
    }
    public void disablePass() {
        pass = false;
    }
    public void enablePass() {
        pass = true;
    }
}
