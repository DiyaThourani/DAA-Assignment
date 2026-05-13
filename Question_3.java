import java.util.*;
public class Question_3{
    private Map<String, List<String>> graph = new HashMap<>();
    private Set<String> visited = new HashSet<>();
    private Stack<String> stack = new Stack<>();

    void addEdge(String u, String v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>());
    }

    void dfsVisit(String node) {
        visited.add(node);
        for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsVisit(neighbor);
            }
        }
        stack.push(node);
    }

    void topologicalSort() {
        List<String> allVertices = new ArrayList<>(graph.keySet());
        Collections.sort(allVertices);

        for (String v : allVertices) {
            if (!visited.contains(v)) {
                dfsVisit(v);
            }
        }

        System.out.print("  Topological Order:  ");
        List<String> result = new ArrayList<>();
        while (!stack.isEmpty()) result.add(stack.pop());
        System.out.print(String.join(" -> ", result));
    }

    public static void main(String[] args) {
        System.out.println("  Q3: TOPOLOGICAL SORT (DFS)");

        Question_3 g = new Question_3();

        String[][] edges = {
                {"m","q"}, {"m","r"}, {"m","x"},
                {"n","q"}, {"n","o"}, {"n","u"},
                {"o","r"}, {"o","s"}, {"o","v"},
                {"p","o"}, {"p","s"}, {"p","z"},
                {"q","t"},
                {"r","u"}, {"r","y"},
                {"s","r"},
                {"u","t"}, {"u","y"},
                {"v","w"}, {"v","x"},
                {"w","z"}
        };

        System.out.println("\n  Edges added:");
        for (String[] e : edges) {
            g.addEdge(e[0], e[1]);
            System.out.print("    " + e[0] + " -> " + e[1] + ", ");
        }

        System.out.println();
        g.topologicalSort();
    }
}