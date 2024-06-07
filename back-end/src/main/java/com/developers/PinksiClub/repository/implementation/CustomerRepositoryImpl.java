package com.developers.PinksiClub.repository.implementation;

import com.developers.PinksiClub.repository.CustomerRepository;
import com.developers.PinksiClub.service.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customer save(Customer customer) {
        if (customer.getId() == null){
            jdbcTemplate.update(
                    "INSERT INTO customer(name, email)VALUE (?,?)",
            customer.getName(),customer.getEmail());
        } else {
        jdbcTemplate.update(
                "UPDATE customer SET name = ?, email = ? WHERE id = ?",
                customer.getName(), customer.getEmail(), customer.getId());
    }

        return customer;
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public Customer findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM customer WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> {
                    Customer customer = new Customer() {
                        @Override
                        public Long getId() {
                            return null;
                        }

                        @Override
                        public String getName() {
                            return "";
                        }

                        @Override
                        public String getEmail() {
                            return "";
                        }

                        @Override
                        public void setId(Long id) {

                        }

                        @Override
                        public void put(Long id, Customer customer) {

                        }

                        @Override
                        public void setName(String name) {

                        }

                        @Override
                        public void setEmail(String email) {

                        }
                    };
                    customer.setId(rs.getLong("id"));
                    customer.setName(rs.getString("name"));
                    customer.setEmail(rs.getString("email"));
                    return customer;
                }
        );

    }

    @Override
    public List<Customer> findAll() {
       return jdbcTemplate.query("SELECT * FROM customer",
               (rs, rowNum) -> {
                   Customer customer = new Customer() {
                       @Override
                       public Long getId() {
                           return null;
                       }

                       @Override
                       public String getName() {
                           return "";
                       }

                       @Override
                       public String getEmail() {
                           return "";
                       }

                       @Override
                       public void setId(Long id) {

                       }

                       @Override
                       public void put(Long id, Customer customer) {

                       }

                       @Override
                       public void setName(String name) {

                       }

                       @Override
                       public void setEmail(String email) {

                       }
                   };
                   customer.setId(rs.getLong("id"));
                   customer.setName(rs.getString("name"));
                   customer.setEmail(rs.getString("email"));
                   return customer;
               }
       );

    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM customer WHERE id = ?", id);
    }
}
