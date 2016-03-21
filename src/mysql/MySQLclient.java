package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/** 	MySQLclient is a client which establishes connection to a MySQL server.
 * each client can only handle one connection at a time, and each connection
 * can only handle a query at a time, so if you need a multithreaded batch of
 * queries to be excecuted, you should create different MySQLclients.
 * @author Skeleton */
public class MySQLclient {

	private boolean isConnectionReady;
	public String mHost, mUser, mPass, mDB;
	public Connection cone;
    public Statement St;
    public ResultSet Rs;

    protected BlockingQueue<String> updatesToDo;


    /**		Create a new MySQL Client object which can open
     * connections to a specified MySQL server
     * NOTE: This constructor is recommended when you don't know
     * the server parameters yet.*/
	public MySQLclient(){
		updatesToDo =new LinkedBlockingQueue<String>();
	}


    /** Create a new MySQL Client object which can open
     * connections to a specified MySQL server
     * @param host hostname
	 * @param user username
	 * @param pass password
	 * @param mDB database name	 */
	public MySQLclient(String host, String user, String pass, String DB){
		mHost = host;
		mUser = user;
		mPass = pass;
		mDB = DB;
		updatesToDo =new LinkedBlockingQueue<String>();
	}

	/** 	Opens a new connection to a MySQL server with given parameters.
	 * NOTE: Its recommended to open a connection in a new thread as this method
	 * may take several seconds to be completed
	 * @param host hostname
	 * @param user username
	 * @param pass password
	 * @param mDB database name	 */
	public void openConn(String host, String user, String pass, String DB){
		mHost = host;
		mUser = user;
		mPass = pass;
		mDB = DB;
		try{
			Class.forName("com.mysql.jdbc.Driver");
	        cone=DriverManager.getConnection("jdbc:mysql://"+mHost+"/"+mDB+"?user="+mUser+"&password="+mPass);
	        isConnectionReady = true;
	        excecuteUpdates();
		}catch(Exception e){
			System.out.println(e.getMessage());//e.printStackTrace();
			isConnectionReady = false;
		}
	}

	/** 	Opens a new connection to a MySQL server with the parameters established
	 * when instantiating this MySQL Client object.
	 * NOTE: Its recommended to open a connection in a new thread as this method
	 * may take several seconds to be completed
	 * @param host hostname
	 * @param user username
	 * @param pass password
	 * @param mDB database name */
	public void openConn(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
	        cone=DriverManager.getConnection("jdbc:mysql://"+mHost+"/"+mDB+"?user="+mUser+"&password="+mPass);
	        isConnectionReady = true;
	        excecuteUpdates();
		}catch(Exception e){
			System.out.println(e.getMessage());//e.printStackTrace();
			isConnectionReady = false;
		}
	}

	/** 	Send a command to mysql Server. You should make sure the connection
	 * to the server is established before excecuting this method.
	 * @param isUpdate if update, no ResultSet is returned
	 * @param query the query  command to be sent 	 */
	public synchronized void query(boolean isUpdate, String query){
		try{
	        St=cone.createStatement();
	        if(isUpdate){
	        	St.executeUpdate(query);
	        }
	        else{
	        	Rs=St.executeQuery(query);
	        }
		}catch(Exception e){
			e.printStackTrace();
		}
    }


	/** 	This method is exclusively for updates/insert commands
	 * to MySQL server. Once the connection to the server is ready
	 * all the updates queue commands are excecuted
	 * @param query	 */
	public void addUpdateToDo(String query){
		if(isConnectionReady){
			query(true,query);
			if( updatesToDo.size() > 0)
				excecuteUpdates();
		} else{
			updatesToDo.add(query);
		}
	}

	/** 	Excecute all the updates that are queued	 */
	private synchronized void excecuteUpdates(){
		if(isConnectionReady && updatesToDo.size()>0){
			while(updatesToDo.size() > 0 )
				try {
					query(true,updatesToDo.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}

	/** 	Clear the Updates queue
	 * @param query	 */
	public synchronized void  clearUpdatesToDo(String query){
		updatesToDo.clear();
	}

	public boolean isConnectionReady(){
		return isConnectionReady;
	}

}
