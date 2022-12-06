package pl.gambeat007.ucl.customer;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.gambeat007.ucl.model.TransactionType;
import pl.gambeat007.ucl.model.UCLBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString

@Entity
@Table(name = "customers")
public class Customer extends UCLBase {

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "transaction_type")
    private TransactionType transactionType;

    public Customer() {
    }

    public Customer(String name, String email, String password, TransactionType transactionType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.transactionType = transactionType;
    }
}
