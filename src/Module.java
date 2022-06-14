import java.util.HashSet;
import java.util.List;

public class  Module {
    private String name;
    private HashSet<String> dependencies;
    private int visited =0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<String> getDependencies() {
        return dependencies;
    }

    public void setDependencies(HashSet<String> dependencies) {
        this.dependencies = dependencies;
    }

    public int getVisited() {
        return visited;
    }

    public void setVisited(int visited) {
        this.visited = visited;
    }
}
