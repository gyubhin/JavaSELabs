package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {

    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Double> typePriceSum = new HashMap<>();
        Map<String, Integer> typeCount = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            typePriceSum.put(type, typePriceSum.getOrDefault(type, 0.0) + pub.getPrice());
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> averagePrice = new HashMap<>();
        for (String type : typePriceSum.keySet()) {
            averagePrice.put(type, typePriceSum.get(type) / typeCount.get(type));
        }
        return averagePrice;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> typeCount = new HashMap<>();
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distribution = new HashMap<>();
        int totalCount = publications.length;
        for (String type : typeCount.keySet()) {
            double percentage = (double) typeCount.get(type) / totalCount * 100;
            distribution.put(type, percentage);
        }
        return distribution;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return (double) count / publications.length * 100;
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        }
        return "기타";
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> averagePrices = calculateAveragePriceByType(publications);
        for (String type : averagePrices.keySet()) {
            System.out.println("   - " + type + ": " + df.format(averagePrices.get(type)) + "원");
        }

        System.out.println("\n2. 출판물 유형 분포:");
        Map<String, Double> distributions = calculatePublicationDistribution(publications);
        for (String type : distributions.keySet()) {
            System.out.println("   - " + type + ": " + String.format("%.2f", distributions.get(type)) + "%");
        }

        System.out.println("\n3. 2007년에 출판된 출판물 비율: " + String.format("%.2f", calculatePublicationRatioByYear(publications, "2007")) + "%");
    }
}