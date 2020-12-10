package br.com.splitranges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TxtCreator {
	
	private Spliter spliter;
	
	public TxtCreator(Spliter spliter) {
		this.spliter = spliter;
	}
	
	
	public void criaTxt(String file, String type) {
		
		if (file.contains("Delete")) {
			
			try {
				FileWriter fw = new FileWriter(file);
				PrintWriter pw = new PrintWriter(fw);
				
				int cnt = 1;
				
				for (int i=0; i < spliter.getLists().getFirstRange().size(); i++) {
					pw.print(cnt + "\t");
					pw.print(spliter.getLists().getFirstRange().get(i) + "\t");
					pw.print(spliter.getLists().getLastRange().get(i) + "\t");
					pw.println(spliter.getLists().getNeType().get(i));
					cnt++;
				}
				
				pw.close();
				System.out.println("Arquivo de Delete disponível em: " + file);
			}
			
			catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		else {
			
			try {
				FileWriter fw = new FileWriter(file);
				PrintWriter pw = new PrintWriter(fw);
				
				pw.println("Pesquisar IMSI\tHLR\tAuC\tHss\tLookup");
				int cnt = 1;
				String tabs = "";
				
				if (type.equalsIgnoreCase("HLR")) {
					tabs = "\t";
				} else if (type.equalsIgnoreCase("AUC")) {
					tabs = "\t\t";
				} else if (type.equalsIgnoreCase("HSS")) {
					tabs = "\t\t\t";
				} else {
					System.out.println
					("*************************************************************************\n"
					+"***       O Elemento de Rede deve ser uma das opções abaixo:          ***\n"
					+"***                        (HLR / AuC / Hss)                          ***\n"
					+"*************************************************************************");
					System.exit(0);
				}
				
				for (int i=0; i < spliter.getLists().getFirstRange().size(); i++) {
					
					long numOfBrokenRanges = (long) spliter.getLists().getLastRange().get(i) - (long) spliter.getLists().getFirstRange().get(i);
					long x = 0;
					
//					if (numOfBrokenRanges > 1000) {
//						continue;
//					}
					
					do {
						pw.print(cnt + "\t");
						pw.print(((long) spliter.getLists().getFirstRange().get(i) + x) + tabs);
						pw.println(spliter.getLists().getNeType().get(i) + "\t\tRealizar Filtro");
						
						x++;
						cnt++;
					}
					while (x <= numOfBrokenRanges);
				}
				
				pw.close();
				System.out.println("Arquivo de Create disponível em: " + file);
				
			}
			catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

}
