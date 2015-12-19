//Java Program which takes input from the user and executes the spatial queries as specified.
import java.sql.*;
public class Hw2 {
	
   //Database credentials
   static final String USER = "system";
   static final String PASS = "Pammipassone1";
   
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	   
//if(args[0].equals("hw2")){
        	if(args[0].equals("window")){
        		System.out.println("First Query of the Homework");
        		first_query_window(args[1], args[2], args[3], args[4], args[5]);
        		
        	} 
        	else if(args[0].equals("within")){
        		System.out.println("Second Query of the Homework");
        		second_query_within(args[1], args[2]);
       
        	}
        	else if(args[0].equals("nearest-neighbor")){
        		System.out.println("Third Query of the Homework");
        		third_query_nearest_neighbor(args[1], args[2], args[3]);
        		
        	}
        	else if(args[0].equals("fixed")){
        		System.out.println("Fourth Query of the Homework");
        		fourth_query_fixed(args[1]);
        		
        	}
        		
	  //}
     else{
		   System.out.println("Please give the First Argument correctly");
	   }
	   
   }
   
private static void fourth_query_fixed(String string) {
	int choice = Integer.parseInt(string);
	System.out.println(choice);
	switch(choice){
	case 1: 
		System.out.println("Choice 1");
		getqueryfour1result();
        break;
	case 2:
		System.out.println("Choice 2"); 
		getqueryfour2result();
        break;
	case 3:
		System.out.println("Choice 3");
		getqueryfour3result();
        break;
	case 4:
		System.out.println("Choice 4"); 
		getqueryfour4result();
        break;
	case 5: 
		System.out.println("Choice 5"); 
		getqueryfour5result();
        break;
	default :
        System.out.println("Default choice");
	}
	System.out.println("Done with fixed query execution");
	
}

private static void getqueryfour1result(){
	Connection conn = null;
	Statement stmt = null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch(ClassNotFoundException e){
		   e.printStackTrace();   
	}
	
	try{
	     System.out.println("Connecting to database for 4.1 query...");
	     conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",USER,PASS);
	     System.out.println("Connection statement executed for 4.1 query");
	     //STEP 4: Execute a query
	     System.out.println("Creating statement for 4.1 query...");
	     stmt = conn.createStatement();
	     System.out.println("Creating statement finished for 4.1 query...");
	}   
	catch(SQLException se){
		      se.printStackTrace();
		   }
	try{
	   String sql4;
//	   sql4 = "select distinct b.BuildingID AS BuildingID_Value From Building b where SDO_RELATE(b.BuildingShape, (select t.TramStopShape as TramShape from TramStop t where TramStopID = 't2ohe'), 'mask = inside+coveredby+OVERLAPBDYINTERSECT') = 'TRUE'"
//		+" UNION "
//		+"select distinct b.BuildingID AS BuildingID_Value From Building b where SDO_RELATE(b.BuildingShape, (select t.TramStopShape as TramShape from TramStop t where TramStopID = 't6ssl'), 'mask = inside+coveredby+OVERLAPBDYINTERSECT') = 'TRUE'" 
//		+" union "
//		+"select distinct s.StudentID AS Studend_ID_Value FROM Student s where SDO_RELATE(s.StudentShape,(select t.TramStopShape as TramShape from TramStop t where TramStopID = 't2ohe'), 'mask = inside+coveredby') = 'TRUE'"
//		+" UNION " 
//		+"select distinct s.StudentID AS Studend_ID_Value FROM Student s where SDO_RELATE(s.StudentShape,(select t.TramStopShape as TramShape from TramStop t where TramStopID = 't6ssl'), 'mask = inside+coveredby') = 'TRUE'" 
//		;
	   
//		sql4 = "select b.BuildingID AS BuildingID_Value"+
//		"From Building b"+ 
//		"where SDO_RELATE(b.BuildingShape, (select t.TramStopShape  from TramStop t where TramStopID = 't2ohe'), 'mask = inside+coveredby') = 'TRUE'"+
//		"AND SDO_RELATE(b.BuildingShape, (select t.TramStopShape  from TramStop t where TramStopID = 't6ssl'), 'mask = inside+coveredby') = 'TRUE'"+
//		"union"+
//		"select distinct s.StudentID AS Studend_ID_Value"+ 
//		"FROM Student s"+ 
//		"where SDO_RELATE(s.StudentShape,(select t.TramStopShape  from TramStop t where TramStopID = 't2ohe'), 'mask = inside+coveredby') = 'TRUE'"+
//		"AND SDO_RELATE(s.StudentShape,(select t.TramStopShape  from TramStop t where TramStopID = 't6ssl'), 'mask = inside+coveredby') = 'TRUE'";

	   //sql4 = "select s.StudentID as Column_Value FROM Student s where SDO_FILTER(s.StudentShape,SDO_geometry(2003,NULL,NULL,SDO_elem_info_array(1,1003,4),SDO_ordinate_array(274,70,134,70,204,247))) = 'TRUE' union select b.BuildingID From Building b where SDO_FILTER(b.BuildingShape,SDO_geometry(2003,NULL,NULL,SDO_elem_info_array(1,1003,4),SDO_ordinate_array(263,432,163,432,213,482))) = 'TRUE'";
	      sql4 = "select b.BuildingID as building_id from Building b where sdo_relate(b.BuildingShape,SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(274,70,134,70,204,247)),'mask=inside+coveredby+overlapbdyintersect')= 'TRUE' AND sdo_relate(b.BuildingShape,SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(263,432,163,432,213,482)),'mask=inside+coveredby')='TRUE' INTERSECT select s.StudentID from Student s where sdo_relate(s.StudentShape,SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(274,70,134,70,204,247)),'mask=inside+coveredby+overlapbdyinersect')= 'TRUE' AND sdo_relate(s.StudentShape,SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(263,432,163,432,213,482)),'mask=inside+coveredby')='TRUE'";  
	          System.out.println("sql4 " + sql4);
	          ResultSet rs = stmt.executeQuery(sql4);
	          System.out.println("after executeQuery");
	          System.out.println("BuildingID and StudentID are as follows:");
	          if(!rs.equals(null)){
	        	  System.out.println("0 rows");		      
	          }else{
	        	  System.out.println("rows");
	      	  
	          }
	          while(rs.next()){
		          String BuildingID_Value1  = rs.getString("building_id");
		          System.out.println(BuildingID_Value1);
	        }
	          
	       rs.close();
	       stmt.close();
	       conn.close();
	     }   catch(SQLException se){
	         se.printStackTrace();
	      }			
}

