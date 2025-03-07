import java.util.Objects;

public class Project { 
String title;
    private Type type;

    public Project (String title, Type type)
    {
        this.title = title;
        this.type = type;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Project)) return false;
        Project project = (Project) obj;
        return Objects.equals(project.title, title) && Objects.equals(project.type, type);
    }
}
