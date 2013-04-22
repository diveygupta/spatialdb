/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package pop;

/**
 *
 * @author DIVEY
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.*;
/**
 *
 * @author DIVEY
 */
public class populate {
    
    
    
 public int[] apX;
 public int[] apY;
 public int[] apR;
 
 public int[] peopleX;
 public int[] peopleY;
 

 
 public int peoplec=0;
 public int apc=0;
 public int buildingc=0;
 public Building[] b=new Building[50];
 
 public Connection mainConnection = null;
   public Statement mainStatement = null;
   public PreparedStatement SecondStatement = null;
  public  ResultSet mainResultSet = null;
	public int fromx=0,fromy=0;
   public static void main(String[] args) {
    
   //     System.out.println("hi");
    populate file=new populate();
   file.ConnectToDB();
     file.DeleteData();
  //   System.out.println("sdsd");
       // System.out.println("**"+args[0]+"**"+args[1]+"**"+args[2]);
//     
     
      file.building(args[0]);
    file.people(args[1]);
    file.ap(args[2]);
//    
//    
//      file.ap("C:\\Users\\DIVEY\\Desktop\\1st sem\\db\\hw2\\ap.xy");
//           
//           file.people("C:\\Users\\DIVEY\\Desktop\\1st sem\\db\\hw2\\people.xy");
//            file.building("C:\\Users\\DIVEY\\Desktop\\1st sem\\db\\hw2\\building.xy");
    }
  
