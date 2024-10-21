public class AdapterPattern {

    public static void main(String[] args) {
        MicroUSBCharger oldCharger = new MicroUSBCharger();
        USBTypeC adapter = new MicroUSBToUSBTypeCAdapter(oldCharger);

        adapter.chargeWithUSBTypeC();
    }
}


interface USBTypeC {
    void chargeWithUSBTypeC();
}

class MicroUSBCharger {
    void chargeWithMicroUSB() {
        System.out.println("Charging with micro-USB...");
    }
}

class MicroUSBToUSBTypeCAdapter implements USBTypeC {
    MicroUSBCharger microUSBCharger;

    public MicroUSBToUSBTypeCAdapter(MicroUSBCharger microUSBCharger) {
        this.microUSBCharger = microUSBCharger;
    }
    @Override
    public void chargeWithUSBTypeC() {
        microUSBCharger.chargeWithMicroUSB();
        System.out.println("Adapter: Charging with USB-C (via adapter)");
    }
}
