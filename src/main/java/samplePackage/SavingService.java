package samplePackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SavingService implements SavingsInterface{

    Connection conn;

    public SavingService(Connection conn) {
        this.conn = conn;
    }



    public Savings search(int custno) throws SQLException,ClassNotFoundException {



        String quer1 = "SELECT * FROM savingstable WHERE custno = ?";
        PreparedStatement query = conn.prepareStatement(quer1);
        query.setInt(1, custno);

        ResultSet rs = query.executeQuery();

        if(!rs.first()){

            System.out.print("Record doesn't exist");
            return null;
        }

        Savings obj1 = null;

        obj1 = new Savings(rs.getInt("custno"), rs.getString("custname"));

        return obj1;

    }

    @Override
    public void add(Savings save) throws ClassNotFoundException, SQLException {


        String quer1 = "INSERT INTO savingstable VALUES ( ?, ? ,? ,? ,?)";
        PreparedStatement query = conn.prepareStatement(quer1);


        query.setInt(1, save.getCustno());
        query.setString(2, save.getCustname());
        query.setDouble(3, save.getCdep());
        query.setInt(4, save.getNyears());
        query.setString(5, save.getSavtype());


        query.executeUpdate();

    }

    @Override
    public Savings edit(Savings save, int custno) throws SQLException, ClassNotFoundException {

        PreparedStatement query;
        query = conn.prepareStatement("UPDATE savingstable SET custno =?, custname=?,cdep=?, nyears=?, savtype=?,  WHERE custno = ?");
        query.setInt(1, save.getCustno());
        query.setString(2, save.getCustname());
        query.setDouble(3, save.getCdep());
        query.setString(5, save.getSavtype());
        query.setInt(6, custno);


        query.executeUpdate();

        System.out.println("One record edited");

        return save;
    }

    @Override
    public void delete(String custno) throws SQLException {

        String quer1 = "DELETE from savingstable where custno = ?";
        PreparedStatement query = conn.prepareStatement(quer1);
        query.setString(1,custno);
        query.executeUpdate();

        System.out.println("One record Deleted");

    }

    @Override
    public List<Savings> display() throws ClassNotFoundException, SQLException {

        List<Savings> SaveList = new ArrayList<Savings>();

        String quer1 = "SELECT * FROM savingstable";
        PreparedStatement query = conn.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();

        Savings obj1;

        //display records if there is a data;

        while (rs.next()) {

            obj1 = new Savings(rs.getInt("custno"), rs.getString("custname"));

            SaveList.add(obj1);
        }


        return SaveList;
    }
}
