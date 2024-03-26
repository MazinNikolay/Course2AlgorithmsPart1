package pro.sky.Course2AlgorithmsPart1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.Course2AlgorithmsPart1.exceptions.*;
import pro.sky.Course2AlgorithmsPart1.service.StringListService;

@RestController
@RequestMapping(path = "/list")
public class StringListController {

    private final StringListService stringListService;

    public StringListController(StringListService stringListService) {
        this.stringListService = stringListService;
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> handleNumberFormat() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Введите целочисленное значение");
    }

    @ExceptionHandler(NoExistListException.class)
    public ResponseEntity<String> handleNoExistList() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Не создан экземпляр ArrayList");
    }

    @ExceptionHandler(InvalidArgException.class)
    public ResponseEntity<String> handleInvalidArg() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Не введен(ы) аргумент(ы)");
    }

    @ExceptionHandler(IncorrectSizeInput.class)
    public ResponseEntity<String> handleincorrectSizeInput() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Введена неверная размерность массива");
    }

    @ExceptionHandler(OutOfBoundsExceptions.class)
    public ResponseEntity<String> handleOutOfBounds() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Массив уже заполнен");
    }

    @ExceptionHandler(IndexOutOfRangeException.class)
    public ResponseEntity<String> handleOutOfRange() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Введеный индекс не соответствет " +
                "размеру массива или фактическому количеству элементов");
    }

    @ExceptionHandler(NoAddedException.class)
    public ResponseEntity<String> handleNoAdded() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("В эту позицию добавить нельзя," +
                " элемент уже существует");
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFound() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Указанный элемент не найден.");
    }

    @GetMapping(path = "/create")
    public String createList(@RequestParam(value = "size", required = false) String size) {
        stringListService.createStringList(size);
        return "StringList created";
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam(value = "index", required = false) String index,
                      @RequestParam(value = "item", required = false) String item) {
        return stringListService.add(index, item);
    }

    @GetMapping(path = "/set")
    public String set(@RequestParam(value = "index", required = false) String index,
                      @RequestParam(value = "item", required = false) String item) {
        return stringListService.set(index, item);
    }

    @GetMapping(path = "/removeOnIndex")
    public String remove(@RequestParam(value = "index", required = false) int index) {
        return stringListService.remove(index);
    }

    @GetMapping(path = "/removeOnItem")
    public String remove(@RequestParam(value = "item", required = false) String item) {
        return stringListService.remove(item);
    }

    @GetMapping(path = "/indexOf")
    public int indexOf(@RequestParam(value = "item", required = false) String item) {
        return stringListService.indexOf(item);
    }

    @GetMapping(path = "/lastIndexOf")
    public int print(@RequestParam(value = "item", required = false) String item) {
        return stringListService.lastIndexOf(item);
    }

    @GetMapping(path = "/get")
    public String get(@RequestParam(value = "index", required = false) String index) {
        return stringListService.get(index);
    }

    @GetMapping(path = "/print")
    public String print() {
        return stringListService.printArray();
    }
}
