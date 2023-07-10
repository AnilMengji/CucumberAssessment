package StepDefinitions;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import io.cucumber.java.en.Given;

public class DataComparison_Steps {
		
	@Given("I want to read the the data from CSV file an@Datatransformd generate the output file")
	public void i_want_to_read_the_the_data_from_csv_file_an_datatransformd_generate_the_output_file() throws IOException, CsvException {
	
	
	String InputFilepath1 =".//Data//Instrument_Details.csv";
    String InputFilepath2 =".//Data//Position_Details.csv";
    //create two empty string array for output file
    String reportFile_line1[] = new String[5];
    String reportFile_line2[] = new String[5];
    reportFile_line1[0] = "PR01";
    reportFile_line2[0] = "PR02";

    //Read all lines from input file1
    CSVReader reader_file1 = new CSVReader(new FileReader(InputFilepath1));
    List<String[]> allRows = reader_file1.readAll();
    int inputFileRowsCount=allRows.size();

    if(inputFileRowsCount!=0) {
        //read data from input file1 and write into output file
        int i = 0;
        //Read CSV line by line and use the string array as you want
        for (String[] row : allRows) {
            if (i == 1) {
                reportFile_line1[2] = row[2];
                reportFile_line1[4] = row[3];
            }
            if (i == 2) {
                reportFile_line2[2] = row[2];
                reportFile_line2[4] = row[3];
            }
            i++;
        }
    }

    CSVReader reader_file2 = new CSVReader(new FileReader(InputFilepath2));
    //Read all lines from input file2
    List<String[]> allRows_PositionTable = reader_file2.readAll();
    int allRows_PositionTableRowsCount=allRows_PositionTable.size();
    int count=0;

    if(allRows_PositionTableRowsCount!=0) {
        //read data from input file2 and write into output file
        for (String[] row : allRows_PositionTable) {
            if (count == 1) {
                reportFile_line1[1] = row[0];
                reportFile_line1[3] = row[2];
            }
            if (count == 2) {
                reportFile_line2[1] = row[0];
                reportFile_line2[3] = row[2];
            }
            count++;
        }
    }
    CSVWriter writer = new CSVWriter(new FileWriter(".//Data//PositionReport.csv"));
    //Writing data to a csv file
    String line1[] = {"ID", "PositionID", "ISIN", "Quantity", "Total Price(quantity*unit price)"};

    //Writing data to the csv file
    writer.writeNext(line1);
    String R1C3=reportFile_line1[3];
    String R1C4=reportFile_line1[4];

    int totalPriceRow1=Integer.parseInt(R1C3)*Integer.parseInt(R1C4);
    reportFile_line1[4]=String.valueOf(totalPriceRow1);


    String R2C3=reportFile_line2[3];
    String R2C4=reportFile_line2[4];

    int totalPriceRow2=Integer.parseInt(R2C3)*Integer.parseInt(R2C4);
    reportFile_line2[4]=String.valueOf(totalPriceRow2);

    writer.writeNext(reportFile_line1);
    writer.writeNext(reportFile_line2);

    //Flushing data from writer to file
    writer.flush();
}



	
	
	
	
	
	
	
	
}

	
	
	
	
	
	