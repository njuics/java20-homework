import character.*;
import sort.*;

public class Main {
	public static GrandPa grandpa = new GrandPa("爷爷");
	public static void main(String[] args) {
		Sort show = new HuluwaSort();
		Huluwa Hulu_Queues[] = new Huluwa[HuluwaSort.Huluwa_NUM];
		show.DisorganizeLine(Hulu_Queues);
		show.orchestration_sort(grandpa, Hulu_Queues);
		System.out.println();
		show.DisorganizeLine(Hulu_Queues);
		show.choreography_sort(grandpa, Hulu_Queues);
	}
}
