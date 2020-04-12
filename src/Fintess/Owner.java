package Fintess;

import java.time.LocalDate;

 public class Owner implements Comparable<Owner>{
    private String name;
    private String surname;
    private LocalDate birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        if (birthDate.isBefore(LocalDate.now())){this.birthDate = birthDate;}
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public Owner(String name, String surname, LocalDate birthDate) {
        if(name != null&&surname != null){
            setName(name);
            setSurname(surname);
            setBirthDate(birthDate);
        }
    }

     @Override
     public String toString() {
         return "Owner{" +
                 "name='" + name + '\'' +
                 ", surname='" + surname +
                 '}';
     }

     @Override
     public int compareTo(Owner o) {
         int compare;
        if (o == null) compare = -1;
        else {
            compare = getSurname().compareTo(o.getSurname());
            if (compare == 0) compare = getName().compareTo(o.getName());
        }
        return compare;
     }
 }
