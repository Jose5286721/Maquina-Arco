package py.com.arco.maquina.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

@RestController
public class HomeController {

	GpioPinDigitalOutput pin;
	
	@GetMapping("/")
	public String home() {
		return "Hola a todos";
	}
	
	@GetMapping("/light")
	public String light() {
		if(pin!=null) {
			GpioController gpioController = GpioFactory.getInstance();
			pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_05,"led",PinState.LOW);
		}
		pin.toggle();
		return "ok";
	}
}
