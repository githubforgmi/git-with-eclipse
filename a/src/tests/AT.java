package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class AT {
	//second changes
	//thired change
	Random r= new Random();
  @Test
  public void f() {
	  
	  int count=0;
	  int l=0;
	  List<Integer> list=new ArrayList<Integer>();
	  for(int i=0;count<10-1;i++){
		  
		int k=  r.nextInt(10);
		if(list.contains(k)){
			System.out.println("duplicate:"+"count="+count+";"+" i="+i+";"+"k="+k);
			continue;
		}
		else{
		// l=k;
		 list.add(k);
		 count++;
		 System.out.println("count="+count+";"+" i="+i+";"+"k="+k);
		 
		 //need to perform which action u want 
		 
		}
		//if(count==95)
			//break;
	  }
  }  
  }

