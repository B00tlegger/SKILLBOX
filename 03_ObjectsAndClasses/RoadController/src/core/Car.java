package core;

public class Car
{
    public String number;
    public int height;
    public double weight;
    public boolean hasVehicle;
    public boolean isSpecial;

    public void setNumber(String number){
        this.number = number;
    }

    public String getNumber(){
        return number;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public Integer getHeight(){
        return height;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public Double getWeight(){
        return weight;
    }
    public void setHasVehicle(boolean hasVehicle){
        this.hasVehicle = hasVehicle;
    }

    public boolean isHasVehicle() {
        return hasVehicle;
    }

    public void setSpecial(boolean isSpecial){
        this.isSpecial = isSpecial;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}