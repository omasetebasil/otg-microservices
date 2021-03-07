package com.edureka.onthegoapp.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.edureka.onthegoapp.models.Country;
import com.edureka.onthegoapp.models.Currency;
import com.edureka.onthegoapp.models.CurrencyRate;
import com.edureka.onthegoapp.models.CustomerPaymentMode;
import com.edureka.onthegoapp.models.Driver;
import com.edureka.onthegoapp.models.DriverVehicle;
import com.edureka.onthegoapp.models.Location;
import com.edureka.onthegoapp.models.MapGrid;
import com.edureka.onthegoapp.models.Payment;
import com.edureka.onthegoapp.models.PaymentMode;
import com.edureka.onthegoapp.models.Rider;
import com.edureka.onthegoapp.models.Vehicle;
import com.edureka.onthegoapp.models.VehicleCategory;
import com.edureka.onthegoapp.repositories.CountryRepository;
import com.edureka.onthegoapp.repositories.CurrencyRateRepository;
import com.edureka.onthegoapp.repositories.CurrencyRepository;
import com.edureka.onthegoapp.repositories.CustomerPaymentModeRepository;
import com.edureka.onthegoapp.repositories.DriverRepository;
import com.edureka.onthegoapp.repositories.DriverVehicleRepository;
import com.edureka.onthegoapp.repositories.LocationRepository;
import com.edureka.onthegoapp.repositories.MapGridRepository;
import com.edureka.onthegoapp.repositories.PaymentModeRepository;
import com.edureka.onthegoapp.repositories.PaymentRepository;
import com.edureka.onthegoapp.repositories.RiderRepository;
import com.edureka.onthegoapp.repositories.VehicleCategoryRepository;
import com.edureka.onthegoapp.repositories.VehicleRepository;

@Service
public class SetupsService implements SetupsServiceImpl {
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private PaymentModeRepository paymentModeRepository;
	@Autowired
	private CustomerPaymentModeRepository customerPaymentModeRepository;
	@Autowired
	private VehicleCategoryRepository vehicleCategoryRepository;
	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private DriverVehicleRepository driverVehicleRepository;
	@Autowired
	private RiderRepository riderRepository;
	@Autowired
	private CurrencyRepository currencyRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private MapGridRepository mapGridRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private CurrencyRateRepository currencyRateRepository;
	
