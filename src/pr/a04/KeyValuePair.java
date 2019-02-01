package pr.a04;

final class KeyValuePair {

	protected Object key;
	protected Object value;
	
	//Vollständiger-Konstruktor
	protected KeyValuePair(Object k, Object v) {
		key = k;
		value = v;
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	protected Object getKey() {
		return key;
	}
	
	/**
	 * 
	 *
	 * @return
	 */
	protected Object getValue() {
		return value;
	}
	
	/**
	 * 
	 * 
	 * @param v
	 */
	protected void changeValue(Object v) {
		value = v;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toString() {
		return value.toString();
	}
}
