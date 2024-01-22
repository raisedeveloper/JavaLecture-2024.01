package ch12_interface.sec04_dao;

import java.util.List;

// DAO (Data Access Object) - DB에 엑세스하기 위한 코드
// DTO (Data Transfer Object) - DB에 엑세스할 때 사용되는 데이터 구조
public interface CustomerDao {
	Customer getCustomer(int cid);

	List<Customer> getCustomerList();

	void insertCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(int cid);

}
