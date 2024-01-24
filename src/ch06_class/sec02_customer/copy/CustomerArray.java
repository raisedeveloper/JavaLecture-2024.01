package ch06_class.sec02_customer.copy;

public class CustomerArray {

	public static void main(String[] args) {
		Customer[] customers = new Customer[3]; // 의미 : 커스토머 객체를 3개를 받을 수 있음
		customers[0] = new Customer(1, "제임스", 27);
		customers[1] = new Customer(2, "마리아", 23);
		customers[2] = new Customer(3, "브라이언", 15);

		Customer[] customers2 = { new Customer(1, "제임스", 27), new Customer(2, "마리아", 23), new Customer(3, "브라이언", 15),
				new Customer(4, "엠마", 31) }; // 두 가지 형태가 다 쓰일까? 개념적으로 여러개를 쓰는 것은 맞고 'Array'대신 'List'를 씀

		// 잘 안쓰임 enhanced for 문
		for (int i = 0; i < customers.length; i++)
			System.out.println(customers[i]);
		for (Customer customer: customers)
			System.out.println(customers);
	}

}
