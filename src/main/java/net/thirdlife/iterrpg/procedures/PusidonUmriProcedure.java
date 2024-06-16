package net.thirdlife.iterrpg.procedures;

public class PusidonUmriProcedure {
	public static boolean execute(double x, double z) {
		if (Math.abs(x) >= 1000 && Math.abs(z) >= 1000) {
			return true;
		}
		return false;
	}
}
