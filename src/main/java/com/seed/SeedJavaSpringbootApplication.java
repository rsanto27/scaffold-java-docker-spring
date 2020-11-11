package com.seed;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seed.domain.Address;
import com.seed.domain.BilletPayment;
import com.seed.domain.CardPayment;
import com.seed.domain.Category;
import com.seed.domain.City;
import com.seed.domain.Client;
import com.seed.domain.Order;
import com.seed.domain.Payment;
import com.seed.domain.Product;
import com.seed.domain.State;
import com.seed.domain.enums.ClientType;
import com.seed.domain.enums.PaymentType;
import com.seed.repositories.AddressRepository;
import com.seed.repositories.CategoryRepository;
import com.seed.repositories.CityRepository;
import com.seed.repositories.ClientRepository;
import com.seed.repositories.OrderRepository;
import com.seed.repositories.PaymentRepository;
import com.seed.repositories.ProductRepository;
import com.seed.repositories.StateRepository;

@SpringBootApplication
public class SeedJavaSpringbootApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private PaymentRepository paymentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SeedJavaSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Office");
		Category cat2 = new Category(null, "Computing");
		
		Product p1 = new Product(null, "computer", 7000.00);
		Product p2 = new Product(null, "printer", 1500.00);
		Product p3 = new Product(null, "mouse", 110.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		State sta1 = new State(null, "New York");
		State sta2 = new State(null, "São Paulo");
		
		City cit1 = new City(null, "Syracuse", sta1);
		City cit2 = new City(null, "São Paulo", sta2);
		City cit3 = new City(null, "Campinas", sta2);
		
		sta1.getCities().addAll(Arrays.asList(cit1));
		sta2.getCities().addAll(Arrays.asList(cit2, cit3));
		
		stateRepository.saveAll(Arrays.asList(sta1, sta2));
		cityRepository.saveAll(Arrays.asList(cit1, cit2, cit3));
		
		Client cli1 = new Client(null, "Rodrigo C", "rodrigo@gmail.com", 
				"45911653028", ClientType.PHYSICAL_PERSON);
		cli1.getPhones().addAll(Arrays.asList("988439659"));
		
		Address a1 = new Address(null, "Fulano Avenue", "666", "near the river", "Grant Village", "2598", cli1, cit1);
		Address a2 = new Address(null, "Fulano Avenue", "666", "near the river", "Grant Village2", "2596", cli1, cit2);
		
		cli1.getAddresses().addAll(Arrays.asList(a1, a2));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(a1, a2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Order order1 = new Order(null, sdf.parse("11/11/2020 11:11"), cli1, a1);
		Order order2 = new Order(null, sdf.parse("11/11/2020 11:11"), cli1, a2);
		
		Payment pay1 = new CardPayment(null, PaymentType.PAID, order1, 6);
		order1.setPayment(pay1);
		
		Payment pay2 = new BilletPayment(null, PaymentType.PENDING, order2, sdf.parse("11/11/2020 11:11"), null);
		order2.setPayment(pay2);
		
		cli1.getOrders().addAll(Arrays.asList(order1, order2));
		
		orderRepository.saveAll(Arrays.asList(order1, order2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));
		

		
	}

}
