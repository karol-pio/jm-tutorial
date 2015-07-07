package com.acme.order;

import java.util.Date;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class PizzaOrderServiceTest {

	private PizzaOrderService pizzaOrderService;
	private MailSender mailSender;
	private OrderDatabase orderDatabase;
	private OrderFactory orderFactory;
	private DeliveryTimeService deliveryTimeService;
	private MessageTemplateService messageTemplate;

	private PizzaType pizzaType;


	@Before
	public void init() {
		mailSender = Mockito.mock(MailSender.class);
		orderDatabase = Mockito.mock(OrderDatabase.class);
		orderFactory = Mockito.mock(OrderFactory.class);
		deliveryTimeService = Mockito.mock(DeliveryTimeService.class);
		messageTemplate = Mockito.mock(MessageTemplateService.class);
		pizzaType = Mockito.mock(PizzaType.class);
		pizzaOrderService = new PizzaOrderService(mailSender, orderDatabase, orderFactory, deliveryTimeService,
				messageTemplate);

	}

	@Test
	public void cancelledOrderShouldBePersistedAndEmailShouldBeSent() {

		String pizzaOrderId = "fake_id";
		Customer customer = givenCustomer();

		PizzaOrder givenOrder = givenPizzaOrder();
		// stub
		OrderCanceledTemplate template = Mockito.mock(OrderCanceledTemplate.class);
		Mockito.when(orderDatabase.get(Mockito.anyString())).thenReturn(givenOrder);
		pizzaOrderService = new PizzaOrderService(mailSender, orderDatabase,
				orderFactory, deliveryTimeService, messageTemplate);
	}

	@Test
	public void cancelledOrderShouldBePersistedAndEmailShoudlBeSent() {
		// given
		String pizzaOrderId = "fake_id";
		PizzaOrder givenPizzaOrder = givenPizzaOrder();
		// stub
		OrderCanceledTemplate template = Mockito
				.mock(OrderCanceledTemplate.class);
		Mockito.when(orderDatabase.get(Mockito.anyString())).thenReturn(
				givenPizzaOrder);

		Mockito.when(messageTemplate.getCancelTemplate()).thenReturn(template);
		// when
		pizzaOrderService.cancelOrder(pizzaOrderId);
		// then

		Assert.assertTrue(givenOrder.isCancelled());
		ArgumentCaptor<String> sentEmailAddress = ArgumentCaptor.forClass(String.class);

		// Assert.assertTrue(sentEmailAddress.getValue().equals(givenOrder.getEmail()));

		Mockito.verify(mailSender).send(Mockito.any(Template.class), sentEmailAddress.capture());

		ArgumentCaptor<PizzaOrder> savedPizzaOrder = ArgumentCaptor.forClass(PizzaOrder.class);
		Mockito.verify(orderDatabase).save(savedPizzaOrder.capture());

		Assert.assertTrue(savedPizzaOrder.getValue().equals(givenOrder));

		Mockito.verify(orderDatabase).save(Mockito.any(PizzaOrder.class));

	}

	@Test
	public void createOrderShouldBePersistedAndEmailShouldBeSent() {

		String pizzaOrderId = "fake_id";
		Customer customer = givenCustomer();
		PizzaOrder givenOrder = givenPizzaOrder();
		Date date = new Date();
		// when
		pizzaOrderService.createOrder(customer, pizzaType);
		// then
		Assert.assertTrue(givenOrder.isCreated());
		ArgumentCaptor<String> sentEmailAddress = ArgumentCaptor.forClass(String.class);
		Mockito.verify(mailSender).send(Mockito.any(Template.class), sentEmailAddress.capture());

		// Mockito.verify(mailSender).send(Mockito.any(Template.class),
		// Mockito.anyString());

		Assert.assertTrue(givenPizzaOrder.isCancelled());
		ArgumentCaptor<String> sentEmailAddress = ArgumentCaptor
				.forClass(String.class);
		Mockito.verify(mailSender).send(Mockito.any(Template.class),
				sentEmailAddress.capture());
		Assert.assertTrue(sentEmailAddress.getValue().equals(
				givenPizzaOrder.getEmail()));

		ArgumentCaptor<PizzaOrder> savedPizzaOrder = ArgumentCaptor
				.forClass(PizzaOrder.class);
		Mockito.verify(orderDatabase).save(savedPizzaOrder.capture());
		
		Assert.assertTrue(savedPizzaOrder.getValue().equals(givenPizzaOrder));


	}

	private PizzaOrder givenPizzaOrder() {


		Customer customer = givenCustomer();
		PizzaType pizzaType = Mockito.mock(PizzaType.class);
		PizzaOrder pizzaOrder = new PizzaOrder(customer, pizzaType);
		return pizzaOrder;
	}

	private Customer givenCustomer() {
		String customerEmail = "fake_email";
		Customer customer = new Customer();
		return customer;
	}


		Customer customer = givenCustomer();
		PizzaType type = Mockito.mock(PizzaType.class);
		PizzaOrder givenOrder = new PizzaOrder(customer, type);
		return givenOrder;
	}

	private Customer givenCustomer() {
		// String customerEmail = "fake_email";
		Customer customer = new Customer();
		return customer;
	}

}
