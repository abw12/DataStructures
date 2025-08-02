package Java8.StreamAPI;

public class Project {
    private String name;
    private String priority;
    private int durationInMonths;

    public Project(String name, String priority, int durationInMonths) {
        this.name = name;
        this.priority = priority;
        this.durationInMonths = durationInMonths;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", priority='" + priority + '\'' +
                ", durationInMonths=" + durationInMonths +
                '}';
    }
}