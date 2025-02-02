package com.example.ttb.repository;


import com.example.ttb.model.response.V1GetUserResponse;
import com.example.ttb.repository.mapper.CustomerJoinWithSalesMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import static com.ttb.interview.test.util.CommonUtil.ZonedDateTimeToTimestamp;

@Repository
@Slf4j
public class CustomerRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String TABLE_NAME = "Customer";

    // Common syntax
    private static final String SPACE = " ";
    private static final String SEMICOLON = ";";
    private static final String COMMA = ",";

    // Customer Fields
    private static final String CUSTOMER_ID = "CustomerId";
    private static final String FIRSTNAME = "Firstname";
    private static final String LASTNAME = "Lastname";
    private static final String CUSTOMER_DATE = "CustomerDate";
    private static final String IS_VIP = "IsVIP";
    private static final String STATUS_CODE = "StatusCode";
    private static final String CREATED_ON = "CreatedOn";
    private static final String MODIFIED_ON = "ModifiedOn";

    // Sales Fields
    private static final String SALE_AMOUNT = "SaleAmount";
    private static final String SALE_DATE = "SaleDate";

    public List<V1GetUserResponse> retrieveCustomerTotalSales(int yearInBack) {
        ZonedDateTime now = ZonedDateTime.now();

        String sql = new StringJoiner(SPACE)
                .add("SELECT")
                .add(getCustomerAllFields() +
                        COMMA +
                        getSalesAllFields() +
                        COMMA +
                        "SUM(s.SaleAmount) AS TotalSales" +
                        COMMA +
                        "RANK() OVER (ORDER BY SUM(s.SaleAmount) DESC) AS SalesRank")
                .add("FROM")
                .add(TABLE_NAME)
                .add("c")
                .add("RIGHT JOIN Sales s ON c.CustomerId = s.CustomerId")
                .add("WHERE SaleDate BETWEEN :year_in_back AND :now")
                .add("GROUP BY")
                .add(getCustomerAllFields())
                .add("ORDER BY TotalSales DESC")
                .add(SEMICOLON)
                .toString();

        Map<String, String> params = new HashMap<>();
        params.put("year_in_back", ZonedDateTimeToTimestamp(now.minusYears(yearInBack)).toString());
        params.put("now", ZonedDateTimeToTimestamp(now).toString());

        return namedParameterJdbcTemplate.query(sql, params, new CustomerJoinWithSalesMapper());
    }

    private String getCustomerAllFields() {
        return new StringJoiner(COMMA)
                .add("c." + FIRSTNAME)
                .add("c." + LASTNAME)
                .add("c." + CUSTOMER_DATE)
                .add("c." + IS_VIP)
                .add("c." + STATUS_CODE)
                .add("c." + CREATED_ON)
                .add("c." + MODIFIED_ON)
                .toString();
    }

    private String getSalesAllFields() {
        return new StringJoiner(COMMA)
                .add("s." + SALE_AMOUNT)
                .add("s." + SALE_DATE)
                .toString();
    }
}
