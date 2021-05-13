package Lecture18;

public class backTracking_queenPerm {
	static int count = 0;

	public static void main(String[] args) {
		QueenPermutation(new boolean[4], 0, 2, "");
		System.out.println("-----------------");
		QueenCombination(new boolean[4], 0, 2, "", -1);// -1 VERY IMP!!!!
		// -1 as lastBoxUsed+1 =0
	}

	// qpsf-queens placed so far
	// tq=total queens
	public static void QueenPermutation(boolean[] boxes, int qpsf, int tq, String ans) {
		if (qpsf == tq) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}

		for (int i = 0; i < boxes.length; i++) {
			// qpsf=0
			// if (boxes[i] == false) {// check whether a queen is already sitting in that
			// box or not
			boxes[i] = true;// q0 at its right place
			// qpsf=1
			QueenPermutation(boxes, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ");
			boxes[i] = false;// undo your changes->BACKTRACING

			// }
			// if statement here becomes non mandatory since loop always runs from next box
		}
	}

	static int count1 = 0;

	public static void QueenCombination(boolean[] boxes, int qpsf, int tq, String ans, int lastBoxUsed) {
		if (qpsf == tq) {
			count1++;
			System.out.println(count1 + ". " + ans);
			return;
		}

		for (int i = lastBoxUsed + 1; i < boxes.length; i++) {
			// qpsf=0
			if (boxes[i] == false) {// check whether a queen is already sitting in that box or not
				boxes[i] = true;// q0 at its right place
				// qpsf=1
				QueenCombination(boxes, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ", i);
				boxes[i] = false;// undo your changes->BACKTRACING

			}
		}
	}
}
