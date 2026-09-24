package com.algebra._6.repository;

import com.algebra._6.domain.Hardware;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Primary
@Repository
@RequiredArgsConstructor
public class JdbcHardwareRepository {

    private final JdbcTemplate jdbcTemplate;

    public Hardware save(Hardware hardware) {
        String sql = "INSERT INTO HARDWARE (NAME, CODE, PRICE, TYPE, AMOUNT) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                hardware.getName(),
                hardware.getCode(),
                hardware.getPrice(),
                hardware.getType().name(),
                hardware.getAmount()
        );

        return hardware;
    }

    public Hardware save(String code, Hardware hardware) {
        String sql = "UPDATE HARDWARE SET NAME=?, PRICE=?, TYPE=?, AMOUNT=? WHERE CODE=?";

        jdbcTemplate.update(
                sql,
                hardware.getName(),
                hardware.getPrice(),
                hardware.getType().name(),
                hardware.getAmount(),
                hardware.getCode()
        );

        return hardware;
    }

    public List<Hardware> findAll() {
        String sql = "SELECT * FROM HARDWARE";

        return jdbcTemplate.query(sql, new HardwareRowMapper());
    }

    public Optional<Hardware> findByCode(String code) {
        String sql = "SELECT * FROM HARDWARE WHERE CODE = ?";

        try {
            Hardware hardware = jdbcTemplate.queryForObject(sql, new HardwareRowMapper(), code);

            return Optional.ofNullable(hardware);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public boolean existsById(String code) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM HARDWARE WHERE CODE = ?",
                Integer.class,
                code
        );

        return count != null && count > 0;
    }

    public void deleteById(String code) {
        jdbcTemplate.update(
                "DELETE FROM HARDWARE WHERE CODE = ?",
                code
        );
    }

    private static class HardwareRowMapper implements RowMapper<Hardware> {

        @Override
        public Hardware mapRow(ResultSet rs, int i) throws SQLException {
            Hardware hardware = new Hardware();

            hardware.setName(rs.getString("NAME"));
            hardware.setCode(rs.getString("CODE"));
            hardware.setPrice(rs.getBigDecimal("PRICE"));
            hardware.setType(Hardware.Type.valueOf(rs.getString("TYPE")));
            hardware.setAmount(rs.getInt("AMOUNT"));

            return hardware;
        }
    }
}
