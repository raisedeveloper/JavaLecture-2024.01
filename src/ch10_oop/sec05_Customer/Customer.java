package ch10_oop.sec05_Customer;

import java.util.Objects;

public class Customer {
private int cid;
private String name;
private int age;
private boolean adult;
public Customer() {
	super();

}
public Customer(int cid, String name, int age, boolean adult) {
	super();
	this.cid = cid;
	this.name = name;
	this.age = age;
	this.adult = adult;
}

@Override
public int hashCode() {
	return Objects.hash(this.cid, this.age); // cid 값과 age 값으로 해쉬코드를 만들것이다 라는 뜻임
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Customer other = (Customer) obj;
	return adult == other.adult && age == other.age && cid == other.cid && Objects.equals(name, other.name);
}




@Override
public String toString() {
	return "Customer [cid=" + cid + ", name=" + name + ", age=" + age + ", adult=" + adult + "]";
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public boolean isAdult() {
	return adult;
}
public void setAdult(boolean adult) {
	this.adult = adult;
}

}