package br.com.splitranges;

import java.io.File;

public class Spliter {
	
	private Lists list;
	
	public Spliter() {
		//Contrutor da classe automaticamente cria uma instância da classe Lists
		Lists list = null;
		setLists(list);
	}
	
	public void splitRanges(String line) {
		
		String[] lines = line.split(";");
		
		for (int i=0; i < lines.length; i++) {
			lines[i] = lines[i].replace("\t", "");
			lines[i] = lines[i].trim();
		}
		
		if (!lines[2].equals(lines[3])) {
			
			//Adicionando cada parte da linha em uma lista específica
			list.addNeType(lines[0].trim());
			list.addSegment(lines[1].trim());
			list.addFirstRange(Long.parseLong(lines[2].trim()));
			list.addLastRange(Long.parseLong(lines[3].trim()));
		}
	}
	
	
	public Lists getLists() {
		return list;
	}

	public void setLists(Lists list) {
		list = new Lists();
		this.list = list;
	}
}
