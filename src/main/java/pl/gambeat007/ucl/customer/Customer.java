package pl.gambeat007.ucl.customer;

import lombok.Getter;
import lombok.Setter;

import pl.gambeat007.ucl.model.UCLBase;
//import pl.gambeat007.ucl.vehicle.Vehicle;

import javax.persistence.*;
//import java.util.List;

/**
 * For later use with application future updates
 */

@Getter
@Setter

@Entity
@Table(name = "customers")
public class Customer extends UCLBase {

//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "email")
//    private String email;
//
////    @Column(name = "transaction_type")
////    @Enumerated(EnumType.STRING)
////    private TransactionType transactionType;
//
//    @OneToMany
//    @JoinColumn(name="customer_id")
//    private List<Vehicle> vehicle;
//
//    public Customer() {
//    }
//
//    public Customer(String name, String email
//            //, TransactionType transactionType
//     )
//    {
//        this.name = name;
//        this.email = email;
////        this.transactionType = transactionType;
//    }
}
