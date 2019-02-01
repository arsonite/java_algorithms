package pr.a06;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import pr.ripp.Edge;
import pr.ripp.Graph;
import pr.ripp.GraphLesen;
import pr.ripp.Vertex;

public class Breitensuche {
	public Breitensuche() {
	}
	
	public HashMap<Integer, Edge<Vertex>> breitensuche(String dat, boolean gerichtet, int start){
		Graph<Vertex, Edge<Vertex>> quelle = GraphLesen.FileToGraph(dat, gerichtet);
		return breitensuche(quelle, start);
	}
	
	public HashMap<Integer, Edge<Vertex>> breitensuche(Graph<Vertex, Edge<Vertex>> graph, int start){
		HashMap<Integer, Edge<Vertex>> hm = new HashMap<>();
		Queue queue = new Queue();
		HashMap<Integer, Integer> legend = new HashMap<>();
		
		for(Vertex v: graph.getVertices()){
			if(v.getId() == start){
				hm.put(v.getId(), new Edge<Vertex>(null, v, 0));
				legend.put(v.getId(), 0);
				continue;
			}
			
			hm.put(v.getId(), new Edge<Vertex>(null, v, Integer.MAX_VALUE));
			legend.put(v.getId(), 0);
		}
		
		queue.add(start);
		while(queue.hasNext()) {
			int pointer = queue.take();
			
			if(legend.get(pointer) == 1) {
				continue;
			}
			legend.put(pointer, 1);

			Collection<Edge<Vertex>> edgeN = graph.getIncidentEdges(pointer);
			for(Edge<Vertex> e: edgeN) {
				queue.add(e.getVertexB().getId());
				int weight = hm.get(pointer).getWeight() + 1;
				
				if(weight < hm.get(e.getVertexB().getId()).getWeight()) {
					hm.put(e.getVertexB().getId(),
						new Edge<Vertex>(new Vertex(pointer), e.getVertexB(), weight));
				}
			}
		}
		return hm;
	}
	
	public void print(HashMap<Integer, Edge<Vertex>> hm){
		for(Entry<Integer, Edge<Vertex>> e: hm.entrySet()){
			Edge<Vertex> q = e.getValue();
			if(q.getWeight() == Integer.MAX_VALUE){
				System.out.printf("pred: %4s vertex: %2s dist: INFINITE%n", 
						q.getVertexA(), 
						q.getVertexB());
			} else {
				System.out.printf("pred: %4s vertex: %2s dist: %d%n", 
						q.getVertexA(), 
						q.getVertexB(), 
						q.getWeight());
			}
		}
	}
}