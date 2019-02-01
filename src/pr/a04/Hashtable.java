package pr.a04;

import java.util.LinkedList;

public class Hashtable implements Map<Object, Object> {

	/* LinkedList mit eigenem
	 * KeyValuePair-Objekt als Typ-Parameter
	 */
	public LinkedList<KeyValuePair>[] array;

	/* Standard-Konstruktor
	 * mit Übergabe der Größe der LinkedList als Integer-Wert
	 */
	public Hashtable(int size) {
		array = new LinkedList[size];
	}	

	/**
	 * Methode zur Bestimmung ob Stelle am Index in der LinkedList leer ist
	 * 
	 * 
	 * @param 	index, Index in der LinkedList
	 * 			der übergeben und überprüft wird
	 * @return 	true, wenn Stelle am Index leer
	 * @return 	false, wenn Stelle am Index belegt 
	 */
	private boolean isEmpty(int index) {
		if(array[index] == null){
			return true;
		}
		return false;
	}

	/**
	 * Funktion, der der Schlüssel übergeben wird
	 * um den Index mithilfe der Divisionsrestmethode (k modulo m) zu bestimmen
	 * 
	 * @param 	key, Schlüssel-Objekt
	 * @return 	int-Wert, als berechneter Index für den am Schlüssel gebundenen Wert
	 */
	private int hashFunction(Object key) {
		return key.hashCode() % array.length;
	}

	/**
	 * Fügt ein Schlüssel-Wert-Paar in die LinkedList ein
	 * - erstellt KeyValuePair-Objekt und übergibt 'key' & 'value'
	 * - berechnet mit Divisionsrestmethode Index für den Schlüssel
	 * - 
	 * 
	 * @param	key, Schlüssel
	 * @param	value, an Schlüssel gebundener Wert
	 * @return 
	 * @return 
	 * @return 
	 */
	public Object put(Object key, Object value) {
		KeyValuePair kvp = new KeyValuePair(key, value);
		int index = hashFunction(key);
		if (isEmpty(index)) {
			array[index] = new LinkedList<>();
			array[index].add(kvp);
			return null;
		}			

		for (int i = 0; i < array[index].size(); i++) {
			if (key.equals(array[index].get(i).getKey())) {
				Object oldValue = array[index].get(i).getValue();
				array[index].get(i).changeValue(value);
				return oldValue;
			}
		}
		array[index].add(kvp);
		return null;
	}

	/**
	 * 
	 * 
	 * @param
	 * @return
	 * @return
	 * @return
	 */
	public Object get(Object key) {
		int index = hashFunction(key);
		if (isEmpty(index)) {
			return null;
		}
		
		for (int i = 0; i < array[index].size(); i++) {
			if (key.equals(array[index].get(i).key)) {
				return array[index].get(i).value;
			}
		}
		return null;
	}

	/**
	 * 
	 * 
	 * @param 
	 * @return 
	 * @return 
	 * @return
	 */
	public Object remove(Object key) {
		int index = hashFunction(key);
		try {
			for (int i = 0; i < array[index].size(); i++) {
				if (key.equals(array[index].get(i).key)) {
					Object temp = array[index].get(i).value;
					array[index].remove(i);
					return temp;
				}
			}
		} catch (java.lang.ArrayIndexOutOfBoundsException exc) {
			return null;
		}
		return null;
	}
}