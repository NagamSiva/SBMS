package in.ashokit.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class OrderIdGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix="OD";
		String suffix="";
		
		try {
			Connection conn = session.connection();
			Statement stmt = conn.createStatement();
			String sql="select order_id_seq.nextval from dual";
			ResultSet resultSet = stmt.executeQuery(sql);
			if(resultSet.next()) {
				int sqlVal=resultSet.getInt(1);
				suffix=String.valueOf(sqlVal);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prefix+suffix;
	}

}