private static void getqueryfour2result() {	
	Connection conn = null;
	Statement stmt = null;
	try{
		//STEP 2: Register JDBC driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch(ClassNotFoundException e){
		   e.printStackTrace();   
	}
	
	//STEP 3: Open a connection
	try{
	     System.out.println("Connecting to database for 4.2 query...");
	     conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",USER,PASS);
	     System.out.println("Connection statement executed for 4.2 query");
	     //STEP 4: Execute a query
	     System.out.println("Creating statement for 4.2 query...");
	     stmt = conn.createStatement();
	     System.out.println("Creating statement finished for 4.2 query...");
	}   
	catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }
	try{
	   String sql5;
	   sql5 = "SELECT  s.StudentID as Student_ID, t.TramStopID as TramStop_ID FROM Student  s,  TramStop  t  WHERE SDO_NN(t.TramStopShape, s.StudentShape, 'sdo_num_res=2')='TRUE'";
	        
	          System.out.println("sql5 " + sql5);
	          ResultSet rs = stmt.executeQuery(sql5);
	          System.out.println("after executeQuery");
	          System.out.println("BuildingID and StudentID are as follows:");
	  
	          
	          //STEP 5: Extract data from result set
	          while(rs.next()){
	          String BuildingID_Value1  = rs.getString("Student_ID");
	          String TramStopID_Value1  = rs.getString("TramStop_ID");
	          System.out.println(BuildingID_Value1);  
	          System.out.println(TramStopID_Value1);
	        }
	          
	     //STEP 6: Clean-up environment
	       rs.close();
	       stmt.close();
	       conn.close();
	     }   catch(SQLException se){
	         //Handle errors for JDBC
	         se.printStackTrace();
	      }	
	
}

