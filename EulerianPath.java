

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
Implementation of code that finds whether given graph is Eulerian or not
@author G25
 */


public class EulerianPath {
	

	
	/**
	 * Function that returns the degree of each vertex 
	 * 
	 * @param v
	 *            : Vertex for which the degree is calculated
	 * @return degree of the given vertex
	 */
	public static int CalculateDegree(Vertex v){
		int degree = 0;
		System.out.println("The vertices w adjacent to vertex " + v + " are " + v.Adj);
		degree = v.Adj.size();
		return degree;
	}
	
	/**
	 * Function that returns the count of vertex
	 * @param vl
	 *            : list of vertex
	 * @return the count of the vertex
	 */
	
	
	
	public static int OddDegreeVertexCount(List<Vertex> vl) {
		int count = 0;
		int degreeofvertex;
		
		Iterator<Vertex> vi = vl.listIterator();
		
		while (vi.hasNext()){
			Vertex v = vi.next();
			degreeofvertex = CalculateDegree(v);
		
			if (degreeofvertex == 0) {
				System.out.println("The Graph is not connected with vertex " +v);
				count = -1;
				break;
			}
			
			if (degreeofvertex % 2 != 0){
				count++;
			}
		}
		
		if (count != -1)
		System.out.println("The number of vertices with odd degree is " + count);
		
		return count;	
		
	}
	
	/**
	 * Procedure that checks if the given graph is Eulerian 
	 * 
	 * @param g
	 *            : input Graph for which Euler path has to be validated
	 * Output is a message that prints if the graph is eulerian or not.
	 */
	
	public static void FindEulerian(Graph g) { 
		int count_OddDegree=0;	
		List<Vertex> vertices = new ArrayList<>(g.verts);
		vertices.remove(0);
		System.out.println("The vertices of the graph are " +vertices);
		count_OddDegree = OddDegreeVertexCount(vertices);
		Vertex FirstVertex = vertices.get(0);
		Vertex LastVertex = vertices.get(vertices.size()-1);
		if (count_OddDegree == 0){
			System.out.println("The graph is Eulerian");
		}
		else if (count_OddDegree == 2){
			System.out.println("The graph has an Eulerian Path between " + FirstVertex + " to " + LastVertex);
		}
		else if (count_OddDegree == -1){
			System.out.println("The graph is not connected");
		}
		else {
			System.out.println("The graph is not Eulierian, it has " + count_OddDegree + " vertices of odd degrees ");
		}
	}
	
	
	

}
