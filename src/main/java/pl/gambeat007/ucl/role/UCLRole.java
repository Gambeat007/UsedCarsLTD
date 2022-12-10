package pl.gambeat007.ucl.role;

/**
 * This is a helper class with fuel types defined
 */

public enum UCLRole {

    // company owner -> access everywhere
    ROLE_OWNER,

    // company customer -> wider access than public
    ROLE_CUSTOMER,

    // most limited access -> few methods
    ROLE_PUBLIC
}