private static void getqueryfour3result() {
	Connection conn = null;
	Statement stmt = null;
	try{
		//STEP 2: Register JDBC driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch(ClassNotFoundException e){
		   e.printStackTrace();   
	}
	
	//STEP 3: Open a connection
	try{
	     System.out.println("Connecting to database for 4.3 query...");
	     conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",USER,PASS);
	     System.out.println("Connection statement executed for 4.3 query");
	     //STEP 4: Execute a query
	     System.out.println("Creating statement for 4.3 query...");
	     stmt = conn.createStatement();
	     System.out.println("Creating statement finished for 4.3 query...");
	}   
	catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }
	try{
	   String sql6;
	   sql6 = "select Tram_ID from (select t.TramStopID As Tram_ID, count(b.BuildingID) as count_of_buildings from TramStop t, Building b where SDO_WITHIN_DISTANCE(b.BuildingShape, t.TramStopShape, 'distance=250') = 'TRUE' group by t.TramStopID order by count_of_buildings desc) where rownum <=1";
	        
	          System.out.println("sql6 " + sql6);
	          ResultSet rs = stmt.executeQuery(sql6);
	          System.out.println("after executeQuery");
	          System.out.println("TramID is as follows:");
	  
	          
	          //STEP 5: Extract data from result set
	          while(rs.next()){
	          String Tram_ID_Value1  = rs.getString("Tram_ID");
	          //String count_of_buildings_Value1  = rs.getString("count_of_buildings");
	          System.out.println(Tram_ID_Value1);  
	          //System.out.println(count_of_buildings_Value1);
	        }
	          
	     //STEP 6: Clean-up environment
	       rs.close();
	       stmt.close();
	       conn.close();
	     }   catch(SQLException se){
	         //Handle errors for JDBC
	         se.printStackTrace();
	      }	
	
}

private static void getqueryfour4result() {
	Connection conn = null;
	Statement stmt = null;
	try{
		//STEP 2: Register JDBC driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch(ClassNotFoundException e){
		   e.printStackTrace();   
	}
	
	//STEP 3: Open a connection
	try{
	     System.out.println("Connecting to database for 4.4 query...");
	     conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",USER,PASS);
	     System.out.println("Connection statement executed for 4.4 query");
	     //STEP 4: Execute a query
	     System.out.println("Creating statement for 4.4 query...");
	     stmt = conn.createStatement();
	     System.out.println("Creating statement finished for 4.4 query...");
	}   
	catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }
	try{
	   String sql7;
	   sql7 = "select * from (select Student_ID, count(Reverse_Nearest_Neighbour) as Reverse_Nearest_Neighbour1 from (select s.StudentID as Student_ID, b.BuildingID as Reverse_Nearest_Neighbour from Student s, Building b "+
	   "where SDO_NN(s.StudentShape, b.BuildingShape, 'sdo_num_res = 1') = 'TRUE') "+
	   "group by Student_ID "+
	   "order by  Reverse_Nearest_Neighbour1 desc) "+
	   "where rownum <= 5";

	        
	          System.out.println("sql7 " + sql7);
	          ResultSet rs = stmt.executeQuery(sql7);
	          System.out.println("after executeQuery");
	          System.out.println("Student_ID as follows:");
	  
	          while(rs.next()){
	          String Student_ID_Value1  = rs.getString("Student_ID");
	          //String Reverse_Nearest_Neighbour_Value1  = rs.getString("Reverse_Nearest_Neighbour1");
	          //System.out.println(Reverse_Nearest_Neighbour_Value1);
	          System.out.println(Student_ID_Value1);  
	        }
	          
	       rs.close();
	       stmt.close();
	       conn.close();
	     }   catch(SQLException se){
	         se.printStackTrace();
	      }	
	
}

