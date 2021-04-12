package com.edureka.onthegoapp.services;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import javax.validation.Valid;

import com.edureka.onthegoapp.dtos.LoginRequest;
import com.edureka.onthegoapp.dtos.LoginResponse;
import com.edureka.onthegoapp.enums.ErrorCode;
import com.edureka.onthegoapp.exception.ResourceNotFoundException;
import com.edureka.onthegoapp.models.*;
import com.edureka.onthegoapp.models.Currency;
import com.edureka.onthegoapp.repositories.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SetupsService implements SetupsServiceImpl {
    @Autowired
    JdbcTemplate jdbcTemplate;
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
    @Autowired
    private ParameterRepository parameterRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private PaymentAllocationRepository paymentAllocationRepository;
    @Autowired
    private WithdrawalRepository withdrawalRepository;

    private static final String TRATE_SQL_QUERY = "select max(trate_amt)trate_amt  from transport_rate";

    private static final String  trateAmt = "trate_amt";

    private static String RECEIVABLES_SQL_QUERY = "select SUM(CASE pymt_drcr WHEN 'C' THEN -pymt_amt ELSE pymt_amt END) AS pymt_amt  from payment,payment_allocations where pytalloc_pyt_id=pyt_id and pytalloc_driv_id=:driv_id";

    private static final String  pytAmt = "pymt_amt";

    private static String WITHDRAWAL_SQL_QUERY = "select SUM(CASE wtl_drcr WHEN 'C' THEN -wtl_amt ELSE wtl_amt END) AS wtl_amt  from withdrawal where wtl_driv_id=:driv_id";

    private static final String  wtlAmt = "wtl_amt";

    private static String PAYMENT_SQL_QUERY = "select pyt_id, pymt_drcr, pymt_date, pymt_amt, pyt_cur_id  from payment,payment_allocations where pytalloc_pyt_id=pyt_id and pytalloc_rid_id=:rid_id order by pyt_id desc";

    private static final String  id = "pyt_id";
    private static final String  pymtDrcr = "pymt_drcr";
    private static final String  pymtDate = "pymt_date";
    private static final String  pymtAmt = "pymt_amt";
    private static final String  curId = "pyt_cur_id";
	
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
    public Optional<Driver> getDriverByStatus(String status){
        return driverRepository.findByCessionActive(status);
    }
    public Optional<Driver> getDriverByIdNoOrMobileNo(String idmobNo){
        return driverRepository.findByByIdNoOrMobileNo(idmobNo);
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
    public Optional<Rider> getRiderByIdNoOrMobileNo(String idmobNo){
        return riderRepository.findByByIdNoOrMobileNo(idmobNo);
    }
    public Rider createRider(Rider rider) {
        LoginResponse loginResponse = this.getAuthenticationToken();

        System.out.println("loginResponse.getTokenType(): "+loginResponse.getTokenType());
        System.out.println("loginResponse.getAccessToken(): "+loginResponse.getAccessToken());

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
    public List<Payment> getPaymentsByRiderId(Long riderid) {
        PAYMENT_SQL_QUERY =
                PAYMENT_SQL_QUERY.replaceAll(":rid_id", riderid != null ? "'" + riderid +
                        "'" : "null");
        Collection<Map<String, Object>> rows = jdbcTemplate.queryForList(PAYMENT_SQL_QUERY);
        List<Payment> paymentsList = new ArrayList<>();
        rows.stream().map((row) -> {
            Payment payment = new Payment();
            payment.setId((Integer) row.get(id));
            payment.setPymtDrcr((String) row.get(pymtDrcr));
            payment.setPymtDate((java.sql.Date)(row.get(pymtDate)));
            payment.setPymtAmt((Integer) row.get(pymtAmt));
            payment.setCurId((Integer) (row.get(curId)));
            return payment;
        }).forEach((ss) -> {
            paymentsList.add(ss);
        });
        return paymentsList;

    }
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    public void deletePayment(long id) {
    	paymentRepository.deleteById(id);
    }
    public PaymentResponse createPaymentRecord(PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse=new PaymentResponse();;
        Payment payment=new Payment();
        payment.setPymtAmt(paymentRequest.getPymtAmt());
        payment.setPymtDate(new Date());
        payment.setPymtDrcr("C");
        payment.setPymtReason(paymentRequest.getPymtReason());
        payment.setCurId(paymentRequest.getCurId());
        System.out.println("payment=="+payment);
        Payment pymt=paymentRepository.save(payment);
        Trip trips =tripRepository.findByTripId(paymentRequest.getTripId());
        if (trips==null) {
            paymentResponse.setMessage("Cannot get trip details");
            paymentResponse.setSuccess(false);
        }else {
            PaymentAllocation paymentAllocation = new PaymentAllocation();
            paymentAllocation.setDrivId(trips.getDrivId());
            paymentAllocation.setPytId(payment.getId());
            paymentAllocation.setRidId(trips.getRidId());
            paymentAllocation.setTripId(trips.getId());
            paymentAllocationRepository.save(paymentAllocation);
            paymentResponse.setMessage("Payment details saved Successfully");
            paymentResponse.setSuccess(true);
            paymentResponse.setPaymentId(payment.getId());
        }
        return paymentResponse;
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
////////////////////////////////////////////
public Parameter findParameter(String name) {
    List<Parameter> parameters = parameterRepository.findByParamName(name);
    return parameters.size() > 0 ? parameters.get(0) : null;
}
    ////////////////////////////////////////////
public LoginResponse getAuthenticationToken() {
        LoginResponse response = LoginResponse.builder()
                .success(false)
                .build();
        try {

            Parameter urlParam = findParameter("AUTH_SERVICE_URL");
            Parameter usernameParam = findParameter("AUTH_USERNAME");
            Parameter secretKeyParam = findParameter("AUTH_SECRET_KEY");
            String loginUrl = urlParam.getParamValue();
            String username = usernameParam.getParamValue();
            String secretKey = secretKeyParam.getParamValue();
            //get from database and not the url

            if (loginUrl == null || username == null || secretKey == null) {
                return response;
            }

            //if no valid token found,get from portal
            ObjectMapper objectMapper = new ObjectMapper();
            LoginRequest request = LoginRequest.builder()
                    .grant_type("password")
                    .username(username)
                    .password(secretKey)
                    .client_id("webapp")
                    .client_secret("websecret")
                    .build();
            HttpResponse< String > serverResponse = Unirest.post(loginUrl)
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Cache-Control", "no-cache")
                    .header("Postman-Token", "b7e8d8db-d9ff-415e-84ed-76726a52d802")
                    .body("grant_type=password&username=" + username + "&password=" + secretKey + "&client_id=webapp" + "&client_secret=websecret")
                    .asString();
            response.setCode(Long.valueOf(serverResponse.getStatus()));
         //   System.out.println("Request: "+request);
            //  log.info("serviceProviderAuthUrl: "+serviceProviderAuthUrl);
          //  System.out.println("Response Status: " + serverResponse.getStatus());
           // response = objectMapper.readValue(serverResponse.getRawBody(), LoginResponse.class);
          //  System.out.println("Response Body: " + serverResponse.getBody());
            //  log.info("Response Code: "+serverResponse.getStatus());
            //log.info("responseCode: "+response.getCode());
            if (response == null) {
                return response;
            } else if (200 == serverResponse.getStatus()) {
                //insert to the token database
                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(serverResponse.getBody().toString());
                Long code = Long.valueOf(serverResponse.getStatus());
                if (200 == serverResponse.getStatus()) {
                    response.setSuccess(true);
                    response.setAccessToken((String) json.get("access_token"));
                    response.setTokenType((String) json.get("token_type"));
                    response.setRefreshToken((String) json.get("refresh_token"));
                 //   response.setExpires((String) json.get("expires_in"));
                    response.setScope((String) json.get("scope"));
                    response.setJti((String) json.get("jti"));
                    response.setCode(code);
                }
             //   System.out.println("response=="+response);
                return response;
            } else {
                return objectMapper.readValue(serverResponse.getRawBody(), LoginResponse.class);
            }
        } catch (MalformedURLException exc) {
            response.setCode(Long.valueOf(ErrorCode.FAILED_REQUEST.getCode()));
            response.setErrorDescription(ErrorCode.FAILED_REQUEST.getDescription().concat("-" + exc.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(Long.valueOf(ErrorCode.FAILED_REQUEST.getCode()));
            response.setErrorDescription(ErrorCode.FAILED_REQUEST.getDescription().concat("-" + e.getMessage()));
        }
        return response;
    }
    ////////////////////////////////
    public List<Trip> getAllTrips(){
        return tripRepository.findAll();
    }
    public Optional<Trip> getTripById(Long id){
        return tripRepository.findById(id);
    }
    public Trip createTrip(Trip trip) {
	    System.out.println("trip=="+trip);
        return tripRepository.save(trip);
    }
    public void deleteTrip(long id) {
        tripRepository.deleteById(id);
    }
    public Optional<Trip> getTripByDrivId(Long id){
        return tripRepository.findByDrivId(id);
    }
    public Optional<Trip> getTripByRidId(Long id){
        return tripRepository.findByRidId(id);
    }
    ////////////////////////////////
    public int getExpenses() {
        return jdbcTemplate.queryForObject(TRATE_SQL_QUERY, Integer.class);

    }
    public ResponseEntity<Trip> getTransportCharges(Trip trip)
            throws ResourceNotFoundException {
        Trip trips=null;
	    int trateAmt=getExpenses();
        trip.setBasicAmt(trateAmt);
        trip.setGrossAmt(trateAmt);

        trips =tripRepository.checkPaidTrips(trip.getId(),"PENDING")
                .orElseThrow(() -> new ResourceNotFoundException("trip for this id :: " + trip.getId() +" Cannot be found/has already been paid"));
        if(trips !=null) {
            tripRepository.save(trip);
            trips =tripRepository.findById(trip.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("trip for this id :: " + trip.getId() +" Cannot be found"));
        }
        return ResponseEntity.ok().body(trips);
    }
    ////////////////////////////////
    public List<Withdrawal> getAllWithdrawals(){
        return withdrawalRepository.findAll();
    }
    public Optional<Withdrawal> getWithdrawalById(Long id){

	    return withdrawalRepository.findById(id);
    }
    public Withdrawal createWithdrawal(WithdrawalRequest withdrawalRequest) {
        Withdrawal withdrawal=null;
        withdrawal.setCurId(withdrawalRequest.getCurId());
        withdrawal.setDrivId(withdrawalRequest.getDrivId());
        withdrawal.setWtlAmt(withdrawalRequest.getWtlAmt());
        withdrawal.setWtlDate(new Date());
        withdrawal.setWtlDrcr("C");
	    return withdrawalRepository.save(withdrawal);
    }
    public void deleteWithdrawal(long id) {
        withdrawalRepository.deleteById(id);
    }
    public Optional<Withdrawal> getWithdrawalByDriverId(Long id){

        return withdrawalRepository.findByDrivId(id);
    }
    ////////////////////////////////
    public int getDriverReceivables(Long drivId) {
        RECEIVABLES_SQL_QUERY =
                RECEIVABLES_SQL_QUERY.replaceAll(":driv_id", drivId != null ? "'" + drivId +
                        "'" : "null");
        return jdbcTemplate.queryForObject(RECEIVABLES_SQL_QUERY, Integer.class);

    }
    ////////////////////////////////
    public int getDriverWithdrawals(Long drivId) {
        WITHDRAWAL_SQL_QUERY =
                WITHDRAWAL_SQL_QUERY.replaceAll(":driv_id", drivId != null ? "'" + drivId +
                        "'" : "null");
        return jdbcTemplate.queryForObject(WITHDRAWAL_SQL_QUERY, Integer.class);

    }
    ////////////////////////////////
    public int getDriverBalanceById(Long drivid){
        int receivables=0;
        int withdrawals=0;
        int balance=0;
        receivables=getDriverReceivables(drivid);
        withdrawals=getDriverWithdrawals(drivid);
        balance=receivables-withdrawals;
        return balance;
    }
}
