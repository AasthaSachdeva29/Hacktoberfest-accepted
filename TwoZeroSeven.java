import java.util.*;
public class TwoZeroSeven {
    public static class Edge{
        int src;
        int dst;
        Edge(int src,int dst){
            this.src=src;
            this.dst=dst;
        }

    }
    public static boolean isCycleDetection(ArrayList<Edge> gr[],int curr,boolean vis[],boolean rec[]){
        vis[curr]=true;
        rec[curr]=true;
        for (int i=0;i<gr[curr].size();i++){
            Edge e=gr[curr].get(i);
            if(rec[e.dst]){
                return true;
            }else if(!vis[e.dst]){
                if (isCycleDetection(gr,e.dst,vis,rec)){
                    return true;
                }
            }
        }
        rec[curr]=false;
        return false;
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Edge> gr[]=new ArrayList[numCourses];
        for(int i=0;i< numCourses;i++){
            gr[i]=new ArrayList<Edge>();
        }
        System.out.println(prerequisites.length);
        for(int i=0;i<prerequisites.length;i++){
            gr[i].add(new Edge(prerequisites[i][1],prerequisites[i][0]));
           // gr[i].add(prerequisites[1]);
        }
        boolean vis[]=new boolean[numCourses];
        boolean rec[]=new boolean[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            if(!vis[i]){
                boolean t=isCycleDetection(gr,i,vis,rec);
              //  System.out.println(t);
                if(t){
                    return false;
                  //  break;
                }
            }
      }
                   // return true;

                return true;
    }


    public static void main(String[] args) {
        int numCourses = 2;

        int[][] prerequisites = {{0,1}};

        System.out.println(canFinish(numCourses,prerequisites));
    }
}
