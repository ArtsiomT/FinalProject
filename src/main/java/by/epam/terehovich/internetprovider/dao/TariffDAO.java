package by.epam.terehovich.internetprovider.dao;

import by.epam.terehovich.internetprovider.connection.ConnectionPool;
import by.epam.terehovich.internetprovider.entity.TariffPlan;
import by.epam.terehovich.internetprovider.exception.PoolException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aterehovich on 24.7.15.
 */
public class TariffDAO  extends AbstractDAO<Integer, TariffPlan> {
    private final static String SELECT_ALL = "SELECT * FROM  internet_provider.tariff_plan";
    private final static String SELECT_BY_ID = "SELECT * FROM internet_provider.tariff_plan WHERE id_tp = ?";
    @Override
    public List<TariffPlan> findAll() {
        List<TariffPlan> tariffPlans = new ArrayList<>();
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL);
            while (rs.next()){
                tariffPlans.add(new TariffPlan(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getInt(4), rs.getInt(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                ConnectionPool.closeConnection(connection);
            } catch (PoolException e) {
                e.printStackTrace();
            }
        }
        return tariffPlans;
    }

    @Override
    public TariffPlan findById(Integer id) {
        TariffPlan tariffPlan = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                tariffPlan = new TariffPlan(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(ps != null){
                try {
                    ps.close();
                    System.out.println("ps.close");
                } catch (SQLException e) {
                    System.out.println("ps.close exception");
                    e.printStackTrace();
                }
            }
            try {
                ConnectionPool.closeConnection(connection);
            } catch (PoolException e) {
                e.printStackTrace();
            }
        }
        return tariffPlan;
    }

    @Override
    public TariffPlan findByKey(String key) {
        return null;
    }

    @Override
    public boolean insertNew(TariffPlan entity) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
