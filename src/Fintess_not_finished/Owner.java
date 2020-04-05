package Fintess_not_finished;

import java.time.LocalDate;

 public class Owner {
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
}
