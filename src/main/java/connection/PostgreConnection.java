package connection;

import dao.CarDAO;
import dao.OrderDAO;
import entity.Cars;
import entity.Orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreConnection {

    public Connection connect() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "jamajka505");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {

        Orders order1 = new Orders("3333",2,"mp456");
        //Orders order3 = new Orders("1111",3,"mp457");
//        Orders order4 = new Orders("2222",4,"mp458");
        //Orders order2 = new Orders("3333",2,"mp459");
        OrderDAO orderDAO = new OrderDAO();
//        orderDAO.create(order4);
//        orderDAO.read(1);
//        Orders ordersRead = new Orders();
//        ordersRead=orderDAO.read(3);
//        System.out.println(ordersRead.toString());
        //orderDAO.update(2,order1);
        //orderDAO.delete(4);
        Cars car1 = new Cars();
        CarDAO carDAO = new CarDAO();
        car1 = carDAO.read("3333");
        System.out.println(car1.toString());
    }

}
