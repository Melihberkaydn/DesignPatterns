package FacadePattern.ecommerce;

public class ECommerceFacade {

    private OrderController orderController;
    private ShippingController shippingController;
    private AdvertisementController advertisementController;

    public ECommerceFacade() {
        this.orderController = new OrderController();
        this.shippingController = new ShippingController();
        this.advertisementController = new AdvertisementController();
    }

    public void processOrder(Order order) {
        orderController.processOrder(order);
    }

    public void processOrder(Order order, String phoneNumber) {
        orderController.processOrder(order, phoneNumber);
    }

    public Order retrieveLatestOrder(int id) {
        return orderController.retrieveLatestOrder(id);
    }

    public void playAdvertisement(int ageRestriction) {
        advertisementController.playAdvertisement(ageRestriction);
    }

    public void shipOrder(Order order, String address) {
        Shipping shipping = shippingController.createShipping(address);
        order.setShipping(shipping);
        shippingController.shipOrder(order);
    }
}
