package com.edureka.onthegoapp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.edureka.onthegoapp.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.edureka.onthegoapp.exception.ResourceNotFoundException;
import com.edureka.onthegoapp.services.SetupsService;


@RestController
@RequestMapping("/api/v1")
public class SetupsController {
	@Autowired
	SetupsService setupsService;
	
    @PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/countries")
	public List<Country> getAllCountries(){
		return setupsService.getAllCountries();
	}
    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable(value = "id") Long countryId)
      throws ResourceNotFoundException {
    	Country country =setupsService.getCountryById(countryId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + countryId));
        return ResponseEntity.ok().body(country);
    }
    @PostMapping("/countries")
    public Country createCountry(@Valid @RequestBody Country country) {
        return setupsService.createCountry(country);
    }
    @DeleteMapping("/countries/{id}")
    public Map<String, Boolean> deleteCountry(@PathVariable(value = "id") Long countryId)
      throws ResourceNotFoundException {
    	Country country = setupsService.getCountryById(countryId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + countryId));

    	setupsService.deleteCountry(countryId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    /////////////////////////////////////////////////////////////
    
	@GetMapping("/paymentmodes")
	public List<PaymentMode> getAllPaymentModes(){
		return setupsService.getAllPaymentMode();
	}
    @GetMapping("/paymentmodes/{id}")
    public ResponseEntity<PaymentMode> getPaymentModeId(@PathVariable(value = "id") Long paymentModeId)
      throws ResourceNotFoundException {
    	PaymentMode paymentMode =setupsService.getPaymentModeById(paymentModeId)
          .orElseThrow(() -> new ResourceNotFoundException("PaymentMode not found for this id :: " + paymentModeId));
        return ResponseEntity.ok().body(paymentMode);
    }
    @PostMapping("/paymentmodes")
    public PaymentMode createPaymentMode(@Valid @RequestBody PaymentMode paymentMode) {
        return setupsService.createPaymentMode(paymentMode);
    }
    @DeleteMapping("/paymentmodes/{id}")
    public Map<String, Boolean> deletePaymentMode(@PathVariable(value = "id") Long paymentModeId)
      throws ResourceNotFoundException {
    	PaymentMode paymentMode = setupsService.getPaymentModeById(paymentModeId)
          .orElseThrow(() -> new ResourceNotFoundException("PaymentMode not found for this id :: " + paymentModeId));

    	setupsService.deletePaymentMode(paymentModeId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    /////////////////////////////////////////////////////////////
    
	@GetMapping("/customerpaymentmodes")
	public List<CustomerPaymentMode> getAllCustomerPaymentModes(){
		return setupsService.getAllCustomerPaymentMode();
	}
    @GetMapping("/customerpaymentmodes/{id}")
    public ResponseEntity<CustomerPaymentMode> getCustomerPaymentModeId(@PathVariable(value = "id") Long paymentModeId)
      throws ResourceNotFoundException {
    	CustomerPaymentMode paymentMode =setupsService.getCustomerPaymentModeById(paymentModeId)
          .orElseThrow(() -> new ResourceNotFoundException("PaymentMode not found for this id :: " + paymentModeId));
        return ResponseEntity.ok().body(paymentMode);
    }
    @PostMapping("/customerpaymentmodes")
    public CustomerPaymentMode createPaymentMode(@Valid @RequestBody CustomerPaymentMode paymentMode) {
        return setupsService.createCustomerPaymentMode(paymentMode);
    }
    @DeleteMapping("/customerpaymentmodes/{id}")
    public Map<String, Boolean> deleteCustomerPaymentMode(@PathVariable(value = "id") Long paymentModeId)
      throws ResourceNotFoundException {
    	CustomerPaymentMode paymentMode = setupsService.getCustomerPaymentModeById(paymentModeId)
          .orElseThrow(() -> new ResourceNotFoundException("PaymentMode not found for this id :: " + paymentModeId));

    	setupsService.deleteCustomerPaymentMode(paymentModeId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
 ///////////////////////////////////////////////////////////
	@GetMapping("/vehiclecategories")
	public List<VehicleCategory> getAllVehicleCategories(){
		return setupsService.getAllVehicleCategories();
	}
    @GetMapping("/vehiclecategories/{id}")
    public ResponseEntity<VehicleCategory> getVehicleCategoryById(@PathVariable(value = "id") Long id)
      throws ResourceNotFoundException {
    	VehicleCategory vehicleCategory =setupsService.getVehicleCategoryById(id)
          .orElseThrow(() -> new ResourceNotFoundException("vehicle category not found for this id :: " + id));
        return ResponseEntity.ok().body(vehicleCategory);
    }
    @PostMapping("/vehiclecategories")
    public VehicleCategory createVehicleCategory(@Valid @RequestBody VehicleCategory vehicleCategory) {
        return setupsService.createVehicleCategory(vehicleCategory);
    }
    @DeleteMapping("/vehiclecategories/{id}")
    public Map<String, Boolean> deleteVehicleCategory(@PathVariable(value = "id") Long id)
      throws ResourceNotFoundException {
    	VehicleCategory vehicleCategory = setupsService.getVehicleCategoryById(id)
          .orElseThrow(() -> new ResourceNotFoundException("vehicle category not found for this id :: " + id));

    	setupsService.deleteCountry(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    ///////////////////////////////////////////////////////////
   	@GetMapping("/drivers")
   	public List<Driver> getAllDrivers(){

        return setupsService.getAllDrivers();
   	}
       @GetMapping("/drivers/{id}")
       public ResponseEntity<Driver> getDriverById(@PathVariable(value = "id") Long id)
         throws ResourceNotFoundException {
    	   Driver driver =setupsService.getDriverById(id)
             .orElseThrow(() -> new ResourceNotFoundException("driver not found for this id :: " + id));
           return ResponseEntity.ok().body(driver);
       }
    @GetMapping("/driverstatus/{status}")
    public ResponseEntity<Driver> getDriverByStatus(@PathVariable(value = "status") String status)
            throws ResourceNotFoundException {
        Driver driver =setupsService.getDriverByStatus(status)
                .orElseThrow(() -> new ResourceNotFoundException("driver not found for this status :: " + status));
        return ResponseEntity.ok().body(driver);
    }
    @GetMapping("/driverbyidnoormobileno/{idmobNo}")
    public ResponseEntity<Driver> getDriverByIdNoOrMobileNo(@PathVariable(value = "idmobNo") String idmobNo)
            throws ResourceNotFoundException {
        Driver driver =setupsService.getDriverByIdNoOrMobileNo(idmobNo)
                .orElseThrow(() -> new ResourceNotFoundException("driver not found for this id/mobile no :: " + idmobNo));
        return ResponseEntity.ok().body(driver);
    }
       @PostMapping("/drivers")
       public Driver createDriver(@RequestBody Driver driver) {

        return setupsService.createDriver(driver);
       }
    @PutMapping("/updatedrivers")
    public Driver updateDriver(@RequestBody Driver driver) {

        return setupsService.createDriver(driver);
    }
       @DeleteMapping("/drivers/{id}")
       public Map<String, Boolean> deleteDriver(@PathVariable(value = "id") Long id)
         throws ResourceNotFoundException {
    	   Driver driver = setupsService.getDriverById(id)
             .orElseThrow(() -> new ResourceNotFoundException("vehicle category not found for this id :: " + id));

       	setupsService.deleteDriver(id);
           Map<String, Boolean> response = new HashMap<>();
           response.put("deleted", Boolean.TRUE);
           return response;
       }
       ///////////////////////////////////////////////////////////
      	@GetMapping("/vehicles")
      	public List<Vehicle> getAllVehicles(){
      		return setupsService.getAllVehicles();
      	}
          @GetMapping("/vehicles/{id}")
          public ResponseEntity<Vehicle> getVehicleById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        	  Vehicle vehicle =setupsService.getVehicleById(id)
                .orElseThrow(() -> new ResourceNotFoundException("vehicle not found for this id :: " + id));
              return ResponseEntity.ok().body(vehicle);
          }
          @PostMapping("/vehicles")
          public Vehicle createVehicle(@Valid @RequestBody Vehicle vehicle) {
              return setupsService.createVehicle(vehicle);
          }
          @DeleteMapping("/vehicles/{id}")
          public Map<String, Boolean> deleteVehicle(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        	  Vehicle vehicle = setupsService.getVehicleById(id)
                .orElseThrow(() -> new ResourceNotFoundException("vehicle category not found for this id :: " + id));

          	setupsService.deleteVehicle(id);
              Map<String, Boolean> response = new HashMap<>();
              response.put("deleted", Boolean.TRUE);
              return response;
          }
          ///////////////////////////////////////////////////////////
        	@GetMapping("/drivervehicles")
        	public List<DriverVehicle> getAllDriverVehicles(){
        		return setupsService.getAllDriverVehicles();
        	}
            @GetMapping("/drivervehicles/{id}")
            public ResponseEntity<DriverVehicle> getDriverVehicleById(@PathVariable(value = "id") Long id)
              throws ResourceNotFoundException {
            	DriverVehicle vehicle =setupsService.getDriverVehicleById(id)
                  .orElseThrow(() -> new ResourceNotFoundException("driver vehicle record not found for this id :: " + id));
                return ResponseEntity.ok().body(vehicle);
            }
            @PostMapping("/drivervehicles")
            public DriverVehicle createDriverVehicle(@Valid @RequestBody DriverVehicle vehicle) {
                return setupsService.createDriverVehicle(vehicle);
            }
            @DeleteMapping("/drivervehicles/{id}")
            public Map<String, Boolean> deleteDriverVehicle(@PathVariable(value = "id") Long id)
              throws ResourceNotFoundException {
            	DriverVehicle vehicle = setupsService.getDriverVehicleById(id)
                  .orElseThrow(() -> new ResourceNotFoundException("driver vehicle not found for this id :: " + id));

            	setupsService.deleteDriverVehicle(id);
                Map<String, Boolean> response = new HashMap<>();
                response.put("deleted", Boolean.TRUE);
                return response;
            }
            ///////////////////////////////////////////////////////////
          	@GetMapping("/riders")
          	public List<Rider> getAllRiders(){
          		return setupsService.getAllRiders();
          	}
              @GetMapping("/riders/{id}")
              public ResponseEntity<Rider> getRiderById(@PathVariable(value = "id") Long id)
                throws ResourceNotFoundException {
            	  Rider rider =setupsService.getRiderById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("rider's record not found for this id :: " + id));
                  return ResponseEntity.ok().body(rider);
              }
                @GetMapping("/riderbyidnoormobileno/{idmobNo}")
                public ResponseEntity<Rider> getRiderByByIdNoOrMobileNo(@PathVariable(value = "idmobNo") String idmobNo)
                        throws ResourceNotFoundException {
                    Rider rider =setupsService.getRiderByIdNoOrMobileNo(idmobNo)
                            .orElseThrow(() -> new ResourceNotFoundException("rider's record not found for this id/mobile number :: " + idmobNo));
                    return ResponseEntity.ok().body(rider);
                }
              @PostMapping("/riders")
              public Rider createRider(@Valid @RequestBody Rider rider) {
                  return setupsService.createRider(rider);
              }
            @PutMapping("/updateriders")
            public Rider updateRider(@Valid @RequestBody Rider rider) {
                return setupsService.createRider(rider);
            }
              @DeleteMapping("/riders/{id}")
              public Map<String, Boolean> deleteRider(@PathVariable(value = "id") Long id)
                throws ResourceNotFoundException {
            	  Rider rider = setupsService.getRiderById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("rider not found for this id :: " + id));

              	setupsService.deleteRider(id);
                  Map<String, Boolean> response = new HashMap<>();
                  response.put("deleted", Boolean.TRUE);
                  return response;
              }
              ///////////////////////////////////////////////////////////
            	@GetMapping("/currencies")
            	public List<Currency> getAllCurrencies(){
            		return setupsService.getAllCurrencies();
            	}
                @GetMapping("/currencies/{id}")
                public ResponseEntity<Currency> getCurrencyById(@PathVariable(value = "id") Long id)
                  throws ResourceNotFoundException {
                	Currency currency =setupsService.getCurrencyById(id)
                      .orElseThrow(() -> new ResourceNotFoundException("currency record not found for this id :: " + id));
                    return ResponseEntity.ok().body(currency);
                }
                @PostMapping("/currencies")
                public Currency createCurrency(@Valid @RequestBody Currency currency) {
                    return setupsService.createCurrency(currency);
                }
                @DeleteMapping("/currencies/{id}")
                public Map<String, Boolean> deleteCurrency(@PathVariable(value = "id") Long id)
                  throws ResourceNotFoundException {
                	Currency currency = setupsService.getCurrencyById(id)
                      .orElseThrow(() -> new ResourceNotFoundException("currency not found for this id :: " + id));

                	setupsService.deleteCurrency(id);
                    Map<String, Boolean> response = new HashMap<>();
                    response.put("deleted", Boolean.TRUE);
                    return response;
                }
                ///////////////////////////////////////////////////////////
              	@GetMapping("/payments")
              	public List<Payment> getAllPayments(){
                      return setupsService.getAllPayments();
              	}
                  @GetMapping("/payments/{id}")
                  public ResponseEntity<Payment> getPaymentById(@PathVariable(value = "id") Long id)
                    throws ResourceNotFoundException {
                	  Payment payment =setupsService.getPaymentById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("payment record not found for this id :: " + id));
                      return ResponseEntity.ok().body(payment);
                  }
                  @PostMapping("/generatepaymententry")
                  public PaymentResponse createPayment(@Valid @RequestBody PaymentRequest payment) {
                      return setupsService.createPaymentRecord(payment);
                  }
                  @DeleteMapping("/payments/{id}")
                  public Map<String, Boolean> deletePayment(@PathVariable(value = "id") Long id)
                    throws ResourceNotFoundException {
                	  Payment payment = setupsService.getPaymentById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("payment not found for this id :: " + id));

                  	setupsService.deletePayment(id);
                      Map<String, Boolean> response = new HashMap<>();
                      response.put("deleted", Boolean.TRUE);
                      return response;
                  }
                @GetMapping("/riderpayments/{riderid}")
                public List<Payment> getPaymentsByRiderId(@PathVariable(value = "riderid") Long riderid)
                         {
                    return setupsService.getPaymentsByRiderId(riderid);
                }
                  ///////////////////////////////////////////////////////////
                	@GetMapping("/mapgrids")
                	public List<MapGrid> getAllMapGrids(){
                		return setupsService.getAllMapGrids();
                	}
                    @GetMapping("/mapgrids/{id}")
                    public ResponseEntity<MapGrid> getMapGridById(@PathVariable(value = "id") Long id)
                      throws ResourceNotFoundException {
                    	MapGrid mapGrid =setupsService.getMapGridById(id)
                          .orElseThrow(() -> new ResourceNotFoundException("map grid record not found for this id :: " + id));
                        return ResponseEntity.ok().body(mapGrid);
                    }
                    @PostMapping("/mapgrids")
                    public MapGrid createMapGrid(@Valid @RequestBody MapGrid mapGrid) {
                        return setupsService.createMapGrid(mapGrid);
                    }
                    @DeleteMapping("/mapgrids/{id}")
                    public Map<String, Boolean> deleteMapGrid(@PathVariable(value = "id") Long id)
                      throws ResourceNotFoundException {
                    	MapGrid mapGrid = setupsService.getMapGridById(id)
                          .orElseThrow(() -> new ResourceNotFoundException("map grid not found for this id :: " + id));

                    	setupsService.deleteMapGrid(id);
                        Map<String, Boolean> response = new HashMap<>();
                        response.put("deleted", Boolean.TRUE);
                        return response;
                    }
                    ///////////////////////////////////////////////////////////
                  	@GetMapping("/locations")
                  	public List<Location> getAllLocations(){
                  		return setupsService.getAllLocations();
                  	}
                      @GetMapping("/locations/{id}")
                      public ResponseEntity<Location> getLocationById(@PathVariable(value = "id") Long id)
                        throws ResourceNotFoundException {
                    	  Location location =setupsService.getLocationById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("location record not found for this id :: " + id));
                          return ResponseEntity.ok().body(location);
                      }
                      @PostMapping("/locations")
                      public Location createLocation(@Valid @RequestBody Location location) {
                          return setupsService.createLocation(location);
                      }
                      @DeleteMapping("/locations/{id}")
                      public Map<String, Boolean> deleteLocation(@PathVariable(value = "id") Long id)
                        throws ResourceNotFoundException {
                    	  Location location = setupsService.getLocationById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("location not found for this id :: " + id));

                      	setupsService.deleteLocation(id);
                          Map<String, Boolean> response = new HashMap<>();
                          response.put("deleted", Boolean.TRUE);
                          return response;
                      }
                      ///////////////////////////////////////////////////////////
                    	@GetMapping("/currencyrates")
                    	public List<CurrencyRate> getAllCurrencyRates(){
                    		return setupsService.getAllCurrencyRates();
                    	}
                        @GetMapping("/currencyrates/{id}")
                        public ResponseEntity<CurrencyRate> getCurrencyRateById(@PathVariable(value = "id") Long id)
                          throws ResourceNotFoundException {
                        	CurrencyRate currencyRate =setupsService.getCurrencyRateById(id)
                              .orElseThrow(() -> new ResourceNotFoundException("currency rate record not found for this id :: " + id));
                            return ResponseEntity.ok().body(currencyRate);
                        }
                        @PostMapping("/currencyrates")
                        public CurrencyRate createCurrencyRate(@Valid @RequestBody CurrencyRate currencyRate) {
                            return setupsService.createCurrencyRate(currencyRate);
                        }
                        @DeleteMapping("/currencyrates/{id}")
                        public Map<String, Boolean> deleteCurrencyRate(@PathVariable(value = "id") Long id)
                          throws ResourceNotFoundException {
                        	CurrencyRate currencyRate = setupsService.getCurrencyRateById(id)
                              .orElseThrow(() -> new ResourceNotFoundException("currency rate not found for this id :: " + id));

                        	setupsService.deleteCurrencyRate(id);
                            Map<String, Boolean> response = new HashMap<>();
                            response.put("deleted", Boolean.TRUE);
                            return response;
                        }
    ///////////////////////////////////////////////////////////
    @GetMapping("/trips")
    public List<Trip> getAllTrips(){
        return setupsService.getAllTrips();
    }
    @GetMapping("/trips/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Trip trip =setupsService.getTripById(id)
                .orElseThrow(() -> new ResourceNotFoundException("trip not found for this id :: " + id));
        return ResponseEntity.ok().body(trip);
    }
    @PutMapping("/updatetrips")
    public Trip updateTrip(@RequestBody Trip trip) {

        return setupsService.createTrip(trip);
    }
    @PostMapping("/trips")
    public Trip createTrip(@RequestBody Trip trip) {

        return setupsService.createTrip(trip);
    }
    @DeleteMapping("/trips/{id}")
    public Map<String, Boolean> deleteTrip(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Trip trip = setupsService.getTripById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found for this id :: " + id));

        setupsService.deleteTrip(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @GetMapping("/drivertrips/{id}")
    public ResponseEntity<Trip> getTripByDrivId(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Trip trip =setupsService.getTripByDrivId(id)
                .orElseThrow(() -> new ResourceNotFoundException("trip not found for this id :: " + id));
        return ResponseEntity.ok().body(trip);
    }
    @GetMapping("/ridertrips/{id}")
    public ResponseEntity<Trip> getTripByRidId(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Trip trip =setupsService.getTripByRidId(id)
                .orElseThrow(() -> new ResourceNotFoundException("trip not found for this id :: " + id));
        return ResponseEntity.ok().body(trip);
    }
    @PutMapping("/getTripPaymentCharges")
    public ResponseEntity<Trip> getTripPaymentCharges(@RequestBody Trip trip)throws ResourceNotFoundException {
        return setupsService.getTransportCharges(trip);
    }
    ///////////////////////////////////////////////////////////
    @GetMapping("/withdrawals")
    public List<Withdrawal> getAllWithdrawals(){
        return setupsService.getAllWithdrawals();
    }
    @GetMapping("/withdrawals/{id}")
    public ResponseEntity<Withdrawal> getWithdrawalById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Withdrawal withdrawal =setupsService.getWithdrawalById(id)
                .orElseThrow(() -> new ResourceNotFoundException("withdrawal record not found for this id :: " + id));
        return ResponseEntity.ok().body(withdrawal);
    }
    @PostMapping("/generatewithdrawalentry")
    public Withdrawal createWithdrawal(@Valid @RequestBody WithdrawalRequest withdrawal) {
        return setupsService.createWithdrawal(withdrawal);
    }
    @DeleteMapping("/withdrawals/{id}")
    public Map<String, Boolean> deleteWithdrawal(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Withdrawal withdrawal = setupsService.getWithdrawalById(id)
                .orElseThrow(() -> new ResourceNotFoundException("withdrawal not found for this id :: " + id));

        setupsService.deleteWithdrawal(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @GetMapping("/driverwithdrawals/{driverid}")
    public ResponseEntity<Withdrawal> getWithdrawalByDriverId(@PathVariable(value = "driverid") Long driverid)
            throws ResourceNotFoundException {
        Withdrawal withdrawal =setupsService.getWithdrawalByDriverId(driverid)
                .orElseThrow(() -> new ResourceNotFoundException("withdrawal records not found for this driver id :: " + driverid));
        return ResponseEntity.ok().body(withdrawal);
    }
    //////////////////////////
    @GetMapping("/driverbalance/{driverid}")
    public int getDriverBalanceById(@PathVariable(value = "driverid") Long driverid)
            {
        return setupsService.getDriverBalanceById(driverid);
    }
}
