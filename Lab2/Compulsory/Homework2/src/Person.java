import java.util.Date;
import java.util.Objects;

public class Person { /** Leonte Tudor**/
protected String name;
    protected String birthDate;

    public Person (String name, String birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        Person person = (Person) obj;
        return Objects.equals(name, person.name) && Objects.equals(birthDate, person.birthDate);
    }
}
