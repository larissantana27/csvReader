package csvDemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class csvDemo {

	public static void main(String[] args) throws IOException
	{
        String csvFile = "//home//larissa//Desktop//csvFiles//Servidores.csv";
        BufferedReader csvContent = null;
        String line = "";
        String csvDivider = ",";

        String csvFile2 = "//home//larissa//Desktop//csvFiles//Frequência.csv";
        BufferedReader csvContent2 = null;
        String line2 = "";
        String csvDivider2 = ",";
       
        try
        {
    	    FileWriter file = new FileWriter("//home//larissa//Desktop//csvFiles//Resultados//resultados.txt");
            PrintWriter printer = new PrintWriter(file);
            
            csvContent = new BufferedReader(new FileReader(csvFile));
            csvContent.readLine();
         
//            line = csvContent.readLine();
//            String[] sectionOfLine = line.split(csvDivider);
//
//            String matriculation = sectionOfLine[0];
//            String employe = sectionOfLine[1];
//            String departament = sectionOfLine[2];
//            String manager = sectionOfLine[3];

            int differentDepartament = 1;

//            int lineInExcel = 1;
//            int employesQuantity = 329;
           
            String pastDepartament = "null";
            
            while((line = csvContent.readLine()) != null) 
            	//(lineInExcel <= employesQuantity)
            {
                String[] sectionOfLine = line.split(csvDivider);

                String matriculation = sectionOfLine[0];
                String employe = sectionOfLine[1];
                String departament = sectionOfLine[2];
                String manager = sectionOfLine[3]; 
                
                if (differentDepartament != 0)
                {
                    printer.printf(" -> %s", departament);
                    printer.printf("\n");
                    printer.printf("\t -> %s", manager);
                    printer.printf("\n\n");
                }

                printer.printf("%s - %s", matriculation, employe);
                printer.printf("\n");

                csvContent2 = new BufferedReader(new FileReader(csvFile2));    
                csvContent2.readLine();
                
//                line2 = csvContent2.readLine();
//                String[] sectionOfLine2 = line2.split(csvDivider2);
//                
//                String matriculation2 = sectionOfLine2[0];
                
                ArrayList<String> months = new ArrayList<String>();
                months.add("january"); months.add("february"); months.add("march"); months.add("april"); months.add("may"); months.add("june");
                months.add("july"); months.add("august"); months.add("september");months.add("october"); months.add("november"); months.add("december");

                int employeFound = 0;
                while ((line2= csvContent2.readLine()) != null || employeFound != 1)
                {
                	 String[] sectionOfLine2 = line2.split(csvDivider2);
                     String matriculation2 = sectionOfLine2[0];
                     
                   if (matriculation.equals(matriculation2))
                    {
                	   //System.out.println(matriculation + " " + employe); 

                        int i = 1;
                        for(String string : months)
                        {                            
                            if (sectionOfLine2[i+2].isEmpty())
                            {
                                printer.printf("\t %s", string);
                                printer.printf("\n");
                            }
                            i++;
                        }
                        employeFound = 1;
                    }
//                   else
//                   {
//                       line2 = csvContent2.readLine();
//                       sectionOfLine2 = line2.split(csvDivider2);
//                       matriculation2 = sectionOfLine2[0];
//                   }
                	
//                	System.out.println(matriculation + " " + employe); 
//                	System.out.println(matriculation2);
                }
//                if(employeFound == 0)
//                {
//                	System.out.println("not found in the second csv");
//                }
//                line = csvContent.readLine();
//                sectionOfLine = line.split(csvDivider);
                            
//                if (matriculation == sectionOfLine[0])
                	
                if (pastDepartament.equals(departament))
                {
                    differentDepartament = 0;
                    //System.out.println("well");
                    printer.printf("\n");
                }
                else
                {
                    differentDepartament = 1;
                    printer.printf("\n\n");
                }
                
//                matriculation = sectionOfLine[0];
//                employe = sectionOfLine[1];
//                departament = sectionOfLine[2];
//                manager = sectionOfLine[3];

                //lineInExcel++;
                pastDepartament = departament;
            }
            file.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("ARQUIVO NÃO ENCONTRADO: \n" + e.getMessage());
        }
	}
}
