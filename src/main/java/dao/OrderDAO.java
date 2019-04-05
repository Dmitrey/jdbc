package dao;

import connection.PostgreConnection;
import entity.Orders;


import java.sql.*;

public class OrderDAO implements DAO<Orders>{

    PostgreConnection builder = new PostgreConnection();

    private static final String INSERT
            = "INSERT INTO orders (vin, order_id, passportid) VALUES (?, ?, ?)";
    private static final String UPDATE
            = "UPDATE orders set vin = ?, passportid = ? where order_id = ?";
    private static final String SELECT
            = "select * from orders where order_id = ?";
    private static final String DELETE
            = "delete from orders where order_id = ?";

    @Override
    public Orders create(Orders order) {
        try{
             Connection con = builder.connect();
             PreparedStatement pst = con.prepareStatement(INSERT);

            pst.setString(1, order.getVin());
            pst.setInt(2, order.getOrderId());
            pst.setString(3, order.getPassportId());
            pst.execute();
            pst.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return order;
    }

    public Orders read(int id){
        try {
            Connection con = builder.connect();
            PreparedStatement pst = con.prepareStatement(SELECT);
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                return new Orders(rs.getString(1), id ,rs.getString(3));
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Orders update(int id, Orders newOrder){
        try{
            Connection con = builder.connect();
            PreparedStatement pst = con.prepareStatement(UPDATE);
            pst.setString(1,newOrder.getVin());
            pst.setString(2,newOrder.getPassportId());
            pst.setInt(3,id);
            pst.execute();
            pst.close();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id){
        try{
            Connection con = builder.connect();
            PreparedStatement pst = con.prepareStatement(DELETE);
            pst.setInt(1,id);
            pst.execute();
            pst.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

}
