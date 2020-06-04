package structure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 *
 * @author zhy
 * @date 2020/6/3
 */
public class Undigraph {

  boolean found = false; // 全局变量或者类成员变量
  private int v; // 顶点的个数
  private LinkedList<Integer>[] adj; // 邻接表

  public Undigraph(int v) {
    this.v = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i) {
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdge(int s, int t) { // 无向图一条边存两次
    adj[s].add(t);
    adj[t].add(s);
  }

  public void bfs(int s, int t) {
    if (s == t) {
      return;
    }
    boolean[] visited = new boolean[v];
    visited[s] = true;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    int[] prev = new int[v];
    for (int i = 0; i < v; ++i) {
      prev[i] = -1;
    }
    while (queue.size() != 0) {
      int w = queue.poll();
      for (int i = 0; i < adj[w].size(); ++i) {
        int q = adj[w].get(i);
        if (!visited[q]) {
          prev[q] = w;
          if (q == t) {
            print(prev, s, t);
            return;
          }
          visited[q] = true;
          queue.add(q);
        }
      }
    }
  }

  public void dfs(int s, int t) {
    found = false;
    boolean[] visited = new boolean[v];
    int[] prev = new int[v];
    for (int i = 0; i < v; ++i) {
      prev[i] = -1;
    }
    recurDfs(s, t, visited, prev);
    print(prev, s, t);
  }

  private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
    if (found) {
      return;
    }
    visited[w] = true;
    if (w == t) {
      found = true;
      return;
    }
    for (int i = 0; i < adj[w].size(); ++i) {
      int q = adj[w].get(i);
      if (!visited[q]) {
        prev[q] = w;
        recurDfs(q, t, visited, prev);
      }
    }
  }

  private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
    if (prev[t] != -1 && t != s) {
      print(prev, s, prev[t]);
    }
    System.out.print(t + " ");
  }

  public static void main(String[] args) {
    Undigraph undigraph = new Undigraph(9);
    undigraph.addEdge(1,2);
    undigraph.addEdge(1,4);
    undigraph.addEdge(2,3);
    undigraph.addEdge(2,5);
    undigraph.addEdge(4,5);
    undigraph.addEdge(5,6);
    undigraph.addEdge(3,6);
    undigraph.addEdge(5,7);
    undigraph.addEdge(6,8);
    undigraph.addEdge(7,8);
    undigraph.bfs(1,8);
    System.out.println();
    undigraph.dfs(1,8);
    System.out.println();
  }

}
