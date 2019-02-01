package pr.a06;

public class Queue {

	protected int[] array;
	protected int add;
	protected int take;
	
	public Queue() {
		array = new int[100];
		add = 0;
		take = 0;
		fillArrayWithEmty();
	}
	
	public Queue(int size) {
		array = new int[size];
		add = 0;
		take = 0;
		fillArrayWithEmty();
	}
	
	private void fillArrayWithEmty(){
		for(int i = 0; i < array.length; i++){
			array[i] = -1;
		}
	}
	
	public void enqueue(int value) {
		if (add == array.length) {
			add = 0;
		}
		if (array[add] != -1){
			//Baustelle, werfe Fehler
		}
		
		array[add] = value;
		add++;
	}
	
	public void add(int value){
		enqueue(value);
	}
	
	public int dequeue() {
		if (take == array.length) {
			take = 0;
		} 
		if (array[take] == -1) {
			//Baustelle, werfe Fehler
		}
		
		int temptake = array[take];
		array[take] = -1;
		take++;
		return temptake;
	}
	
	public int take() {
		return dequeue();
	}
	
	public boolean hasNext() {
		if(array[take] == -1){
			return false;
		}
		return true;
	}
}
