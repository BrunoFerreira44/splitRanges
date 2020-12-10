package br.com.splitranges;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Lists {
	
	private static List neType;
	private static List segment;
	private static List<Long> firstRange;
	private static List<Long> lastRange;

	public Lists() {
		neType = new LinkedList<>();
		segment = new LinkedList<>();
		firstRange = new LinkedList<>();
		lastRange = new LinkedList<>();
	}
	
	

	public static List getNeType() {
		return neType;
	}
	
	public static List getSegment() {
		return segment;
	}

	public static List getFirstRange() {
		return firstRange;
	}
	
	public static List getLastRange() {
		return lastRange;
	}
	
	
	
	
	public static void addNeType(String str) {
		neType.add(str);
	}
	
	public static void addSegment(String str) {
		segment.add(str);
	}
	
	public static void addFirstRange(Long num) {
		firstRange.add(num);
	}
	
	public static void addLastRange(Long num) {
		lastRange.add(num);
	}
	
}
