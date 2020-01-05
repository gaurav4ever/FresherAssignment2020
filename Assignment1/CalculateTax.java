package Assignment1;

class CalculateTax {
  float tax;

  CalculateTax(String type, float price) {
    if (type.equals("raw")) {
      tax = (price * 12.5f) / 100;
    } else if (type.equals("manufactured")) {
      tax = (((price * 12.5f) / 100) + (2f * (price + (price * 12.5f) / 100) / 100));
    } else if (type.equals("imported")) {
      float custom_duty = (price * 10f) / 100;
      if (custom_duty + price <= 100)
        tax = custom_duty + 5;
      else if (custom_duty + price <= 200)
        tax = custom_duty + 10;
      else
        tax = custom_duty + (5f * (custom_duty + price)) / 100;
    }
  }

  public float getTax() {
    return tax;
  }
}