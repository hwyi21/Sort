package sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {

	public QuickSort() {
		Random random = new Random();
		List list = new ArrayList();
		for (int i = 0; i < 10; i++) {
			list.add(random.nextInt(100));
		}
		System.out.println(qsort(list));

	}

	public List qsort(List data) {
		if (data.size() <= 1) {
			return data;
		}
		int pivot = (int) data.get(0);
		List left = new ArrayList();
		List right = new ArrayList();

		for (int i = 1; i < data.size(); i++) {
			if (pivot > (int) data.get(i)) {
				left.add(data.get(i));
			} else {
				right.add(data.get(i));
			}

		}
		List result = new ArrayList();
		result.add(pivot);
		return (List) Stream.of(qsort(left), result, qsort(right)).flatMap(Collection::stream)
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		new QuickSort();
	}

}