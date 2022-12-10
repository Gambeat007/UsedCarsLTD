package pl.gambeat007.ucl.vehicle;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ucl")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    @GetMapping("/vehicles")
    @PreAuthorize("hasRole('PUBLIC')")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        try {
            return new ResponseEntity<>(vehicleRepository.findAll(), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vehicles/by-make{make}")
    @PreAuthorize("hasRole('PUBLIC')")
    public ResponseEntity<List<Vehicle>> findByMake(String make) {
        try {
            List<Vehicle> vehicles = vehicleRepository.findByMake(make);
            if (vehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vehicles/by-model{model}")
    @PreAuthorize("hasRole('PUBLIC')")
    public ResponseEntity<List<Vehicle>> findByModel(String model) {
        try {
            List<Vehicle> vehicles = vehicleRepository.findByModel(model);
            if (vehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vehicles/by-production-year{prodYear}")
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<List<Vehicle>> findByProdYear (int prodYear) {
        try {
            List<Vehicle> vehicles = vehicleRepository.findByProdYear(prodYear);
            if (vehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vehicles/by-fuel-type{fuelType}")
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<List<Vehicle>> findByFuelType (FuelType fuelType) {
        try {
            List<Vehicle> vehicles = vehicleRepository.findByFuelType(fuelType);
            if (vehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vehicles/by-price{price}")
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<List<Vehicle>> findCheaperThanGivenPrice (double price) {
        try {
            List<Vehicle> vehicles = vehicleRepository.findCheaperThan(price);
            if (vehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/vehicles/add-new")
    // ROLE_OWNER -> unlimited access
    @PreAuthorize("hasRole('OWNER')")
    public ResponseEntity<Vehicle> addVehicle (@RequestBody Vehicle vehicle) {
        try {
            Vehicle _vehicle = vehicleRepository.save(new Vehicle(vehicle.getMake(), vehicle.getModel(),
                    vehicle.getProdYear(), vehicle.getPrice(), vehicle.getFuelType()));
            return new ResponseEntity<>(_vehicle, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/vehicles/update{id}")
    @PreAuthorize("hasRole('OWNER')")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") long id, @RequestBody Vehicle vehicle) {
        Optional<Vehicle> vehicleToUpdate = vehicleRepository.findById(id);
        if (vehicleToUpdate.isPresent()) {
            Vehicle _vehicle = vehicleToUpdate.get();
            _vehicle.setMake(vehicle.getMake());
            _vehicle.setModel(vehicle.getModel());
            _vehicle.setProdYear(vehicle.getProdYear());
            _vehicle.setPrice(vehicle.getPrice());
            _vehicle.setFuelType(vehicle.getFuelType());
            return new ResponseEntity<>(vehicleRepository.save(_vehicle), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/vehicles/update-price{id}")
    @PreAuthorize("hasRole('OWNER')")
    public ResponseEntity<Vehicle> updateVehiclePrice(@PathVariable ("id") long id, @RequestBody Vehicle vehicle) {
        Optional<Vehicle> vehicleToUpdate = vehicleRepository.findById(id);
        if(vehicleToUpdate.isPresent()) {
            Vehicle _vehicle = vehicleToUpdate.get();
            _vehicle.setPrice(_vehicle.getPrice());
            return new ResponseEntity<>(vehicleRepository.save(_vehicle), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/vehicles/delete{id}")
    @PreAuthorize("hasRole('OWNER')")
    public ResponseEntity<Vehicle> deleteVehicle(long id) {
        try {
            vehicleRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
