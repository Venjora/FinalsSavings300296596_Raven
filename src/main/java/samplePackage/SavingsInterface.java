package samplePackage;

import java.sql.SQLException;
import java.util.List;

public interface SavingsInterface {
    public void add(Savings cat) throws ClassNotFoundException, SQLException;
    public Savings edit(Savings save, int custno) throws SQLException, ClassNotFoundException;
    public void delete(String custno) throws SQLException;
    public List<Savings> display() throws ClassNotFoundException, SQLException;
}