private static void getqueryfour5result() {
	Connection conn = null;
	Statement stmt = null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch(ClassNotFoundException e){
		   e.printStackTrace();   
	}
	
	try{
	     System.out.println("Connecting to database for 4.5 query...");
	     conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",USER,PASS);
	     System.out.println("Connection statement executed for 4.5 query");
	     //STEP 4: Execute a query
	     System.out.println("Creating statement for 4.5 query...");
	     stmt = conn.createStatement();
	     System.out.println("Creating statement finished for 4.5 query...");
	}   
	catch(SQLException se){
		      
		      se.printStackTrace();
		   }
	try{
	   String sql8;
	   sql8 = "select table1.column_value as vertices_of_MBR from table(SELECT SDO_AGGR_MBR(b.BuildingShape).sdo_ordinates  as Coordinates FROM Building b WHERE b.BuildingName LIKE 'SS%') table1";
	        
	          System.out.println("sql8 " + sql8);
	          ResultSet rs = stmt.executeQuery(sql8);
	          System.out.println("after executeQuery");
	          System.out.println("vertices_of_MBR are as follows:");
	  
	          while(rs.next()){
	          String vertices_of_MBR_Value1  = rs.getString("vertices_of_MBR");
	          System.out.println(vertices_of_MBR_Value1);  
	        }
	          
	       rs.close();
	       stmt.close();
	       conn.close();
	     }   catch(SQLException se){
	         se.printStackTrace();
	      }	
	
}

