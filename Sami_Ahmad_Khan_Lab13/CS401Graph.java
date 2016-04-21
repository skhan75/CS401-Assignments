/**
 * Created by SamiAK on 4/20/16.
 */
import java.util.Vector;
import java.util.Collections;

/*
 * Example of a graph in Java.  This program will print out the graph,
 * listing the vertices and the edges.  The graph used here corresponds
 * to the graph studied in Lecture 13 for DFS and BFS, plus the "I"
 * vertex as described in the end of the lecture. */

public class CS401Graph
{
    public static void main(String[] args)
    {
        new CS401Graph().run();

        return;
    }

    public void run()
    {
      /*
       *
       */
        int inf = Integer.MAX_VALUE;
        int max_row, max_col;
                         /*      A    B    C    D    E    F    G    H    I */
        int adj[][] ={/* A */ { inf, 8,   inf, 10,  inf, inf, 12,  inf, inf },
                      /* B */ { 8,   inf, inf, inf, 12,  18,  inf, inf, inf },
                      /* C */ { inf, inf, inf, inf, inf, 2,   inf, 10,  inf },
                      /* D */ { 10,  inf, inf, inf, inf, 8,   inf, inf, inf },
                      /* E */ { inf, 12,  inf, inf, inf, inf, 24,  inf, inf },
                      /* F */ { inf, 18,  2,   8,   inf, inf, inf, inf, inf },
                      /* G */ { 12,  inf, inf, inf, 24,  inf, inf, inf, inf },
                      /* H */ { inf, inf, 10,  inf, inf, inf, inf, inf, inf },
                      /* I */ { inf, inf, inf, inf, inf, inf, inf, 3,   inf }
        };

        max_row  = max_col = 9;

        Vector<Vertex> graph = new Vector<Vertex>();
        graph.add(new Vertex("A"));
        graph.add(new Vertex("B"));
        graph.add(new Vertex("C"));
        graph.add(new Vertex("D"));
        graph.add(new Vertex("E"));
        graph.add(new Vertex("F"));
        graph.add(new Vertex("G"));
        graph.add(new Vertex("H"));
        graph.add(new Vertex("I"));

        for (int i = 0; i < max_row; i++)  {
            // Go through each row of the adjacency matrix collecting neighbours
            Vertex v = graph.elementAt(i);
            for (int j = 0; j < max_col; j++)  {
                if (adj[i][j] != inf)  {
                    v.add_edge(new Edge(i, j, adj[i][j]));
                }
            }
            v.order_edges(); /* Order (sort) the neighbours for this vertex */
        }                    /* based on cost (lowest to highest)           */

        //BREADTH FIRST TRAVERSAL
        System.out.println("\nBREADTH FIRST TRAVERSAL");
        System.out.println("-------------------------\n");

        //Traversing through A
        System.out.println("Breadth first Traversing from Vertex A\n");
        bft(graph, graph.elementAt(0));
        System.out.println();

        //Traversing through F
        System.out.println("Breadth first Traversing from Vertex F\n");
        bft(graph, graph.elementAt(5) );
        System.out.println();

        //Traversing through I
        System.out.println("Breadth first Traversing from Vertex I\n");
        bft(graph, graph.elementAt(8) );
        System.out.println();

        /*-------------------------------------------------------------------*/


        //DEPTH FIRST TRAVERSAL
        System.out.println("\nDEPTH FIRST TRAVERSAL");
        System.out.println("-------------------------\n");

        //Traversing through A
        System.out.println("Depth first Traversing from Vertex A\n");
        dft(graph, graph.elementAt(0));
        System.out.println();

        //Traversing through F
        System.out.println("Depth first Traversing from Vertex F\n");
        dft(graph, graph.elementAt(5) );
        System.out.println();

        //Traversing through I
        System.out.println("Depth first Traversing from Vertex I\n");
        dft(graph, graph.elementAt(8) );
        System.out.println();


    }

