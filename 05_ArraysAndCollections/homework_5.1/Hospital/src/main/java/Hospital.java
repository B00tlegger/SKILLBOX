public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        //TODO: напишите метод генерации массива температур пациентов

        int scale = (int) Math.pow(10, 1);
        float[] temperatures = new float[patientsCount];
        for (int i = 0 ; i < temperatures.length ; i ++)
        {
            float temperature = 32 + (float) Math.round((8 * Math.random()) * scale) / scale;
            temperatures[i] = temperature;
        }
        return temperatures ;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */
        StringBuilder allTemperatures = new StringBuilder();
        int patientsCount = temperatureData.length;
        float scale = (float) Math.pow(10, 2);
        float sumValue = 0;
        float averageValue;
        int healthyPatient = 0;
        for (float temperatures : temperatureData) {
            allTemperatures.append(temperatures).append(" ");
            sumValue = sumValue + temperatures;
            if (temperatures > 36.1 && temperatures < 37 )
            {
                healthyPatient++;
            }
        }
        averageValue = Math.round((sumValue / patientsCount) * scale) / scale;

        String report =
                "Температуры пациентов: " + allTemperatures.toString().trim() +
                        "\nСредняя температура: " + averageValue +
                        "\nКоличество здоровых: " + healthyPatient;

        return report;
    }
}
