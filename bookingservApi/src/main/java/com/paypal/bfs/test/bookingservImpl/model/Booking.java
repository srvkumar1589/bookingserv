
package com.paypal.bfs.test.bookingservImpl.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


/**
 * Booking resource
 * <p>
 * Booking resource object
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "first_name",
        "last_name",
        "date_of_birth",
        "checkin_datetime",
        "checkout_datetime",
        "total_price",
        "deposit",
        "address_line1",
        "address_line2",
        "city",
        "state",
        "country",
        "zip_code"
})
@Entity
public class Booking {

    /**
     * Booking id
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Booking id")
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * First name
     * (Required)
     */
    @JsonProperty("first_name")
    @JsonPropertyDescription("First name")
    private String firstName;
    /**
     * Last name
     * (Required)
     */
    @JsonProperty("last_name")
    @JsonPropertyDescription("Last name")
    private String lastName;
    /**
     * Date of birth(yyyy/MM/dd)
     * (Required)
     */
    @JsonProperty("date_of_birth")
    @JsonPropertyDescription("Date of birth(yyyy-MM-dd)")
    private String dateOfBirth;
    /**
     * Checkin datetime
     * (Required)
     */
    @JsonProperty("checkin_datetime")
    @JsonPropertyDescription("Checkin datetime")
    private Date checkinDatetime;
    /**
     * Checkout datetime
     * (Required)
     */
    @JsonProperty("checkout_datetime")
    @JsonPropertyDescription("Checkout datetime")
    private Date checkoutDatetime;
    /**
     * Total Price
     * (Required)
     */
    @JsonProperty("total_price")
    @JsonPropertyDescription("Total Price")
    private Double totalPrice;
    /**
     * Deposit Money
     * (Required)
     */
    @JsonProperty("deposit")
    @JsonPropertyDescription("Deposit Money")
    private Double deposit;
    /**
     * address line 1
     * (Required)
     */
    @JsonProperty("address_line1")
    @JsonPropertyDescription("address line 1")
    private String addressLine1;
    /**
     * address line 2
     */
    @JsonProperty("address_line2")
    @JsonPropertyDescription("address line 2")
    private String addressLine2;
    /**
     * city
     * (Required)
     */
    @JsonProperty("city")
    @JsonPropertyDescription("city")
    private String city;
    /**
     * state
     * (Required)
     */
    @JsonProperty("state")
    @JsonPropertyDescription("state")
    private String state;
    /**
     * country
     * (Required)
     */
    @JsonProperty("country")
    @JsonPropertyDescription("country")
    private String country;
    /**
     * zip code
     * (Required)
     */
    @JsonProperty("zip_code")
    @JsonPropertyDescription("zip code")
    private String zipCode;
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Booking id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * Booking id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * First name
     * (Required)
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * First name
     * (Required)
     */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Last name
     * (Required)
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * Last name
     * (Required)
     */
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Date of birth(yyyy/MM/dd)
     * (Required)
     */
    @JsonProperty("date_of_birth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Date of birth(yyyy/MM/dd)
     * (Required)
     */
    @JsonProperty("date_of_birth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Checkin datetime
     * (Required)
     */
    @JsonProperty("checkin_datetime")
    public Date getCheckinDatetime() {
        return checkinDatetime;
    }

    /**
     * Checkin datetime
     * (Required)
     */
    @JsonProperty("checkin_datetime")
    public void setCheckinDatetime(Date checkinDatetime) {
        this.checkinDatetime = checkinDatetime;
    }

    /**
     * Checkout datetime
     * (Required)
     */
    @JsonProperty("checkout_datetime")
    public Date getCheckoutDatetime() {
        return checkoutDatetime;
    }

    /**
     * Checkout datetime
     * (Required)
     */
    @JsonProperty("checkout_datetime")
    public void setCheckoutDatetime(Date checkoutDatetime) {
        this.checkoutDatetime = checkoutDatetime;
    }

    /**
     * Total Price
     * (Required)
     */
    @JsonProperty("total_price")
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Total Price
     * (Required)
     */
    @JsonProperty("total_price")
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Deposit Money
     * (Required)
     */
    @JsonProperty("deposit")
    public Double getDeposit() {
        return deposit;
    }

    /**
     * Deposit Money
     * (Required)
     */
    @JsonProperty("deposit")
    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    /**
     * address line 1
     * (Required)
     */
    @JsonProperty("address_line1")
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * address line 1
     * (Required)
     */
    @JsonProperty("address_line1")
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * address line 2
     */
    @JsonProperty("address_line2")
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * address line 2
     */
    @JsonProperty("address_line2")
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * city
     * (Required)
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * city
     * (Required)
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * state
     * (Required)
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * state
     * (Required)
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * country
     * (Required)
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * country
     * (Required)
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * zip code
     * (Required)
     */
    @JsonProperty("zip_code")
    public String getZipCode() {
        return zipCode;
    }

    /**
     * zip code
     * (Required)
     */
    @JsonProperty("zip_code")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Booking.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null) ? "<null>" : this.firstName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null) ? "<null>" : this.lastName));
        sb.append(',');
        sb.append("dateOfBirth");
        sb.append('=');
        sb.append(((this.dateOfBirth == null) ? "<null>" : this.dateOfBirth));
        sb.append(',');
        sb.append("checkinDatetime");
        sb.append('=');
        sb.append(((this.checkinDatetime == null) ? "<null>" : this.checkinDatetime));
        sb.append(',');
        sb.append("checkoutDatetime");
        sb.append('=');
        sb.append(((this.checkoutDatetime == null) ? "<null>" : this.checkoutDatetime));
        sb.append(',');
        sb.append("totalPrice");
        sb.append('=');
        sb.append(((this.totalPrice == null) ? "<null>" : this.totalPrice));
        sb.append(',');
        sb.append("deposit");
        sb.append('=');
        sb.append(((this.deposit == null) ? "<null>" : this.deposit));
        sb.append(',');
        sb.append("addressLine1");
        sb.append('=');
        sb.append(((this.addressLine1 == null) ? "<null>" : this.addressLine1));
        sb.append(',');
        sb.append("addressLine2");
        sb.append('=');
        sb.append(((this.addressLine2 == null) ? "<null>" : this.addressLine2));
        sb.append(',');
        sb.append("city");
        sb.append('=');
        sb.append(((this.city == null) ? "<null>" : this.city));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null) ? "<null>" : this.state));
        sb.append(',');
        sb.append("country");
        sb.append('=');
        sb.append(((this.country == null) ? "<null>" : this.country));
        sb.append(',');
        sb.append("zipCode");
        sb.append('=');
        sb.append(((this.zipCode == null) ? "<null>" : this.zipCode));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