	public List<Country> getAllCountries(){
		return countryRepository.findAll();
	}
    public Optional<Country> getCountryById(Long countryId){
    	        return countryRepository.findById(countryId);
    }
    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }
    public void deleteCountry(long id) {
    	countryRepository.deleteById(id);
    }
    ////////////////////////////////
	public List<PaymentMode> getAllPaymentMode(){
		return paymentModeRepository.findAll();
	}
    public Optional<PaymentMode> getPaymentModeById(Long paymentModeId){
    	        return paymentModeRepository.findById(paymentModeId);
    }
    public PaymentMode createPaymentMode(PaymentMode paymentMode) {
        return paymentModeRepository.save(paymentMode);
    }
    public void deletePaymentMode(long id) {
    	paymentModeRepository.deleteById(id);
    }
    ////////////////////////////////
	public List<CustomerPaymentMode> getAllCustomerPaymentMode(){
		return customerPaymentModeRepository.findAll();
	}
    public Optional<CustomerPaymentMode> getCustomerPaymentModeById(Long customerPaymentMode){
    	        return customerPaymentModeRepository.findById(customerPaymentMode);
    }
    public CustomerPaymentMode createCustomerPaymentMode(CustomerPaymentMode customerPaymentMode) {
        return customerPaymentModeRepository.save(customerPaymentMode);
    }
    public void deleteCustomerPaymentMode(long id) {
    	customerPaymentModeRepository.deleteById(id);
    }

    ////////////////////////////////
	public List<VehicleCategory> getAllVehicleCategories(){
		return vehicleCategoryRepository.findAll();
	}
    public Optional<VehicleCategory> getVehicleCategoryById(Long id){
    	        return vehicleCategoryRepository.findById(id);
    }
    public VehicleCategory createVehicleCategory(VehicleCategory vehicleCategory) {
        return vehicleCategoryRepository.save(vehicleCategory);
    }
    public void deleteVehicleCategory(long id) {
    	vehicleCategoryRepository.deleteById(id);
    }

    ////////////////////////////////
	public List<Driver> getAllDrivers(){
		return driverRepository.findAll();
	}
    public Optional<Driver> getDriverById(Long id){
    	        return driverRepository.findById(id);
    }
    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }
    public void deleteDriver(long id) {
    	driverRepository.deleteById(id);
    }

    ////////////////////////////////
	public List<Vehicle> getAllVehicles(){
		return vehicleRepository.findAll();
	}
    public Optional<Vehicle> getVehicleById(Long id){
    	        return vehicleRepository.findById(id);
    }
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
    public void deleteVehicle(long id) {
    	vehicleRepository.deleteById(id);
    }
    
    ////////////////////////////////
	public List<DriverVehicle> getAllDriverVehicles(){
		return driverVehicleRepository.findAll();
	}
    public Optional<DriverVehicle> getDriverVehicleById(Long id){
    	        return driverVehicleRepository.findById(id);
    }
    public DriverVehicle createDriverVehicle(DriverVehicle driverVehicle) {
        return driverVehicleRepository.save(driverVehicle);
    }
    public void deleteDriverVehicle(long id) {
    	driverVehicleRepository.deleteById(id);
    }
    ////////////////////////////////
	public List<Rider> getAllRiders(){
		return riderRepository.findAll();
	}
    public Optional<Rider> getRiderById(Long id){
    	        return riderRepository.findById(id);
    }
    public Rider createRider(Rider rider) {
        return riderRepository.save(rider);
    }
    public void deleteRider(long id) {
    	riderRepository.deleteById(id);
    }
    ////////////////////////////////
	public List<Currency> getAllCurrencies(){
		return currencyRepository.findAll();
	}
    public Optional<Currency> getCurrencyById(Long id){
    	        return currencyRepository.findById(id);
    }
    public Currency createCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }
    public void deleteCurrency(long id) {
    	currencyRepository.deleteById(id);
    }
    ////////////////////////////////
	public List<Payment> getAllPayments(){
		return paymentRepository.findAll();
	}
    public Optional<Payment> getPaymentById(Long id){
    	        return paymentRepository.findById(id);
    }
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    public void deletePayment(long id) {
    	paymentRepository.deleteById(id);
    }
    ////////////////////////////////
	public List<MapGrid> getAllMapGrids(){
		return mapGridRepository.findAll();
	}
    public Optional<MapGrid> getMapGridById(Long id){
    	        return mapGridRepository.findById(id);
    }
    public MapGrid createMapGrid(MapGrid mapGrid) {
        return mapGridRepository.save(mapGrid);
    }
    public void deleteMapGrid(long id) {
    	mapGridRepository.deleteById(id);
    }
    ////////////////////////////////
	public List<Location> getAllLocations(){
		return locationRepository.findAll();
	}
    public Optional<Location> getLocationById(Long id){
    	        return locationRepository.findById(id);
    }
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }
    public void deleteLocation(long id) {
    	locationRepository.deleteById(id);
    }
    ////////////////////////////////
	public List<CurrencyRate> getAllCurrencyRates(){
		return currencyRateRepository.findAll();
	}
    public Optional<CurrencyRate> getCurrencyRateById(Long id){
    	        return currencyRateRepository.findById(id);
    }
    public CurrencyRate createCurrencyRate(CurrencyRate currencyRate) {
        return currencyRateRepository.save(currencyRate);
    }
    public void deleteCurrencyRate(long id) {
    	currencyRateRepository.deleteById(id);
    }
}
