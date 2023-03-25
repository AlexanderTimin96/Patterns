import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        Logger logger = Logger.getInstance();
        logger.log("Создаем объект класса фильтр");
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        logger.log("Фильтруем список через стримы");
        List<Integer> result = source.stream().filter(x -> x <= treshold).collect(Collectors.toList());
        logger.log("Возвращаем отфильтрованный список");
        return result;
    }
}
