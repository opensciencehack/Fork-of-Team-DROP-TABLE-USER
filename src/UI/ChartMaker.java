package UI;
import java.util.ArrayList;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.SwingWrapper;

public class ChartMaker {

    public void showCategoryChart(String title, String xTitle, String yTitle, ArrayList<Integer> x, ArrayList<Integer> y) {
        CategoryChart colChart = new CategoryChart(1024, 600);
		colChart.setXAxisTitle(xTitle);
		colChart.setYAxisTitle(yTitle);		
		
		colChart.addSeries(title, x, y);
		new SwingWrapper<CategoryChart>(colChart).displayChart();
    }

    public ArrayList<Integer> makeRange(int start, int length) {
    	ArrayList<Integer> al = new ArrayList<>();
    	for(int i = start; i < start + length; i ++) {
   	    	al.add(i);
      	}
    	
    	return al;
    }
}