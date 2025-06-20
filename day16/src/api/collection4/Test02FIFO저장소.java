package api.collection4;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Test02FIFO저장소 {
	public static void main(String[] args) {
		//FIFO (First In First Out)
		//: 먼저 들어온 데이터가 먼저 나가는 구조
		//: Queue 라는 구조로 처리
		
//		Queue<String> queue = new ArrayBlockingQueue<>(10);
		Queue<String> queue = new PriorityBlockingQueue<>(10); //우선순위와 관계없이 
		
		//추가
		queue.offer("카카오");
		queue.offer("구글");
		queue.offer("네이버");
		
		System.out.println("가장 처음에 들어온 데이터 = " + queue.peek());
		queue.poll(); //맨 앞의 데이터를 추출(제거)
		System.out.println("가장 처음에 들어온 데이터 = " + queue.peek());
		queue.poll(); //맨 앞의 데이터를 추출(제거)
		System.out.println("가장 처음에 들어온 데이터 = " + queue.peek());
		queue.poll(); //맨 앞의 데이터를 추출(제거)
		System.out.println("가장 처음에 들어온 데이터 = " + queue.peek());
		queue.poll(); //맨 앞의 데이터를 추출(제거)
	}
}