 public void populate(){
     
 }
    public void ap(String f) {
    
      apX =new int[20];
      apY =new int[20];
      apR =new int[20];
         try{
  // Open the file that is the first 
  // command line parameter
            // System.out.println(f);
  FileInputStream fstream = new FileInputStream(f);
            try (DataInputStream in = new DataInputStream(fstream)) {
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String strLine;
                //Read File Line By Line
                while ((strLine = br.readLine()) != null)   {
                // Print the content on the console
               // System.out.println (strLine);
                    String tokens[]=strLine.split(", ");
                   //  System.out.println (strLine);
                    //  System.out.println ("+"+tokens[1]+"+");
                    //  System.out.println (tokens[2]);
                    //  System.out.println (tokens[3]);
                      
                      //String g=toke
                   
                     
                    
                  //  System.out.println (apX[c]);
                 //   System.out.println (apY[c]);
                  //  System.out.println (apR[c]);
                    int x1,y1,x2,y2,x3,y3;
                    x1 = Integer.parseInt(tokens[1]) - Integer.parseInt(tokens[3]);
                    apX[apc]=Integer.parseInt(tokens[1]);
				   y1 = Integer.parseInt(tokens[2]);
                    x2 = Integer.parseInt(tokens[1]) + Integer.parseInt(tokens[3]);
                    apY[apc]=Integer.parseInt(tokens[2]);
					y2 = Integer.parseInt(tokens[2]);
                    x3 = Integer.parseInt(tokens[1]);
                    apR[apc]=Integer.parseInt(tokens[3]);
					y3 = Integer.parseInt(tokens[2]) - Integer.parseInt(tokens[3]);
                    fromx=x3;
                     String temp = x1+","+y1+","+x2+","+y2+","+x3+","+y3;
                    fromy=y3;
					String str = "INSERT INTO accesspoint VALUES ('"+tokens[0]+"',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE("+tokens[1]+","+tokens[2]+", NULL),NULL,NULL),"+tokens[3]+",SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,4),MDSYS.SDO_ORDINATE_ARRAY("+temp+")))";
                    //System.out.println(insertString); //printing query on console
                     mainStatement=mainConnection.createStatement();
                    mainStatement.executeUpdate(str);
                    
                    
                  apc++;  
                   
                }
            }
             System.out.println("Data inserted in accesspoint");
    }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
       
    }
     public void building(String f) {
      // System.out.println(f);
         try{
  // Open the file that is the first 
  // command line parameter
            // System.out.println(f);
  FileInputStream fstream = new FileInputStream(f);
  
      
                 DataInputStream in = new DataInputStream(fstream);
                 BufferedReader br = new BufferedReader(new InputStreamReader(in));
                 String strLine,te;
                 //Read File Line By Line
               //  System.out.println("Inside ");
               //  System.out.println(br);
                 while ((strLine = br.readLine()) != null)   {
                      String tokens[]=strLine.split(", ");
                 // Print the content on the console
                    //  Building dd=new Building();
                    //  dd.setBpoints(5);
                    //  System.out.println(dd.getBpoints());
              //   System.out.println (strLine);
                     //System.out.println(buildingc);
                      int temp;         
                     b[buildingc] = new Building();
                    
                      b[buildingc].setBpoints(Integer.parseInt(tokens[2]));
                     temp= b[buildingc].getBpoints();
                    //  System.out.println(temp);
                      b[buildingc].buildingX=new int[temp];
                       b[buildingc].buildingY=new int[temp];
                      
                    //  System.out.println(temp);
                      int tok=3;
                      te="";
                      for(int i=0;i<temp;i++)
                      {     
                      b[buildingc].buildingX[i]=Integer.parseInt(tokens[tok]);
                      te=te+ b[buildingc].buildingX[i];
                      te=te+",";
                      b[buildingc].buildingY[i]=Integer.parseInt(tokens[tok+1]);
                      te=te+b[buildingc].buildingY[i];
                      if(i<(temp-1)) {
                              te=te+",";
                          }
                      
                      tok=tok+2;
                      }
                     // System.out.println(tokens[0] +tokens[1]+tokens[2]);
                      String str = "INSERT INTO building VALUES ('"+tokens[0]+"','"+tokens[1]+"',"+tokens[2]+",SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY("+te+")))";
                       mainStatement=mainConnection.createStatement();
                       mainStatement.execute(str);
                      buildingc++;
                 }
                 
//                  for(int i=0;i<b[0].bpoints;i++)
//                     {     
//                         System.out.println(b[0].buildingX[i]);   
//                          System.out.println(b[0].buildingY[i]); 
//                     
//                     }
               System.out.println("Data inserted in building");   
             }
    catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
       
    }
      public void people(String f) {
     // System.out.println(f);
           peopleX =new int[200];
            peopleY =new int[200];
            
        try{
  // Open the file that is the first 
  // command line parameter
  FileInputStream fstream = new FileInputStream(f);
              try (DataInputStream in = new DataInputStream(fstream)) {
                  BufferedReader br = new BufferedReader(new InputStreamReader(in));
                  String strLine;
                  //Read File Line By Line
                  while ((strLine = br.readLine()) != null)   {
                       String tokens[]=strLine.split(", ");
                  // Print the content on the console
              //    System.out.println (strLine);
                        peopleX[peoplec]=Integer.parseInt(tokens[1]);
                     peopleY[peoplec]=Integer.parseInt(tokens[2]);
                     
                     String str = "INSERT INTO people VALUES ('"+tokens[0]+"',SDO_GEOMETRY(2001,NULL,SDO_POINT_TYPE("+tokens[1]+","+tokens[2]+", NULL),NULL,NULL))";
                      mainStatement=mainConnection.createStatement();
                       mainStatement.execute(str);
                 peoplec++;
                  }
              }
               System.out.println("Data inserted in people");
    }catch (Exception e){//Catch exception if any
//  System.err.println("Error: " + e.getMessage());
  } 
        
    }
       public void ConnectToDB()
    {
        //System.out.println("trying to connect");
		try
		{
   //                 System.setProperty("oracle.net.tns_admin","D:\\app\\DIVEY\\product\\11.2.0\\dbhome_1\\NETWORK\\ADMIN");
			// loading Oracle Driver
                    //  System.out.println("trying to connect");
    		System.out.print("Looking for Oracle's jdbc-odbc driver ... ");
	    	DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	    	System.out.println(", Loaded.");

			String URL = "jdbc:oracle:thin:@gilaan.usc.edu:1521:csci585";
	    	String userName = "scott";
	    	String password = "tiger";

	    	System.out.print("Connecting to DB...");
	    	mainConnection = DriverManager.getConnection(URL, userName,password);
	    	System.out.println(", Connected!");

    		mainStatement = mainConnection.createStatement();
	    //	SecondStatement = mainConnection.prepareStatement( "insert into info values( ?, ?, ?)" );

   		}
   		catch (Exception e)
   		{
     		System.out.println( "Error while connecting to DB: "+ e.toString() );
     		e.printStackTrace();
     		System.exit(-1);
   		}
     }
    
    public void DeleteData() {
        String str;
        try {
            mainStatement=mainConnection.createStatement();
        } catch (SQLException ex) {
            
        }
    str= "DELETE FROM building";
        try {
            mainStatement.execute(str);
        } catch (SQLException ex) {
            
        }
    str=   "DELETE FROM people";
        try {
            mainStatement.execute(str);
        } catch (SQLException ex) {
           
        }
     str= "DELETE FROM accesspoint";
        try {
            mainStatement.execute(str);
        } catch (SQLException ex) {
         
        }
        
        
    }   
   
    public class Building {
     int bpoints;
         int[] buildingX;
        int[] buildingY;
        
    public int getBpoints() {
        return bpoints;
    }

    public void setBpoints(int bpoints) {
        this.bpoints = bpoints;
    }

    public int[] getBuildingX() {
        return buildingX;
    }

    public void setBuildingX(int[] buildingX) {
        this.buildingX = buildingX;
    }

    public int[] getBuildingY() {
        return buildingY;
    }

    public void setBuildingY(int[] buildingY) {
        this.buildingY = buildingY;
    }
        
         public void Building(){}
         
}

   
    
}