//        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.lastName == null) ? 0 : this.lastName.hashCode()));
        result = ((result * 31) + ((this.country == null) ? 0 : this.country.hashCode()));
        result = ((result * 31) + ((this.zipCode == null) ? 0 : this.zipCode.hashCode()));
        result = ((result * 31) + ((this.totalPrice == null) ? 0 : this.totalPrice.hashCode()));
        result = ((result * 31) + ((this.city == null) ? 0 : this.city.hashCode()));
        result = ((result * 31) + ((this.dateOfBirth == null) ? 0 : this.dateOfBirth.hashCode()));
        result = ((result * 31) + ((this.firstName == null) ? 0 : this.firstName.hashCode()));
        result = ((result * 31) + ((this.checkinDatetime == null) ? 0 : this.checkinDatetime.hashCode()));
        result = ((result * 31) + ((this.checkoutDatetime == null) ? 0 : this.checkoutDatetime.hashCode()));
        result = ((result * 31) + ((this.deposit == null) ? 0 : this.deposit.hashCode()));
        result = ((result * 31) + ((this.addressLine1 == null) ? 0 : this.addressLine1.hashCode()));
        result = ((result * 31) + ((this.addressLine2 == null) ? 0 : this.addressLine2.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.state == null) ? 0 : this.state.hashCode()));
//        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Booking) == false) {
            return false;
        }
        Booking rhs = ((Booking) other);
        return ((((((((((((((((this.lastName == rhs.lastName) || ((this.lastName != null) && this.lastName.equals(rhs.lastName))) && ((this.country == rhs.country) || ((this.country != null) && this.country.equals(rhs.country)))) && ((this.zipCode == rhs.zipCode) || ((this.zipCode != null) && this.zipCode.equals(rhs.zipCode)))) && ((this.totalPrice == rhs.totalPrice) || ((this.totalPrice != null) && this.totalPrice.equals(rhs.totalPrice)))) && ((this.city == rhs.city) || ((this.city != null) && this.city.equals(rhs.city)))) && ((this.dateOfBirth == rhs.dateOfBirth) || ((this.dateOfBirth != null) && this.dateOfBirth.equals(rhs.dateOfBirth)))) && ((this.firstName == rhs.firstName) || ((this.firstName != null) && this.firstName.equals(rhs.firstName)))) && ((this.checkinDatetime == rhs.checkinDatetime) || ((this.checkinDatetime != null) && this.checkinDatetime.equals(rhs.checkinDatetime)))) && ((this.checkoutDatetime == rhs.checkoutDatetime) || ((this.checkoutDatetime != null) && this.checkoutDatetime.equals(rhs.checkoutDatetime)))) && ((this.deposit == rhs.deposit) || ((this.deposit != null) && this.deposit.equals(rhs.deposit)))) && ((this.addressLine1 == rhs.addressLine1) || ((this.addressLine1 != null) && this.addressLine1.equals(rhs.addressLine1)))) && ((this.addressLine2 == rhs.addressLine2) || ((this.addressLine2 != null) && this.addressLine2.equals(rhs.addressLine2)))) && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id)))) && ((this.state == rhs.state) || ((this.state != null) && this.state.equals(rhs.state)))));
    }

}
