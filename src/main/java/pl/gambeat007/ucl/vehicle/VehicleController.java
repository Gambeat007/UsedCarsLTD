package pl.gambeat007.ucl.vehicle;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gambeat007.ucl.model.FuelType;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ucl")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    @GetMapping("/vehicles/make{make}")
    public ResponseEntity<List<Vehicle>> findByMake(@PathVariable("make") String make) {
        try {
            List<Vehicle> vehicles = vehicleRepository.findByMake(make);
            if (vehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/vehicles/add")
    public ResponseEntity<Vehicle> addVehicle (@RequestBody Vehicle vehicle) {
        try {
            Vehicle _vehicle = vehicleRepository.save(new Vehicle(vehicle.getMake(), vehicle.getModel(),
                    vehicle.getProdYear(), vehicle.getPrice(), vehicle.getFuelType()));
            return new ResponseEntity<>(_vehicle, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/vehicles/update-all{id}")
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
    public ResponseEntity<Vehicle> updateVehiclePrice(@PathVariable long id, @RequestBody Vehicle vehicle) {
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
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable long id) {
        try {
            vehicleRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vehicles/model{model}")
    public ResponseEntity<List<Vehicle>> findByModel(@PathVariable("model") String model) {
        try {
            List<Vehicle> vehicles = vehicleRepository.findByModel(model);
            if (vehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vehicles/prod-year{prodYear}")
    public ResponseEntity<List<Vehicle>> findByProdYear (@PathVariable("prodYear") int prodYear) {
        try {
            List<Vehicle> vehicles = vehicleRepository.findByProdYear(prodYear);
            if (vehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vehicles/cheaper-than-given-price{price}")
    public ResponseEntity<List<Vehicle>> findCheaperThanGivenPrice (@PathVariable("price") double price) {
        try {
            List<Vehicle> vehicles = vehicleRepository.findCheaperThan(price);
            if (vehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vehicles/fuel-type{fuelType}")
    public ResponseEntity<List<Vehicle>> findByFuelType (@PathVariable("fuelType") FuelType fuelType) {
        try {
            List<Vehicle> vehicles = vehicleRepository.findByFuelType(fuelType);
            if (vehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
