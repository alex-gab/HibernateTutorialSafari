package com.infiniteskills.data.entities;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "finances_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Set<Account> accounts = new HashSet<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Credential credential;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTH_DATE", nullable = false)
    private Date birthDate;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @ElementCollection
    @CollectionTable(name = "user_address", joinColumns = @JoinColumn(name = "USER_ID"))
    @AttributeOverrides({@AttributeOverride(name = "addressLine1", column = @Column(name = "USER_ADDRESS_LINE_1")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "USER_ADDRESS_LINE_2"))})
    private List<Address> addresses = new ArrayList<>();

    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdDate;

    @Column(name = "CREATED_BY", updatable = false)
    private String createdBy;

    @Formula("lower(datediff(curdate(), birth_date)/365)")
    private int age;

    @Transient
    private boolean valid;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddress(Address address) {
        this.addresses.add(address);
    }

    public Credential getCredential() {
        return credential;
    }

    void setCredential(Credential credential) {
        this.credential = credential;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }


    public void addAccount(Account account) {
        accounts.add(account);
    }
}
