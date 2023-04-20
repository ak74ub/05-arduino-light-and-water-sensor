#include "Adafruit_seesaw.h"
#include <Wire.h>
#include "BH1750.h"
#include <stdio.h>
#include <string.h>

Adafruit_seesaw soil_sensor;
BH1750 light_meter;
char sensor_data[20] = "";

void setup(){
    Serial.begin(9600);
    Wire.begin();
    light_meter.begin();
    soil_sensor.begin(0x36); 
}

void loop(){
    float tempC = soil_sensor.getTemp();
    float lux = light_meter.readLightLevel();
    uint16_t capread = soil_sensor.touchRead(0);

    snprintf(sensor_data, 20, "%.2f %.2f %d", tempC, lux, capread);
    Serial.print(sensor_data);
    delay(1000);
}