private static void third_query_nearest_neighbor(String string, String string2, String string3) {
	
	System.out.println("inside third method");
	String table_name = string;
	String building_id = string2;
	int neighbours = Integer.parseInt(string3);
	if(table_name.equals("building")){
	neighbours = neighbours+1;
	}
	else if(table_name.equals("tramstop"))
	{
		neighbours = neighbours+1;
	}	
	else if(table_name.equals("student"))
	{
		neighbours = neighbours+1;
	}
	Connection conn = null;
	Statement stmt = null;
	try{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch(ClassNotFoundException e){
		   e.printStackTrace();   
	}
	
	try{
	     System.out.println("Connecting to database for Third query...");
	     conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",USER,PASS);
	     System.out.println("Connection statement executed for Third query");
	     System.out.println("Creating statement for Third query...");
	     stmt = conn.createStatement();
	     System.out.println("Creating statement finished for Third query...");
	}   
	catch(SQLException se){
		      se.printStackTrace();
		   }
	try{
	   String sql3;
	   /*
	    SELECT  b1.BuildingID as Building_ID
        FROM Building b1, Building b2
        WHERE SDO_NN(b1.BuildingShape, b2.BuildingShape, 'sdo_num_res =6') = 'TRUE'  and  b2.BuildingID = 'b3' and  b1.BuildingID != 'b3';*/
	   if(table_name.equals("building")){
		   sql3 = "SELECT  b1."+table_name+"ID"+" as Result_ID FROM "+table_name+" b1, Building b2 WHERE SDO_NN(b1."+table_name+"Shape, b2.BuildingShape, 'sdo_num_res ="+neighbours+"') = 'TRUE'  and  b2.BuildingID = '"+
			          building_id+
			          "'"+ 
			          " and b1."+table_name+"ID != '"+building_id+"'"
			          ;
		   System.out.println("sql3 " + sql3);
		   ResultSet rs = stmt.executeQuery(sql3);
		   System.out.println("after executeQuery");
		   while(rs.next()){
			          String BuildingID_value  = rs.getString("Result_ID");
			          System.out.println("Result_ID: "+BuildingID_value);
			        }    
			       rs.close();
			       stmt.close();
			       conn.close();
		   
	   }
	   else if(table_name.equals("tramstop")){
		   sql3 = "SELECT  b1."+table_name+"ID"+" as Result_ID FROM "+table_name+" b1, TramStop b2 WHERE SDO_NN(b1."+table_name+"Shape, b2.TramStopShape, 'sdo_num_res ="+neighbours+"') = 'TRUE'  and  b2.TramStopID = '"+
			          building_id+
			          "'"+ 
			          " and b1."+table_name+"ID != '"+building_id+"'"
			          ;
		   System.out.println("sql3 " + sql3);
		   ResultSet rs = stmt.executeQuery(sql3);
		   System.out.println("after executeQuery");
		   while(rs.next()){
			          String BuildingID_value  = rs.getString("Result_ID");
			          System.out.println("Result_ID: "+BuildingID_value);
			        }    
			       rs.close();
			       stmt.close();
			       conn.close();
		   
	   }
	   else if(table_name.equals("student")){
		   sql3 = "SELECT  b1."+table_name+"ID"+" as Result_ID FROM "+table_name+" b1, Student b2 WHERE SDO_NN(b1."+table_name+"Shape, b2.StudentShape, 'sdo_num_res ="+neighbours+"') = 'TRUE'  and  b2.StudentID = '"+
			          building_id+
			          "'"+ 
			          " and b1."+table_name+"ID != '"+building_id+"'"
			          ;
		   System.out.println("sql3 " + sql3);
		   ResultSet rs = stmt.executeQuery(sql3);
		   System.out.println("after executeQuery");
		   while(rs.next()){
			          String BuildingID_value  = rs.getString("Result_ID");
			          System.out.println("Result_ID: "+BuildingID_value);
			        }    
			       rs.close();
			       stmt.close();
			       conn.close();
		   
	   }

	     }   catch(SQLException se){
	         se.printStackTrace();
	      }
	
	
}

private static void second_query_within(String string, String string2) {
	String student_id = string;
	int distance_value = Integer.parseInt(string2);	   
	Connection conn = null;
	Statement stmt = null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch(ClassNotFoundException e){
		   e.printStackTrace();   
	}
	try{
	     System.out.println("Connecting to database for second query...");
	     conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",USER,PASS);
	     System.out.println("Connection statement executed for second query");
	     System.out.println("Creating statement for second query...");
	     stmt = conn.createStatement();
	     System.out.println("Creating statement finished for second query...");
	}   
	catch(SQLException se){
		      se.printStackTrace();
		   }
	try{
	   String sql2;
	   sql2 = 
	          "SELECT TramStopID, BuildingID FROM TramStop t, Building b, Student s WHERE s.StudentID = '"+
	          student_id+
	          "'"+
	          " AND SDO_WITHIN_DISTANCE(t.TramStopshape, s.StudentShape, 'distance="+distance_value+"') = 'TRUE'"+
	          " AND SDO_WITHIN_DISTANCE(b.BuildingShape, s.StudentShape, 'distance="+distance_value+"') = 'TRUE'";
	          System.out.println("sql2 " + sql2);
	          ResultSet rs = stmt.executeQuery(sql2);
	          System.out.println("after executeQuery");
	          while(rs.next()){
	          String tramStopID  = rs.getString("TramStopID");
	          String BuildingID  = rs.getString("BuildingID");
	          System.out.println("TramStopID: "+tramStopID+" BuildingID: "+BuildingID);
	        }
	          
	       rs.close();
	       stmt.close();
	       conn.close();
	     }   catch(SQLException se){
	         se.printStackTrace();
	      }
	
	
}

private static void first_query_window(String string, String string2, String string3, String string4, String string5) {
	String table_name = string;
	int lower_x = Integer.parseInt(string2);
	int lower_y = Integer.parseInt(string3);
	int upper_x = Integer.parseInt(string4);
	int upper_y = Integer.parseInt(string5);
		   
	Connection conn = null;
	Statement stmt = null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch(ClassNotFoundException e){
		   e.printStackTrace();   
	}
	
	try{
	     System.out.println("Connecting to database...");
	     conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",USER,PASS);
	     System.out.println("Connection statement executed");
	     System.out.println("Creating statement...");
	     stmt = conn.createStatement();
	     System.out.println("Creating statement finished...");
	}   
	catch(SQLException se){
		      se.printStackTrace();
		   }
	try{
	   String sql1;
	   sql1 = " SELECT "+ 
	          "b."+table_name+"ID"+" as ColumnValue"+
	          " FROM "+table_name+" b"+
	          " WHERE sdo_filter (b."+table_name+"Shape,  SDO_geometry(2003,NULL,NULL,"+
	          "SDO_elem_info_array(1,1003,3),"+
	          "SDO_ordinate_array("+lower_x+","+lower_y+","+upper_x+","+upper_y+"))) = 'TRUE'";
	          System.out.println("sql1" + sql1);
	          ResultSet rs = stmt.executeQuery(sql1);
	          System.out.println("after executeQuery");
	          System.out.println("The values of the Requested Table ID's are as follows:");
	          while(rs.next()){
	          String id  = rs.getString("ColumnValue");
	          System.out.println(id);
	        }
	          
	       rs.close();
	       stmt.close();
	       conn.close();
	     }   catch(SQLException se){
	         se.printStackTrace();
	      }	
  }
}
