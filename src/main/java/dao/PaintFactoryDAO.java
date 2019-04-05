package dao;

import connection.PostgreConnection;
import entity.Orders;
import entity.PaintFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaintFactoryDAO {
    PostgreConnection builder = new PostgreConnection();

    private static final String INSERT
            = "INSERT INTO paintfactory (factory_id,paint) VALUES (?, ?)";
    private static final String UPDATE
            = "UPDATE paintfactory set paint = ? where factory_id = ?";
    private static final String SELECT
            = "select * from paintfactory where order_id = ?";
    private static final String DELETE
            = "delete from paintfactory where factory_id = ?";


    public PaintFactory create(PaintFactory paintFactory) {
        try{
            Connection con = builder.connect();
            PreparedStatement pst = con.prepareStatement(INSERT);

            pst.setInt(1,paintFactory.getFactoryId());
            pst.setString(2, paintFactory.getPaint());

            pst.execute();
            pst.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return paintFactory;
    }

    public PaintFactory read(int factoryId){
        try {
            Connection con = builder.connect();
            PreparedStatement pst = con.prepareStatement(SELECT);
            pst.setInt(1,factoryId);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                return new PaintFactory (factoryId,rs.getString(1));
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public PaintFactory update(int id, PaintFactory paintFactory){
        try{
            Connection con = builder.connect();
            PreparedStatement pst = con.prepareStatement(UPDATE);
            pst.setString(1,paintFactory.getPaint());
            pst.execute();
            pst.close();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }


    public void delete(int factoryId){
        try{
            Connection con = builder.connect();
            PreparedStatement pst = con.prepareStatement(DELETE);
            pst.setInt(1,factoryId);
            pst.execute();
            pst.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

}
