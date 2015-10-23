package test.bean;

import net.cassite.pure.data.Data;
import net.cassite.pure.data.DataComparable;
import net.cassite.pure.data.DataIterable;
import net.cassite.pure.data.DataUtils;

import javax.persistence.*;
import java.util.*;

@Entity
public class User {
    public DataComparable<Integer> id = new DataComparable<Integer>(this);
    public Data<String> type = new Data<String>(this);
    public Data<String> name = new Data<String>(this);
    public Data<String> gender = new Data<String>(this);
    public Data<String> phone = new Data<String>(this);
    public Data<String> username = new Data<String>(this);
    public Data<String> password = new Data<String>(this);
    public DataComparable<Date> addtime = new DataComparable<Date>(this);
    public Data<Clinic> clinic = new Data<Clinic>(this);
    public DataIterable<Outpatient, Set<Outpatient>> outpatients = new DataIterable<>(new HashSet<>(), this);

    @ManyToOne
    public Clinic getClinic() {
        return clinic.get();
    }

    public void setClinic(Clinic clinic) {
        DataUtils.set(this.clinic, clinic);
    }

    @OneToMany(mappedBy = "user")
    public Set<Outpatient> getOutpatients() {
        return outpatients.get();
    }

    public void setOutpatients(Set<Outpatient> outpatients) {
        DataUtils.set(this.outpatients, outpatients);
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        DataUtils.set(this.id, id);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        DataUtils.set(this.type, type);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        DataUtils.set(this.name, name);
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        DataUtils.set(this.gender, gender);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        DataUtils.set(this.phone, phone);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        DataUtils.set(this.username, username);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        DataUtils.set(this.password, password);
    }

    public Date getAddtime() {
        return addtime.get();
    }

    public void setAddtime(Date addtime) {
        DataUtils.set(this.addtime, addtime);
    }
}
