package mb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ReadFile {

	private Scanner input;
	
	
	public ReadFile()
	{
		this.openFile();
	}
	
	 public void openFile()
	  {
	      try
	      {
	          input= new Scanner(new File(getClass().getResource("readfile.txt").getFile()));
	      }

	          

	      catch(FileNotFoundException fileNotFound)
	      {
	         System.err.print("Can't open file...");
	         System.exit(1);
	      }
	  }
	 
	 
	 public void read()
	 {
		
		 int x,y,t,d;
		 int m,n;// m = number of walls n = number of doors
	     int   fx ,fy;// position of Nemo
	     int count;
	     
	     
		 
		 try
		 {
			 while(input.hasNext())
			 {
				 Node[][]  Graph = new Node[200][200];
			       
				 for(int i=0;i< 200; i++)
			            for(int j =0; j<200; j++ )
			            {
			                Graph[i][j] = new Node();
			                Graph[i][j].x = j;
			                Graph[i][j].y = i;
			              
			                
			            }
			       

			       // System.out.println(1.5/1);
			        m = input.nextInt();
			        n = input.nextInt();
			        System.out.printf("m = %d n = %d", m,n);

			        while(m!=-1 & n!= -1)
			        {
			        for( int i=0; i< m ; i++)
			        {
			            x = input.nextInt();
			            y = input.nextInt();
			            d = input.nextInt();
			            t = input.nextInt();
			            if (d == 1)
			            {
			                Graph[y][x].left =2;
			                Graph[y][x-1].right = 2;
			                y++;

			                for(int k=0;k< t-1 ; k++)
			                {
			                    Graph[y][x].left =2;
			                    Graph[y][x-1].right = 2;
			                    y++;
			                }



			            }
			            
			            
			            if(d==0)
			            {
			                Graph[y][x].up = 2;
			                Graph[y-1][x].down =2;
			                x++;
			                for(int k=0;k< t-1 ; k++)
			                {
			                     Graph[y][x].up = 2;
			                     Graph[y-1][x].down =2;
			                     x++;

			                }


			            }
			        }//end for
			        
			        System.out.println("end of the walls");

			         for( int i=0; i< n ; i++)
			         {
			             x = input.nextInt();
			            y = input.nextInt();
			            d = input.nextInt();

			             if (d == 1)
			            {
			                Graph[y][x].left =1;
			                Graph[y][x-1].right = 1;


			            }

			            if(d==0)
			            {
			                Graph[y][x].up = 1;
			                Graph[y-1][x].down =1;


			            }


			         }//end for
			         
			         System.out.println("end of the doors");
			        fx = (int)input.nextDouble();
			        fy = (int )input.nextDouble();

			        //Node s = Graph[fx][fy];
			        count = dijsktra(fx, fy, Graph);
			        System.out.println("\ncount = " + count);

			          m = input.nextInt();
			        n = input.nextInt();

			    }//end while
			        
			        int d1 = Integer.MAX_VALUE;
			        int d2 = Integer.MAX_VALUE;
			      if(d1 + 0 < d2)
			    	  System.out.println("lskjfkljs");
			 
			 }
		 }
			 catch(NoSuchElementException elementException)
	         {
	             System.err.println("File improperly formed.");
	             input.close();
	             System.exit(1);
	            
	         }
	         
	         catch(IllegalStateException stateException)
	         {
	             System.err.println("Error reading from file .");
	             System.exit(1);
	             
	         }
		 
	 }
	 
	 
	    public void closeFile()
	    {
			      if(input!=null)
			          input.close();
			          
	    }
	    
	    
	    
	    
	    public  int   dijsktra(int sx,int sy,Node[][] Graph)
	    {
	    	//System.out.printf("sx = %d , sy = %d",sx,sy);
	        PriorityQueue<Node> queue = new PriorityQueue<Node>();
	        Node s = Graph[sx][sy];
	        Node u;
	        
	          for(int i=0;i< 200; i++)
	            for(int j =0; j<200; j++ )
	            {
	                //Graph[i][j] = new Node();
	                queue.add(Graph[i][j]);
	              
	                
	            }
	        //queue.
	        queue.remove(Graph[sx][sy]);
	        Graph[sx][sy].d =0;
	        queue.add(Graph[sx][sy]);
	        
	        
	        
	        u = queue.remove();
	           Node[] adj = new Node[4];
	          //System.out.printf("u.x = %d  u.y = %d ", u.x, u.y);
	           
	          //System.out.printf("u.right= %d ", u.right);
	           if(u.right == 1 | u.right == 0)
	           {
	        	   if(u.x == Graph[0].length -1 )
	        		   adj[0] = null;
	        	   else
	        	   {
	              adj[0] =  Graph[u.y][u.x +1];
	              //System.out.println("sldjflksj");
	        	   }
	           }
	           else 
	        	   adj[0] = null;
	          
	      
	           
	           if(u.up == 1 | u.up == 0)
	           {
	        	   if(u.y == 0)
	        		   adj[1]= null;
	        	   else
	        	   {
	              adj[1] =  Graph[u.y -1 ][u.x];
	             
	        	   }
	           }
	           else 
	        	   adj[1] = null;
	           
	         
	           
	           if(u.down == 1 | u.down == 0)
	           {
	        	   if(u.y == Graph[0].length -1)
	        		   adj[2] = null;
	        	   else{
	              adj[2] =  Graph[u.y + 1][u.x];
	             
	        	   }
	           }
	           
	           else 
	        	   adj[2] = null;
	           
	          // System.out.printf("u.left = %d ", u.left);
	           if(u.left == 1 | u.left == 0)
	           {
	        	   if(u.x == 0)
	        		   adj[3] = null;
	        	   else{
	              adj[3] =  Graph[u.y][u.x -1];
	             
	        	   }
	           }
	           else 
	        	   adj[3] = null;
	           
	           
	           if(adj[0] != null)
	           {
	               if(u.d + u.right < adj[0].d )
	               {
	            	
	                   adj[0].d =u.d + u.right ;
	                   Graph[u.y][u.x +1].d =u.d + u.right  ;

	                   queue.remove(Graph[u.y][u.x +1]);
	                   Graph[u.y][u.x +1].pred = u;
	                   queue.add(Graph[u.y][u.x +1]);



	               }
	           }
	           
	           if(adj[1] != null)
	           {
	               if(u.d + u.up < adj[1].d )
	               {
	            	  // System.out.println("sldjflksj");
	                    adj[1].d =u.d + u.up ;  
	                    Graph[u.y -1 ][u.x].d =u.d + u.up  ;

	                    queue.remove(Graph[u.y -1 ][u.x]);
	                    Graph[u.y -1 ][u.x].pred = u;
	                    queue.add(Graph[u.y -1 ][u.x]);


	               }
	               
	           }
	           if(adj[2] != null)
	           {
	                if(u.d + u.down < adj[2].d )
	               {
	                	// System.out.println("sldjflksj");
	                    adj[2].d =u.d + u.down;
	                     Graph[u.y + 1][u.x].d =u.d + u.down  ;

	                    queue.remove( Graph[u.y + 1][u.x]);
	                     Graph[u.y + 1][u.x].pred = u;
	                    queue.add( Graph[u.y + 1][u.x]);


	               }
	               
	           }
	           if(adj[3] != null)
	           {

	                if(u.d + u.left < adj[3].d )
	               {
	                	 //System.out.println("sldjflksj");
	                    adj[3].d =u.d + u.left;
	                     Graph[u.y][u.x -1].d =u.d + u.left  ;

	                    queue.remove( Graph[u.y][u.x -1]);
	                     Graph[u.y][u.x -1].pred = u;
	                    queue.add( Graph[u.y][u.x -1]);


	               }
	           }
	               

	     

	        while(!queue.isEmpty())
	        {
	           u = queue.remove();
	           Node[] adj1 = new Node[4];
	        	           
	         
	           if(u.right == 1 | u.right == 0)
	           {
	        	   if(u.x == Graph[0].length -1 )
	        		   adj1[0] = null;
	        	   else
	        	   {
	              adj1[0] =  Graph[u.y][u.x +1];
	              
	        	   }
	           }
	           else 
	        	   adj1[0] = null;
	          
	         
	           
	           if(u.up == 1 | u.up == 0)
	           {
	        	   if(u.y == 0)
	        		   adj1[1]= null;
	        	   else
	        	   {
	              adj1[1] =  Graph[u.y -1 ][u.x];
	             
	        	   }
	           }
	           else 
	        	   adj1[1] = null;
	           
	          
	           
	           if(u.down == 1 | u.down == 0)
	           {
	        	   if(u.y == Graph[0].length -1)
	        		   adj1[2] = null;
	        	   else{
	              adj1[2] =  Graph[u.y + 1][u.x];
	             
	        	   }
	           }
	           
	           else 
	        	   adj1[2] = null;
	           
	          
	           if(u.left == 1 | u.left == 0)
	           {
	        	   if(u.x == 0)
	        		   adj1[3] = null;
	        	   else{
	              adj1[3] =  Graph[u.y][u.x -1];
	           
	        	   }
	           }
	           else 
	        	   adj1[3] = null;
	           
	           
	           if(adj1[0] != null)
	           {
	               if(u.d + u.right < adj1[0].d )
	               {
	            	  
	                   adj1[0].d =u.d + u.right ;
	                   Graph[u.y][u.x +1].d =u.d + u.right  ;

	                   queue.remove(Graph[u.y][u.x +1]);
	                   Graph[u.y][u.x +1].pred = u;
	                   queue.add(Graph[u.y][u.x +1]);



	               }
	           }
	           
	           if(adj1[1] != null)
	           {
	               if(u.d + u.up < adj1[1].d )
	               {
	            	  
	                    adj1[1].d =u.d + u.up ;  
	                    Graph[u.y -1 ][u.x].d =u.d + u.up  ;

	                    queue.remove(Graph[u.y -1 ][u.x]);
	                    Graph[u.y -1 ][u.x].pred = u;
	                    queue.add(Graph[u.y -1 ][u.x]);


	               }
	               
	           }
	           if(adj1[2] != null)
	           {
	                if(u.d + u.down < adj1[2].d )
	               {
	                	
	                    adj1[2].d =u.d + u.down;
	                     Graph[u.y + 1][u.x].d =u.d + u.down  ;

	                    queue.remove( Graph[u.y + 1][u.x]);
	                     Graph[u.y + 1][u.x].pred = u;
	                    queue.add( Graph[u.y + 1][u.x]);


	               }
	               
	           }
	           if(adj1[3] != null)
	           {

	                if(u.d + u.left < adj1[3].d )
	               {
	                
	                    adj1[3].d =u.d + u.left;
	                     Graph[u.y][u.x -1].d =u.d + u.left  ;

	                    queue.remove( Graph[u.y][u.x -1]);
	                     Graph[u.y][u.x -1].pred = u;
	                    queue.add( Graph[u.y][u.x -1]);


	               }
	               
	            }

	           u.mark =1;// finished

	           
	                   
	        }
	        

	        Node q =  Graph[0][0];
	       Node p = q.pred;
	      int  count =0; 
	      boolean sw = true;
	      if (q!= null & p != null){
	    	  
	        while(sw)
	        {
	            if((p.x == q.x + 1) & (p.y== q.y))
	            {
	            
	            	
	            	count += q.right;
	            	
	            	
	            }
	           
	            else if((p.x == q.x -1) & (p.y== q.y))
	            {
	            	
	            	count += q.left;
	         
	            }
	            else if ((p.y == q.y + 1)  & (p.x== q.x))
	            {
	            	//System.out.println("third if");
	            	//System.out.printf("\np.x = %d p.y = %d  q.x = %d q.y = %d", p.x , p.y,q.x , q.y);
	            	count += q.down;
	            	//System.out.println("\n" + count);
	            }
	            
	            else if((p.y == q.y - 1)  & (p.x== q.x))
	            {
	            	//System.out.println("fourth if");
	            	//System.out.printf("\np.x = %d p.y = %d  q.x = %d q.y = %d", p.x , p.y,q.x , q.y);
	            	count += q.up;
	            	//System.out.println("\n" + count);
	            }
	            
	            q = p;
	            p = q.pred;
	            
	            if((q.x == s.x) & (q.y == s.y))
	            	sw = false;
	        }

	        
	      }
	      else if (p== null  )
	    	  return -1;
		return count;

	    }
	    
			
	   
	 
	 
	 
}
