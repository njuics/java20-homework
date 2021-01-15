public class GrandPa extends Characters {
	GrandPa() {
		this.id = 0;
		this.name = "үү";
	}
	
	public void sort(Characters[] calBros) {
		Sort sortObject = new Sort();
		sortObject.bubbleSort(calBros);
	}
}