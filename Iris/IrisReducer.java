package Iris;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import java.io.IOException;


public class IrisReducer  extends Reducer <Text,Text,Text,Text> {
   String[] tempString;
   float tempSepalLength, tempSepalWidth, tempPetalLength, tempPetalWidth;
   float totalSepalLength, totalSepalWidth, totalPetalLength,  totalPetalWidth;
   float minSepalLength, maxSepalLength, meanSepalLength, minSepalWidth, maxSepalWidth, meanSepalWidth, minPetalLength, maxPetalLength, meanPetalLength, minPetalWidth, maxPetalWidth, meanPetalWidth;

   public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

       minSepalLength = minPetalLength = minSepalWidth = minPetalWidth = Float.MAX_VALUE;
       maxSepalLength = maxPetalLength = maxSepalWidth = maxPetalWidth = Float.MIN_VALUE;
      totalSepalLength=0; totalSepalWidth=0;totalPetalLength=0;  
      totalPetalWidth=0;
       int count = 0;

      for(Text value: values) {
         // TODO use String split() method to split value and assign to tempString
//System.out.println("valiues==>"+values.toString());         
 tempString=value.toString().split("_");
         // TODO convert tempString elements to temp sepal/petal length/width vars
System.out.println("---->>"+tempString[0]);          
tempSepalLength=Float.parseFloat(tempString[0]);
          tempSepalWidth=Float.parseFloat(tempString[1]);
          tempPetalLength=Float.parseFloat(tempString[2]);
          tempPetalWidth=Float.parseFloat(tempString[3]);
         // TODO determine if you have min/max sepal/petal length/widths and assign to min/max sepal/petal lenght/widths accordingly
          if(minSepalLength>=tempSepalLength){
            minSepalLength=tempSepalLength;
          }
          if(maxSepalLength<=tempSepalLength){
            maxSepalLength=tempSepalLength;
          }
          if(minSepalWidth>=tempSepalWidth){
            minSepalWidth=tempSepalWidth;
          }
          if(maxSepalWidth<=tempSepalWidth){
            maxSepalWidth=tempSepalWidth;
          }
          if(minPetalLength>=tempPetalLength){
            minPetalLength=tempPetalLength;
          }
          if(maxPetalLength<=tempPetalLength){
            maxPetalLength=tempPetalLength;
          }
          if(minPetalWidth>=tempPetalWidth){
            minPetalWidth=tempPetalWidth;
          }
          if(maxPetalWidth<=tempPetalWidth){
            maxPetalWidth=tempPetalWidth;
          }
         // TODO calculate running totals for sepal/petal length/widths for use in calculation of means
          totalSepalLength+=tempSepalLength;
          totalSepalWidth+=tempSepalWidth;
          totalPetalLength+=tempPetalLength;
          totalPetalWidth+=tempPetalWidth;
         // TODO increment counter for use in calculation of means
          count++;
      } 
     
      // TODO calculate mean sepal/petal length/width 
      meanSepalLength=totalSepalLength/(float)count;
      meanSepalWidth=totalSepalWidth/(float)count;
      meanPetalLength=totalPetalLength/(float)count;
      meanPetalWidth=totalPetalWidth/(float)count;
      // TODO generate string output per the requirement
      // minSepalLength\tmaxSepalLength\tmeanSepalLength\t ...
      String output="\t"+minSepalWidth+"\t"+maxSepalWidth+"\t"+meanSepalWidth+"\t"+minSepalLength+"\t"+maxSepalLength+"\t"+meanSepalLength+"\t"+minPetalWidth+"\t"+maxPetalWidth+"\t"+meanPetalWidth+"\t"+minPetalLength+"\t"+maxPetalLength+"\t"+meanPetalLength;

      // TODO emit output to context
      context.write(key, new Text(output));

   }
}
