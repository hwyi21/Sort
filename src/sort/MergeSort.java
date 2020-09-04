package sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	
	public MergeSort() {
		List data = new ArrayList();
		data.add(3);
		data.add(5);
		data.add(1);
		data.add(4);
		data.add(2);
		mergeSplit(data);
		System.out.println(mergeSplit(data));
		
		
	}
	
	public List split(List data) {
		int medium = (int) data.size()/2;
		List left = data.subList(0, medium);
		List right = data.subList(medium, data.size());
		System.out.println(left);
		System.out.println(right);
		return data;
	}

	
	public List mergeSplit(List data) {
		if(data.size()<=1) {
			return data;
		}
		int medium = (int) data.size()/2;
		List left = mergeSplit(data.subList(0, medium));
		List right = mergeSplit(data.subList(medium, data.size()));
		
		return merge(left, right);
	}
	
	public List merge(List left, List right) {
		List merged = new ArrayList();
		int left_point = 0;
		int right_point = 0;
		
		//case1: left / right 가 아직 남아있을 때
		while(left.size()>left_point&&right.size()>right_point) {
			if ((int)left.get(left_point)>(int)right.get(right_point)) {
				merged.add(right.get(right_point));
				right_point +=1;
			}else {
				merged.add(left.get(left_point));
				left_point += 1;
			}
		}
		//case2: left만 남아있을 때
		while(left.size()>left_point) {
			merged.add(left.get(left_point));
			left_point += 1;
		}
		//case3: right만 남아있을 때
		while(right.size()>right_point) {
			merged.add(right.get(right_point));
			right_point +=1;
		}
		return merged;
	}
	public static void main(String[] args) {
		new MergeSort();
	}

}