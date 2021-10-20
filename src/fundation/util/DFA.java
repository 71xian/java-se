package fundation.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DFA {

	private Map innerWordMap;

	public void initWordMap(Collection<String> collection) {
		if (collection.isEmpty()) {
			return;
		}
		innerWordMap = new HashMap<>(collection.size());
		collection.forEach(key -> {
			if (key.isEmpty()) {
				return;
			}
			char[] chs = key.toCharArray();
			final int size = chs.length;
			Map currentMap = innerWordMap;
			for (int i = 0; i < size; i++) {
				char ch = chs[i];
				Object wordMap = currentMap.get(ch);
				if (wordMap != null) {
					currentMap = (Map) wordMap;
				} else {
					Map<String, Boolean> newWOrdMap = new HashMap<>();
					newWOrdMap.put("isEnd", false);
					currentMap.put(ch, newWOrdMap);
					currentMap = newWOrdMap;
				}
				if (i == size - 1) {
					currentMap.put("isEnd", true);
				}
			}
		});
	}
}
