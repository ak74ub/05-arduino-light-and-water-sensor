#include "Adafruit_seesaw.h"
#include <stdio.h>

Adafruit_seesaw soil_sensor;
char output[20];
char str_temp[10];

void setup() {
  Serial.begin(9600);
  
  if (!soil_sensor.begin(0x36)) {
    Serial.println("sensor not found!");
    while(1) delay(1);
  }
}

void loop() {
  float soil_temp = soil_sensor.getTemp();
  uint16_t soil_moisture = soil_sensor.touchRead(0);
  
  dtostrf(soil_temp, 4, 2, str_temp);

  snprintf(output, 20, "%s %d", soil_temp, soil_moisture);
  delay(100);
}
