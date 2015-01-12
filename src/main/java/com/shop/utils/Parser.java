package com.shop.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {
	public static List<String> tokenize(String searchString) {
		List<String> tags = new ArrayList<String>();
		StringTokenizer tokenizerComma = new StringTokenizer(searchString, ",");
		while (tokenizerComma.hasMoreTokens()) {
			String tag = tokenizerComma.nextToken();
			StringTokenizer tokenizerSpace = new StringTokenizer(tag, " ");
			while (tokenizerSpace.hasMoreTokens()) {
				tags.add(tokenizerSpace.nextToken());
			}
		}
		return tags;
	}

}
