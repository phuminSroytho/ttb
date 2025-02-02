package com.example.ttb.repository.mapper;




import com.example.ttb.model.response.V1GetUserResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ttb.interview.test.util.CommonUtil.timestampToZonedDateTime;


public class CustomerJoinWithSalesMapper implements RowMapper<V1GetUserResponse> {
    @Override
    public V1GetUserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        V1GetUserResponse response = new V1GetUserResponse();
        response.setCustomerId(rs.getString("c.CustomerId"));
        response.setFirstName(rs.getString("c.Firstname"));
        response.setLastName(rs.getString("c.Lastname"));
        response.setCustomerDate(timestampToZonedDateTime(rs.getTimestamp("c.CustomerDate")));
        response.setVip(rs.getBoolean("c.IsVIP"));
        response.setStatusCode(rs.getString("c.StatusCode"));
        response.setCreatedOn(timestampToZonedDateTime(rs.getTimestamp("c.CreatedOn")));
        response.setModifiedOn(timestampToZonedDateTime(rs.getTimestamp("c.ModifiedOn")));
        response.setTotalSales(rs.getString("TotalSales"));
        response.setSalesRank(rs.getString("SalesRank"));
        return response;
    }
}
