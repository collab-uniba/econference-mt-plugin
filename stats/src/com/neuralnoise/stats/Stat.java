package com.neuralnoise.stats;

import java.util.*;

import org.rosuda.JRI.*;

class Stat implements RMainLoopCallbacks {

	public static String doublesToString(List<Double> a) {
		StringBuffer ret = new StringBuffer();
		boolean first = true;
		for (Double d : a) {
			if (!first) {
				ret.append(", ");
			}
			ret.append(d);
			first = false;
		}
		return ret.toString();
	}

	private static Double tTest(Rengine re, List<Double> a, List<Double> b, String type, boolean paired) {
		Double ret = new Double(-1);

		REXP x = re.eval("t.test(c(" + doublesToString(a) + "), c("
				+ doublesToString(b) + "), paired=" + (paired ? "TRUE" : "FALSE") + ", alternative=\"" + type
				+ "\")");
		
		RVector v = x.asVector();
		REXP pexp = (REXP) v.get(2);

		ret = new Double(pexp.asDouble());

		return ret;
	}

	public static Double pairedTTestLess(Rengine re, List<Double> a, List<Double> b) {
		return tTest(re, a, b, "less", true);
	}

	public static Double pairedTTestGreater(Rengine re, List<Double> a, List<Double> b) {
		return tTest(re, a, b, "greater", true);
	}

	public static Double unpairedTTestLess(Rengine re, List<Double> a, List<Double> b) {
		return tTest(re, a, b, "less", false);
	}

	public static Double unpairedTTestGreater(Rengine re, List<Double> a, List<Double> b) {
		return tTest(re, a, b, "greater", false);
	}
	
	public void rWriteConsole(Rengine re, String text, int oType) {
		System.out.print(text);
	}

	public void rBusy(Rengine re, int which) {
		System.out.println("rBusy(" + which + ")");
	}

	public String rReadConsole(Rengine re, String prompt, int addToHistory) {
		return prompt;
	}

	public void rShowMessage(Rengine re, String message) {
		System.out.println("rShowMessage \"" + message + "\"");
	}

	public String rChooseFile(Rengine re, int newFile) {
		return null;
	}

	public void rFlushConsole(Rengine re) { }

	public void rLoadHistory(Rengine re, String filename) { }

	public void rSaveHistory(Rengine re, String filename) { }
}