    //Depth First Traversal
    private void dft(Vector<Vertex> graph, Vertex source) {
        
        CS401StackLinkedListImpl<Vertex> stack = new CS401StackLinkedListImpl<Vertex>();
        StringBuilder sb = new StringBuilder();
        sb.append("" + source.name + ", ");

        source.state = 2; //Visited
        stack.push(source);

        while(!stack.isEmpty()) {

            int count = 0;
            int count2 = 0;

            //getting number of adjacent vertex
            for (Edge e : stack.top().edgelist) {
                count++;
            }

            //for discovering the adjacent vertices
            for(Edge e : stack.top().edgelist){
                if(graph.elementAt(e.destination).state == 0)
                    graph.elementAt(e.destination).state = 1;

                if(graph.elementAt(e.destination).state == 1){
                    graph.elementAt(e.destination).state = 2;
                    sb.append("" + graph.elementAt(e.destination).name + ", ");
                    stack.push(graph.elementAt(e.destination));
                    break;
                }

                if(graph.elementAt(e.destination).state == 2)
                    count2++;

                if(count == count2)
                    stack.pop();
            }
        }
        String s = sb.toString().trim();
        System.out.println(s.substring(0, (s.length()-1)));

        for(Vertex v : graph) //Clearing the states of the graph
            v.state = 0;

    }

    //Breadth First Traversal
    public void bft(Vector<Vertex> graph, Vertex source){
        CS401QueueLinkedListImpl<Vertex> queue = new CS401QueueLinkedListImpl<Vertex>();
        StringBuilder sb = new StringBuilder();

        source.state = 2; //Visited
        queue.add(source);

        while(!queue.is_empty()){

            Vertex v = queue.remove();

            sb.append(""+ v.name + ", ");

            for(Edge e : v.edgelist) {

                if (graph.elementAt(e.destination).state == 0) {
                    graph.elementAt(e.destination).state = 1;
                    queue.add(graph.elementAt(e.destination));
                }
            }

        }
        String s = sb.toString().trim();
        System.out.println(s.substring(0, (s.length()-1)));

        for(Vertex v : graph) //Clearing the states of the graph
            v.state = 0;
        }


    //--------------------------------------------------------------------
    static class Vertex {
        private String name;
        private int id;    /* Integral id of vertex: [0, n-1] */
        private int state; /* 0: undiscovered; 1: discovered; 2: visited */
        private int pred;  /* Predecessor node.  Unused here */
        private Vector<Edge> edgelist;

        private static int counter = 0;

        public Vertex(String name)  {
            this.name = name;
            state = 0;
            pred = -1;
            id = counter++;
            edgelist = null;
        }

        public void order_edges()  {
            Collections.sort(edgelist);
        }

        public String toString()  {
            StringBuffer s = new StringBuffer();

            s.append("Vertex: " + name + "(" + id + ")");
            s.append(" (" + state + ", " + pred + ")\n");
            s.append("  Neighbours: ");
            for (Edge e : edgelist)  {
                s.append(e);
                s.append(" ");
            }

            return s.toString();
        }

        public void add_edge(Edge e)  {
            if (edgelist == null)  {
                edgelist = new Vector<Edge>();
            }
            edgelist.add(e);
        }

        public boolean match_name(String name)  {
            if (this.name.equals(name))
                return true;
            else
                return false;
        }

        public void visited()  {
            state = 2;
        }

        public String get_name()  {
            return name;
        }

        public static int get_vertex_index(String name)  {
            int v = -1;

            switch(name)  {
                case "A": v = 0; break;
                case "B": v = 1; break;
                case "C": v = 2; break;
                case "D": v = 3; break;
                case "E": v = 4; break;
                case "F": v = 5; break;
                case "G": v = 6; break;
                case "H": v = 7; break;
                case "I": v = 8; break;
                default: System.out.println("get_vertex_index: invalid name"); break;
            }
            return v;
        }

        public static String get_vertex_name(int index)  {
            String v = "null";
            switch(index)  {
                case 0: v = "A"; break;
                case 1: v = "B"; break;
                case 2: v = "C"; break;
                case 3: v = "D"; break;
                case 4: v = "E"; break;
                case 5: v = "F"; break;
                case 6: v = "G"; break;
                case 7: v = "H"; break;
                case 8: v = "I"; break;
                default: System.out.println("get_vertex_name: invalid index"); break;
            }
            return v;
        }
    } // Class Vertex

    static class Edge implements Comparable<Edge>  {
        private int source;
        private int destination;
        private int cost;

        public Edge(int s, int d, int c)  {
            source = s; destination = d; cost = c;
        }

        public String toString()  {
            StringBuffer s = new StringBuffer();

            s.append("(" + Vertex.get_vertex_name(source) + ", " +
                    Vertex.get_vertex_name(destination) + ", " + cost + ")");
            return s.toString();
        }

        public int compareTo(Edge o)  {
            if (this.cost < o.cost)
                return -1;
            else if (this.cost > o.cost)
                return 1;
            else
                return 0;
        }

    } // Class Edge


}