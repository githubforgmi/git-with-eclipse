package tests;

public class split {

	//c1 c2 c3 c4
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="sdfg$@SDFG$x@cv$c@XCVB";
		String[] s1=s.split("\\@");
		System.out.println(s1.length);

	}

}
