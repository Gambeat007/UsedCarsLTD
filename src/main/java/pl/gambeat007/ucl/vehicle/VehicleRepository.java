package pl.gambeat007.ucl.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.gambeat007.ucl.model.FuelType;

import java.util.List;
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT vehicle FROM Vehicle vehicle WHERE vehicle.make=?1")
    List<Vehicle> findByMake(String make);

    @Query("SELECT vehicle FROM Vehicle vehicle WHERE vehicle.model=?1")
    List<Vehicle> findByModel(String model);

    @Query("SELECT vehicle FROM Vehicle vehicle WHERE vehicle.prodYear=?1")
    List<Vehicle> findByProdYear(int prodYear);

    @Query("SELECT vehicle FROM Vehicle vehicle WHERE vehicle.price<=?1")
    List<Vehicle> findCheaperThan(double price);

    @Query("SELECT vehicle FROM Vehicle vehicle WHERE vehicle.fuelType=?1")
    List<Vehicle> findByFuelType(FuelType fuelType);

}
