package dao;

import connection.PostgreConnection;
import entity.Cars;
import entity.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDAO {

    PostgreConnection builder = new PostgreConnection();

    private static String INSERT = "insert into cars(vin,model,colour) values (?,?,?)";

    private static final String SELECT = "select * from cars where vin = ?";

    private static final String UPDATE = "UPDATE cars set model = ?, colour = ? where vin = ?";

    private static final String DELETE = "delete from cars where vin = ?";


    public Cars create(Cars car) {
        try{
            Connection con = builder.connect();
            PreparedStatement pst = con.prepareStatement(INSERT);

            pst.setString(1, car.getVin());
            pst.setString(2, car.getModel());
            pst.setString(3, car.getColour());
            pst.execute();
            pst.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return car;
    }


    public Cars read(String vin){
        try {
            Connection con = builder.connect();
            PreparedStatement pst = con.prepareStatement(SELECT);
            pst.setString(1,vin);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                return new Cars(vin ,rs.getString(1), rs.getString(2));
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Orders update(String vin, Cars newCar){
        try{
            Connection con = builder.connect();
            PreparedStatement pst = con.prepareStatement(UPDATE);
            pst.setString(1,newCar.getModel());
            pst.setString(2,newCar.getColour());
            pst.setString(3,newCar.getVin());
            pst.execute();
            pst.close();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }


    public void delete(String vin){
        try{
            Connection con = builder.connect();
            PreparedStatement pst = con.prepareStatement(DELETE);
            pst.setString(1,vin);
            pst.execute();
            pst.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
