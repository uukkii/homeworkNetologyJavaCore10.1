public class JvmComprehension {

    public static void main(String[] args) { // JvmComprehension.java компилируется в байт-код JvmComprehension.class.
                                             // ClassLoader передает JvmComprehension.class в JMV.
                                             // Выделяется область памяти для метаспейс, хип и стэк.
                                             // В стэке создается фрейм метода main().
        int i = 1;                      // 1 - В фрейм метода main() помещается переменная типа int.
        Object o = new Object();        // 2 - В хипе выделяется память под объект с названием 'o' типа Object,
                                        //     В фрейм метода main() помещается переменная со ссылкой на этот объект.
        Integer ii = 2;                 // 3 - В хипе выделяется память под объект с с названием 'ii' типа Integer,
                                        //     В фрейм метода main() помещается переменная со ссылкой на этот объект.
        printAll(o, i, ii);             // 4 - В стэке создается фрейм метода printAll().
        System.out.println("finished"); // 7 - В стэке создается фрейм со ссылкой на строку со значением "finished".
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 - В хипе выделяется память под объект с названием 'uselessVar' типа Integer,
                                                    //     В фрейм метода main() помещается переменная со ссылкой на этот объект.
        System.out.println(o.toString() + i + ii);  // 6 - В стэке создается фрейм со ссылкой на объект 'ii' и переменная 'i' типа int с заданным значением,
                                                    //     В стэке создается фрейм метода toString().
    }
} // Методы убираются из стэка.
  // Stop The World пауза - приостановка потоков программы для запуска сборщика мусора.
  // Сборщик мусора удаляет неиспользуемые в хипе объекты.
