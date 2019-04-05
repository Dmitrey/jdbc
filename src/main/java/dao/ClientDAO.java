package dao;

import com.sun.security.ntlm.Client;
import connection.PostgreConnection;
import entity.Cars;
import entity.Clients;
import entity.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {
    PostgreConnection builder = new PostgreConnection();

    private static String INSERT = "insert into client(client_id, client_name) values (?,?)";

    private static final String SELECT = "select * from client where client_id = ?";

    private static final String UPDATE = "UPDATE client set client_name = ? where client_id = ?";

    private static final String DELETE = "delete from client where client_id = ?";


    public Clients create(Clients client) {
        try{
            Connection con = builder.connect();
            PreparedStatement pst = con.prepareStatement(INSERT);

            pst.setString(1, client.getClientId());
            pst.setString(2, client.getClientName());

            pst.execute();
            pst.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return client;
    }

    public Clients read(String clientID){
        try {
            Connection con = builder.connect();
            PreparedStatement pst = con.prepareStatement(SELECT);
            pst.setString(1,clientID);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                return new Clients(rs.getString(1),clientID);
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Orders update(String clientId, Clients newClient){
        try{
            Connection con = builder.connect();
            PreparedStatement pst = con.prepareStatement(UPDATE);
            pst.setString(1,newClient.getClientName());
            pst.setString(2,newClient.getClientId());
            pst.execute();
            pst.close();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }


    public void delete(String clientId){
        try{
            Connection con = builder.connect();
            PreparedStatement pst = con.prepareStatement(DELETE);
            pst.setString(1,clientId);
            pst.execute();
            pst.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
