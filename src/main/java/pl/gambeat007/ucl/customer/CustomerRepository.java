package pl.gambeat007.ucl.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.gambeat007.ucl.model.TransactionType;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT customer FROM Customer customer WHERE customer.name=?1")
    List<Customer> findByName(String name);

    @Query("SELECT customer FROM Customer customer WHERE customer.email=?1")
    List<Customer> findByEmail(String email);

    @Query("SELECT customer FROM Customer customer WHERE customer.transactionType=?1")
    List<Customer> findByTransactionType(TransactionType transactionType);
}
