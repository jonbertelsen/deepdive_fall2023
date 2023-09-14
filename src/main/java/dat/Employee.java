package dat;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@NoArgsConstructor
public class Employee implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    public Employee(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Employee(String name, int age, LocalDate birthdate)
    {
        this.name = name;
        this.age = age;
        this.birthDate = birthdate;
    }
}