package dat;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
public class GardenTask extends Task
{
    private String location;

    public GardenTask(String title, String description, LocalDate dueDate, String location)
    {
        super(title, description, dueDate);
        this.location = location;
    }

    @Override
    public String toString()
    {
        return super.toString() + "GardenTask{" +
                "location='" + location + '\'' +
                '}';
    }
}
