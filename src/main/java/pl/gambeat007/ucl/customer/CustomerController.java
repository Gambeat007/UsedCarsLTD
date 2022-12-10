package pl.gambeat007.ucl.customer;

import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.List;
//import java.util.Optional;

@RestController
@RequestMapping("/ucl")
@RequiredArgsConstructor
public class CustomerController {

//    private final CustomerRepository customerRepository;
//
//    @GetMapping("/customers/name{name}")
//    public ResponseEntity<List<Customer>> findByName(@PathVariable("name") String name) {
//        try {
//            List<Customer> customers = customerRepository.findByName(name);
//            if (customers.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(customers, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
////    @PostMapping("/customers/add")
////    public ResponseEntity<Customer> addCustomer (@RequestBody Customer customer) {
////        try {
////            Customer _customer = customerRepository.save(new Customer(customer.getName(), customer.getEmail()
//////                    , customer.getTransactionType()
////            ));
////            return new ResponseEntity<>(_customer, HttpStatus.CREATED);
////        } catch (Exception e) {
////            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
////        }
////    }
////
////    @PutMapping("/customers/update{id}")
////    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
////        Optional<Customer> customerToUpdate = customerRepository.findById(id);
////        if (customerToUpdate.isPresent()) {
////            Customer _customer = customerToUpdate.get();
////            _customer.setName(customer.getName());
////            _customer.setEmail(customer.getEmail());
//////            _customer.setTransactionType(customer.getTransactionType());
////            return new ResponseEntity<>(customerRepository.save(_customer), HttpStatus.OK);
////        } else {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
////    }
//
//    @DeleteMapping("/customers/delete{id}")
//    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") long id) {
//        try {
//            customerRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/customers/email{email}")
//    public ResponseEntity<List<Customer>> findByEmail(@PathVariable("email") String email) {
//        try {
//            List<Customer> customers = customerRepository.findByEmail(email);
//            if (customers.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(customers, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
////    @GetMapping("/customers/transaction-type{transactionType}")
////    public ResponseEntity<List<Customer>> findByTransactionType(@PathVariable("transactionType") TransactionType transactionType) {
////        try {
////            List<Customer> customers = customerRepository.findByTransactionType(transactionType);
////            if (customers.isEmpty()) {
////                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
////            }
////            return new ResponseEntity<>(customers, HttpStatus.OK);
////        } catch (Exception e) {
////            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
////        }
////    }
}
