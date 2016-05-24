package domini;

import java.util.Comparator;

public class CompararArrays implements Comparator<Pair<Integer,String>> {
	@Override
	public int compare(Pair<Integer, String> arg0, Pair<Integer, String> arg1) {
		int ret = arg0.second.compareTo(arg1.second);
		return ret;
	}
}
