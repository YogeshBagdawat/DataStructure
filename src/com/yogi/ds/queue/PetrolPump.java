package com.yogi.ds.queue;

import java.util.Currency;
import java.util.LinkedList;
import java.util.Queue;

public class PetrolPump {

	int petrol = 0;
	int distance = 0;

	public PetrolPump(int petrol, int distance) {
		this.petrol = petrol;
		this.distance = distance;
	}

	public static int calculateFirstPoint(PetrolPump[] petrolpump) {
		int n = petrolpump.length;

		Queue<Integer> q = new LinkedList<>();
		int start = -1;
		int end = 1;

		/*
		 * while (start != end || curr_petrol < 0) { while (curr_petrol < 0 &&
		 * start != end) { curr_petrol -= petrolpump[start].petrol -
		 * petrolpump[start].distance; start = (start + 1) % n; if(start == 0){
		 * return -1; } } curr_petrol += petrolpump[end].petrol -
		 * petrolpump[end].distance; end = (end + 1) % n; }
		 */
		q.add(start++);
		int curr_petrol = petrolpump[start].petrol - petrolpump[start].distance;
		while (q.peek() != start || curr_petrol < 0) {
			while (!q.isEmpty() && curr_petrol < 0) {
				q.clear();
				start = (start + 1) % n;
				curr_petrol = petrolpump[start].petrol - petrolpump[start].distance;
				q.add(start);
			}
			start = (start + 1) % n;
			q.add(start);
			curr_petrol += petrolpump[start].petrol - petrolpump[start].distance;

		}
		return q.poll();
	}

	public static void main(String[] args) {

		// PetrolPump[] arr = { new PetrolPump(4, 6), new PetrolPump(6, 5), new
		// PetrolPump(7, 3), new PetrolPump(4, 5) };
		PetrolPump[] arr = { new PetrolPump(4, 6), new PetrolPump(6, 5), new PetrolPump(7, 3), new PetrolPump(4, 5) };
		// PetrolPump[] arr = { new PetrolPump(6, 4), new PetrolPump(3, 6), new
		// PetrolPump(7, 3) };
		int start = calculateFirstPoint(arr);

		System.out.println(start == -1 ? "No Solution" : "Start = " + start);
	}

}
