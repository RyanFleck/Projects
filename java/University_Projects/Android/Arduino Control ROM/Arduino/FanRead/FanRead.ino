void setup() {
  // put you5r setup code here, to run once:
  pinMode(13,OUTPUT);
  pinMode(12,OUTPUT);
  pinMode(11,OUTPUT);
  
  digitalWrite(13,HIGH);
  digitalWrite(12,HIGH);
  digitalWrite(11,HIGH);
}

void loop()
{
  digitalWrite(13,HIGH);
  digitalWrite(12,HIGH);
  digitalWrite(11,HIGH);
  delay(500);

  digitalWrite(13,LOW);
  digitalWrite(12,LOW);
  digitalWrite(11,LOW);
  delay(500);
  
}
