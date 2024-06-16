package net.thirdlife.iterrpg.procedures;

public class SorrowSpireConditionProcedure {
	public static boolean execute(double y) {
		boolean check = false;
		if (y <= 70 && y >= 34) {
			return true;
		}
		return false;
	}
}
