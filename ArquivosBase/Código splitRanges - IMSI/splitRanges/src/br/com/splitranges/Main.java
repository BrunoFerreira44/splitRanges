package br.com.splitranges;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Main {
	
	private static Spliter spliter;

	public static void main(String[] args) throws IOException {
		
		String line = null;

		if (args.length == 2 ) {
			
			//Instancia a prórpia classe para chamar o método setSpliter()
			Main main = new Main();
			main.setSpliter();
			
			//Le o arquivo passado por parametro e armazena em br
			BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));
			
			//Cada linha do arquivo será passada para o método splitRanges()
			while ((line = br.readLine()) != null) {
				spliter.splitRanges(line);
			}
		}
		
		else {
			System.out.println
					("*************************************************************************\n"
					+"*** Insira um arquivo TXT como parâmetro e também o elemento de rede: ***\n"
					+"***                        (HLR / AuC / Hss)                          ***\n"
					+"*************************************************************************");
			
			System.exit(0);
		}
		
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String timeStamp = new SimpleDateFormat("ddMMyyyyHHmm").format(ts);
		
		File[] dirs = new File[] {
			new File("output/" + timeStamp),
			new File("output/" + timeStamp + "/Delete-" + args[1].toUpperCase()),
			new File("output/" + timeStamp + "/Create-" + args[1].toUpperCase()),
		};
		
		for (File d : dirs) {
			d.mkdirs();
			System.out.println("Diretório " + d.getPath() + " criado com sucesso!");
		}
		
		
		TxtCreator txtCreator = new TxtCreator(spliter);
		txtCreator.criaTxt(dirs[1].getAbsolutePath() + "/listDelete.txt", args[1]);
		txtCreator.criaTxt(dirs[2].getAbsolutePath() + "/listCreate.txt", args[1]);
	}
	
	
	public void setSpliter () {
		//Cria uma instância da classe Spliter somente se entrar no if do método main()
		Spliter spliter = new Spliter();
		this.spliter = spliter;
	}
	

}
