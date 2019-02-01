package pr.a06;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import pr.ripp.Edge;
import pr.ripp.Graph;
import pr.ripp.GraphLesen;
import pr.ripp.Vertex;

public class Breitensuche_final {
	
	/**
	 * Standard Konstrucktor
	 */
	public Breitensuche_final() {
	}

	/**
	 * Erstellt eine Hashmap mit dem Ergebnis der breitensuche bei dem übgebenen Graphen in Form einer Text Datei.
	 * @param dat Text Datei die Graphen beinhaltet.
	 * @param gerichtet Bestimmt ob der Graph als gerichteter Graph oder ungerichteter Graphe gelsen wird.
	 * @param start Der Startknoten für die Breitensuche.
	 * @return HashMap mit dem Ergebnis der Breitensuche, der Schlüssel ist der Integer 
	 * Wert des Knoten und verweißt auf die Kante die bei VertexA den Vorgänger Knoten, 
	 * bei VertexB den Zielknoten, und bei gewicht das Gewicht beinhaltet
	 */
	public HashMap<Integer, Edge<Vertex>> breitensuche(String dat, boolean gerichtet, int start){
		Graph<Vertex, Edge<Vertex>> quelle = GraphLesen.FileToGraph(dat, gerichtet);
		return breitensuche(quelle, start);
	}
	
	/**
	 * Erstellt eine Hashmap mit dem Ergebnis der breitensuche bei dem übgebenen Graphen.
	 * @param Graph für den die Breitensuche ausgeführt werden soll.
	 * @param gerichtet Bestimmt ob der Graph als gerichteter Graph oder ungerichteter Graphe gelsen wird.
	 * @param start Der Startknoten für die Breitensuche.
	 * @return HashMap mit dem Ergebnis der Breitensuche, der Schlüssel ist der Integer 
	 * Wert des Knoten und verweißt auf die Kante die bei VertexA den Vorgänger Knoten, 
	 * bei VertexB den Zielknoten, und bei gewicht das Gewicht beinhaltet
	 */
	public HashMap<Integer, Edge<Vertex>> breitensuche(Graph<Vertex, Edge<Vertex>> graph, int start){
		HashMap<Integer, Edge<Vertex>> hm = new HashMap<>();
		Queue queue = new Queue();
		
		//Die HashMap legend bekommt den Knoten(Integer Wert) als Schluessel.
		//Value 0 besagt: Knoten wurde noch nicht besucht.
		//Value 1 besagt: Knoten wurde bereits besucht.
		HashMap<Integer, Integer> legend = new HashMap<>();
		
		//Alle Knoten vom übgebendem Graphen werden abgefragt und in die HashMap mit
		//ihren Knoten(Integer Wert) als Schlüssel gespeichert und mit einer neuen Kante
		//mit VertexA: null(pred), VertexB: Knoten selbst, Gewicht: Interger.MAX gespeichert
		//(außer der übgebene Startknoten dieser bekommt Gewicht 0).
		for(Vertex v: graph.getVertices()) {
			if(v.getId() == start){
				hm.put(v.getId(), new Edge<Vertex>(null, v, 0));
				legend.put(v.getId(), 0);
				continue;
			}
			
			hm.put(v.getId(), new Edge<Vertex>(null, v, Integer.MAX_VALUE));
			legend.put(v.getId(), 0);
		}
		
		queue.add(start);
		//Die while Schleife wird solange ausgeführt wie Nachbarn gefunden werden die noch
		//nicht besucht wurden.
		while(queue.hasNext()) {
			int pointer = queue.take();
			
			//Wenn Knoten bereits besucht fahre fort.
			if(legend.get(pointer) == 1) {
				continue;
			}
			//Trage Knoten als besucht ein.
			legend.put(pointer, 1);
			
			//Alle Nachbarn vom Knoten in der Queue werden abgefragt, sie werden
			//in die Queue eingetragen und es wird geprüft ob ihr Gewicht kleiner ist
			//als der bereits vorhandene Wert in der HashMap, wenn dies zutrifft werden
			//die Werte überschreiben.
			Collection<Edge<Vertex>> edgeN = graph.getIncidentEdges(pointer);
			for(Edge<Vertex> e: edgeN) {
				queue.add(e.getVertexB().getId());
				int weight = hm.get(pointer).getWeight() + 1;
				
				if(weight < hm.get(e.getVertexB().getId()).getWeight()) {
					hm.put(e.getVertexB().getId(), new Edge<Vertex>(new Vertex(pointer), e.getVertexB(), weight));
				}
			}
		}
		return hm;
	}
	
	/**
	 * Formatierte Ausgabe für eine Hashmap die mit breitensuche() erstellt worden ist.
	 * @param hm Erzeugte HashMap der breitensuche()
	 */
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