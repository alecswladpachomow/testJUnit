import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
public class Main {
    private static SerialPort serialPort;
    public static void main(String[] args) {
        //Передаём в конструктор имя порта
        serialPort = new SerialPort("COM1");
        try {
            //Открываем порт
            serialPort.openPort();
            //Выставляем параметры
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            //Включаем аппаратное управление потоком
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN |
                    SerialPort.FLOWCONTROL_RTSCTS_OUT);
            //Устанавливаем ивент лисенер и маску
            serialPort.addEventListener(new PortReader(), SerialPort.MASK_RXCHAR);
            //Отправляем запрос устройству
            serialPort.writeString("Get data");
            System.out.println("порт открыт");
        }
        catch (SerialPortException err) {
            System.out.println(err);
            System.out.println("ошибка порнта");
        }// write your code here
    }
    private static class PortReader implements SerialPortEventListener {

        public void serialEvent(SerialPortEvent event) {
            if(event.isRXCHAR() && event.getEventValue() > 0){
                try {
                    //Получаем ответ от устройства, обрабатываем данные и т.д.
                    String data = serialPort.readString(event.getEventValue());
                    //И снова отправляем запрос
                    serialPort.writeString("Get data");
                }
                catch (SerialPortException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
