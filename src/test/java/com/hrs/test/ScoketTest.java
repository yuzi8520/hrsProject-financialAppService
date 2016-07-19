package com.hrs.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;



/**
 * @author监听控制台的命令
 *
 */
public class  ScoketTest {
	public static boolean lockflag=true;
	private  Socket socket = null; 
	private ServerSocket server=null;

	public static void main(String args[]){
		new ScoketTest().run();	
	}


	/**
	 * 监听控制 命令，设置参数
	 * 
	 * 
	 */
	public void run(){

	
			 
		 try { 
			 if(server==null)server=new ServerSocket(9895);
			 while(lockflag){
			 Socket client=server.accept();
			 BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
			//BufferedWriter out=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
			 	StringBuilder sb = new StringBuilder();
				 String str ="";
				 while( (str=in.readLine()) != null){
					 sb.append(str);
				 }
				   
				 System.out.println(str);
			 
			 //启用退出策略
	    	 //try {
				//sp.exitSystem();
			//  } catch (Exception e) {
				 //logger.error(e.getMessage(),e);
				// start();
			 // }
			 }
	     }catch (UnknownHostException e) {      
	    	 //logger.error("无法识别服务器的主机名");
	    	 System.out.println("无法识别服务器的主机名");  
	     }catch (IOException e){   
	    	// logger.error(e.getMessage(),e);
	    	 e.printStackTrace();  
	     } finally{      
			 try {
				 if(socket!=null)socket.close();	
				 if(server!=null){
					 server.close();
					 server=null;
				 }
			 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//logger.error(e.getMessage(),e);
			}

	    
	  }
	 }

	

}
