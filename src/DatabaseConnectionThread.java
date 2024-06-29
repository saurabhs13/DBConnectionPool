import java.sql.*;
public class DatabaseConnectionThread implements Runnable{
    private boolean poolActive = false;

    public DatabaseConnectionThread(boolean poolActive){
        this.poolActive = poolActive;
    }
    @Override
    public void run(){
        try {
            Connection conn;
             if(this.poolActive){
                conn = DatabaseConnectionPool.getConnection();
             }else{
                conn = DatabaseConnection.getConnection();
             }
             if(null == conn){
                System.out.println("Could not establish a connection: "+Thread.currentThread().getName());
                return;
             }else{
                System.out.println("Connected to database successfully: "+Thread.currentThread().getName());
             }
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM customer_schema.customer WHERE id = '1'");
            /*while (rs.next()) {
                System.out.print("Column 1 returned ");
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
            }*/
            rs.close();
            st.close();
            if(poolActive){
                DatabaseConnectionPool.putConnection(conn);
            }else{
                conn.close();
            }
        }catch(Exception e){
         //   e.printStackTrace();
        } 
    }
}