// C++ code
//
int moisture = 0;

void setup()
{
  pinMode(A1, INPUT);
  Serial.begin(9600);
  
}

void loop()
{
  // Apply power to the soil moisture sensor
  delay(10); // Wait for 10 millisecond(s)
  moisture = analogRead(A1);
  // Turn off the sensor to reduce metal corrosion
  // over time

  if (moisture < 200) {
    Serial.print("Very low moisture" + moisture);
  } else {
    if (moisture < 400) {
      Serial.print("Low moisture" + moisture);
    } else {
      if (moisture < 600) {
        Serial.print("Average moisture" + moisture);
      } else {
        if (moisture < 800) {
          Serial.print("High moisture" + moisture);
        } else {
          Serial.print("Extremely high moisture" + moisture);
        }
      }
    }
  }
  delay(100); // Wait for 100 millisecond(s)
}