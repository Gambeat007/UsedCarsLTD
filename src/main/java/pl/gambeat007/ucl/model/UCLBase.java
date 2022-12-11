package pl.gambeat007.ucl.model;

import lombok.Getter;

import javax.persistence.*;

/**
 * This is a base class from where id is inherited from
 */

@Getter
@MappedSuperclass
public abstract class UCLBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
