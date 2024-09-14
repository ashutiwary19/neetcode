import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class TopKFreqElements {
        public int[] topKFrequent(int[] nums, int k) {
                Map<Integer, Long> countMap = IntStream.of(nums).boxed()
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                List<Integer> list = countMap.entrySet().stream()
                                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                .map(entry -> entry.getKey())
                                .limit(k).collect(Collectors.toList());

                return list.stream().mapToInt(Integer::intValue).toArray();

        }

        public int[] topKFrequent2(int[] nums, int k) {
                Map<Integer, Long> countMap = IntStream.of(nums).boxed()
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                PriorityQueue<Map.Entry<Integer, Long>> pq = new PriorityQueue<>(
                                Map.Entry.comparingByValue(Comparator.reverseOrder()));

                pq.addAll(countMap.entrySet());

                List<Integer> list = Stream.generate(pq::poll).limit(k).map(entry -> entry.getKey())
                                .collect(Collectors.toList());

                return list.stream().mapToInt(Integer::intValue).toArray();

        }
}
