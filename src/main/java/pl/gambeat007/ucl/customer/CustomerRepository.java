package pl.gambeat007.ucl.customer;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.gambeat007.ucl.user.User;

//import java.util.List;

/**
 * For later use with application future updates
 */

@Repository
public interface CustomerRepository extends JpaRepository<User, Long> {

//    @Query("SELECT customer FROM Customer customer WHERE customer.name=?1")
//    List<Customer> findByName(String name);
//
//    @Query("SELECT customer FROM Customer customer WHERE customer.email=?1")
//    List<Customer> findByEmail(String email);
//
////    @Query("SELECT customer FROM Customer customer WHERE customer.transactionType=?1")
////    List<Customer> findByTransactionType(TransactionType transactionType);

}
