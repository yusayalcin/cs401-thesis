private static void read(String success,String fail) throws IOException {
		PrintStream text = new PrintStream(new File("C:\\Users\\ahmet\\Desktop\\bitirme\\buffreader\\difference\\"+System.currentTimeMillis()+"Differences.txt"));
		System.setOut(text);
		BufferedReader reader1 = new BufferedReader(new FileReader(success));
		BufferedReader reader2 = new BufferedReader(new FileReader(fail));
		String line1 ;
        String line2 ;
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> text1 = new ArrayList<String>();
		ArrayList<String> text2 = new ArrayList<String>();
		while ((line1 = reader1.readLine()) != null) {
			text1.add(line1);
		}
		while ((line2 = reader2.readLine()) != null) {
			text2.add(line2);
		}
		if(text2.size() > text1.size()) {
			for(int i = 0; i<text1.size(); i++) {
				if(!text1.get(i).equals(text2.get(i))) {
					result.add(text2.get(i));
				}
			}
			for(int j = text1.size(); j < text2.size(); j++) {
				result.add(text2.get(j));
			}
			
		}
		else {
			for(int i = 0; i<text1.size(); i++) {
				if(!text1.get(i).equals(text2.get(i))) {
					result.add(text2.get(i));
				}
			}	
		}
		
        	
		/*ArrayList<String> lines = new ArrayList<String>();
		while ((line = reader1.readLine()) != null) {
			lines.add(line);
		}
		String[] result = new String[lines.size()];
		for(int i=0; i<lines.size(); i++) {
			result[i] = lines.get(i);
		}
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		return result;
	}*/	
        for(int i = 0; i < result.size(); i++) {
        	System.out.println(result.get(i));
        
        }
    }
}
