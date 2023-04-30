#include <Wire.h>
#include <BH1750.h>

//Global variables
BH1750 light_Meter;

void setup() {
  Serial.begin(9600);

  //Initialize the I2c bus
  Wire.begin();

  light_Meter.begin();

  Serial.println(F("BH1750 Test begin"));

}

void loop() {
  float lux = light_Meter.readLightLevel();
  Serial.print("Light : ");
  Serial.print(lux);
  Serial.println(" lx");
  delay(1000);
}
